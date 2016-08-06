#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<dirent.h>
void filecopy(FILE*,FILE*);
int main(int argc,char* argv[])
{
		FILE *fp;
		FILE *rp;
		DIR *d,*g;
		int a=0;
		int b=0;
		int f=0,sl=0;
		char *ptr;
		int com1=0,com2=0,com3=0,com4=0;
		char s[999],m[99];
		if(argc<=2){
				printf("error");
				return -1;
		}
		if(strcmp(argv[1],"-s")==0){
				com1=1;
				com3=1;
		}
		if(strcmp(argv[1],"-o")==0){
				com2=1;
				com4=1;
		}
		if((d=opendir(argv[argc-1]))!=NULL){
				for(b=1;b<argc-1;b++){
						if(com1==1){		    			   
								b++;
								com1=0;
						}
						else if(com2==1){
								b++;
								com2=0;
						}
						fp=fopen(argv[b],"r");
						if((g=opendir(argv[b]))==0){
								sl=strlen(argv[b]);
								ptr=&(argv[b][sl-1]);
								while(*(ptr)!='/'){
										ptr--;
										sl--;
										if(sl==1){
												argv[b]=ptr;
												goto mark1;
										}
								}
								ptr=ptr+1;	
								argv[b]=ptr;

mark1:           sprintf(s,"%s/%s",argv[argc-1],argv[b]);
				 rp=fopen(s,"r");
				 if(rp==NULL){
						 rp=fopen(s,"w");
						 filecopy(fp,rp);
				 }
				 else if(rp!=NULL){
						 if(com3==1){
								 continue;
						 }
						 if(com4==1){
								 rp=fopen(s,"w");
								 filecopy(fp,rp);
								 continue;
						 }
						 printf("%s has existed. 1.cover 2.exit:",argv[b]);
						 scanf("%d",&f);
						 if(f==1){
								 rp=fopen(s,"w");
								 filecopy(fp,rp);
						 }
						 else if(f==2)
								 continue;
						 else 
								 printf("fuck");
				 }
						}
				}
		}
		else {
				fp=fopen(argv[argc-2],"r");
				rp=fopen(argv[argc-1],"r");
				if(rp==NULL){
						rp=fopen(argv[argc-1],"w");
						filecopy(fp,rp);
						rp=fopen(argv[argc-1],"r");
				}
				else if(rp!=NULL){
						if(com3==1){
								return 0;
						}
						if(com4==1){

								rp=fopen(argv[argc-1],"w");
								filecopy(fp,rp);
								return 0;
						}
						printf("The file has existed. 1.cover 2.exit:");
						scanf("%d",&f);
						if(f==1){
								rp=fopen(argv[argc-1],"w");
								filecopy(fp,rp);
						}
						else if(f==2)
								return 0;
						else
								printf("fuck!");
				}
		}
}
void filecopy(FILE* ifp,FILE* ofp)
{
		int c ;		
		while((c=getc(ifp))!=EOF){
				putc(c,ofp);
		}
}

