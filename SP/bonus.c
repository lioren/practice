#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <signal.h>
#include <unistd.h>
int number_fish=0;
int i=0;
bool fish=false;
bool is_put=false;
void end(int sig){
    	printf("\nThe number of totally grabbed fishes : %d\n",number_fish);
		exit(0);
}
void gotornot(int sig){
		if(fish==false){
				fish=true;
				printf("A fish is eating the bait!\n");
				for(i=3;i>=1;i--){
						sleep(1);
				  		if(is_put==false)
								return;
				   			printf("The remain time to pull the fishing pole:%d\n",i);
				}
				if(is_put==false)
						return;
				else 
						alarm(1);
		}
		else{
				fish=false;
				printf("The fish has escaped\n");
				int time=(rand()%3)+3;
				alarm(time);
		}
}
void controll(int sig){
		if(is_put==true){
				is_put=false;
				printf("\nPull the fishing pole\n");
				if(fish){
						fish=false;
						printf("Got a fish !The number of currently grabbed fishes : %d\n", ++number_fish);
				}
				alarm(0);
		}
		else{
				is_put=true;
				printf("\nPut the fishing pole\n");
				alarm(0);
				int time=(rand()%3)+3;
				alarm(time);
		}
}
int main(void){
		signal(SIGTSTP,end);
		signal(SIGINT,controll);
		signal(SIGALRM,gotornot);
     	while (1){
		}
		return 0;
}
