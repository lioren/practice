#include<stdio.h>      
#include<stdlib.h>      
int main()      
{      
		int i, j, n,k=0;      
		while(1){    
				scanf ("%d", &n);    
				if(n==0)    
						break;                                 
				for (i=2; i<n; i++)      
				{      
						for (j=2; j<i; j++)           
								if(i%j == 0) goto next;             
						k++;      
next: ;      
				}      
				printf("%d\n",k);  
				k=0;    
		}           
		return 0;      
}  
