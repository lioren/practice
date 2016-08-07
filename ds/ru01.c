#include<stdio.h>  
#include<stdlib.h>  
main()  
{  
		int n ;  

		while( scanf("%d",&n)!=EOF){  
				if (n==0) return -1;  
				int count=0;  
				while (1) {  
						while ((n&1)==0) { n >>= 1; ++count; }  
						if (n<=3) {  

								count += n - 1;  
								break;  
						}  
						if ((n&3)==1)  --n;  
						else ++n;  
						++count;  
				}  
				printf("%d\n",count);  
		}   
}  
