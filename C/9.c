#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define a 100
#define b 100
int swap(char** ,char**);
main()
{
		int n,i,k,j;
		//	scanf("%d",&n);
//		char x[a][b],y[b];
      
			char *q[a],*p;
			char fuck[b];
			n=0;
          while(fgets(fuck,b,stdin)){
		q[n]=(char*)malloc(strlen(fuck)+1);
		strcpy(q[n],fuck);
		n++;}
       char y[b];
		for(i=0;i<n;i++){
				k=0;
				for(j=0;j<n-i-1;j++)

						if(strcmp(q[j],q[j+1])>0){
							
			//	strcpy(y,q[k]);
			//	strcpy(q[k],q[a-i-1]);
			//	strcpy(q[a-i-1],y);
			      swap(&q[j],&q[j+1]);      
			       //     p=q[j];
			       //     q[j]=q[j+1];
					//	q[j+1]=p;

						}
		}
		for(i=0;i<n;i++){
				printf("%s\n",q[i]);
		}
		int c=0,d=0;
		char z[b];
		//	for(i=0;i<a;i++){
		//	c=strlen(x[i]);
		//	if(c>=d){
		//			d=c;

		for(i=0;i<n;i++){
				k=0;
				for(j=0;j<n-1-i;j++){
						if(strlen(q[j])>strlen(q[j+1])){
							//	strcpy(z,q[j]);
							//	strcpy(q[j],q[j+1]);
							//	strcpy(q[j+1],z);
                            swap(&q[j],&q[j+1]);
						//	p=q[j];
						//	q[j]=q[j+1];
						//	q[j+1]=p;
						}
				}

				//	strcpy(z[i],x[i]);
		}

		for(i=0;i<n;i++)
				printf("%s\n",q[i]);

		int e=0,f=0;
		char m[b];
		for(i=0;i<n;i++){
				k=0;
				for(j=0;j<n-1-i;j++){
						if(atoi(q[j])>atoi(q[j+1])){
					//			strcpy(m,q[j]);
					//			strcpy(q[j],q[j+1]);
					//			strcpy(q[j+1],m);
                        swap(&q[j],&q[j+1]);
					//      p=q[j];
					  //    q[j]=q[j+1];
					    //  q[j+1]=p;

						}
				}
		}
		for(i=0;i<n;i++)
				printf("%s\n",q[i]);
}


int swap(char **c,char **d)
{
		 char  *temp;
		 temp=*c;
		 *c=*d;
		 *d=temp;
         
}		

