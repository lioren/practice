#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX 1000
#define SWAP(x,y) {int t; t = x; x = y; y = t;}

void quickSort(int[], int, int);
void bubbleSort(int[],int, int);

int main(void) {
		clock_t start1,end1,start2,end2;
		srand(time(NULL));
		int number[MAX] = {0};
        int mumber[MAX] = {0};
	//	printf("first:");


		int i;
		for(i = 0; i < MAX; i++) {
				number[i] = rand() % 60000;
				mumber[i] = number[i];
				//printf("%d ", number[i]);
		}
		start1=clock();
		quickSort(number, 0, MAX-1);
		end1=clock();

	//	printf("\nlast:");


	//	for(i = 0; i < MAX; i++)
	//			printf("%d ", number[i]);

		start2=clock();
		bubbleSort(mumber,0,MAX-1);
		end2=clock();
	//	printf("\nlast:");

	//	for(i=0;i<MAX;i++)
	//			printf("%d ",number[i]);

		printf("\n");

		printf("%0.9f\n",(double)(end1-start1)/CLOCKS_PER_SEC);
		printf("%0.9f\n",(double)(end2-start2)/CLOCKS_PER_SEC);
		return 0;
}

void quickSort(int number[], int left, int right) {
		if(left < right) {
				int i = left;
				int j = right + 1;

				while(1) {

						while(i + 1 < MAX && number[++i] < number[left]) ;

						while(j -1 > -1 && number[--j] > number[left]) ;
						if(i >= j)
								break;
						SWAP(number[i], number[j]);
				}

				SWAP(number[left], number[j]);

				quickSort(number, left, j-1);
				quickSort(number, j+1, right);
		}
}
void bubbleSort(int number[],int a,int b){
		int i=0,j=0,c;
		for(i=a;i<b;i++){
				for(j=a;j<b-i;j++){
						if(number[j]>number[j+1]){
								c=number[j];
								number[j]=number[j+1];
								number[j+1]=c;}
				}
		}
}

