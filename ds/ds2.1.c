#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
typedef struct {
		char name[30];
		int age;
		enum {female,male}sex;
}element;
element *queue;
int capacity=1;
int rear = 0;
int front= 0;
void queuefull();
void add(char* name2 , int  age2 , char * sex2 );
element delet();
main()
{
  queue=(element*)malloc(sizeof(element));
  char *ptr;
  char *qtr;
  int i ;
  char s[100];
  while(fgets(s,100,stdin)!=NULL){
  		  if(s[0]=='E'){
  		  		  printf("quit\n");
  		  		  break;
		  }
		  if(s[0]=='D'){
		  		  delet();
		  		  continue;
		  }
		  else
		  		  ptr=s;
		  		  char name[30];
		  		  int age;
		  		  char sex[9]; 
		  		  while(*ptr!=',')
		  		  		  ptr++;
		  		  		  ptr++;
		  		  		  while(*ptr!=',')
		  		  		  		  ptr++;
		  		  		  		  ptr++;   // = = who can find?.....
		  		  		  		  ptr++;
		  		  		  		  qtr=ptr;
		  		  		  		  while(*ptr!='}')
		  		  		  		  		  ptr++;
		  		  		  		  		  *ptr='\0';
		  		  		  		  		  strcpy(sex,qtr);
		  		  //		  for(i=0;i<strlen(sex);i++){
		  		  	//	  		  if(isupper(sex[i]!=0))
		  		  //		  		  		  sex[i]=tolower(sex[i]);
				//		  }     
				  ptr=s;
				  while(*ptr!=',')
				  		  ptr++;
				  		  ptr++;
				  		  while(*ptr=='0')
				  		  		  ptr++;
				  		  		  qtr=ptr;
				  		  		  while(*ptr!=',')
				  		  		  		  ptr++;
				  		  		  		  *ptr='\0';
				  		  		  		age=atoi(qtr);
				  ptr=s;
				  while(*ptr!='"')
				  		  ptr++;
				  		  ptr++;
				  		  qtr=ptr;
				  		  while(*ptr!='"')
				  		  		  ptr++;
				  		  		  *ptr='\0';
				  		  		  strcpy(name,qtr);
				  add(name, age , sex);
  }
}
void queuefull()
{
		element* newqueue;
	    newqueue=(element*)malloc(2*capacity*sizeof(element));
		int start=(front+1)%capacity;
		int i = 0,x ;
//		if(start==0){
  //              strcpy(newqueue[i].name,queue[start].name);
    //            newqueue[i].age=queue[start].age;
      //          newqueue[i++].sex=queue[start].sex;			
//		}
	    if(start<2){
				for(x=start;x<start+capacity-1;x++){
                newqueue[i++]=queue[x];
				}
		}
		else {
				for(x=start;x<capacity;x++){
						newqueue[i++]=queue[start];
				}
				int j=0;
				for( j=0;j<rear+1;j++){
						newqueue[i++]=queue[j];

				}
		}  
		front=2*capacity-1;
		rear=capacity-1;
		capacity*=2;
		free(queue);
		queue=newqueue;
		printf("queue full,allocate double size %d\n",capacity);
}
void add(char *name2 , int  age2 , char * sex2 )
{
		rear=(rear+1)%capacity;
		if(rear==front)
				queuefull();
				strcpy(queue[rear].name,name2);
				queue[rear].age=age2;
			//	strcpy(stack[top].sex,sex2);
			    if(strcasecmp(sex2,"female")==0)
			    		queue[rear].sex=0;
			    else    queue[rear].sex=1;
			    switch(queue[rear].sex){
			        case 0 :		
		                    printf("insert record,name=%s,age=%d,sex=female\n",queue[rear].name,queue[rear].age);
		                    break;
		            case 1 :
		                    printf("insert record,name=%s,age=%d,sex=male\n",queue[rear].name,queue[rear].age);
		                    break;
				}
}
element delet()
{
		if(front==rear){
				printf("queue is empty\n");}
		else{
                front=(front+1)%capacity;
				if(queue[front].sex==0)
				printf("delete{%s,%d,female},%d elements in queue\n",queue[front].name,queue[front].age,rear-front);
				else
                printf("delete{%s,%d,male},%d elements in queue\n",queue[front].name,queue[front].age,rear-front);
				return queue[front];
		}
}




