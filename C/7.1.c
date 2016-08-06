#include<stdio.h>

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
