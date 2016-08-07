#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<semaphore.h>
#include<pthread.h>
#include<math.h>
int compare1(const void *, const void *);
int compare2(const void *, const void *);
int len;
int **square;
sem_t semaphore; 
void *odd_do(void *num){
		fflush(NULL);
		int a = *(int*)num;
		int i,j ;
		if(a%2==0){
				qsort(square[a],len,sizeof(int),compare1);
		}
		else if(((a+1)%2)==0){
				qsort(square[a],len,sizeof(int),compare2);
		}
		free(num);  
		pthread_exit(NULL); 
}
void *even_do(void *num){
		fflush(NULL);
		int a = *(int*)num;
		int i ,j;
		for(i=0;i<len-1;i++){
				for(j=0;j<len-1-i;j++){
						if(square[j][a]>square[j+1][a]){
								int tmp;
								tmp=square[j+1][a];
								square[j+1][a]=square[j][a];
								square[j][a]= tmp ;
								}
				}
		}
		free(num);
		pthread_exit(NULL);
        
}
int main () {
		int param1;
		int i,j,k;
		srand(time(NULL));
		scanf("%d",&len);
		pthread_t t[len*2];
		square=(int**)malloc(len*sizeof(int*));
		printf("Begin matrix:\n");
		for(i=0;i<len;i++){
				square[i]=(int*)malloc(len*sizeof(int*));
				for(j=0;j<len;j++){
						square[i][j]=(rand()%100)+1;
						printf("%d ",square[i][j]);
				}
				printf("\n");
		}
		int count = log(len)+1;
		while(count>=0){
				count--;
		for(k=0;k<len;k++){
				int *ptr = malloc(sizeof(int));
				*ptr = k ;
				pthread_create(&t[k], NULL, odd_do, ptr); 
		}
		for(i=0;i<len;i++){
				pthread_join((pthread_t) t[i], (void **) NULL); 
		}
		for(k=0;k<len;k++){
				int *ptr = malloc(sizeof(int));
				*ptr = k ;
				pthread_create(&t[k], NULL, even_do, ptr);
		}
		for(i=0;i<len;i++){
				pthread_join((pthread_t) t[i], (void **) NULL); 
		}
		}
		printf("\n\n");
        printf("Result matrix:\n");
		for(i=0;i<len;i++){
				for(j=0;j<len;j++){
						printf("%d ",square[i][j]);
				}
				printf("\n");
		}
}
int compare1(const void *a, const void *b)
{
		int c = *(int *)a;
		int d = *(int *)b;
		if(c < d) {return -1;}            
		else if (c == d) {return 0;}     
		else return 1;                        
}
int compare2(const void *a, const void *b)
{
		int c = *(int *)a;
		int d = *(int *)b;
		if(c > d) {return -1;}    
		else if (c == d) {return 0;}    
		else return 1;                        
}
