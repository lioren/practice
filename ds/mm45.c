#include <stdlib.h>            
#include <stdio.h>            
int main()            
{            
		int a,b,c,tmp;            
		scanf("%d%d%d",&a,&b,&c);          
		if(a+b<=c||a+c<=b||b+c<=a)        
				printf("invalid\n");        
		else   if (a*a+b*b==c*c||a*a+c*c==b*b||b*b+c*c==a*a)        
				printf("right\n");     
		else if(a*a+b*b<c*c||a*a+c*c<b*b||b*b+c*c<a*a)        
				printf("obtuse\n");                
		else if(a*a+b*b>c*c||a*a+c*c>b*b||b*b+c*c>a*a)        
				printf("acute\n") ;           
}  
