int a;
int b;
int c;
void main(){
		a=1;
		b=2;
		printf("assign 1 to global variable a\n");
		printf("assign 2 to global variable b\n");
		printf("next line will print int global variable a\n");
        printf("%d\n",a);
		printf("next line will print int global variable b\n");
        printf("%d\n",b);
        c=a+b;
        printf("assign a+b to c\n");
  		printf("next line will print global variable c\n");
  		printf("%d\n",c);
  	    c=a-b;
  		printf("assign a-b to c\n");
  		printf("next line will print global variable c\n");
  		printf("%d\n",c);
  		printf("");
	 
}
