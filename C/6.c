#include<stdio.h>
main()
{
		char a[500];
		int i,j=0,n,c;
		int d;
		scanf("%d",&n);
		if (n<=0||n>500){
				printf("error");		return 0 ;}
		d=getchar();
		if(isdigit(d)==0&&d!='\n')
	/*	if(d!='1'&&d!='0'&&d!='2'&&d!='3'&&d!='4'&&d!='5'&&d!='6'&&d!='7'&&d!='8'&&d!='9'&&d!='\n')*/{
				printf("error");
				return 0; }
                                


				for(i=0;i<n;i++)
						scanf("%d",&a[i]);

				for(i=0;i<n;i++){
						for(j=0;j<n-1-i;j++){
								if(a[j]>a[j+1]){
										c=a[j];
										a[j]=a[j+1];
										a[j+1]=c;}
						}
				}
				for(i=0;i<n;i++)
						printf("%d\n",a[i]);
						return 0;
}

/*a[j]=a[j]+a[j+1];
  a[j+1]=a[j]-a[j+1];
  a[j]=a[j]-a[j+1];*/
