#include<stdio.h>
#include<string.h>
#define MAXLINE 1000

int strindex(char source[],char searchfor[]);
char pattern[]="app";
main()
{
		char line[MAXLINE];
		int found=0;int j=0,c=0,d=0;
		char a[100];
		while(getword(line,MAXLINE)>0){
				if(strindex(line,pattern)>=0){
						c=strlen(line);
				if(c>d){
						d=c;
						strcpy(a,line);
				   

                       
				}
}
}
printf("%s",a);
return found;

}
int getword(char s[],int lim)
{
		int c,i;
		i=0;
		while(--lim>0&&(c=getchar())!=EOF&&c!='\n'&&c!=' '&&c!='\t')
				s[i++]=c;
		if(c=='\n'||c==' '||c=='\t')
				s[i++]=c;
		s[i]='\0';
		return i;
}
int strindex(char s[],char t[])
{
		int i,j,k;
		for(i=0;s[i]!='\0';i++){
				j=i;
				k=0;
				while(t[k]!='\0'&&s[j]==t[k]){
						j++;
						k++;
			//	for(j=i,k=0;t[k]!='\0'&&s[j]==t[k];j++,k++)
										//;
				if(k>0&&t[k]=='\0')
						return i;
				}
		}
		return -1;
}

