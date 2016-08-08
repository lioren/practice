package hw1;

import java.util.*;
import java.io.*;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.Word;

public class Hw1 {
	protected Dictionary dic;

	class node {
		String filename;
		String key;
		int value = 0;

	}

	class show implements Comparable<show> {
		String key;
		double grade;

		public double getgrade() {
			return grade;
		}

		@Override
		public int compareTo(show a) {
			double m = a.getgrade();
			if (this.grade > m)
				return -1;
			return 1;
		}

	}

	public Hw1() {

	}

	protected Seg getSeg() {
		return new ComplexSeg(dic);
	}

	public String segWords(String txt, String wordSpilt) throws IOException {
		Reader input = new StringReader(txt);
		StringBuilder sb = new StringBuilder();
		Seg seg = getSeg();
		MMSeg mmSeg = new MMSeg(input, seg);
		Word word = null;
		boolean first = true;
		Stemmer stemmer = new Stemmer();
		while ((word = mmSeg.next()) != null) {
			if (!first) {
				sb.append(wordSpilt);
			}
			String w = word.getString();
			char[] text2 = w.toCharArray();
			stemmer.add(text2, text2.length);
			stemmer.stem();
			String w2 = stemmer.toString();
			System.out.println(w2);
			sb.append(w2);
			first = false;

		}
		return sb.toString();
	}

	public static List<String> ngrams(int n, String str) {
		List<String> ngrams = new ArrayList<String>();
		String[] words;

		words = str.split("");
		for (int i = 0; i < words.length - n + 1; i++)
			ngrams.add(concat(words, i, i + n));

		return ngrams;
	}

	public static List<String> ngrams2(int n, String str) {
		List<String> ngrams = new ArrayList<String>();
		String[] words;

		words = str.split(" ");
		for (int i = 0; i < words.length - n + 1; i++)
			ngrams.add(concat2(words, i, i + n));

		return ngrams;
	}

