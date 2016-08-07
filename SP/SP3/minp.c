#include<stdio.h>
#include<stdlib.h>
main()
{
		FILE* fp;
		fp=fopen("input2.txt","w");
		int i ,a ;
		for(i=0;i<100000;i++){
				a=(rand()%100)+1;
				fprintf(fp,"%d\n",a);
		}
}
