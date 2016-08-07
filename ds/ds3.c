#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int  change(char* ,char*);     //   infix to postfix
int compare(char);             //   compaer + - * / % 
void calculate(char *);        //   calculate answer
int k=0;
int j=0;
main()
{
		int i,n;
		char before[50]; 
		char after[50];   
     	while(fgets(before,50,stdin)!=NULL){
				k=0;
				n=change(before,after);
				if(n==1){
						printf("parentheses mismatch\n");
						continue;
				}
				if(n>5){     // most 5 digits 
						printf("invalid tokens\n");
						continue;
				}
				for(i=0;i<j;i++){
						printf("%c", after[i]);
				}
				calculate(after);
		}
}
int  change(char *before ,char *after)
{
		char stack[50];
	    j=0;
		int top=-1, n,left=0,right=0,r1=0,r2=0,r3=0,l1=0,l2=0,l3=0;
		if(before[0]=='+'||before[0]=='-'||before[0]=='/'||before[0]=='*'||before[0]==')'||before[0]==']'||before[0]=='}')
				return 6;
		for(k=0;before[k]!='\n';k++){
				switch(before[k]){
						case '(':
						case '[':
						case '{':
						         if(before[k+1]=='+'||before[k+1]=='-'||before[k+1]=='/'||before[k+1]=='*'||before[k+1]=='%')
						         		 return 6;
						         if((before[k])=='(')
						         		 l1++;
						         else if((before[k])=='[')
						         		 l2++;
						         else if((before[k])=='{')
						         		 l3++;
						         left++;
						         stack[++top]=before[k];
						         break;
						case '+':
						case '-':
						case '*':
						case '/':
						case '%':
						         if(before[k+1]=='+'||before[k+1]=='-'||before[k+1]=='/'||before[k+1]=='*'||before[k+1]=='%')
						         		 return 6;
						         while(compare(stack[top])>=compare(before[k])){
						         		 after[j++]=stack[top--];
						         		 after[j++]=',';
								 }
						         		 stack[++top]=before[k];
						         		 break;
						case ')':
						case ']':
						case '}':
						         if((before[k+1]<='9')&&(before[k+1]>='0'))
						         		 return 6;
						         if(before[k+1]=='('||before[k+1]=='['||before[k+1]=='{')
						         		 return 6;
						         if((before[k])==')')
						         		 r1++;
						         if((before[k])==']')
						         		 r2++;
						         if((before[k])=='}')
						         		 r3++;
						         right++;
						         if(right>left)
						         		 return 1;
						         while(stack[top]!='('&&stack[top]!='['&&stack[top]!='{'){
						         		 after[j++]=stack[top--];
						         		 after[j++]=',';
								 }
						         		 top--;
						         		 break;
						case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case '0':
						        n=0;
						        while('0'<=before[k]&&before[k]<='9'){
						        		after[j++]=before[k];
						        		k++;
						        		n++;
						        		if(n>5)
						        				return n;

								}
								after[j++]=',';
							    k--;
							    break;
						case ' ':
						        break;
					    default :
					             return 6;
						        
				}
		}
				while(top>-1){
						after[j++]=stack[top--];
						after[j++]=',';
				}
				if(left!=right||r1!=l1||r2!=l2||r3!=l3)
						return 1;
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
						case '+':
						         op1=stack[top];
						         stack[top--]=0;
						         op2=stack[top];
						         stack[top]=op1+op2;
						         break;
						case '-':
						         op1=stack[top];
						         stack[top--]=0;
						         op2=stack[top];
						         stack[top]=op2-op1;
						         break;
						case '*':
						         op1=stack[top];
						         stack[top--]=0;
						         op2=stack[top];
						         stack[top]=op1*op2;
						         break;
						case '/':
						         op1=stack[top];
						         stack[top--]=0;
						         op2=stack[top];
						         stack[top]=op2/op1;
						         break;
						case '%':
						         op1=stack[top];
						         stack[top--]=0;
						         op2=stack[top];
						         stack[top]=op2%op1;
						         break;
						case ',': 
						         break;
						default:
					    n=0;
						while(isdigit(after[i+1])!=0){
								n++;
								i++;
						}
						for(n=n;n>=0;n--){
								stack[top+1]=stack[top+1]+(after[i-n]-'0')*(pow(10,n));
						}
								top++;
				}
		}
				printf("\nAnswer:%d\n",stack[top]);
}
int compare(char a)
{
		if(a=='+'||a=='-')
				return 1;
		if(a=='*'||a=='/'||a=='%')
				return 2;
		else 
		        return 0 ;

}



