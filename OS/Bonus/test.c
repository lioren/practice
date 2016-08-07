#include <pthread.h>     
#include <stdio.h>   
#define  x1 7
#define  x2 23
#define  y1 9
#define  y2 19
#define  xtrain 10
#define  ytrain 12
#define  xlen 34
#define  ylen 43 
int xstart = 25;
int xend = 0;
int ystart = 32;
int yend = 0;
int xflag1 =0;
int yflag1 =0;
int xflag2 =0;
int yflag2 =0;
pthread_t thread1,thread2;
pthread_mutex_t mutex;
void *print_george(void *argu) {
		int i ,j;
		if(xend<xstart){
				for(i=0;i<xlen;i++){
						if(!(i>xend&&i<xstart))
								printf(">");
						else if(i>=xstart && i<=xend){

								printf(">");
						}
						else if(i==x1||i==x2){
								printf("X");
						}
						else 
								printf(".");
				}	
		}
		else if(xstart<xend){
				for(i=0;i<xlen;i++){
						if(i>=xstart && i<=xend)
								printf(">");
						else if(i==x1||i==x2){
								printf("X");
						}
						else 
								printf(".");
				}

		}
		if(xend+1==x1 && yflag1==1) {
				printf("\n");
				pthread_exit(NULL);
		}
		if(xend+1==x2 && yflag2==1) {
				printf("\n");
				pthread_exit(NULL);
		}
        
		xstart++;
		xend++;
		if(xend==x1)
				xflag1=1;
		if(xstart==x1+1)
                xflag1=0;
        if(xend==x2)
        		xflag2=1;
        if(xstart==x2+1)
        		xflag2=0;
		if(xstart>=xlen)
				xstart=xstart-xlen;
		if(xend>=xlen)
				xend=xend-xlen;
        

		printf("\n");
		pthread_exit(NULL);    
}    

void *print_mary(void *argu) {    
//		pthread_join(thread1,NULL);  
		int m ,n;
		if(yend<ystart){
				for(m=0;m<ylen;m++){
						if(!(m>yend&&m<ystart))
								printf(">");
						else if(m>=ystart && m<=yend){

								printf(">");
						}
						else if(m==y1||m==y2){
								printf("X");
						}
						else 
								printf(".");
				}	
		}
		else if(ystart<yend){
				for(m=0;m<ylen;m++){
						if(m>=ystart && m<=yend)
								printf(">");
						else if(m==y1||m==y2){
								printf("X");
						}
						else 
								printf(".");
				}

		}
		if(yend+1==y1 && xflag1==1) {
				printf("\n");
				pthread_exit(NULL);
		}
		if(yend+1==y2 && xflag2==1) {
				printf("\n");
				pthread_exit(NULL);
		}
		ystart++;
		yend++;
		if(yend==y1)
				yflag1=1;
		if(ystart==y1)
				yflag1=0;
		if(yend==y2)
				yflag2=1;
		if(ystart==y2)
				yflag2=0;
		if(ystart>=ylen)
				ystart=ystart-ylen;
		if(yend>=ylen)
				yend=yend-ylen;
		
		printf("\n");
		pthread_exit(NULL);    
}    

int main() {     
		pthread_mutex_init (&mutex,NULL);
		int count=0;
		while(count<100){
				pthread_create(&thread1, NULL, &print_george, NULL);
				pthread_join(thread1,NULL);
				pthread_create(&thread2, NULL, &print_mary, NULL);
				pthread_join(thread2,NULL);
				sleep(1);
				printf("\n\n");
				count++;
		}
		//	while (1) {     
		//			printf("----------------\n");   
		//			sleep(1);   
		//	} 
		return 0;    
}
