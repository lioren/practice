#include<stdio.h>  
#include<stdlib.h>  
#include<math.h>  
int  change(char* ,char*);       
void calculate(char *);          
int k=0;  
int j=0;  
main()  
{  
		int i,n;  
		char after[50];  
		while(1){  
				scanf("%s",&after);  

				k=0;  
				j=strlen(after);                  
				if(after[0]!='0')   calculate(after);  
				else break;  
		}      
		return 0;         
}  
void  calculate(char *after)  
{  
		int stack[50];  
		int top = -1,i=0,n;  
		for(i=0;i<50;i++){  
				stack[i]=0;  
		}  
		int op1,op2;  
		for(i=0;i<j;i++){  
				switch(after[i]){  
						case '+':                                op1=stack[top];                                 stack[top--]=0;                                 op2=stack[top];                                 stack[top]=op1+op2;                                 break;                     case '-':                                op1=stack[top];                                 stack[top--]=0;                                 op2=stack[top];                                 stack[top]=op2-op1;                                 break;                     case '*':                                op1=stack[top];                                 stack[top--]=0;                                 op2=stack[top];                                 stack[top]=op1*op2;                                 break;                     case '/':                                op1=stack[top];                                 stack[top--]=0;                                 op2=stack[top];                                 stack[top]=op2/op1;                                 break;                     case '%':                                op1=stack[top];                                 stack[top--]=0;                                 op2=stack[top];                                 stack[top]=op2%op1;                                 break;                     case ',':                                break;                     default:                                stack[top+1]=after[i]-'0';                                                      top++;  
				}  
		}               printf("%d\n",stack[top]);  
}  
