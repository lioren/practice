#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#define max 2000
typedef struct tnode{
		char name[max];
		int count;
		struct tnode *left;
		struct tnode *right;
}ads;
typedef struct data{
		char name[max];
		int count;
}daa;
int countcmp(const void*,const void*);
int namecmp(const void*,const void*);
daa app[600000];
int k=0;
ads* binsert(ads*,char*);
ads* bcaseinsert(ads*,char*);
void inorder(ads*);
//int k=0;
int main (int argc , char* argv[])
{
        char s[max];
		FILE*fp;
		char c;
		int i=0,m=0;
	//	daa app[1000];
		int comd1,comd2,k;
		ads *root=NULL;
		ads *new=NULL;
		ads *curr=NULL;
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
//printf("%d",fp);
             while(fgets(s,max,fp)!=NULL){
             	/*	 		 new=(ads*)malloc(sizeof(ads));
                         //    new->left=new->right=NULL;
                             strcpy(new->name,s);
                             new->count=1;
                             root=new;   */
                 s[strlen(s)-1]='\0';
                 if(comd1!=1){
                    if(root==NULL){
                    root= binsert(root,s);
                    }
                    
                    else 
                    binsert(root,s);	 
                    
                    
				 }
				 else if(comd1==1){
				 	if(root==NULL){
				 	root= bcaseinsert(root,s);
				 	}
				 	else 
				    bcaseinsert(root,s);
				    
			     }
			     
			 }
				 inorder(root);
              //     for(i=0;i<10;i++){
              //     		 printf("%d",app[i].count);  
              //   		 printf("%s",app[i].name);
              //   	 } 
                for(i=0;i<600000;i++){
                		if(app[i].count==0){
                				m=i;
                				break;}
                				}
                if(comd2!=2){				
                qsort(app,m,sizeof(daa),namecmp);
                
                for(i=0;i<m;i++){

                		printf("%s\t%d\n",app[i].name,app[i].count);
				}
				}
                else if(comd2==2){
                qsort(app,m,sizeof(daa),countcmp);
                for(i=0;i<m;i++){
                		printf("%s\t%d\n",app[i].name,app[i].count);
				}
				}
}
ads* binsert(ads*ptr,char* key)
{
	// ads*new=NULL;
     if(ptr==NULL){
          ptr=(ads*)malloc(sizeof(ads));
          ptr->left=NULL;
          ptr->right=NULL;
          strcpy(ptr->name,key);
          ptr->count=1;
       //   return ptr;
	 }
	 else {
	 		 if(strcmp(key,ptr->name)>0)
	 	  ptr->right=binsert(ptr->right,key);
	         else if(strcmp(key,ptr->name)<0)
	 	  ptr->left=binsert(ptr->left,key);
	         else ptr->count+=1;
	 }
	  return ptr;
}
ads* bcaseinsert(ads*ptr,char* key)
{
	// ads*new=NULL;
     if(ptr==NULL){
          ptr=(ads*)malloc(sizeof(ads));
          ptr->left=NULL;
          ptr->right=NULL;
          strcpy(ptr->name,key);
          ptr->count=1;
       //   return ptr;
	 }
	 else {
	 		 if(strcasecmp(key,ptr->name)>0)
	 	  ptr->right=bcaseinsert(ptr->right,key);
	         else if(strcasecmp(key,ptr->name)<0)
	 	  ptr->left=bcaseinsert(ptr->left,key);
	         else ptr->count++;
	 }
	  return ptr;
}
void inorder( ads*ptr)
{
//	static int k=0;
		if(ptr!=NULL){
				inorder(ptr->left);
	    strcpy(app[k].name,ptr->name);
	    app[k].count=ptr->count;
        k++; 
		inorder(ptr->right);
		}
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












































































































































