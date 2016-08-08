#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<time.h>
#include<fnmatch.h>
#include<dirent.h>
#include<openssl/md5.h>
typedef struct tnode{
		char key[33];
		char name[20];
		int e;
		int begin;
		int end;
		int exist;
		int exist_line;
		char location[90];
		struct tnode *next;
}ads;
typedef struct DB{
		int id;
		char key[33];
		char name[20];
		char time[30];
		int s;
		int e;
		int el;
		char location[90];
		char p;
		int begin;
		int end;
		char v[8];

}mydb;
typedef struct dir{
		int id;
		char name[30];
		char location[90];
		int  exist;
}mydir;
mydb db[100000];
mydir dir[1000];
ads* app[513];
int hash33(char*);
int totalsize=0;
int numobject=-1;
char buf2[100];
int sizecmp(const void*,const void*);
int namecmp(const void*,const void*);
int locationcmp(const void*,const void*);
void hinsert(char* ,char* ,int, int, int,int,int,char*);
void savefile(char* , char*);
void create(char*,int);
void update_file();
int main(int argc, char* argv[]){
		size_t ret;
	//	int numobject= -1;
		FILE* dirptr;
		int numdir=-1;
		dirptr=fopen("./dir.db","r");

		while(fgets(buf2,99,dirptr)!=NULL){
				if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
				if(strcmp(buf2,"@id:")==0){
						fgets(buf2,99,dirptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						numdir++;
						dir[numdir].id= atoi(buf2);
				}
				else if(strcmp(buf2,"@name:")==0){
						fgets(buf2,99,dirptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						int i;
						for(i=0;i<90;i++){
								if(buf2[i]==' ')buf2[i]='\0';
						}
						strcpy(dir[numdir].name,buf2);

				}
				else if(strcmp(buf2,"@location:")==0){
						fgets(buf2,99,dirptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						int i;
						for(i=0;i<90;i++){
								if(buf2[i]==' '){buf2[i]='\0';break;}
						}
						strcpy(dir[numdir].location,buf2);

				}
				else if(strcmp(buf2,"@exist:")==0){
						fgets(buf2,99,dirptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						dir[numdir].exist = atoi(buf2);

				}
		}
		fclose(dirptr);
		update_file();
		if(argc==1){

		}
		else if(strcmp(argv[1],"move")==0){
				if(strcmp(argv[2],"-f")==0){
						int i;
						int des_f=0;
						char des[20];
						char des_l[90];
						FILE* dptr;
						for(i=0;i<numdir+1;i++){
								if((strcmp(dir[i].name,argv[4])==0) && dir[i].exist==1){
										strcpy(des,argv[4]);
										des_f=1;
										strcpy(des_l,dir[i].location);
										//printf("%s\n",des_l);
								}
						}
						if(des_f==0){printf("destination directory not found\n");exit(1);}


						int hv=hash33(argv[3]);
						ads* qtr;
						qtr=app[hv];
						if(qtr==NULL){printf("This file not exist\n");exit(1);}
						else{ 
								while((strcmp(qtr->name,argv[3])!=0) || (qtr->exist==0)){
										qtr=qtr->next;
										if(qtr==NULL){printf("This file not exist\n");exit(1);}
								}
						}
						int line = qtr->exist_line;
						int curline=1;


						dptr=fopen("my.db","r+");
						char newloc[90];
						int j;

						for(j=0;j<90;j++)newloc[j]=' ';newloc[89]='\0';
						//strcat(des_l,des);
						//strcat(des_l,"/");
						strncpy(newloc,des,strlen(des));

						//printf("123");
						while(!(feof(dptr))){
								fgets(buf2,99,dptr);
								curline++;
								if(curline==(line+4)){
										fseek(dptr,0,SEEK_CUR);
										fprintf(dptr,"%s",newloc);
										break;
								}
						}
						fclose(dptr);


				}
				else if(strcmp(argv[2],"-d")==0){
						FILE* dptr;
						int i;
						int sor_f=0;
						int des_f=0;
						char sor[20];
						char des[20];
						char sor_l[90];
						char des_l[90];
						for(i=0;i<numdir+1;i++){
								if((strcmp(dir[i].name,argv[3])==0) && dir[i].exist==1){
										strcpy(sor,argv[3]);
										sor_f=1;
										strcpy(sor_l,dir[i].location);
										//printf("%s\n",sor_l);
								}
								if((strcmp(dir[i].name,argv[4])==0) && dir[i].exist==1){
										strcpy(des,argv[4]);
										des_f=1;
										strcpy(des_l,dir[i].location);
										//printf("%s\n",des_l);
								}
						}
						if(sor_f==0||des_f==0){
								if(sor_f==0)printf("source directory not found\n");
								if(des_f==0)printf("destination directory not found\n");
								exit(1);
						}

						dptr=fopen("dir.db","r+");

						char newloc[90];
						int j;
						for(j=0;j<90;j++)newloc[j]=' ';newloc[89]='\0';
						strcat(des_l,des);
						strcat(des_l,"/");
						strncpy(newloc,des_l,strlen(des_l));

						while(!(feof(dptr))){
								fgets(buf2,99,dptr);
								if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
								if(strcmp(buf2,sor)==0){
										fgets(buf2,99,dptr);
										fseek(dptr,0,SEEK_CUR);
										fprintf(dptr,"%s",newloc);
										break;
								}

						}
						fclose(dptr);


				}
		}
		else if(strcmp(argv[1],"create")==0){
				create(argv[2],numdir);



		}
		else if(strcmp(argv[1],"save")==0){
				printf("save\n");
				if(argc==3){
						char path[30] = "";
						savefile(argv[2],path);

				}
				else if(argc==4){
						if(strcmp(argv[2],"-d")==0){

								DIR* dir;
								struct dirent* ptr;
								dir=opendir(argv[3]);
								if(dir==NULL){printf("Directory not found\n");exit(1);}
								create(argv[3],numdir);
								while((ptr=readdir(dir))!=NULL){
										if(strcmp(ptr->d_name,".")==0 || strcmp(ptr->d_name,"..")==0) continue;
										printf("save %s\n",ptr->d_name);
										savefile(ptr->d_name,argv[3]);

								}

						}


				}

		}
		else if(strcmp(argv[1],"get")==0){
				//printf("get\n");
				if(argc==3){
						int i;
						int hv=hash33(argv[2]);
						ads* qtr;
						qtr=app[hv];
						if(qtr==NULL){printf("This file not exist\n");exit(1);}
						else if((qtr->exist)==0){printf("This file not exist\n");exit(1);}
						else{ 
								while(strcmp(qtr->name,argv[2])!=0)
										qtr=qtr->next;
						}
						int cbegin,cend;
						if((qtr->begin)==0)
								cbegin=qtr->begin;
						else
								cbegin=qtr->begin;
						cend=qtr->end;

						//	printf("%d   %d\n",cbegin,cend);

						FILE* dataptr;
						char* buf;
						size_t ret;
						dataptr = fopen("./alldata","rb");
						fseek(dataptr,(long)cbegin,0);

						buf=(char*)malloc(((qtr->end)-(qtr->begin))*sizeof(char));
						int offset=0;

						fread(buf,1,(qtr->end)-(qtr->begin),dataptr);
						//offset++;


						fclose(dataptr);
						FILE* fptr2;
						char path[50] = "./";
						strcat(path,argv[2]);
						fptr2 =fopen(path,"wb+");
						fwrite(buf,1,(qtr->end)-(qtr->begin),fptr2);
						fclose(fptr2);

				}
				else if(argc==4){
						if(strcmp(argv[2],"-d")==0){
								int i;
								for(i=0;i<=numdir;i++){

										if((strcmp(argv[3],dir[i].name)==0) && dir[i].exist==1){
												break;
										}
								}
								if(i==numdir+1){ printf("Directory not found\n");exit(1);}
								int j;
								char cmd[90];
								strcat(cmd,"mkdir ");
								strcat(cmd,argv[3]);
								//printf("%s\n",cmd);
								system(cmd);
								for(j=0;j<=numobject;j++){
										if(strcmp(db[j].location,argv[3])==0 && db[j].e==1){
												FILE* dataptr;
												char* buf;
												size_t ret;
												int cbegin,cend;
												cbegin= db[j].begin;
												cend=db[j].end;
												dataptr = fopen("./alldata","rb");
												fseek(dataptr,(long)cbegin,0);

												buf=(char*)malloc((cend-cbegin)*sizeof(char));
												int offset=0;

												fread(buf,1,(cend-cbegin),dataptr);
												fclose(dataptr);

												FILE* fptr2;
												char path[50] = "./";
												strcat(path,argv[3]);
												strcat(path,"/");
												strcat(path,db[j].name);
												fptr2 =fopen(path,"wb+");
												fwrite(buf,1,(cend-cbegin),fptr2);
												fclose(fptr2);

										}
								}

						}


				}
		}
		else if(strcmp(argv[1],"list")==0){
				//	printf("list\n");
				int i;
				printf("Directory:\n");
				printf("id       directory_name       location\n");
				for(i=0;i<=numdir;i++){
						if(dir[i].exist!=0)
								printf("%-9d%-21s%s\n",dir[i].id,dir[i].name,dir[i].location);
				}
				printf("\n");

				if(argc==2){
						int i;
						printf("File:\n");
						printf("id          file name          size          time                         location\n");
						for(i=0;i<numobject+1;i++){
								if(db[i].e==0) continue;
								printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
						}
				}
				else if(argc==3){
						int i;
						if(strcmp(argv[2],"-n")==0){
								qsort(db,numobject+1,sizeof(mydb),namecmp);
								printf("File:\n");
								printf("id          file name          size          time                         location\n");
								for(i=0;i<numobject+1;i++){
										if(db[i].e==0) continue;
										printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
								}
						}
						else if(strcmp(argv[2],"-s")==0){
								qsort(db,numobject+1,sizeof(mydb),sizecmp);
								printf("File:\n");
								printf("id          file name          size          time                         location\n");
								for(i=0;i<numobject+1;i++){
										if(db[i].e==0) continue;
										printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
								}
						}
						else if(strcmp(argv[2],"-l")==0){
								qsort(db,numobject+1,sizeof(mydb),locationcmp);
								printf("File:\n");
								printf("id          file name          size          time                         location\n");
								for(i=0;i<numobject+1;i++){
										if(db[i].e==0) continue;
										printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
								}
						}

				}

		}
		else if(strcmp(argv[1],"delete")==0){
				//	printf("delete\n");
				if(argc==3){
						int hv=hash33(argv[2]);
						ads* qtr;
						qtr=app[hv];
						if(qtr==NULL){printf("This file not exist\n");exit(1);}
						else{ 
								while((strcmp(qtr->name,argv[2])!=0) || (qtr->exist==0)){
										qtr=qtr->next;
										if(qtr==NULL){printf("This file not exist\n");exit(1);}
								}
						}
						int line = qtr->exist_line;
						int curline=1;
						FILE* fptr99;
						fptr99=fopen("./my.db","r+");
						while(!(feof(fptr99))){
								fgets(buf2,99,fptr99);
								curline++;
								if(curline==line){
										fseek(fptr99,0,SEEK_CUR);
										fprintf(fptr99,"0");
										break;
								}
						}
				}
				else if(argc==4){
						if(strcmp(argv[2],"-d")==0){
								int i;
								FILE* dptr;

								for(i=0;i<=numdir;i++){
										if((strcmp(dir[i].name,argv[3])==0) && (dir[i].exist!=0))
												break;
								}
								if(i==numdir+1){ printf("Directory not found"); exit(1);}
								//	printf("%d\n",dir[1].exist);
								dptr=fopen("dir.db","r+");
								while(!(feof(dptr))){
										fgets(buf2,99,dptr);
										if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
										if((strcmp(buf2,dir[i].name)==0)){
												//			printf("%d\n%d\n",i,dir[i].exist);	
												fgets(buf2,99,dptr);
												//			printf("%s\n",buf2);
												fgets(buf2,99,dptr);
												//			printf("%s\n",buf2);
												fgets(buf2,99,dptr);
												//			printf("%s\n",buf2);
												fseek(dptr,0,SEEK_CUR);
												fprintf(dptr,"0");

										}
								}
								fclose(dptr);
								int del_l[50] = {0};
								int j=0;
								for(i=0;i<=numobject;i++){
										if((strcmp(db[i].location,argv[3])==0) && db[i].e==1){
												del_l[j]=db[i].el;
												j++;
												printf("Delete %s\n",db[i].name);
										}
								}
								int curline=1;
								j=0;
								FILE *fptr;
								fptr=fopen("./my.db","r+");
								while(!(feof(fptr))){
										fgets(buf2,99,fptr);
										curline++;
										if(curline==del_l[j]){
												//						printf("%d\n",del_l[j]);
												j++;
												fseek(fptr,0,SEEK_CUR);
												fprintf(fptr,"0");
										}
								}
								fclose(fptr);

						}

				}

		}
		else if(strcmp(argv[1],"find")==0){
				//	printf("find\n");
				if(argc==3){
						int i;
						printf("id          file name          size          time                         location\n");
						for(i=0;i<numobject+1;i++){
								char* ptr;
								if(db[i].e!=0){
										ptr=strstr(db[i].name,argv[2]);
										if(ptr!=NULL){
												printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);

										}
								}
						}
				}
				if(argc==4){
						if(strcmp(argv[2],"-r")==0){
								printf("id          file name          size          time                         location\n");
								int i;
								for(i=0;i<numobject+1;i++){
										if(db[i].e!=0){
												int ret;
												ret=fnmatch(argv[3],db[i].name,0);
												if(ret==0){
														printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
												}
										}
								}

						}
						if(strcmp(argv[2],"-q")==0){
								printf("id          file name          size          time                         location\n");
								int i;

								for(i=0;i<numobject+1;i++){

										if(db[i].e!=0){
												char *ptr;
												if(strstr(argv[3],"&")==NULL && strstr(argv[3],"|")==NULL){
														if(((ptr=strstr(argv[3],"@size"))!=NULL)){
																//printf("%d\n",db[i].s);
																char* buf;
																int j;
																if(argv[3][5]=='>'){
																		char tmp[30];
																		strcpy(tmp,argv[3]);
																		buf=strtok(tmp,">");
																		buf=strtok(NULL,">");
																		int k= atoi(buf);
																		//printf("%d",k);
																		if((db[i].s)>k){
																				printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
																		}

																}
																else if(argv[3][5]=='='){
																		char tmp[30];
																		strcpy(tmp,argv[3]);
																		buf=strtok(tmp,"=");
																		buf=strtok(NULL,"=");
																		int k= atoi(buf);
																		//printf("%d",k);
																		if((db[i].s)==k){
																				printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
																		}
																}
																else if(argv[3][5]=='<'){
																		char tmp[30];
																		strcpy(tmp,argv[3]);
																		buf=strtok(tmp,"<");
																		buf=strtok(NULL,"<");
																		int k= atoi(buf);
																		//printf("%d",k);
																		if((db[i].s)<k){
																				printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
																		}
																}
														}
														else if(((ptr=strstr(argv[3],"@location"))!=NULL)){
																char* buf;
																int j;
																char tmp[30];
																strcpy(tmp,argv[3]);
																buf=strtok(tmp,"=");
																buf=strtok(NULL,"=");
																if(strcmp(db[i].location,buf)==0){
																		printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);

																}


														}
												}
												else if(strstr(argv[3],"&")!=NULL){
													//	printf("123");
														char* buf;
														char tmp[30];
														char* buf1;
														char* buf2;
														strcpy(tmp,argv[3]);
														buf=strtok(tmp,"&");
														char tmp1[30];
														char tmp2[30];
														strcpy(tmp1,buf);
														buf=strtok(NULL,"&");
														strcpy(tmp2,buf);
													//	printf("%s\n%s\n",tmp1,tmp2);
																if(argv[3][5]=='>'){
																		buf1=strtok(tmp1,">");
																		buf1=strtok(NULL,">");
																		buf2=strtok(tmp2,"=");
																		buf2=strtok(NULL,"=");
																	//	printf("%s\n%s\n",buf1,buf2);
																		int k= atoi(buf1);
																	//	printf("%d",k);
																		if(((db[i].s)>k) && (strcmp(db[i].location,buf2)==0) ){
																				printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
																		}

																}
																else if(argv[3][5]=='='){
																		buf1=strtok(tmp1,"=");
																		buf1=strtok(NULL,"=");
																		buf2=strtok(tmp2,"=");
																		buf2=strtok(NULL,"=");
																		int k= atoi(buf1);
																		//printf("%d",k);
																		if(((db[i].s)==k) && (strcmp(buf2,db[i].location)==0) ){
																				printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
																		}
																}
																else if(argv[3][5]=='<'){
																
																		buf1=strtok(tmp1,"<");
																		buf1=strtok(NULL,"<");
																		buf2=strtok(tmp2,"=");
																		buf2=strtok(NULL,"=");
																		int k= atoi(buf1);
																		//printf("%d",k);
																		if(((db[i].s)<k) && (strcmp(buf2,db[i].location)==0) ){
																				printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
																		}
																}
												}
												else if(strstr(argv[3],"|")!=NULL){
													//	printf("123");
														char* buf;
														char tmp[30];
														char* buf1;
														char* buf2;
														strcpy(tmp,argv[3]);
														buf=strtok(tmp,"|");
														char tmp1[30];
														char tmp2[30];
														strcpy(tmp1,buf);
														buf=strtok(NULL,"|");
														strcpy(tmp2,buf);
													//	printf("%s\n%s\n",tmp1,tmp2);
																if(argv[3][5]=='>'){
																		buf1=strtok(tmp1,">");
																		buf1=strtok(NULL,">");
																		buf2=strtok(tmp2,"=");
																		buf2=strtok(NULL,"=");
																	//	printf("%s\n%s\n",buf1,buf2);
																		int k= atoi(buf1);
																	//	printf("%d",k);
																		if(((db[i].s)>k) || (strcmp(db[i].location,buf2)==0) ){
																				printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
																		}

																}
																else if(argv[3][5]=='='){
																		buf1=strtok(tmp1,"=");
																		buf1=strtok(NULL,"=");
																		buf2=strtok(tmp2,"=");
																		buf2=strtok(NULL,"=");
																		int k= atoi(buf1);
																		//printf("%d",k);
																		if(((db[i].s)==k) || (strcmp(buf2,db[i].location)==0) ){
																				printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
																		}
																}
																else if(argv[3][5]=='<'){
																
																		buf1=strtok(tmp1,"<");
																		buf1=strtok(NULL,"<");
																		buf2=strtok(tmp2,"=");
																		buf2=strtok(NULL,"=");
																		int k= atoi(buf1);
																		//printf("%d",k);
																		if(((db[i].s)<k) || (strcmp(buf2,db[i].location)==0) ){
																				printf("%-12d%-19s%-14d%-29s%s\n",db[i].id,db[i].name,db[i].s,db[i].time,db[i].location);
																		}
																}
												}


										}
								}
						}
				}
		}
		else if(strcmp(argv[1],"rename")==0){
				if(argc==4){
						int i;
						FILE* fptr;
						int hv=hash33(argv[2]);
						ads* qtr;
						qtr=app[hv];
						if(qtr==NULL){printf("This file not exist\n");exit(1);}
						else{ 
								while((strcmp(qtr->name,argv[2])!=0) || (qtr->exist==0)){
										qtr=qtr->next;
										if(qtr==NULL){printf("This file not exist\n");exit(1);}
								}
						}
						char name[20];
						int j;
						for(j=0;j<20;j++)name[j]=' ';
						if(strlen(argv[3])<=20){
								strncpy(name,argv[3],strlen(argv[3]));
						}

						int line = qtr->exist_line;
						int curline=1;
						fptr=fopen("./my.db","r+");
						while(!(feof(fptr))){
								fgets(buf2,99,fptr);
								curline++;
								if(curline==line-8){
										fseek(fptr,0,SEEK_CUR);
										fprintf(fptr,"%s\n",name);
										break;
								}
						}
				}

		}

}

int  hash33(char *key)
{
		//printf("input :  %s\n",key);
		int i,k;
		unsigned int hv=0;
		k=strlen(key);
		char key2[99];
		//key2=key;
		for(i=0;i<k;i++){
				key2[i]=toupper(key[i]);
				hv=(hv<<5)+hv+key2[i];
		}
		hv=hv%513;
		return hv;
}

void hinsert(char*key ,char*name , int hv , int begin , int end ,int exist,int el,char*location)
{
		ads* ptr;
		ads* qtr;
		qtr=app[hv];
		if(app[hv]==NULL){
				ptr=(ads*)malloc(sizeof(ads));

				strcpy(ptr->key,key);
				strcpy(ptr->name,name);
				ptr->begin=begin;
				ptr->end=end;
				ptr->exist=exist;
				ptr->exist_line=el;
				strcpy(ptr->location,location);
				ptr->next=NULL;
				app[hv]=ptr;
		}		
		else  {
				/*while(strcmp(key,qtr->name)!=0){
				  q++;
				  qtr=qtr->next;
				  if(qtr==NULL)
				  break;}
				  if(qtr!=NULL){
				  qtr->count+=1;
				  return;
				  }*/
				ptr=(ads*)malloc(sizeof(ads));;
				strcpy(ptr->key,key);
				strcpy(ptr->name,name);
				ptr->begin=begin;
				ptr->end=end;
				ptr->exist=exist;
				ptr->exist_line=el;
				strcpy(ptr->location,location);
				ptr->next=app[hv];}
		app[hv]=ptr; 
		//printf("%d   %s\n",hv,app[hv]->name);
		//printf("%s\n",key);

}
int sizecmp(const void *a , const void *b)
{
		mydb*c=(mydb*)(a);
		mydb*d=(mydb*)(b);
		return((d->s)-(c->s));
}
int namecmp(const void *a , const void *b)
{
		mydb*c=(mydb*)(a);
		mydb*d=(mydb*)(b);
		return(strcmp(c->name,d->name));
}
int locationcmp(const void *a , const void *b)
{
		mydb*c=(mydb*)(a);
		mydb*d=(mydb*)(b);
		return(strcmp(c->location,d->location));

}
void savefile(char* filename, char* directory)
{
		mydb a;
		int i;
		FILE* fptr;
		char*  buf;
		int cursize;
		char buf2[100];
		char path[100]="../";
		int control=0;
		strcat(path,"DATA_ENGINEER/");
		if(directory[0]!='\0'){
				strcat(path,directory);
				strcat(path,"/");
				control=1;
		}
		strcat(path,filename);
		printf("%s\n",path);

		fptr=fopen(path,"rb");
		if(fptr==NULL) { printf("File not found \n"); exit(1);}
		fseek(fptr,0,SEEK_END);
		cursize = ftell(fptr);

		rewind(fptr);
		int hv=hash33(filename);
		ads* qtr;
		qtr=app[hv];
		if(qtr!=NULL){
				while(strcmp(qtr->name,filename)!=0) qtr=qtr->next;

		}
		if(qtr!=NULL&& qtr->exist==1){
				printf("This file name has existed , 1.overwrite 2. exit\n");
				int a;
				scanf("%d",&a);
				if(a==1){
						printf("overwrite\n");

						int line = qtr->exist_line;
						int curline=1;
						FILE* fptr99;
						fptr99=fopen("my.db","r+");
						while(!(feof(fptr99))){
								fgets(buf2,99,fptr99);
								curline++;
								if(curline==line){
										fseek(fptr99,0,SEEK_CUR);
										fprintf(fptr99,"0\n");
										break;
								}
						}	
						fclose(fptr99);
				}
				else if(a==2){
						printf("exit\n");
						return;
				}


		}
		buf=(char*)malloc(cursize*sizeof(char));
		size_t ret;
		ret=fread(buf,1,cursize,fptr);

		unsigned char md[16];
		MD5(buf,ret,md);

		for(i=0;i<16;i++){
				sprintf(&a.key[i*2],"%02x",(unsigned int)md[i]);
				//		strcat(a.key,tmp);
		}

		for(i=0;i<numobject+1;i++){
				if(strcmp(a.key,db[i].key)==0)
						break;
		}
		fclose(fptr);
		if(i!=numobject+1) printf("Same data\n");
		FILE* fptr2;
		fptr2 =fopen("./alldata","ab+");

		time_t  timep;
		char timetmp[30];
		time(&timep);
		strcpy(timetmp,ctime(&timep));
		//printf("%s\n",timetmp);
		if(i==numobject+1)
				fwrite(buf,1,cursize,fptr2);
		fclose(fptr2);
		char name[20];
		int j;
		for(j=0;j<20;j++)name[j]=' ';name[20]='\0';
		if(strlen(filename)<20){
				strncpy(name,filename,strlen(filename));
		}
		FILE* fptr3;
		fptr3 =fopen("./my.db","ab+");
		fprintf(fptr3,"@id:\n");
		fprintf(fptr3,"%d\n",numobject+1);
		fprintf(fptr3,"@key:\n");
		fprintf(fptr3,"%s\n",a.key);
		fprintf(fptr3,"@name:\n");
		fprintf(fptr3,"%s\n",name);
		fprintf(fptr3,"@time:\n");
		fprintf(fptr3,"%s",timetmp);
		fprintf(fptr3,"@pointer:\n");
		if(i!=numobject+1) fprintf(fptr3,"1\n");
		else fprintf(fptr3,"0\n");
		fprintf(fptr3,"@size:\n");
		fprintf(fptr3,"%d\n",cursize);	
		fprintf(fptr3,"@exist:\n");
		fprintf(fptr3,"1\n");
		fprintf(fptr3,"@el:\n");
		int el=22*(numobject+2)-8;
		fprintf(fptr3,"%d\n",el);

		char location_name[90];
		//char default_location[23] = "DATA_ENGINEER";
		for(j=0;j<90;j++)location_name[j]=' ';location_name[90]='\0';
		strncpy(location_name,directory,strlen(directory));
		fprintf(fptr3,"@location:\n");
		if(control==0) fprintf(fptr3,"DATA_ENGINEER\n");
		else fprintf(fptr3,"%s\n",location_name);
		fprintf(fptr3,"@begin:\n");
		if(i!=numobject+1) fprintf(fptr3,"%d\n",db[i].begin);
		else fprintf(fptr3,"%d\n",totalsize);
		fprintf(fptr3,"@end:\n");
		if(i!=numobject+1) fprintf(fptr3,"%d\n",db[i].end);
		else fprintf(fptr3,"%d\n",totalsize+cursize);
		fclose(fptr3);
		update_file();
}
void create(char* dname,int numdir)
{
		char dirpath[50] = "./";
		FILE* dptr;
		dptr=fopen("./dir.db","ab+");
		if(dptr==NULL) { printf("Directory not found \n"); exit(1);}
		char location[90];
		int j;
		for(j=0;j<90;j++)location[j]=' ';location[90]='\0';
		char ini[30]="../DATA_ENGINEER/";
		strncpy(location,ini,strlen(ini));


		fprintf(dptr,"@id:\n");
		fprintf(dptr,"%d\n",numdir+1);
		fprintf(dptr,"@name:\n");
		fprintf(dptr,"%s\n",dname);
		fprintf(dptr,"@location:\n");
		fprintf(dptr,"%s\n",location);
		fprintf(dptr,"@exist:\n");
		fprintf(dptr,"1\n");
}
void update_file()
{
		numobject=-1;
		totalsize=0;
		FILE* dbptr;
		dbptr=fopen("./my.db","r");
		if(dbptr==NULL) { dbptr=fopen("my.db","wb");}
		while(fgets(buf2,99,dbptr)!=NULL){
				if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
				if(strcmp(buf2,"@id:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						numobject++;
						db[numobject].id= atoi(buf2);
				}
				else if(strcmp(buf2,"@key:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						strcpy(db[numobject].key,buf2);
				}
				else if(strcmp(buf2,"@name:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						int i;
						for(i=0;i<20;i++){
								if(buf2[i]==' ')buf2[i]='\0';
						}
						strcpy(db[numobject].name,buf2);
				}
				else if(strcmp(buf2,"@time:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						strcpy(db[numobject].time,buf2);
				}
				else if(strcmp(buf2,"@pointer:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						db[numobject].p=buf2[0];
				}
				else if(strcmp(buf2,"@size:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						db[numobject].s = atoi(buf2);
						if(db[numobject].p!='1')
								totalsize=totalsize+db[numobject].s;
				}
				else if(strcmp(buf2,"@exist:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						db[numobject].e = atoi(buf2);

				}
				else if(strcmp(buf2,"@el:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						db[numobject].el = atoi(buf2);

				}
				else if(strcmp(buf2,"@location:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						int i;
						for(i=0;i<90;i++){
								if(buf2[i]==' '){buf2[i]='\0';break;}
						}
						strcpy(db[numobject].location,buf2);

				}
				else if(strcmp(buf2,"@begin:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						db[numobject].begin = atoi(buf2);

				}
				else if(strcmp(buf2,"@end:")==0){
						fgets(buf2,99,dbptr);
						if(buf2[strlen(buf2)-1] == '\n') buf2[strlen(buf2)-1] = '\0';
						db[numobject].end = atoi(buf2);

						int hv=hash33(db[numobject].name);
						hinsert(db[numobject].key,db[numobject].name,hv,db[numobject].begin,db[numobject].end,db[numobject].e,db[numobject].el,db[numobject].location);

				}
		}
		fclose(dbptr);


}
