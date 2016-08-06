#include<stdio.h>
#include<stdlib.h>
int main(void)
{
		int i=0;
		int n=0; 
		int k;




		for(;;)	{	

				printf("¿é¤J¦æ¼Æ:");	




				if(scanf("%d",&n) == 1){	

						if(n>100)
								continue;                
						for(i=0;i<n;i++)	{			
                                 printf("*");
								for(k=1;k<n-i;k++)
										printf(" ");
                                 printf("*");

								for(k=0;k<(2*i+1);k++)
										printf("*");

								printf("\n");
						} 

						for(i=n-2;i>=0;i--)	{

								for(k=1;k<n-i;k++)
										printf(" ");

								for(k=0;k<(2*i+1);k++)
										printf("*");

								printf("\n");
						}

						if(n<=0)
								break;


				}



				else 
						fpurge(stdin);



		}


		return 0;		
}
