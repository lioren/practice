#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define input 20
typedef struct{
		int key;
} element;
element buf;
element a[5000];
element b[5000];
int s=0;
int q=0;
void minipush(element);
element minipop();
void maxpush(element);
element maxpop();
main()
{
		int i;
		for(i=0;i<5000;i++){
				a[i].key=0;
				b[i].key=0;
		}
		while(1==scanf("%d",&(buf.key))){
				if(buf.key>a[1].key){
						minipush(buf);

						if(s>q)
								maxpush(minipop());
				}
				else {
						maxpush(buf);
						if(q>s+1)
								minipush(maxpop());
				}
				if(q==s){
						printf("%d\n",(a[1].key+b[1].key)/2);
				}
				else printf("%d\n",a[1].key);
		}
}
void minipush(element buf)
{
		int i,n=0 ;
		i=++(s);
		//		printf("%d\n",i);
		while((i!=1)&&(buf.key<b[i/2].key)){
				b[i]=b[i/2];
				i=i/2;
		}
		b[i]=buf;
}
element minipop()
{
		if(s==0){
				printf("heap is empty\n");
				return;
		}
		int parent ,child;
		element item,temp;
		item=b[1];
		temp=b[s--];
		parent=1;
		child=2;
		while(child<=s){
				if((child<s)&&(b[child].key)>b[child+1].key)
						child++;
				if(temp.key<=a[child].key)
						break;
				b[parent]=b[child];
				parent=child;
				child=child*2;
		}
		b[parent]=temp;
		return item;
}
void maxpush(element buf)
{
		int i,n=0 ;
		i=++(q);
		//		printf("%d\n",i);
		while((i!=1)&&(buf.key>a[i/2].key)){
				a[i]=a[i/2];
				i=i/2;
		}
		a[i]=buf;
}
element maxpop()
{
		if(q==0){
				printf("heap is empty\n");
				return;
		}
		int parent ,child;
		element item,temp;
		item=a[1];
		temp=a[q--];
		parent=1;
		child=2;
		while(child<=q){
				if((child<q)&&(a[child].key)<a[child+1].key)
						child++;
				if(temp.key>=a[child].key)
						break;
				a[parent]=a[child];
				parent=child;
				child=child*2;
		}
		a[parent]=temp;
		return item;
}
