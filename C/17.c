#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#define max 100
typedef struct tnode{
		char name[max];
		int count;
		struct tnode *next;
}ads;
typedef struct ynode{
		char name[max];
		int count;
}daa;
int q=0;
int countcmp(const void*,const void*);
int namecmp(const void*,const void*);
ads* app[513];
daa add[3000];
void hinsert(char*, int);
void hcaseinsert(char* ,int);
int hash33(char*);
int hcaseash33(char*);
int main (int argc , char* argv[])
{
		char s[max];
		FILE*fp;
		char c;
		int i=0,m=0;
		int comd1,comd2,k,x=0;
		unsigned int hv;
		for(i=0;i<513;i++){
				app[i]=NULL;
		}
		while((c=getopt(argc,argv,"in"))!=-1)
		{
				switch(c)
				{
						case'i':
								comd1=1;
								break;
						case'n':
								comd2=2;
								break;
						case'?':
								printf("error");
								return -1;
						default:
								break;
				}	
		}
		if(argv[optind]==NULL){
				printf("error");
				return -1;}
		fp=fopen(argv[optind],"r");
		while(fgets(s,max,fp)!=NULL){
				s[strlen(s)-1]='\0';
				hv=hash33(s);
				//				printf("%d\n",hv);
				if(comd1!=1){
						hinsert(s,hv);
				}    
				else if(comd1==1){
						hcaseinsert(s,hv);	 
				} 
		}
		for(i=0;i<513;i++){
mark1:	if(app[i]==NULL){
				continue;}
		strcpy(add[x].name,app[i]->name);
		add[x].count=app[i]->count;
		x++;
		app[i]=app[i]->next;
		goto mark1;
		}
		if(comd2!=2){				
				qsort(add,x,sizeof(daa),namecmp);
		}
		else if(comd2==2){
				qsort(add,x,sizeof(daa),countcmp);
		}
		for(i=0;i<x;i++){
				printf("%s\t%d\n",add[i].name,add[i].count);
		}
		printf("%d",q);
}
void hinsert(char*key , int hv)
{
		ads* ptr;
		ads* qtr;
		//	ptr=(ads*)malloc(sizeof(ads));
		//	strcpy(ptr->name,key);
		//	ptr->count=1;
		qtr=app[hv];
		if(app[hv]==NULL){
				ptr=(ads*)malloc(sizeof(ads));
				strcpy(ptr->name,key);
				ptr->count=1;
				ptr->next=NULL;
				app[hv]=ptr;
		}		
		else  {
				while(strcmp(key,qtr->name)!=0){
						q++;
						qtr=qtr->next;
						if(qtr==NULL)
								break;}
				if(qtr!=NULL){
						qtr->count+=1;
						return;
				}
				ptr=(ads*)malloc(sizeof(ads));
				strcpy(ptr->name,key);
				ptr->count=1;
				ptr->next=app[hv];}
		app[hv]=ptr; 
}
void hcaseinsert(char*key , int hv)
{
		ads* ptr;
		ads* qtr;
	//	ptr=(ads*)malloc(sizeof(ads));
	//	strcpy(ptr->name,key);
	//	ptr->count=1;
		qtr=app[hv];
		if(app[hv]==NULL){
				ptr=(ads*)malloc(sizeof(ads));
				strcpy(ptr->name,key);
				ptr->count=1;
				ptr->next=NULL;
				app[hv]=ptr;
		}		
		else  {
				while(strcasecmp(key,qtr->name)!=0){
						q++;
						qtr=qtr->next;
						if(qtr==NULL)
								break;}
				if(qtr!=NULL){
						qtr->count+=1;
						return;
				}
				ptr=(ads*)malloc(sizeof(ads));
				strcpy(ptr->name,key);
				ptr->count=1;
				ptr->next=app[hv];}
		app[hv]=ptr; 
}
int  hash33(char *key)
{
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
int  hcaseash33(char *key)
{
		int i,k;
		unsigned int hv=0;
		k=strlen(key);
	
	
		for(i=0;i<k;i++){
		
				hv=(hv<<5)+hv+key[i];
		}
		hv=hv%513;
		return hv;
}
int countcmp(const void *a , const void *b)
{
		daa*c=(daa*)(a);
		daa*d=(daa*)(b);
		return((d->count)-(c->count));
}
int namecmp(const void *a , const void *b)
{
		daa*c=(daa*)(a);
		daa*d=(daa*)(b);
		return(strcmp(c->name,d->name));
}












































































































































