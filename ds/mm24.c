#include<stdio.h>    
int main()    
{    
		int a,b,c;    
		while(scanf("%d%d",&a,&b)!=EOF){    
				if(a>b){    
						c=a-b;    
						printf("%d\n",c);}    
				else if(a<b){    
						c=b-a;    
						printf("%d\n",c);}    
		}    
		return 0;    
}  