	public static String concat(String[] words, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++)
			sb.append((i > start ? "" : "") + words[i]);
		return sb.toString();
	}

	public static String concat2(String[] words, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++)
			sb.append((i > start ? " " : "") + words[i]);
		return sb.toString();
	}

	protected void run(String[] args) throws IOException {

		File f = new File("./hw1dataset30k/Data");

		ArrayList<String> fileList = new ArrayList<String>();
		if (f.isDirectory()) //
		{

			String[] s = f.list();

			for (int i = 0; i < s.length; i++) {

				fileList.add(s[i]);
				String tmp3 = "./hw1dataset30k/Data/" + s[i];

				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmp3), "UTF-8"));
				StringBuffer buff = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine()) != null) {

					buff.append(temp + "\r\n");
				}

				br.close();
				String tmp4 = "./selectdata/" + s[i];
				FileWriter fw = new FileWriter(tmp4);
				fw.write(segWords(buff.toString(), "\n"));
				fw.flush();
				fw.close();

			}
		}

	}

	protected void cindex() throws IOException {

		ArrayList<node>[] hashtable = (ArrayList<node>[]) new ArrayList[4096];
		int[] numoffile = new int[31043];
		for (int i = 0; i < 4096; i++) {
			hashtable[i] = new ArrayList<node>();
		}
		File f = new File("./selectdata");

		ArrayList<String> fileList = new ArrayList<String>();
		if (f.isDirectory()) {
			String[] s = f.list();

			// for (int i = 0; i < s.length; i++) { // 每次處理1000個檔案 ，持續 32次
			for (int i = 30001; i < 31043; i++) {
				fileList.add(s[i]);
				String tmp3 = "./selectdata/" + s[i];
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmp3), "UTF-8"));
				StringBuffer buff = new StringBuffer();
				String temp = null;

				int line = 0;

				while ((temp = br.readLine()) != null) {
					line++;

					int j = temp.hashCode();
					if (j < 0)
						j = j & 0x7FFFFFFF;
					j = j % 4096;

					node tmp = new node();
					tmp.filename = s[i];
					tmp.key = temp;
					tmp.value = 1;

					if (hashtable[j].isEmpty()) {
						hashtable[j].add(tmp);

					}

					else if (!hashtable[j].isEmpty()) {

						int x = 0;
						for (x = 0; x < hashtable[j].size(); x++) {

							node tmp2;
							tmp2 = hashtable[j].get(x);

							if (tmp2.filename.equals(tmp.filename) && tmp2.key.equals(tmp.key)) {
								tmp2.value = tmp2.value + 1;
								hashtable[j].set(x, tmp2);
								break;
							} else {

							}
						}

						if (x == hashtable[j].size()) {

							hashtable[j].add(tmp);

						}
					}

				}
				int mm = Integer.parseInt(s[i].substring(0, s[i].indexOf('.')));
				numoffile[mm] = line;

				br.close();
			}
			for (int m = 0; m < 4096; m++) {
				if (!hashtable[m].isEmpty()) {
					String filename = "./idx/" + m + "_idx.txt";

					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
					for (int n = 0; n < hashtable[m].size(); n++) {
						node tmp2 = new node();
						tmp2 = hashtable[m].get(n);
						int kk = Integer.parseInt(tmp2.filename.substring(0, tmp2.filename.indexOf('.')));
						double tf = (double) tmp2.value / (double) numoffile[kk];
						String tmp4 = tmp2.key + " " + tmp2.filename + " " + tmp2.value + " " + tf;

						out.println(tmp4);
					}
					out.close();
				}
			}

		}

	}

	protected void calculate(ArrayList<show> hashtable, int n, String ngram, String flag) throws IOException {
		int f;
		double idf;
		f = ngram.hashCode();
		if (f < 0)
			f = f & 0x7FFFFFFF;
		f = f % 4096;
		String tmp3 = "./idx/" + f + "_idx.txt";
		int numoffile = 0;
		BufferedReader mr = new BufferedReader(new InputStreamReader(new FileInputStream(tmp3), "UTF-8"));
		String temp2 = null;
		while ((temp2 = mr.readLine()) != null) {
			String[] tmp;
			tmp = temp2.split(" ");
			if (tmp[0].equals(ngram)) {
				numoffile++;
			}
		}
		idf = Math.log((double) 31042 / (double) numoffile);
		// System.out.println(idf);
		mr.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmp3), "UTF-8"));
		String temp = null;
		while ((temp = br.readLine()) != null) {
			String[] tmp;
			tmp = temp.split(" ");
			if (tmp[0].equals(ngram)) {

				if (hashtable.isEmpty()) {
					show tmp2 = new show();
					tmp2.key = tmp[1];
					if (flag.equals("1")) {
						tmp2.grade = Double.parseDouble(tmp[3]);
					} else if (flag.equals("2")) {
						tmp2.grade = Double.parseDouble(tmp[3])*idf;
					}
					hashtable.add(tmp2);
				} else {
					int x = 0;
					for (x = 0; x < hashtable.size(); x++) {
						show tmp2;
						tmp2 = hashtable.get(x);

						if (tmp2.key.equals(tmp[1])) {
							if (flag.equals("1")) {
							tmp2.grade = Double.parseDouble(tmp[3]) * n * n + tmp2.grade;
							}
							else if (flag.equals("2")) {
								tmp2.grade = Double.parseDouble(tmp[3]) * n * n  * idf + tmp2.grade;
							}
							hashtable.set(x, tmp2);
							break;
						} else {

						}
					}
					if (x == hashtable.size()) {
						show tmp2 = new show();
						tmp2.key = tmp[1];
						if (flag.equals("1")) {
						tmp2.grade = Double.parseDouble(tmp[3]);
						}
						else if (flag.equals("2")) {
							tmp2.grade = Double.parseDouble(tmp[3])*idf;
						}
						hashtable.add(tmp2);

					}

				}

			}
		}
		br.close();

	}

	protected void Search(String s, String flag) throws IOException {

		ArrayList<show> hashtable = (ArrayList<show>) new ArrayList();

		if (s.getBytes().length != s.length()) {
			for (int n = 1; n <= s.length(); n++) {
				for (String ngram : ngrams(n, s)) {
					calculate(hashtable, n, ngram, flag);

				}

			}
			Collections.sort(hashtable);
			for (int i = 0; i < hashtable.size(); i++) {
				if (i == 20)
					break;

				System.out.println(hashtable.get(i).key);
				String tmp3 = "./hw1dataset30k/Data/" + hashtable.get(i).key;
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmp3), "UTF-8"));
				String temp = null;
				while ((temp = br.readLine()) != null) {
					if(temp.indexOf(s)!=-1){
						System.out.println("ture");
						br.close();
						break;
					}
					
					
				}

			}

		} else {
			String[] words;
			words = s.split(" ");
			Stemmer stemmer = new Stemmer();
			for (int i = 0; i < words.length; i++) {
				stemmer.add(words[i].toCharArray(), words[i].length());
				stemmer.stem();
				String w2 = stemmer.toString();
				//System.out.println(w2);
				calculate(hashtable, 1, w2, flag);
				// for (String ngram : ngrams2(i, s)) {
				// System.out.println(ngram);
				// calculate(hashtable,i,ngram);
			}
			// }
			Collections.sort(hashtable);
			for (int i = 0; i < hashtable.size(); i++) {
				if (i == 20)
					break;

				System.out.println(hashtable.get(i).key);
				String tmp3 = "./hw1dataset30k/Data/" + hashtable.get(i).key;
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmp3), "UTF-8"));
				String temp = null;
				while ((temp = br.readLine()) != null) {
					if(temp.indexOf(s)!=-1){
						System.out.println("ture");
						br.close();
						break;
					}
					
					
				}

			}

		}

	}

	static class Comparator {

	}

	public static void main(String[] args) throws IOException {
		 new Hw1().run(args); // 用來進行詞幹提取與STEMMING，並產生相應的檔案，耗時約5分鐘

		// new Hw1().cindex(); // 建INDEX
/*		System.out.println("Choose type 1.TF  2.TF-IDF:");
		Scanner s = new Scanner(System.in);
		String flag;
		flag = s.nextLine();
		System.out.println("Input term:");
		Scanner scanner = new Scanner(System.in);
		String search;
		search = scanner.nextLine();

		new Hw1().Search(search, flag); */

	}
}
