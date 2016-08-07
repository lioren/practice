#include <stdio.h>  
#include <stdlib.h>   
#include <string.h>  
int pow1(int,int);  
int main(void)  
{  
		char c[10];  
		int n[10],l;  
		int i;  
		int ans=0 ;  
		while(fgets(c,10,stdin)!=0){  
				l=strlen(c)-1;  
				for(i=0;i<l;i++){                               
						n[i]=c[i]-64;  
				}  
				for(i=0;i<l;i++){  
						ans= ans + (n[i])*pow1(26,l-i-1);    
				}  
				printf("%d\n",ans);  
				ans=0;  
		}  
}  
int pow1(int a,int b)  
{     int c=1,i;  
		for(i=0;i<b;i++){  
				c= c*a;  
		}  
		return  c;  
}  
