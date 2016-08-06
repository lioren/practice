#include<stdio.h>
#include<stdlib.h>
int main (int argc , char* argv[])
{        
	    char bitmask[8],array[6];
        bitmask[7]=1;
        bitmask[6]=1<<1;
        bitmask[5]=1<<2;
        bitmask[4]=1<<3;
        bitmask[3]=1<<4;
        bitmask[2]=1<<5;
        bitmask[1]=1<<6;
        bitmask[0]=1<<7;
        char s,x,c;
	    char picA[12][12];
	    char picB[12][12];
	    char picC[12][12];
	    char picD[12][12];
	    char big[12][72];
	    int i=0,j=0,num=0,lengh=0,wide=0,count=0,n=0;
	    char ch;
	    FILE *fp;
	    fp=fopen(argv[1],"rb");
        while(num!=76)
        {
        	  ch=fgetc(fp);
              if(lengh==0){
              		  lengh=ch;
              		  num++;
              		  continue;
			  }
              if(wide==0){
              		  wide=ch;
              		  num++;
              		  continue;
			  }
			  if(count==0){
			  		  count=ch;
			  		  num++;
			  		  continue;
			  }
			  for(j=0;j<=7;j++){
			  		  s=(ch)&(bitmask[j]);     
			  		  if(n==12){
                           i++;
                           n=0;}
                 if(i<12) {         
			  		  if(s!=0){
			  		  		  picA[i][n]=1;
			  		  		  n++;
					  }
					  if (s==0){
					  		  picA[i][n]=0;
					  		  n++;
					  }
				 }
				 if(i>=12&&i<24){
				 	 if(s!=0){
				 	 		 picB[i-12][n]=1;
				 	 		 n++;
					 }
					 if(s==0){
					 		 picB[i-12][n]=0;
					 		 n++;
					 }
				 }
				 if(i>=24&&i<36){
				 	 if(s!=0){
				 	 		 picC[i-24][n]=1;
				 	 		 n++;
					 }
					 if(s==0){
					 		 picC[i-24][n]=0;
					 		 n++;
					 }
				 }
                 if(i>=36&&i<48){
				 	 if(s!=0){
				 	 		 picD[i-36][n]=1;
				 	 		 n++;
					 }
					 if(s==0){
					 		 picD[i-36][n]=0;
					 		 n++;
					 }
				 }
			  }
       		num++;
		}
        i=0;
        while((c=getchar())!='\n'){
        		array[i]=c;
        		i++;
        }
               if(i>6){
               		   printf("error");
               		   return -1;}
               for(s=0;s<i;s++){
               		   if(array[s]!='a'&&array[s]!='b'&&array[s]!='c'&&array[s]!='d'&&array[s]!='A'&&array[s]!='B'&&array[s]!='C'&&array[s]!='D'){
               		   		   printf("error");
               		   		   return -1;
					   }
			   }
               		   
             for(s=0;s<i;s++){	   
                 if(array[s]=='a'||array[s]=='A'){
                    for(i=0;i<12;i++){
                    		for(j=0;j<12;j++){
                    				if(picA[i][j]==0)
                    			    printf(" ");
                    			    else 
                    			    printf("*");
							}
							if(i<11)
							printf("\n");
					}
				  }
				  if(array[s]=='b'||array[s]=='B'){
                    for(i=0;i<12;i++){
                    		for(j=0;j<12;j++){
                    				if(picB[i][j]==0)
                    			    printf(" ");
                    			    else 
                    			    printf("*");
							}
							if(i<11)
		                    printf("\n");
					}
				  }
                   if(array[s]=='c'||array[s]=='C'){
                    for(i=0;i<12;i++){
                    		for(j=0;j<12;j++){
                    				if(picC[i][j]==0)
                    			    printf(" ");
                    			    else 
                    			    printf("*");
							}
							if(i<11)
							printf("\n");
					}
				  }
				   if(array[s]=='d'||array[s]=='D'){
                    for(i=0;i<12;i++){
                    		for(j=0;j<12;j++){
                    				if(picD[i][j]==0)
                    			    printf(" ");
                    			    else 
                    			    printf("*");
							}
							if(i<11)
							printf("\n");
					}
					}		
			 }
}
