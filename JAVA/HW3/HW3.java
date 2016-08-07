import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.*;

public class HW3
{

		public static void main(String[] args)throws IOException
		{
				HashMap <String ,Integer > map ;
				map = new HashMap<String ,Integer>();

				String Words[] = {
						"link", "fraud", "work", "god", "job", "atm",
						"angel", "the", "ilove", "sex", "jesus", "connect",
						"fuck", "monkey", "irs", "master", "bitch", "duck",
						"michael", "jordan", "dragon", "soccer", "killer", "career",
						"pepper", "devil", "princess", "iloveyou", "ssl", "paypal" };

				int phishingPoints[] = {1,3,2,2,3,1,1,2,1,1,2,2,3,1,1,1,1,2,3,2,1,1,2,1,1,2,3,2,1,1};
                int count[] = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                int points[]= { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
				//System.out.println("123");
			    FileReader fr=new FileReader("test.txt");
				BufferedReader br=new BufferedReader(fr);
				String s;
                while((s=br.readLine())!=null){
                		String sbuf=s;
                	//	System.out.println(br.readLine());
                		for(int i=0;i<30;i++){
                				s=sbuf;
                				int len;
                				while((len=s.indexOf(Words[i]))!=-1){
                						//s=s.substring(len+1,s.length());
                						//System.out.println(len);
                						s=s.substring(len+1,s.length());
                						count[i]++;
                						points[i]=points[i]+phishingPoints[i];
                				}
             					
						}
				}
				int total=0;
				System.out.printf("Word       Count       Points\n");
				for(int i=0;i<30;i++){
				System.out.printf("%-15s%-10s%s\n",Words[i],count[i], points[i]);
				total+=points[i];
				}
				System.out.printf("\nTotal points: %s\n",total);


		}

}
