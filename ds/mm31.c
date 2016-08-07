#include <stdio.h>          
#include <stdlib.h>                 
int main(void) {          
		int n,m,p=1;  
		scanf("%d",&n);  
		for(;n>0;n--){  
				scanf("%d",&m);  
				while(m>0){  
						p=p*m;  
						m--;  
				}  
				printf("%d\n",p);  
				p=1;  
		}          
}  
