#include <stdlib.h>  
#include <stdio.h>  

int  main(void)  
{  
		int mm=0,n,big=0,now,small=99999999 ;  
		typedef struct{  
				int x;  
				int y;  
				int most;  
		} cor ;  
		cor num[100];  
		scanf("%d",&n);  
		int k,x1=200,y1=200;  
		k=n;  
		int x,y,i=0,j;  
		while(n>0){  
				scanf("%d%d",&x,&y);  
				num[i].x=x;  
				num[i].y=y;  
				i++;  
				n--;  
		}  
		for(i=0;i<k;i++){  
				for(j=0;j<k;j++){  
						if(i==j)  
								continue;  
						now=(num[i].x-num[j].x)*(num[i].x-num[j].x)+(num[i].y-num[j].y)*(num[i].y-num[j].y);  
						if(now>=big){  
								big=now;  
								num[i].most = big  ;  
						}  
				}  
				big=0;  
		}  
		for(i=0;i<k;i++){  
				if(num[i].most<small){  
						x1=num[i].x;  
						y1=num[i].y;  
						small=num[i].most;  
						mm=i;  
				}  
				if(num[i].most==small){  
						if(num[i].x<x1){  
								mm=i;  
								continue;}  
						else if(num[i].y<y1)  
								mm=i;  
				}               
		}  
		printf("%d %d\n",num[mm].x,num[mm].y);  

  
}  
