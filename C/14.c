#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define  max 1000
int agecmp(const void* , const void*);
int namecmp(const void* , const void*);
int phonecmp(const void* , const void*);
typedef struct address_rec{
		char name[max];
		char age[max];
		char phone[max];
		struct address_rec *next;
}ads;	
int main(int argc,char*argv[])
{        
		int i=0,a,j=0;
		char s[max],buf[max],namebuf[max],phonebuf[max];
		char p;
		char *ptr;
		FILE *fp;
		ads *head =NULL;
		ads *curr =NULL;
		ads *prev =NULL;
		ads *fucking = NULL;
		fp=fopen(argv[1],"r");
		ads app[1000];
		while(fgets(s,max,fp)!=NULL){
				//			if((strcmp(s,"\n")==0)){
				//				printf("error");
				//				break;}
				curr=(ads*)malloc(sizeof(ads));
				curr->next=NULL;
				ptr=s;
				ptr=ptr+strlen(s)-1;
				*ptr='\0';
				ptr=strstr(s,"phone");
				*(ptr-1)='\0';
				ptr=ptr+6;
				strcpy(curr->phone,ptr);
				ptr=strstr(s,":");
				ptr=ptr+1;
				strcpy(curr->name,ptr);
				if(head==NULL)
						head=curr;
				else 
						prev->next=curr;
				prev=curr;
		}
		//		    curr=head;
		//		while(curr!=NULL){
		//			printf("%s\t%s",curr->name,curr->phone);
		//			curr=curr->next;}
		//	for(j=0;j<i;j++){
		//	printf("%s\t%s",app[j].name,app[j].phone);}
		while(1){
mark2:    printf("1.list\n2.find\n3.insert\n4.delete\n5.exit\nPlease enter command:");
		  scanf("%d",&a);
		  if(a!=1&&a!=2&&a!=3&&a!=4&&a!=5){
				  printf("Error!Please insert again\n");
				  for(a=1;a!='\n'&&a!=EOF;a=getchar());
				  goto mark2;}
		  if(a==1){
				  curr=head;
				  while(curr!=NULL){
						  printf("%s\t%s\n",curr->name,curr->phone);
						  curr=curr->next;}
				  printf("Press any key back to main menu:\n");
				  //		getchar();
				  getchar();
				  for (a=1; a!='\n' && a!=EOF; a=getchar()) ;
				  continue;}

		  if(a==3){
mark1:   	printf("Name:");
			fpurge(stdin);
			fgets(namebuf,max,stdin);
			namebuf[strlen(namebuf)-1]='\0';
	//				scanf("%s",namebuf);
			printf("Phone:");
			fpurge(stdin);
			fgets(phonebuf,max,stdin);
			phonebuf[strlen(phonebuf)-1]='\0';
			fpurge(stdin);
	//				scanf(" %s",phonebuf);
			curr=head;
			while(curr!=NULL){
					if(strcmp(curr->name,namebuf)>0||strcmp(curr->name,namebuf)<0)
							curr=curr->next;
					else if(strcmp(curr->name,namebuf)==0)	{
							printf("The name has existed.Please enter command:\n1.continue\n2.absort\n3.override\n");
							//      curr=NULL;
							//				for(a=1;a!='\n'&&a!=EOF;a=getchar());
							while(1){
									scanf("%d",&a);
									if(a!=1&&a!=2&&a!=3){
											printf("Error!Please insert again!\n");
											continue;}
									if(a==2)
											goto mark2;
									if(a==3){
											strcpy(curr->name,namebuf);
											strcpy(curr->phone,phonebuf);
											printf("finished override\n");
											goto mark2;}
									if(a==1);
									curr=NULL;
									break;}

					}
			}
			curr=(ads*)malloc(sizeof(ads));
			//			if(curr=NULL)
			//					exit(EXIT_FAILURE);
			curr->next =NULL;
			strcpy(curr->name,namebuf);
			strcpy(curr->phone,phonebuf);
			if(head==NULL)
					head=curr;
			else 
					prev->next=curr;
			prev=curr;
			//		for(a=1;a!='\n'&&a!=EOF;a=getchar());

			printf("1.back to main menu\n2.insert next data\n");
			while(1){
					fpurge(stdin);
					scanf("%d",&a);
					if(a!=2&&a!=1){
							printf("error!please insert again!\n");
							continue;}
					if(a==2){
							for(a=1;a!='\n'&&a!=EOF;a=getchar());
							goto mark1;}
					if(a==1)
							for(a=1;a!='\n'&&a!=EOF;a=getchar());
					break;}
		  }
		  else if(a==2){
				  printf("Please input the search name:");
				  fpurge(stdin);
				//  scanf("%s",namebuf);
				   fgets(namebuf,max,stdin);
				   namebuf[strlen(namebuf)-1]='\0';
				   fpurge(stdin);
				  curr=head;
				  while(curr!=NULL){
						  if(strcmp(curr->name,namebuf)>0||strcmp(curr->name,namebuf)<0)
								  curr=curr->next;
						  else 	{
								  printf("%s\t%s\n",curr->name,curr->phone);
								  break; }
				  }
				  if (curr==NULL){
						  printf("Not found\n");
						  goto mark2;}
mark3:  printf("1.Delete it\n2.back to main menu\n");
		//for(a=1;a!='\n'&&a!=EOF;a=getchar());
		fpurge(stdin);
		scanf("%d",&a);
		if(a!=1&&a!=2){
				printf("Error!Please insert again!\n");
				goto mark3;}
		else if(a==1){
				fucking=head;
				if(fucking==curr){
						head=head->next;
						free(curr);
						goto mark2;}
				else{
						while(fucking->next!=curr){
								fucking=fucking->next;}
						fucking->next=curr->next;
						//  fucking=curr->next;
						//    free(curr->name);
						//    free(curr->phone);
						free(curr);
						if(fucking->next==NULL)
								prev=fucking;}
		}

		  }
		else   if(a==4){
mark4:	printf("Please input the name will be deleted:");
        fpurge(stdin);
	//	scanf("%s",namebuf);
	    fgets(namebuf,max,stdin);
	    namebuf[strlen(namebuf)-1]='\0';
		curr=head;
		while(curr!=NULL){
				if(strcmp(curr->name,namebuf)>0||strcmp(curr->name,namebuf)<0)
						curr=curr->next;
				else if(strcmp(curr->name,namebuf)==0)	{
						printf("%s\t%s\n",curr->name,curr->phone);
						break;  }
		}
		if(curr==NULL){
				printf("Not found\n");
				goto mark2;}
mark5:            printf("delet it?(yes/no)");
			//	  for(a=1;a!='\n'&&a!=EOF;a=getchar());
				  scanf("%s",namebuf);
				  if(strcmp(namebuf,"no")==0)
						  goto mark2;
				  else if (strcmp(namebuf,"yes")==0){
						  fucking=head;
						  if(fucking==curr){
								  head=head->next;
								  free(curr);
								  }
						  else {
								  while(fucking->next!=curr){
										  fucking=fucking->next;}
								  fucking->next=curr->next;
								  free(curr);
								  if(fucking->next==NULL)
										  prev=fucking;}
						  while(1){
								  printf("1.back to main menu\n2.delete next data\n");
								  for(a=1;a!='\n'&&a!=EOF;a=getchar());
								  scanf("%d",&a);
								  if(a==1)
										  goto mark2;
								  if(a==2)
										  goto mark4;
								  else 
										  printf("Error!Please insert again!\n");
								  continue;

						  }
				  }
				  else 
						  printf("Please insert again\n");
				  goto mark5;
		  }
		  else if(a==5){ 
				  return -1;}
		  else if(a!=1&&a!=2&&a!=3&&a!=4&&a!=5){ 
				  printf("Error!  Please insert again!\n");
				  continue;}
		}
		/*		if(argc==4){ 
				if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-age")==0&&strcmp((argv[3]),"-r")==0){
				qsort(app,i,sizeof(ads),agecmp);
				for(j=i-1;j>=0;j--){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}

				else if(strcmp((argv[2]),"-k")==0&&strcmp((argv[3]),"-age")==0&&strcmp((argv[1]),"-r")==0){
				qsort(app,i,sizeof(ads),agecmp);
				for(j=i-1;j>=0;j--){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}

				else if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-name")==0&&strcmp((argv[3]),"-r")==0){
				qsort(app,i,sizeof(ads),namecmp);
				for(j=i-1;j>=0;j--){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}

				else if(strcmp((argv[2]),"-k")==0&&strcmp((argv[3]),"-name")==0&&strcmp((argv[1]),"-r")==0){
				qsort(app,i,sizeof(ads),namecmp);
				for(j=i-1;j>=0;j--){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}

				else if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-phone")==0&&strcmp((argv[3]),"-r")==0){
				qsort(app,i,sizeof(ads),phonecmp);
				for(j=i-1;j>=0;j--){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}

				else if(strcmp((argv[2]),"-k")==0&&strcmp((argv[3]),"-phone")==0&&strcmp((argv[1]),"-r")==0){
				qsort(app,i,sizeof(ads),phonecmp);
				for(j=i-1;j>=0;j--){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}
				else printf("error");
				}
				else if(argc==3){
				if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-age")==0){
				qsort(app,i,sizeof(ads),agecmp);
				for(j=0;j<i;j++){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}


				else if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-name")==0){
				qsort(app,i,sizeof(ads),namecmp);
				for(j=0;j<i;j++){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}


				else if(strcmp((argv[1]),"-k")==0&&strcmp((argv[2]),"-phone")==0){
				qsort(app,i,sizeof(ads),phonecmp);
				for(j=0;j<i;j++){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}
				else printf("error");
				}
				else if(argc==2){
				if(strcmp((argv[1]),"-r")==0){
		qsort(app,i,sizeof(ads),namecmp);
		for(j=i-1;j>=0;j--){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}
				else printf("error");
}
else if(argc==1){ 
		qsort(app,i,sizeof(ads),namecmp);
		for(j=0;j<i;j++){
				printf("%s\t",app[j].name);
				printf("%s\t",app[j].age);
				printf("%s",app[j].phone);}}
				else printf("error");      */
				}


int  agecmp(const void*a , const void*b)
{
		ads*c=(ads*)(a);
		ads*d=(ads*)(b);
		if(strcmp(c->age , d->age)>0)
				return 1;
		else if (strcmp(c->age , d->age)<0)
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
