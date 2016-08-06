#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define  max 1000
int agecmp(const void* , const void*);
int namecmp(const void* , const void*);
int phonecmp(const void* , const void*);
typedef struct address_rec{
		char name[40];
		char age[30];
		char phone[30];
}ads;	
int main(int argc,char*argv[])
{        
		int i=0,a=0,j=0;
		char s[max],buf[max];
		char *ptr;
		ads app[1000];
		while(fgets(s,max,stdin)!=NULL){
				if((strcmp(s,"\n")==0)){
						printf("error");
						break;}
				a++;
				ptr=s;
			    ptr=strstr(s,"age");
				*(ptr-1)='\0';
				strcpy(app[i].name,s);
				ptr=ptr+4;
				strcpy(buf,ptr);
				ptr=strstr(buf,"phone");
				*(ptr-1)='\0';
				strcpy(app[i].age,buf);
				strcpy(app[i].phone,ptr);
				i++;
		}
		if(argc==4){ 
				if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-age")==0&&strcmp((argv[3]),"-r")==0){
						qsort(app,i,sizeof(ads),agecmp);
						for(j=i-1;j>=0;j--){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}

				else if(strcmp((argv[2]),"-k")==0&&strcmp((argv[3]),"-age")==0&&strcmp((argv[1]),"-r")==0){
						qsort(app,i,sizeof(ads),agecmp);
						for(j=i-1;j>=0;j--){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}

				else if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-name")==0&&strcmp((argv[3]),"-r")==0){
						qsort(app,i,sizeof(ads),namecmp);
						for(j=i-1;j>=0;j--){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}

				else if(strcmp((argv[2]),"-k")==0&&strcmp((argv[3]),"-name")==0&&strcmp((argv[1]),"-r")==0){
						qsort(app,i,sizeof(ads),namecmp);
						for(j=i-1;j>=0;j--){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}

				else if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-phone")==0&&strcmp((argv[3]),"-r")==0){
						qsort(app,i,sizeof(ads),phonecmp);
						for(j=i-1;j>=0;j--){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}

				else if(strcmp((argv[2]),"-k")==0&&strcmp((argv[3]),"-phone")==0&&strcmp((argv[1]),"-r")==0){
						qsort(app,i,sizeof(ads),phonecmp);
						for(j=i-1;j>=0;j--){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}
				else printf("error");
		}
		else if(argc==3){
				if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-age")==0){
						qsort(app,i,sizeof(ads),agecmp);
						for(j=0;j<i;j++){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}


				else if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-name")==0){
						qsort(app,i,sizeof(ads),namecmp);
						for(j=0;j<i;j++){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}


				else if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-phone")==0){
						qsort(app,i,sizeof(ads),phonecmp);
						for(j=0;j<i;j++){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}
				else printf("error");
		}
		else if(argc==2){
				if(strcmp((argv[1]),"-r")==0){
						qsort(app,i,sizeof(ads),namecmp);
						for(j=i-1;j>=0;j--){
								printf("%s\t",app[j].name);
								printf("age:%s\t",app[j].age);
								printf("%s",app[j].phone);}}
				else printf("error");
		}
		else if(argc==1){ 
				qsort(app,i,sizeof(ads),namecmp);
				for(j=0;j<i;j++){
						printf("%s\t",app[j].name);
						printf("age:%s\t",app[j].age);
						printf("%s",app[j].phone);}}
		else printf("error");
}


int  agecmp(const void*a , const void*b)
{
		ads*c=(ads*)(a);
		ads*d=(ads*)(b);
		if((atoi(c->age)  - atoi( d->age))>0)
				return 1;
		else if ((atoi(c->age)  - atoi( d->age))<0)
				return -1;
		else    return 0;
}
int  namecmp(const void*a , const void*b)
{
		ads*c=(ads*)(a);
		ads*d=(ads*)(b);
		if(strcmp(c->name , d->name)>0)
				return 1;
		else if (strcmp(c->name , d->name)<0)
				return -1;
		else    return 0;
}
int  phonecmp(const void*a , const void*b)
{
		ads*c=(ads*)(a);
		ads*d=(ads*)(b);
		if(strcmp(c->phone , d->phone)>0)
				return 1;
		else if (strcmp(c->phone , d->phone)<0)
				return -1;
		else    return 0;
}
