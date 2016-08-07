#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define input 20
typedef struct{
		int key;
} element;
element buf;
element heap[21];
int s=0;
void push(element);
void display();
void sort(); 
element pop();
main()
{
		srand(time(NULL));
		char  comd;
		int n ;
		while(1){
		scanf("%c",&comd);
		switch(comd){ 
				case 'E':
				         printf("End");
				         return 0;
		
				case 'N':
				         scanf("%d",&n);
				         int i,now,a=0,num;
				         for(i=0;i<n;i++){
				         		 buf.key=(rand()%60001)-30000;
				         		 push(buf);
				         //		 printf("%d\n",buf[i]);
						 }
						 printf("Initial priority queue :");
						 for(i=1;i<s+1;i++){
						 printf("%d ",heap[i].key);
						 }
						 printf("\n");
						 break;
				case 'D':
	                     printf("Delete element:%d\n",heap[1]);
				         pop();
				         break;
				case 'I':
				         if(s==20){
				         		 printf("heap is full\n");
				         		 break;
						 }
				         buf.key=(rand()%60001)-30000;
				         printf("Insert element:%d\n",buf.key);
				         push(buf);
				         break;
				case 'M':
				         printf("Mini heap:");
				         display();
						 printf("\n");
						 break;
				case 'S':
				         printf("Size of priority queue:%d\n",s);
				         break;
				case 'T':
				         printf("Min priority element :%d\n",heap[1]);
				         break;
				case 'P':
				         printf("Show priority queue:");
				         sort();
				         printf("\n");
				         break;
				default :
				      //   printf("wrong command\n");
				         break;

		}
		}
		
}
void sort()
{
		element copy[21];
		element store[21];
		int i,c;
		c=s;
		for(i=1;i<c+1;i++){
				copy[i]=heap[i];
		}
		for(i=1;i<c+1;i++){
				store[i]=pop();
				printf("%d ",store[i].key);
		}
		for(i=1;i<c+1;i++){
				heap[i]=copy[i];
		}
		s=c;

}
void display()
{
		int i=0;
		for(i=1;i<s+1;i++){
				printf("%d ",heap[i].key);
		}
}
void push(element buf)
{
		int i,n=0 ;
		i=++(s);
//		printf("%d\n",i);
		while((i!=1)&&(buf.key<heap[i/2].key)){
				heap[i]=heap[i/2];
				i=i/2;
		}
		heap[i]=buf;
}
element pop()
{
		if(s==0){
				printf("heap is empty\n");
				return;
		}
		int parent ,child;
		element item,temp;
		item=heap[1];
		temp=heap[s--];
		parent=1;
		child=2;
		while(child<=s){
				if((child<s)&&(heap[child].key)>heap[child+1].key)
						child++;
				if(temp.key<=heap[child].key)
						break;
				heap[parent]=heap[child];
				parent=child;
				child=child*2;
		}
		heap[parent]=temp;
		return item;
}
