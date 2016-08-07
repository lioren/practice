#include<stdio.h>  
#include<stdlib.h>  
#include<string.h>  
main()  
{   
		int n,m;  
		scanf("%d",&n);  
		int a[n],i;  
		for(i=0;i<n;i++){  
				scanf("%d",&a[i]);  
		}  
		scanf("%d",&m);  
		int b[m];  
		for(i=0;i<m;i++)  
				b[i]=0;  
		for(i=0;i<n;i++)  
				b [ (a[i]%m)] =b [(a[i]%m)]+1  ;  
		for(i=0;i<m;i++){   
				printf("%d\n",b[i]);  
		}       
}  
