#include<stdio.h>  
#include<stdlib.h>  
#include<string.h>  
#include<math.h>  
main()  
{  
		int a,l,q;  
		float num=0;  
		float cou=7;  
		char b[25];  
		char c[15];  
		char *ptr;  
		scanf("%d",&a);  
		getchar();  
		while(a>0){  
				a--;  
				fgets(b,25,stdin);  
				ptr=b;  
				l=strlen(b);  
				b[l]='\0';  
				while(*ptr!=' ')  
						ptr++;  
				ptr++;  
				while(cou>=0){  
						if(*ptr=='0'){  
								ptr++;  
								cou--;  
						}  
						else if(*ptr=='1'){  
								num=num+pow(2,cou);  
								ptr++;  
								cou--;                  
						}  
				}  
				ptr=b;  
				cou=7;  
				while(cou>=0){  
						if(*ptr=='0'){  
								ptr++;  
								cou--;  
						}  
						else if(*ptr=='1'){  
								num=num+pow(2,cou);  
								ptr++;  
								cou--;                  
						}  
				}  
				q=(int)(num+0.5);  
				printf("%d\n",q);  
				num=0;  
				cou=7;              
		}    
		return 0;  
}  
