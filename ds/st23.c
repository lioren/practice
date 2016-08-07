#include<stdio.h>  
#include<stdlib.h>  
#include<string.h>  
#include<math.h>  
main()  
{  
		int a[30],c,i=0,num=0,x,y,temp;  
		scanf("%d",&c);  
		while(c>0){  
				c--;  
				scanf("%d",&a[i]);  
				i++;  
		}  


		for(x=0;x<i;x++){  
				for(y=0;y<x;y++){  
						if(a[x]<a[y]){  
								num++;}  
				}  
		}  
		printf("Complaint =%d\n",num);   
		return 0;  
}  
