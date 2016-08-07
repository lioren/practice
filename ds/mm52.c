#include <stdio.h>  
#include <stdlib.h>   
#include <string.h>  

int main(void)  
{  
		int a=0,b=0,c=0,n;  
		scanf("%d",&n);  
		while(a<n){  

				while(b<a){  
						if((a%b)==0){  
								c=c+b;  
								b++;}  
						else   
								b++;  
				}  

				b=1;    
				if(a==1||a==4)  
						printf("%d\n",a);  
				if(c==a)  
						printf("%d\n",c);  
				c=0;  
				a++;     
		}  
		return 0;  
}  
