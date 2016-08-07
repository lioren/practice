#include<stdio.h>  
main()  
{  
		int n;  
		while(scanf("%d",&n)!=EOF)  
		{  
				int a[3000]={0};  
				int i;  
				for(i=0;i<n;i++)  
						scanf("%d",&a[i]);  
				int b[3000]={0};  
				for(i=1;i<n;i++)  
						b[abs(a[i]-a[i-1])]=1;  
				int ok=1;  
				for(i=1;i<n;i++)  
						if(b[i]==0)  
						{  
								ok = 0;  
								break;  
						}  
				if(ok)  
						printf("Jolly\n");  
				else  
						printf("Not jolly\n");  
		}  
		return 0;  
}  
