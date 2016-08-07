#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
typedef struct {
		char name[30];
		int age;
		enum {female,male}sex;
}element;
element *stack;
int capacity =1;
int top=-1;
void stackfull();
void push(char* name2 , int  age2 , char * sex2 );
element pop();
main()
{
  stack=(element*)malloc(sizeof(element));
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
		  		  pop();
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
				  push(name, age , sex);
  }
}
void stackfull()
{
		stack=(element*)realloc(stack,2*capacity*sizeof(*stack));
		capacity*=2;
		printf("stack full,allocate double size %d\n",capacity);
}
void push(char *name2 , int  age2 , char * sex2 ) 
{
		if(top>=capacity-1)
				stackfull();
				++top;
				strcpy(stack[top].name,name2);
				stack[top].age=age2;
			//	strcpy(stack[top].sex,sex2);
			    if(strcasecmp(sex2,"female")==0)
			    		stack[top].sex=0;
			    else    stack[top].sex=1;
			    switch(stack[top].sex){
			        case 0 :		
		                    printf("insert record,name=%s,age=%d,sex=female\n",stack[top].name,stack[top].age);
		                    break;
		            case 1 :
		                    printf("insert record,name=%s,age=%d,sex=male\n",stack[top].name,stack[top].age);
		                    break;
				}
}
element pop()
{
		if(top<0){
				printf("stack is empty\n");}
		else{
				if(stack[top].sex==0)
				printf("delete{%s,%d,female},%d elements in stack\n",stack[top].name,stack[top].age,top);
				else
                printf("delete{%s,%d,male},%d elements in stack\n",stack[top].name,stack[top].age,top);
				return stack[top--];
		}
}




