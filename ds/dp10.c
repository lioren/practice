#include <stdio.h>  
#include <stdlib.h>   
int main(void)  
{  
		int n,m,i = 0;  
		int ans[45]={0};     
		ans[0]=0;  
		ans[1]=1;  
		scanf("%d",&m);  
		while(m>0){  
				m--;  
				scanf("%d",&n);  
				for(i=2;i<=n;i++){  
						ans[i]=ans[i-1]+ans[i-2];  
				}  
				printf("%d\n",ans[n]);  
		}      
		return 0;  
}  
