#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<dirent.h>
#include<ctype.h>
char* strcasstr(char*a ,char*b);
int main(int argc,char* argv[])
{
		FILE *fp;
		FILE *rp;
		DIR *g,*d;
		struct dirent *entry;
		char s[9999];
		int i,j=0,buf=0,line=0;
		int cmd1=0,cmd2=0,cmd3=0,cmd4=0;
		if(argc<=2){
				printf("error!\n");
				return -1;
		}
		if(strcmp(argv[1],"-cr")==0||strcmp(argv[1],"-rc")==0){
				cmd1=1;
				cmd2=1;
		}
		else if(strcmp(argv[1],"-c")==0){
				cmd1=1;
		}
		else if(strcmp(argv[1],"-r")==0){
				cmd2=1;
		}
		if(argc==3){
				char *head,*ptr;
				line=0;
				fp=fopen(argv[2],"r");	
				while(fgets(s,9999,fp)!=NULL){
						head=s;
						line++;
						while(((ptr=strcasstr(s,argv[1]))!=NULL)){
						
										printf("In %s  Line %d : char %d~%d\n",argv[2],line,(int)(ptr-head)+1,(int)(ptr-head)+(int)strlen(argv[1]));
								*ptr=' ';
						}
			
					
				}
		}
		if(argc==4){
				//if(cmd1==1&&cmd2==1){

				//}
			 if(cmd1==1&&cmd2==0){
			 		 char *head,*ptr;
			 		 fp=fopen(argv[3],"r");
			 		 line=0;
			 		 while(fgets(s,9999,fp)!=NULL){
			 		 		 head=s;
			 		 		 line++;
			 		 		 while(((ptr=strstr(s,argv[2]))!=NULL)){
			 		 		 		 printf("In %s Line %d : Char %d ~ %d\n",argv[3],line,(int)(ptr-head)+1,(int)(ptr-head)+(int)(strlen(argv[2])));
			 		 		 		 *ptr=' ';
							 }
			 		 		 
					 }

				}
				else if(cmd1==0&&cmd2==1||(cmd1==1&&cmd2==1)){
						char fname[30];
						char gname[30];
						FILE *np;
						DIR *a;
						struct dirent *entry2;
						char *ptr,*head;
						line=0;
						if( (d =  opendir(argv[3])) != NULL){
								while((entry=readdir(d))!=NULL){
										if((strcmp(entry->d_name,".")==0)||strcmp(entry->d_name,"..")==0)
												continue;
										sprintf(fname,"%s/%s",argv[3],entry->d_name);
										np=fopen(fname,"r");
										a=opendir(fname);
										if(np!=NULL){
												line=0;
												while(fgets(s,9999,np)!=NULL){
														head=s;
														line++;
														if(cmd1==0){
																while(((ptr=strcasstr(s,argv[2]))!=NULL)){
																		printf("In %s Line %d : Char %d ~ %d\n" ,fname,line,(int)(ptr-head+1),((int)(ptr-head))+(int)(strlen(argv[2])));
																		*ptr=' ';
																}
														}
														else if(cmd1==1){
																while(((ptr=strstr(s,argv[2]))!=NULL)){
																		printf("In %s Line %d : Char %d ~ %d\n" ,fname,line,(int)(ptr-head+1),((int)(ptr-head))+(int)(strlen(argv[2])));
																		*ptr=' ';
																}
														}
												}
										}
										if(a!=NULL){
												while((entry2=readdir(a))!=NULL){
														if((strcmp(entry2->d_name,".")==0)||(strcmp(entry2->d_name,"..")==0))
																continue;
														sprintf(gname,"%s/%s",fname,entry2->d_name);
														if((fp=fopen(gname,"r"))!=NULL){
																line=0;
																while(fgets(s,9999,fp)!=NULL){
																		head=s;
																		line++;
																		if(cmd1==0){
																				while(((ptr=strcasstr(s,argv[2]))!=NULL)){
																						printf("In %s Line %d :Char %d ~ %d\n",gname,line,(int)(ptr-head+1),(int)(ptr-head)+(int)(strlen(argv[2])));
																						*ptr=' ';
																				}
																		}
																		else if(cmd1==1){
																				while(((ptr=strstr(s,argv[2]))!=NULL)){
																						printf("In %s Line %d : Char %d ~ %d\n" ,fname,line,(int)(ptr-head+1),((int)(ptr-head))+(int)(strlen(argv[2])));
																						*ptr=' ';
																				}
																		}
																}
														}

												}
										}

								}
						}
				}


		}
}
char* strcasstr(char*a,char*b)
{
		int i ;
		char* p;
		for(i=0;a[i]!='\0';i++)
				a[i]=toupper(a[i]);
		for(i=0;b[i]!='\0';i++)
				b[i]=toupper(b[i]);

		p=strstr(a,b);
		return p;
}
