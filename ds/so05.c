#include<stdio.h>  
#include<stdlib.h>  
#include<string.h>  
main()  
{   
		int a,b,i,j,k;   
		scanf("%d",&a);  
		while(a>0){  
				a--;   
				scanf("%d",&b);  
				int c[b];  
				int d[b];  
				int e[2*b];  
				for(i=0;i<b;i++)  
						scanf("%d",&c[i]);  
				for(i=0;i<b;i++)  
						scanf("%d",&d[i]);  
				for(i=0,j=0,k=0;k<b;){  
						if(c[i]>=d[j]){   
								e[k]=d[j];  
								k++;  
								j++;   
						}   
						else {  
								e[k]=c[i];  
								k++;  
								i++;   
						}   

				}   
				printf("%d\n",e[b-1]);   

		}   
	 
}  
