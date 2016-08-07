#include<stdio.h>  
#include<stdlib.h>  
#include<string.h>  
main()  
{  
		char a[100],buf;  
		int i ,j,l,ans=1,buf2=1,now=1;  
		char *ptr;  
		while(fgets(a,100,stdin)!=NULL){  
				buf2=1;  
				now=1;  
				ans=1;  
				l=strlen(a)-1;  
				if(l==1){  
						printf("%c\n",a[0]);  
						continue;  

				}  
				a[l]='\0';                        
				for(i=0;i<l;i++){  
						for(j=0;j<l-1;j++){  
								if(a[j]>a[j+1]){  
										buf=a[j+1];  
										a[j+1]=a[j];  
										a[j]=buf;   
								}             
						}  
				}                 
				ptr=a;  
				while(*ptr!='\0'){  
						if(*ptr==*(ptr+1)){  
								now++;  
								ptr++;  
						}  
						else{  
								if(now==ans){  
										buf2=now;  
										now=1;  
								}  
								else if(now>ans){  
										ans=now;  
										buf=*ptr;}  
								ptr++;  
								now=1;                                               
						}  
				}  

				if(buf2==ans){  
						printf("None\n");}  
				else  
						printf("%c\n",buf);  

		}   
}  
