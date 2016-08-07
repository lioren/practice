import java.io.*;
import java.util.Scanner;

public class Avg{
		public static void main(String args[]){
				String amtStr;
				double num=0.0,tot=0.0,com=0.0;
				double times=0.0;
				while(true){
						tot=0;
						times=0;
				while(true){
						Scanner sc=new Scanner(System.in);		
						System.out.println("Enter the number between 0 to 100 or input -1 to calculate the result:");
						amtStr=sc.next();
						num=new Double(amtStr).doubleValue();							
						if((0>num||100<num)&&(num!=-1)){
								System.out.println("Error input ");
								continue;
						}
						else if(num==-1){
								break;
						}
						tot=tot+num;
						times++;
				}
				if(times==0){
						System.out.println("No data to calculate");
				}
				else 
				System.out.println("Average is:"+(tot/times));
                Scanner comd =new Scanner (System.in);
                System.out.println("Enter 1 if you want to calculate new average or 2 if you want to exit the program");
                amtStr=comd.next();
                com=new Double(amtStr).doubleValue();
                if(com==1)
                		continue;
                else if(com==2)
                		break;
				}
		}
}
