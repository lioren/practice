#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define max 10000
int main(void)
{
		int i,s,num=0,n=0,k=1;                                                 //s �C��Ū�i�Ӧr�ꪺ����   num �@���X�ӳ�r  k �C�Ӧr��@�}�l���Ӽ�
		char word[max];                                                        //�ΨӼȮɦs��C��Ū�i�Ӫ��r��
		char *buff2[max];                                                   //�ΨӦs��C�Ӧr��
		char *ptr;           
	  while (getword(word,max)>0){
	  		buff2[num]=(char*)malloc(strlen(word)+1);
	  		                    s=strlen(word);
	  		                    if(s>=1){
						        strcpy(buff2[num],word);
								num++;
								}}        
         for(i=0;i<num-1;i++){
         for(n=0;n<num-1;n++){
         		 if(strcmp(buff2[n],buff2[n+1])>0){
         		 		 ptr=buff2[n];
         		 		 buff2[n]=buff2[n+1];
         		 		 buff2[n+1]=ptr;}}}
         for(i=0;i<num-1;i++){
         		 if  (strcmp(buff2[i],buff2[i+1])==0){
                          k++;
                          continue;
                          }
         		 		 printf("%s\t%d\n",buff2[i],k);
         		 		 k=1;}
         		 		 printf("%s\t%d\n",buff2[i],k);
return 0;
}
int getword(char s[],int n)
{
		int c,i;
		i=0;
		while(--n>0&&(c=getchar())!=EOF&&c!='\n'&&c!=' '&&c!='\t')
				s[i++]=c;
				if(c=='\n'||c==' '||c=='\t')
						s[i++]=c;
						s[i-1]='\0';
						return i ;	
}



			
