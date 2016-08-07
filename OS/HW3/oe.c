#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<fcntl.h>
#define number  10 
main()
{
	    int array[number];
	    int pipes_fd[20][2];
	    int pipes_fd1[20][2];
	    int pipes_fd2[20][2];
	    printf("Please insert 10 numbers to be sorted:\n");
	    int i=0,j;
		i=0;
	    int x,y;
	    while(i<number){
	    		scanf("%d",&array[i++]);
		}
		printf("Your entered:");
		for(i=0;i<number;i++){
				printf("%d ",array[i]);
		}
	    printf("\n");
	    for(i=0;i<number;i++){
	    		pipe(pipes_fd[i]);
	    		pipe(pipes_fd1[i]);
	    		pipe(pipes_fd2[i]);
		}
		i=0;
        pid_t  pid;
        int status;
        for(i=0;i<number-1;i++){
        		pid=fork();
        		if(pid<0||pid==0){
        				break;
				}
		}
        if(pid<0){
        		perror("Fork error");
        		exit(1);
		}
		else if(pid==0){
				if(((i+1)%2)==0){
						for(j=0;j<number/2;j++){
						read(pipes_fd1[i-1][0],&x,sizeof(int));
						read(pipes_fd1[i][0],&y,sizeof(int));
								if(x>y){
										int tmp;
										tmp=x;
										x=y;
										y=tmp;
								}
						write(pipes_fd2[i-1][1],&x,sizeof(int));
						write(pipes_fd2[i][1],&y,sizeof(int));
						}
				}
				else{
						x=array[i];
					    y=array[i+1];
						for(j=0;j<number/2;j++){	
								if(x>y){
										int tmp;
										tmp=x;
									    x=y;
										y=tmp;
								}
						if(i!=0)
								write(pipes_fd1[i-1][1],&x,sizeof(int));
						if(i!=number-2)
								write(pipes_fd1[i][1],&y,sizeof(int));
						if(i!=0)
							    read(pipes_fd2[i-1][0],&x,sizeof(int));
						if(i!=number-2)
								read(pipes_fd2[i][0],&y,sizeof(int));
						}
						write(pipes_fd[i][1],&x,sizeof(int));
						write(pipes_fd[i+1][1],&y,sizeof(int));
				}
				exit(0);
		}
		else{
		}
		int result[15];
		for(i=0;i<number;i++){
				read(pipes_fd[i][0],&result[i],sizeof(int));
		}
		printf("Result :");
		for(i=0;i<number;i++){
				printf("%d ",result[i]);
		}
		printf("\n");        
}
