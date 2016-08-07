#include <stdio.h>          
#include <stdlib.h>     
int com(const void*a ,const void*b);               
int main(void) {          
		int a,b,c,i,p;  
		int ar[1001];   
		scanf("%d",&a);  
		while(a>0){  
				a--;  
				scanf("%d",&b);  
				for(i=0;i<b;i++){  
						scanf("%d",&ar[i]);  
				}  
				qsort(ar,b,sizeof(int),com);  
				while(ar[b-1]%ar[0]){  
						p=  ar[b-1] ;  
						ar[b-1]=ar[0];  
						ar[0]=p %ar[b-1];             
				}  
				printf("%d\n",ar[0]);                
		}          
}          
int com(const void*a ,const void*b)  
{  
		return *(int*)a-*(int*)b;  
}  
