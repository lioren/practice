#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<dirent.h>
#include<ctype.h>
int main(int argc ,char *argv[])
{
		DIR *d;
		char *ptr,*head;
		char buf1[30];
		char buf2[30];
		char buf3[30];
		int i=0,high,n,con=0 ;
		struct dirent *entry;
		struct dirent **namelist;
		if(argc!=3){
				printf("error!\n");
				return -1;
		}

		n=scandir(argv[2],&namelist,0,alphasort);
		high=n;
		if(n<0)
				perror("scandir");
		i=2;
		while(high>0){

				ptr=(namelist[i]->d_name);
				head=ptr;
				sprintf(buf1,"%s/%s",argv[2],ptr);
				while(*ptr!='.'&&ptr!=NULL){
						ptr++;
				}
				if(ptr!=NULL){
						high--;
						i++;
						sprintf(buf3,"%s_%d%s",argv[1],con,ptr);
						sprintf(buf2,"%s/%s_%d%s",argv[2],argv[1],con,ptr);
						rename(buf1,buf2);
						printf("%s => %s\n",head,buf3);
						con++;
				}
				else if(ptr==NULL){
						high--;
						i++;
				}
		}
}
