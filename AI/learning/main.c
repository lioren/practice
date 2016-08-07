#include<stdio.h>
#include<stdlib.h>
#include<string.h>
main(){
		FILE *pf;
		int i=0;
		char trainingdata[701][100];
		pf=fopen("TraData700.csv","r");
		while(fgets(trainingdata[i],100,pf) != NULL)
		{
				i++;
		}
		fclose(pf);

		i=0;
		int j=0;
		int test[701][40];
		for(i=0;i<700;i++){
				j=0;
				char *s = strtok(trainingdata[i],",");
				while (s != NULL) {
						test[i][j++]=atoi(s);
						s = strtok(NULL, ",");
				}
		}

		int count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0;
		float pro1_1_1,pro1_1_2,pro1_2_1,pro1_2_2,pro1_3_1,pro1_3_2,pro1_4_1,pro1_4_2;
		float pro2_1_1,pro2_1_2,pro2_2_1,pro2_2_2,pro2_3_1,pro2_3_2;
		float pro3_1_1,pro3_1_2,pro3_2_1,pro3_2_2,pro3_3_1,pro3_3_2,pro3_4_1,pro3_4_2,pro3_5_1,pro3_5_2;
		float pro4_1_1,pro4_1_2,pro4_2_1,pro4_2_2,pro4_3_1,pro4_3_2;
		float pro5_1_1,pro5_1_2,pro5_2_1,pro5_2_2,pro5_3_1,pro5_3_2,pro5_4_1,pro5_4_2,pro5_5_1,pro5_5_2;
		float pro6_1_1,pro6_1_2,pro6_2_1,pro6_2_2,pro6_3_1,pro6_3_2,pro6_4_1,pro6_4_2,pro6_5_1,pro6_5_2;
		float pro7_1_1,pro7_1_2,pro7_2_1,pro7_2_2,pro7_3_1,pro7_3_2,pro7_4_1,pro7_4_2;
		float pro8_1_1,pro8_1_2,pro8_2_1,pro8_2_2,pro8_3_1,pro8_3_2,pro8_4_1,pro8_4_2;
		float pro9_1_1,pro9_1_2,pro9_2_1,pro9_2_2,pro9_3_1,pro9_3_2,pro9_4_1,pro9_4_2;
		float pro10_1_1,pro10_1_2,pro10_2_1,pro10_2_2,pro10_3_1,pro10_3_2;
		float pro11_1_1,pro11_1_2,pro11_2_1,pro11_2_2,pro11_3_1,pro11_3_2;
		float pro12_1_1,pro12_1_2,pro12_2_1,pro12_2_2,pro12_3_1,pro12_3_2,pro12_4_1,pro12_4_2;
		float pro13_1_1,pro13_1_2,pro13_2_1,pro13_2_2;
		float pro14_1_1,pro14_1_2,pro14_2_1,pro14_2_2;
		float pro15_1_1,pro15_1_2,pro15_2_1,pro15_2_2,pro15_3_1,pro15_3_2;
		float pro16_1_1,pro16_1_2,pro16_2_1,pro16_2_2;
		float pro17_1_1,pro17_1_2,pro17_2_1,pro17_2_2;
		float pro18_1_1,pro18_1_2,pro18_2_1,pro18_2_2;
		float pro19_1_1,pro19_1_2,pro19_2_1,pro19_2_2;
		float pro20_1_1,pro20_1_2,pro20_2_1,pro20_2_2;
		float pro21_1_1,pro21_1_2,pro21_2_1,pro21_2_2;
		float pro22_1_1,pro22_1_2,pro22_2_1,pro22_2_2;
		float pro23_1_1,pro23_1_2,pro23_2_1,pro23_2_2;
		float pro24_1_1,pro24_1_2,pro24_2_1,pro24_2_2;
		for(i=0;i<600;i++){
				if(test[i][0]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][0]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][0]==2 && test[i][24]==1)
						count3++;
				else if(test[i][0]==2 && test[i][24]==2)
						count4++;
				else if(test[i][0]==3 && test[i][24]==1)
						count5++;
				else if(test[i][0]==3 && test[i][24]==2)
						count6++;
				else if(test[i][0]>=4 && test[i][24]==1)
						count7++;
				else if(test[i][0]>=4 && test[i][24]==2)
						count8++;
		}
				pro1_1_1 = (float)count1/(float)(count1+count2);
				pro1_1_2 = (float)count2/(float)(count1+count2);
				pro1_2_1 = (float)count3/(float)(count3+count4);
				pro1_2_2 = (float)count4/(float)(count3+count4);
				pro1_3_1 = (float)count5/(float)(count5+count6);
				pro1_3_2 = (float)count6/(float)(count5+count6);
				pro1_4_1 = (float)count7/(float)(count7+count8);
				pro1_4_2 = (float)count8/(float)(count7+count8);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0;

		for(i=0;i<600;i++){				
				if(test[i][1]<=24 && test[i][24]==1)
						count1++;
				else if(test[i][1]<=24 && test[i][24]==2)
						count2++;
				else if(test[i][1]<=42 && test[i][24]==1)
						count3++;
				else if(test[i][1]<=42 && test[i][24]==2)
						count4++;
				else if(test[i][1]<=600 && test[i][24]==1)
						count5++;
				else if(test[i][1]<=600 && test[i][24]==2)
						count6++;

		}	
				pro2_1_1 = (float)count1/(float)(count1+count2);
				pro2_1_2 = (float)count2/(float)(count1+count2);
				pro2_2_1 = (float)count3/(float)(count3+count4);
				pro2_2_2 = (float)count4/(float)(count3+count4);
				pro2_3_1 = (float)count5/(float)(count5+count6);
				pro2_3_2 = (float)count6/(float)(count5+count6);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0;

		for(i=0;i<600;i++){
				if(test[i][2]==0 && test[i][24]==1)
						count1++;
				else if(test[i][2]==0 && test[i][24]==2)
						count2++;
				else if(test[i][2]==1 && test[i][24]==1)
						count3++;
				else if(test[i][2]==1 && test[i][24]==2)
						count4++;
				else if(test[i][2]==2 && test[i][24]==1)
						count5++;
				else if(test[i][2]==2 && test[i][24]==2)
						count6++;
				else if(test[i][2]==3 && test[i][24]==1)
						count7++;
				else if(test[i][2]==3 && test[i][24]==2)
						count8++;
				else if(test[i][2]>=4 && test[i][24]==1)
						count9++;
				else if(test[i][2]>=4 && test[i][24]==2)
						count10++;
		}
				pro3_1_1 = (float)count1/(float)(count1+count2);
				pro3_1_2 = (float)count2/(float)(count1+count2);
				pro3_2_1 = (float)count3/(float)(count3+count4);
				pro3_2_2 = (float)count4/(float)(count3+count4);
				pro3_3_1 = (float)count5/(float)(count5+count6);
				pro3_3_2 = (float)count6/(float)(count5+count6);
				pro3_4_1 = (float)count7/(float)(count7+count8);
				pro3_4_2 = (float)count8/(float)(count7+count8);
				pro3_5_1 = (float)count9/(float)(count9+count10);
				pro3_5_2 = (float)count10/(float)(count9+count10);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0;

		for(i=0;i<600;i++){				
				if(test[i][3]<=50 && test[i][24]==1)
						count1++;
				else if(test[i][3]<=50 && test[i][24]==2)
						count2++;
				else if(test[i][3]<=100 && test[i][24]==1)
						count3++;
				else if(test[i][3]<=100 && test[i][24]==2)
						count4++;
				else if(test[i][3]<=600 && test[i][24]==1)
						count5++;
				else if(test[i][3]<=600 && test[i][24]==2)
						count6++;

		}	
				pro4_1_1 = (float)count1/(float)(count1+count2);
				pro4_1_2 = (float)count2/(float)(count1+count2);
				pro4_2_1 = (float)count3/(float)(count3+count4);
				pro4_2_2 = (float)count4/(float)(count3+count4);
				pro4_3_1 = (float)count5/(float)(count5+count6);
				pro4_3_2 = (float)count6/(float)(count5+count6);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0;

		for(i=0;i<600;i++){
				if(test[i][4]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][4]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][4]==2 && test[i][24]==1)
						count3++;
				else if(test[i][4]==2 && test[i][24]==2)
						count4++;
				else if(test[i][4]==3 && test[i][24]==1)
						count5++;
				else if(test[i][4]==3 && test[i][24]==2)
						count6++;
				else if(test[i][4]==4 && test[i][24]==1)
						count7++;
				else if(test[i][4]==4 && test[i][24]==2)
						count8++;
				else if(test[i][4]>=5 && test[i][24]==1)
						count9++;
				else if(test[i][4]>=5 && test[i][24]==2)
						count10++;
		}
				pro5_1_1 = (float)count1/(float)(count1+count2);
				pro5_1_2 = (float)count2/(float)(count1+count2);
				pro5_2_1 = (float)count3/(float)(count3+count4);
				pro5_2_2 = (float)count4/(float)(count3+count4);
				pro5_3_1 = (float)count5/(float)(count5+count6);
				pro5_3_2 = (float)count6/(float)(count5+count6);
				pro5_4_1 = (float)count7/(float)(count7+count8);
				pro5_4_2 = (float)count8/(float)(count7+count8);
				pro5_5_1 = (float)count9/(float)(count9+count10);
				pro5_5_2 = (float)count10/(float)(count9+count10);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0;

		for(i=0;i<600;i++){
				if(test[i][5]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][5]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][5]==2 && test[i][24]==1)
						count3++;
				else if(test[i][5]==2 && test[i][24]==2)
						count4++;
				else if(test[i][5]==3 && test[i][24]==1)
						count5++;
				else if(test[i][5]==3 && test[i][24]==2)
						count6++;
				else if(test[i][5]==4 && test[i][24]==1)
						count7++;
				else if(test[i][5]==4 && test[i][24]==2)
						count8++;
				else if(test[i][5]>=5 && test[i][24]==1)
						count9++;
				else if(test[i][5]>=5 && test[i][24]==2)
						count10++;
		}
				pro6_1_1 = (float)count1/(float)(count1+count2);
				pro6_1_2 = (float)count2/(float)(count1+count2);
				pro6_2_1 = (float)count3/(float)(count3+count4);
				pro6_2_2 = (float)count4/(float)(count3+count4);
				pro6_3_1 = (float)count5/(float)(count5+count6);
				pro6_3_2 = (float)count6/(float)(count5+count6);
				pro6_4_1 = (float)count7/(float)(count7+count8);
				pro6_4_2 = (float)count8/(float)(count7+count8);
				pro6_5_1 = (float)count9/(float)(count9+count10);
				pro6_5_2 = (float)count10/(float)(count9+count10);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0;

		for(i=0;i<600;i++){
				if(test[i][6]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][6]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][6]==2 && test[i][24]==1)
						count3++;
				else if(test[i][6]==2 && test[i][24]==2)
						count4++;
				else if(test[i][6]==3 && test[i][24]==1)
						count5++;
				else if(test[i][6]==3 && test[i][24]==2)
						count6++;
				else if(test[i][6]>=4 && test[i][24]==1)
						count7++;
				else if(test[i][6]>=4 && test[i][24]==2)
						count8++;
		}
				pro7_1_1 = (float)count1/(float)(count1+count2);
				pro7_1_2 = (float)count2/(float)(count1+count2);
				pro7_2_1 = (float)count3/(float)(count3+count4);
				pro7_2_2 = (float)count4/(float)(count3+count4);
				pro7_3_1 = (float)count5/(float)(count5+count6);
				pro7_3_2 = (float)count6/(float)(count5+count6);
				pro7_4_1 = (float)count7/(float)(count7+count8);
				pro7_4_2 = (float)count8/(float)(count7+count8);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0;

		for(i=0;i<600;i++){
				if(test[i][7]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][7]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][7]==2 && test[i][24]==1)
						count3++;
				else if(test[i][7]==2 && test[i][24]==2)
						count4++;
				else if(test[i][7]==3 && test[i][24]==1)
						count5++;
				else if(test[i][7]==3 && test[i][24]==2)
						count6++;
				else if(test[i][7]>=4 && test[i][24]==1)
						count7++;
				else if(test[i][7]>=4 && test[i][24]==2)
						count8++;
		}
				pro8_1_1 = (float)count1/(float)(count1+count2);
				pro8_1_2 = (float)count2/(float)(count1+count2);
				pro8_2_1 = (float)count3/(float)(count3+count4);
				pro8_2_2 = (float)count4/(float)(count3+count4);
				pro8_3_1 = (float)count5/(float)(count5+count6);
				pro8_3_2 = (float)count6/(float)(count5+count6);
				pro8_4_1 = (float)count7/(float)(count7+count8);
				pro8_4_2 = (float)count8/(float)(count7+count8);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0;

		for(i=0;i<600;i++){
				if(test[i][8]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][8]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][8]==2 && test[i][24]==1)
						count3++;
				else if(test[i][8]==2 && test[i][24]==2)
						count4++;
				else if(test[i][8]==3 && test[i][24]==1)
						count5++;
				else if(test[i][8]==3 && test[i][24]==2)
						count6++;
				else if(test[i][8]>=4 && test[i][24]==1)
						count7++;
				else if(test[i][8]>=4 && test[i][24]==2)
						count8++;
		}
				pro9_1_1 = (float)count1/(float)(count1+count2);
				pro9_1_2 = (float)count2/(float)(count1+count2);
				pro9_2_1 = (float)count3/(float)(count3+count4);
				pro9_2_2 = (float)count4/(float)(count3+count4);
				pro9_3_1 = (float)count5/(float)(count5+count6);
				pro9_3_2 = (float)count6/(float)(count5+count6);
				pro9_4_1 = (float)count7/(float)(count7+count8);
				pro9_4_2 = (float)count8/(float)(count7+count8);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0;

		for(i=0;i<600;i++){				
				if(test[i][9]<=30 && test[i][24]==1)
						count1++;
				else if(test[i][9]<=30 && test[i][24]==2)
						count2++;
				else if(test[i][9]<=55 && test[i][24]==1)
						count3++;
				else if(test[i][9]<=55 && test[i][24]==2)
						count4++;
				else if(test[i][9]<=600 && test[i][24]==1)
						count5++;
				else if(test[i][9]<=600 && test[i][24]==2)
						count6++;

		}	
				pro10_1_1 = (float)count1/(float)(count1+count2);
				pro10_1_2 = (float)count2/(float)(count1+count2);
				pro10_2_1 = (float)count3/(float)(count3+count4);
				pro10_2_2 = (float)count4/(float)(count3+count4);
				pro10_3_1 = (float)count5/(float)(count5+count6);
				pro10_3_2 = (float)count6/(float)(count5+count6);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0;

		for(i=0;i<600;i++){				
				if(test[i][10]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][10]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][10]<=2 && test[i][24]==1)
						count3++;
				else if(test[i][10]<=2 && test[i][24]==2)
						count4++;
				else if(test[i][10]>=3 && test[i][24]==1)
						count5++;
				else if(test[i][10]>=3 && test[i][24]==2)
						count6++;

		}	
				pro11_1_1 = (float)count1/(float)(count1+count2);
				pro11_1_2 = (float)count2/(float)(count1+count2);
				pro11_2_1 = (float)count3/(float)(count3+count4);
				pro11_2_2 = (float)count4/(float)(count3+count4);
				pro11_3_1 = (float)count5/(float)(count5+count6);
				pro11_3_2 = (float)count6/(float)(count5+count6);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0;		

		for(i=0;i<600;i++){
				if(test[i][11]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][11]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][11]==2 && test[i][24]==1)
						count3++;
				else if(test[i][11]==2 && test[i][24]==2)
						count4++;
				else if(test[i][11]==3 && test[i][24]==1)
						count5++;
				else if(test[i][11]==3 && test[i][24]==2)
						count6++;
				else if(test[i][11]>=4 && test[i][24]==1)
						count7++;
				else if(test[i][11]>=4 && test[i][24]==2)
						count8++;
		}
				pro12_1_1 = (float)count1/(float)(count1+count2);
				pro12_1_2 = (float)count2/(float)(count1+count2);
				pro12_2_1 = (float)count3/(float)(count3+count4);
				pro12_2_2 = (float)count4/(float)(count3+count4);
				pro12_3_1 = (float)count5/(float)(count5+count6);
				pro12_3_2 = (float)count6/(float)(count5+count6);
				pro12_4_1 = (float)count7/(float)(count7+count8);
				pro12_4_2 = (float)count8/(float)(count7+count8);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0;

		for(i=0;i<600;i++){				
				if(test[i][12]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][12]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][12]>=2 && test[i][24]==1)
						count3++;
				else if(test[i][12]>=2 && test[i][24]==2)
						count4++;
		}	
				pro13_1_1 = (float)count1/(float)(count1+count2);
				pro13_1_2 = (float)count2/(float)(count1+count2);
				pro13_2_1 = (float)count3/(float)(count3+count4);
				pro13_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;	

		for(i=0;i<600;i++){				
				if(test[i][13]<=1 && test[i][24]==1)
						count1++;
				else if(test[i][13]<=1 && test[i][24]==2)
						count2++;
				else if(test[i][13]>=2 && test[i][24]==1)
						count3++;
				else if(test[i][13]>=2 && test[i][24]==2)
						count4++;
		}	
				pro14_1_1 = (float)count1/(float)(count1+count2);
				pro14_1_2 = (float)count2/(float)(count1+count2);
				pro14_2_1 = (float)count3/(float)(count3+count4);
				pro14_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;	

		for(i=0;i<600;i++){				
				if(test[i][14]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][14]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][14]<=1 && test[i][24]==1)
						count3++;
				else if(test[i][14]<=1 && test[i][24]==2)
						count4++;
				else if(test[i][14]>=2 && test[i][24]==1)
						count5++;
				else if(test[i][14]>=2 && test[i][24]==2)
						count6++;

		}	
				pro15_1_1 = (float)count1/(float)(count1+count2);
				pro15_1_2 = (float)count2/(float)(count1+count2);
				pro15_2_1 = (float)count3/(float)(count3+count4);
				pro15_2_2 = (float)count4/(float)(count3+count4);
				pro15_3_1 = (float)count5/(float)(count5+count6);
				pro15_3_2 = (float)count6/(float)(count5+count6);
		count1=0,count2=0,count3=0,count4=0,count5=0,count6=0;		

		for(i=0;i<600;i++){				
				if(test[i][15]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][15]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][15]>=1 && test[i][24]==1)
						count3++;
				else if(test[i][15]>=1 && test[i][24]==2)
						count4++;
		}	
				pro16_1_1 = (float)count1/(float)(count1+count2);
				pro16_1_2 = (float)count2/(float)(count1+count2);
				pro16_2_1 = (float)count3/(float)(count3+count4);
				pro16_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;	

		for(i=0;i<600;i++){				
				if(test[i][16]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][16]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][16]>=1 && test[i][24]==1)
						count3++;
				else if(test[i][16]>=1 && test[i][24]==2)
						count4++;
		}	
				pro17_1_1 = (float)count1/(float)(count1+count2);
				pro17_1_2 = (float)count2/(float)(count1+count2);
				pro17_2_1 = (float)count3/(float)(count3+count4);
				pro17_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;	

		for(i=0;i<600;i++){				
				if(test[i][17]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][17]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][17]>=1 && test[i][24]==1)
						count3++;
				else if(test[i][17]>=1 && test[i][24]==2)
						count4++;
		}	
				pro18_1_1 = (float)count1/(float)(count1+count2);
				pro18_1_2 = (float)count2/(float)(count1+count2);
				pro18_2_1 = (float)count3/(float)(count3+count4);
				pro18_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;

		for(i=0;i<600;i++){				
				if(test[i][18]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][18]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][18]>=1 && test[i][24]==1)
						count3++;
				else if(test[i][18]>=1 && test[i][24]==2)
						count4++;
		}	
				pro19_1_1 = (float)count1/(float)(count1+count2);
				pro19_1_2 = (float)count2/(float)(count1+count2);
				pro19_2_1 = (float)count3/(float)(count3+count4);
				pro19_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;

		for(i=0;i<600;i++){				
				if(test[i][19]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][19]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][19]>=1 && test[i][24]==1)
						count3++;
				else if(test[i][19]>=1 && test[i][24]==2)
						count4++;
		}	
				pro20_1_1 = (float)count1/(float)(count1+count2);
				pro20_1_2 = (float)count2/(float)(count1+count2);
				pro20_2_1 = (float)count3/(float)(count3+count4);
				pro20_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;

		for(i=0;i<600;i++){				
				if(test[i][20]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][20]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][20]>=1 && test[i][24]==1)
						count3++;
				else if(test[i][20]>=1 && test[i][24]==2)
						count4++;
		}	
				pro21_1_1 = (float)count1/(float)(count1+count2);
				pro21_1_2 = (float)count2/(float)(count1+count2);
				pro21_2_1 = (float)count3/(float)(count3+count4);
				pro21_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;

		for(i=0;i<600;i++){				
				if(test[i][21]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][21]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][21]>=1 && test[i][24]==1)
						count3++;
				else if(test[i][21]>=1 && test[i][24]==2)
						count4++;
		}	
				pro22_1_1 = (float)count1/(float)(count1+count2);
				pro22_1_2 = (float)count2/(float)(count1+count2);
				pro22_2_1 = (float)count3/(float)(count3+count4);
				pro22_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;

		for(i=0;i<600;i++){				
				if(test[i][22]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][22]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][22]>=1 && test[i][24]==1)
						count3++;
				else if(test[i][22]>=1 && test[i][24]==2)
						count4++;
		}	
				pro23_1_1 = (float)count1/(float)(count1+count2);
				pro23_1_2 = (float)count2/(float)(count1+count2);
				pro23_2_1 = (float)count3/(float)(count3+count4);
				pro23_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;

		for(i=0;i<600;i++){				
				if(test[i][23]<=0 && test[i][24]==1)
						count1++;
				else if(test[i][23]<=0 && test[i][24]==2)
						count2++;
				else if(test[i][23]>=1 && test[i][24]==1)
						count3++;
				else if(test[i][23]>=1 && test[i][24]==2)
						count4++;
		}	
				pro24_1_1 = (float)count1/(float)(count1+count2);
				pro24_1_2 = (float)count2/(float)(count1+count2);
				pro24_2_1 = (float)count3/(float)(count3+count4);
				pro24_2_2 = (float)count4/(float)(count3+count4);
		count1=0,count2=0,count3=0,count4=0;


     	FILE *nf;
     	FILE *fp;
		i=0;
		int total=0,error=0;
		int one=0,two=0;
		char solution[7000][100];
		nf=fopen("input.csv","r");
		while(fgets(solution[i],100,nf) != NULL)
		{
				i++;
		}
		total=i;
		fclose(nf);

		i=0;

		int input[7000][40];
		for(i=0;i<total;i++){
				j=0;
				char *s = strtok(solution[i],",");
				while (s != NULL) {
						input[i][j++]=atoi(s);
	
						s = strtok(NULL, ",");
				}
		}

		float tmp1,tmp2,tmp3,tmp4,tmp5,tmp6,tmp7,tmp8,tmp9,tmp10,tmp11,tmp12,tmp13,tmp14,tmp15,tmp16,tmp17,tmp18,tmp19,tmp20,tmp21,tmp22,tmp23,tmp24;
		fp=fopen("output.csv","w");
		for(i=0;i<total;i++){
						if(input[i][0]<=1) tmp1=pro1_1_1;
						else if(input[i][0]==2) tmp1=pro1_2_1;
						else if(input[i][0]==3) tmp1=pro1_3_1*1.25;
						else if(input[i][0]>=4) tmp1=pro1_4_1;

						if(input[i][1]<=24) tmp2=pro2_1_1;
						else if(input[i][1]<=42) tmp2=pro2_2_1;
						else if(input[i][1]<=600) tmp2=pro2_3_1*1.25;

						if(input[i][2]==0) tmp3=pro3_1_1;
						else if(input[i][2]==1) tmp3=pro3_2_1;
						else if(input[i][2]==2) tmp3=pro3_3_1;
						else if(input[i][2]==3) tmp3=pro3_4_1;
						else if(input[i][2]>=4) tmp3=pro3_5_1;

						if(input[i][3]<=50) tmp4=pro4_1_1;
						else if(input[i][3]<=100) tmp4=pro4_2_1;
						else if(input[i][3]<=600) tmp4=pro4_3_1*1.25;

						if(input[i][4]<=1) tmp5=pro5_1_1;
						else if(input[i][4]==2) tmp5=pro5_2_1;
						else if(input[i][4]==3) tmp5=pro5_3_1;
						else if(input[i][4]==4) tmp5=pro5_4_1;
						else if(input[i][4]>=5) tmp5=pro5_5_1;

						if(input[i][5]<=1) tmp6=pro6_1_1*1.25;
						else if(input[i][5]==2) tmp6=pro6_2_1;
						else if(input[i][5]==3) tmp6=pro6_3_1;
						else if(input[i][5]==4) tmp6=pro6_4_1*1.25;
						else if(input[i][5]>=5) tmp6=pro6_5_1;

						if(input[i][6]<=1) tmp7=pro7_1_1*1.25;
						else if(input[i][6]==2) tmp7=pro7_2_1;
						else if(input[i][6]==3) tmp7=pro7_3_1;
						else if(input[i][6]>=4) tmp7=pro7_4_1;

						if(input[i][7]<=1) tmp8=pro8_1_1*1.25;
						else if(input[i][7]==2) tmp8=pro8_2_1;
						else if(input[i][7]==3) tmp8=pro8_3_1;
						else if(input[i][7]>=4) tmp8=pro8_4_1;

						if(input[i][8]<=1) tmp9=pro9_1_1;
						else if(input[i][8]==2) tmp9=pro9_2_1;
						else if(input[i][8]==3) tmp9=pro9_3_1;
						else if(input[i][8]>=4) tmp9=pro9_4_1;

						if(input[i][9]<=30) tmp10=pro10_1_1;
						else if(input[i][9]<=55) tmp10=pro10_2_1;
						else if(input[i][9]<=600) tmp10=pro10_3_1*1.25;

						if(input[i][10]<=1) tmp11=pro11_1_1;
						else if(input[i][10]<=2) tmp11=pro11_2_1;
						else if(input[i][10]>=3) tmp11=pro11_3_1;

						if(input[i][11]<=1) tmp12=pro12_1_1;
						else if(input[i][11]==2) tmp12=pro12_2_1;
						else if(input[i][11]==3) tmp12=pro12_3_1;
						else if(input[i][11]>=4) tmp12=pro12_4_1;

						if(input[i][12]<=1) tmp13=pro13_1_1;
						else if(input[i][12]>=2) tmp13=pro13_2_1;

						if(input[i][13]<=1) tmp14=pro14_1_1;
						else if(input[i][13]>=2) tmp14=pro14_2_1;

						if(input[i][14]<=0) tmp15=pro15_1_1;
						else if(input[i][14]<=1) tmp15=pro15_2_1;
						else if(input[i][14]>=2) tmp15=pro15_3_1*2;

						if(input[i][15]<=0) tmp16=pro16_1_1;
						else if(input[i][15]>=1) tmp16=pro16_2_1;

						if(input[i][16]<=0) tmp17=pro17_1_1;
						else if(input[i][16]>=1) tmp17=pro17_2_1;

						if(input[i][17]<=0) tmp18=pro18_1_1*1.25;
						else if(input[i][17]>=1) tmp18=pro18_2_1;

						if(input[i][18]<=0) tmp19=pro19_1_1;
						else if(input[i][18]>=1) tmp19=pro19_2_1;

						if(input[i][19]<=0) tmp20=pro20_1_1;
						else if(input[i][19]>=1) tmp20=pro20_2_1;

						if(input[i][20]<=0) tmp21=pro21_1_1;
						else if(input[i][20]>=1) tmp21=pro21_2_1;

						if(input[i][21]<=0) tmp22=pro22_1_1;
						else if(input[i][21]>=1) tmp22=pro22_2_1;

						if(input[i][22]<=0) tmp23=pro23_1_1;
						else if(input[i][22]>=1) tmp23=pro23_2_1;

						if(input[i][23]<=0) tmp24=pro24_1_1*1.25;
						else if(input[i][23]>=1) tmp24=pro24_2_1;

						float final;
						final = (tmp1+tmp2+tmp3+tmp4+tmp5+tmp6+tmp7+tmp8+tmp9+tmp10+tmp11+tmp12+tmp13+tmp14+tmp15+tmp16+tmp17+tmp18+tmp19+tmp20+tmp21+tmp22+tmp23+tmp24)/24;
						//printf("%d  %f\n",i+1,final);
						if(input[i][24]==1){
								one++;
						}
						else two++;
						if(final>=0.70) {
								fprintf(fp,"1\n");
								if(input[i][24]==2){
										error++;

								}
						}

						else { 
								fprintf(fp,"2\n");
								if(input[i][24]==1){
										error++;
								}
						}


		}

		//printf("%d   %d\n",one,two);
		//printf("%d\n",error);





		//printf("%f\n%f",pro23_2_1,pro23_2_2);
		return 0;
		}
