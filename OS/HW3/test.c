#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<fcntl.h>
int count = 9;
main()
{
	/*	int pipes_fd[2];
		pipe(pipes_fd);
		int  a[5] = {1,2,3,4,5} ;
		write(pipes_fd[1],a,sizeof(a));
		int b[10];
		read(pipes_fd[0],b,sizeof(b));
		printf("%d",b[2]);*/
	    int array[15];
	    int pipes_fd[20][2];
	    printf("Please insert 10 numbers to be sorted\n");
	    int i=0;
	    for(i=0;i<20;i++){
	    		pipe(pipes_fd[i]);
		}
		i=0;
	    while(i<10){
	    		scanf("%d",&array[i++]);
		}
        pid_t  pid;
        int status;
        for(i=0;i<10;i++){
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
	//			printf("%d\n",array[i]);
				if(((i+1)%2)==0){
						int buf[15];
						int j=1;
						read(pipes_fd[i-1][0],buf,sizeof(buf));
						while(j<9){
								if(buf[j]>buf[j+1]){
										int tmp;
										tmp=buf[j];
										buf[j]=buf[j+1];
										buf[j+1]=tmp;
								}
								j=j+2;
						}
						write(pipes_fd[i][1],buf,sizeof(buf));

				}
				else{
						int buf[15];
						int j=0;
						if(i==0){
								for(i=0;i<10;i++){
										buf[i]=array[i];
								}
								i=0;
						}
						if(i!=0){
						read(pipes_fd[i-1][0],buf,sizeof(buf));
						}
						while(j<10){
								if(buf[j]>buf[j+1]){
										int tmp;
										tmp=buf[j];
										buf[j]=buf[j+1];
										buf[j+1]=tmp;
								}
								j=j+2;
						}
					//	close(pipes_fd[i][0]);
					//	close(pipes_fd[i][1]);
						write(pipes_fd[i][1],buf,sizeof(buf));

				}
		}
		else{
		while(count>0){
				count--;
				waitpid(pid,&status,0);

		}
		int result[15];
		read(pipes_fd[9][0],result,sizeof(result));
        int k;
		for(k=0;k<10;k++){
				printf("%d ",result[k]);
		}
		//printf("1\n");
		}
        
}
