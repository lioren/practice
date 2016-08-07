#include<stdio.h>  
#include<stdlib.h>  
#include<string.h>  
main()  
{   
		int n;  
		scanf("%d",&n);  
		int a[n],i;  
		int b[3];  
		b[0]=0;b[1]=0,b[2]=0;  
		for(i=0;i<n;i++){  
				scanf("%d",&a[i]);  
		}  
		for(i=0;i<n;i++){  
				b [ (a[i]%3)] =b [(a[i]%3)]+1  ;  
		}  
		printf("%d %d %d\n",b[0],b[1],b[2]);  
 
}  
