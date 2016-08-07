#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(int argc , char *argv[])
{
		FILE *fp;
		FILE *rp;
		char *ptr;
		char c,a;
		char tmp[5]={};
		char name[20];
		char buf[999]={};
		char array[999]={};
		char array2[999]={};
		int i=0,top=0,j,top2=0,num=0,j2,line=1;
		fp=fopen(argv[1],"r");
		ptr=strtok(argv[1],".");
		sprintf(name,"%s.output",ptr);
		rp=fopen(name,"w");
		while((c=getc(fp))!=EOF){
				if(c=='\n')
						line++;
				if(c=='<'){
						if(i!=0){
								for(j=0;j<i;j++)
										putc(buf[j],rp);
						}
						i=0;
						buf[i]=c;
						i++;		        		
				}
				else if(c=='>'){
						buf[i]=c;
						if((strcmp(buf,"<Newline>")==0)){
								if(top>0){
										array2[top2]='\n';
										top2++;
								}
								else if(top==0)
								putc('\n',rp);
						}
						else if((strcmp(buf,"<Proper>")==0)){
								array[top]='P';
								top++;
						}
						else if((strcmp(buf,"<Upper>")==0)){
								array[top]='U';
								top++;
						}
						else if((strcmp(buf,"<Lower>")==0)){
								array[top]='L';
								top++;
						}
						else if((strcmp(buf,"<Reverse>")==0)){
								array[top]='R';
								top++;
						}
						else if(buf[1]=='I'&&buf[2]=='n'&&buf[3]=='s'&&buf[4]=='e'&&buf[5]=='r'&&buf[6]=='t'&&buf[7]==' '&&buf[8]=='c'&&buf[9]=='h'&&buf[10]=='a'&&buf[11]=='r'){
								j=26;
								ptr=&(buf[26]);
								while((*ptr)>='0'&&(*ptr)<='9'){
										tmp[num]=*ptr;
										num++;
										ptr++;
								}
								num=atoi(tmp);

								for(j=0;j<num;j++){
										putc(buf[16],rp);
								}
								for(j=0;j<5;j++)
										tmp[j]='\0';
								num=0;
						}
						else if((strcmp(buf,"</Proper>")==0)){
								if(array[top-1]!='P'){
										printf("ERROR!In %s.tex Line: %d  Pair of tags are interleaved!",argv[1],line);
										return -1;
								}

								if((top-1)!=0){
										ptr=strtok(array2," ");
										while(ptr!=NULL){
												if((*ptr)>='a'&&(*ptr)<='z')
														*ptr=(*ptr)-32;         
												ptr=strtok(NULL," ");
												
										}					
										array[top-1]='\0';
										top--;
								}

								else if((top-1)==0){
										ptr=strtok(array2," ");
										while(ptr!=NULL){
												if((*ptr)>='a'&&(*ptr)<='z')
														*ptr=(*ptr)-32;         
												ptr=strtok(NULL," ");   

										}
										for(j=0;j<top2;j++){
												if(array2[j]=='\0'){
														putc(' ',rp);
														continue;
												}
												putc(array2[j],rp);
										}
										array[top-1]='\0';
										top--;
										top2=0;
								}

						}
						else if((strcmp(buf,"</Upper>")==0)){
								if(array[top-1]!='U'){
									     printf("ERROR!In %s.tex Line: %d  Pair of tags are interleaved!",argv[1],line);
										return -1;
								}
								if((top-1)!=0){
										for(j=0;j<strlen(array2);j++){
												array2[j]=toupper(array2[j]);
										}
										array[top-1]='\0';
										top--;
								}
								else if((top-1)==0){
										for(j=0;j<strlen(array2);j++){
												array2[j]=toupper(array2[j]);
												putc(array2[j],rp);
										}
										array[top-1]='\0';
										top--;
										top2=0;
								}
						}
						else if((strcmp(buf,"</Lower>")==0)){
								if(array[top-1]!='L'){ 
										printf("ERROR!In %s.tex Line: %d  Pair of tags are interleaved!",argv[1],line);
										return -1;
								}
								if((top-1)!=0){
										for(j=0;j<strlen(array2);j++){
												array2[j]=tolower(array2[j]);
										}
										array[top-1]='\0';
										top--;
								}
								else if((top-1)==0){
										for(j=0;j<strlen(array2);j++){
												array2[j]=tolower(array2[j]);
												putc(array2[j],rp);
										}
										array[top-1]='\0';
										top--;
										top2=0;
								}

						}
						else if((strcmp(buf,"</Reverse>")==0)){
								if(array[top-1]!='R'){
										printf("ERROR!In %s.tex Line: %d  Pair of tags are interleaved!",argv[1],line);
										return -1;
								}
								if((top-1)!=0){
										for(j=0,j2=strlen(array2)-1;j<j2;j++,j2--){
												a=array2[j];
												array2[j]=array2[j2];
												array2[j2]=a;
										}
										array[top-1]='\0';
										top--;
								}
								if((top-1)==0){
										for(j=0,j2=strlen(array2)-1;j<j2;j++,j2--){
												a=array2[j];
												array2[j]=array2[j2];
												array2[j2]=a;
										}
										for(j=0;j<strlen(array2);j++){
												putc(array2[j],rp);
										}
										array[top-1]='\0';
										top--;
										top2=0;
								}

						}

						for(j=0;j<=i;j++)
								buf[j]='\0';
						i=0;

				}
				else if(i!=0){
						buf[i]=c;
						i++;
				}
				else if(i==0&&top==0){
						putc(c,rp);
				}
				else if(i==0&&top!=0){
						array2[top2]=c;
						top2++;
				}
				if(top2==0){
						for(j=0;j<200;j++)
								array2[j]='\0';
				}
		}
}
