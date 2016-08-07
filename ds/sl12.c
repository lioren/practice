#include <stdio.h>  
#include <stdlib.h>  
#include<string.h>  
main()  
{  
		char a[1001000];  
		int i=0,len;  
		while(fgets(a,1001000,stdin)!=NULL){  
				i=0;                              
				len=strlen(a);      
				while(a[i]!='\n'){  
						if(a[i]>='A'&&a[i]<='Z'){  
								a[i]=a[i]+57-((a[i]-65)*2);  
						}  
						else if(a[i]>='a'&&a[i]<='z'){  
								a[i]=a[i]-57-((a[i]-122)*2);  
						}  
						else if(a[i]>='0'&&a[i]<='9'){  
								if(a[i]=='9')  
										a[i]=a[i]-9;  
								else   
										a[i]=a[i]+1;  
						}  
						i++;  



				}  
				for(i=0;i<len-1;i++)  
				{  
						printf("%c",a[i]);  
				}  
				printf("\n");  
		}  
}  
