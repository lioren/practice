#include <stdio.h>  
#include <stdlib.h>  
#include<string.h>  
main()  
{  
		char a[100];  
		int l=0,ans=0,i=0;  
		while(1){  
				fgets(a,100,stdin);  
				if(a[0]=='e'&&a[1]=='n'&&a[2]=='d')  
						break;  
				l=strlen(a)-1;   
				for(i=0;i<l;i++){  
						if(a[i]=='a'||a[i]=='e'||a[i]=='i'||a[i]=='o'||a[i]=='u')  
								ans=ans+5;  
						else  if(a[i]=='A'||a[i]=='E'||a[i]=='I'||a[i]=='O'||a[i]=='U')  
								ans=ans+6;                  
						else if(a[i]>='a'&&a[i]<='z')  
								ans=ans+2;  
						else   
								ans=ans+3;  
				}  
				printf("%d\n",ans);  
				ans=0;  
		}   
		return 0 ;  
}  

