#include<stdio.h>                              
int main()                              
{      int line,h2=0,v2=0,h3=0,v3=0;                              
		double sum=200,h,v;                      
		scanf("%d",&line);                                     
		while(line>0){                              
				int a,b,c;                              
				while(scanf("%d%d%d",&a,&b,&c)!=EOF){                              
						v=a*b*c;                              
						h=(2*((a*b)+(b*c)+(c*a)));                              
						if(sum>(h/v)){                              
								sum=(h/v);                        
								h2=(int)h;                              
								v2=(int)v;                              
								line--;}                              
						else                              
								line--;                                     
				} }                             
		h3=h2;                          
		v3=v2;               
		int c=0;                       
		while(h2%v2){                              
				c=h2;                              
				h2=v2;                              
				v2=c%h2;                          
		}                                         
		printf("%d/%d\n",(h3/v2),(v3/v2));                      
		return 0;                                                    
}  
