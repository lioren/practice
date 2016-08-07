#include<stdio.h>   
#include<stdlib.h>   
#include<string.h>   
main()   
{   
		char x[102],y[102];   
		int circle[10]={1,1,4,4,2,1,1,4,4,2};   
		int L[10][4]={{0},{1},{6,2,4,8},{1,3,9,7},{6,4},{5},{6},{1,7,9,3},{6,8,4,2},{1,9}};   
		while(scanf("%s %s",x,y)==2)   
		{   
				int n=strlen(x),m=strlen(y),a,b,c;   
				if(n==1&&m==1&&x[0]=='0'&&y[0]=='0') break;   
				if(n==1&&x[0]=='0') {printf("0\n");continue;}   
				if(m==1&&y[0]=='0') {printf("1\n");continue;}   
				int xx=x[n-1]-48,yy[102]={0};   
				for(a=0,b=m-1;b>=0;a++,b--) {yy[a]=y[b]-48;}   

				for(a=m-1;a>=0;a--)   
						yy[a]=(yy[a+1]*10+yy[a])%circle[xx];   
				printf("%d\n",L[xx][yy[0]]);   
		}   
		return 0;   
} 
