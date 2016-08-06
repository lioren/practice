#include<stdio.h>
#define MAXLINE 1024
int getline(char line[],int maxline);
void copy(char to[],char from[]);
main()
{
		int len,max;
		char line[MAXLINE];
        char longest[MAXLINE];
        max=0;
        while((len=getline(line,MAXLINE))>0)
        		if(len>max){
        				max=len;
        				copy(longest,line);
				}
				if(max>0)printf("%s",longest);
				return 0;
}
				void copy(char to[],char from[])
				{int i;
				i=0;
				while((to[i]=from[i])!='\0')i++;
				}
                  
		
