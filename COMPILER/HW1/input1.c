#include<stdio.h>  
#include<stdlib.h>  

void Change(int N)  
{  
		if(!N) return;  
		Change(N/2);  
		printf("%d",N%2);  
}  
main()  
{   
	//	int n;   
		while(scanf("%d",&n)==1)  
				Change(n),puts("");  
		return 0;   
}  
