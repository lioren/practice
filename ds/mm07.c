#include<stdio.h>  
#include<string.h>  
#include<stdlib.h>  
main()  
{  
		int  a,b,count=0;  
		char c[15];  
		char d[15];  
		scanf("%d%d",&a,&b);  
		sprintf(c,"%d",a);  
		sprintf(d,"%d",b);  
		char* ptr;  
		ptr=d;  
		while(ptr!=NULL){                                                   ptr=strstr(d,c);  
				if(ptr==NULL){  
						break;}  
				else {  
						strcpy(d,ptr+1);  
						count++;}  
		}  
		printf("%d\n",count);  
}  
