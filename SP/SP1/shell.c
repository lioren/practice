#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#define MAXLINE 1024
main(void)
{
		char	buf[MAXLINE];
		char *arg[100] = {};
		char *ptr;
		pid_t	pid;
		int	status,i=0,j;
		fflush(stdin);
		printf("@ ");	
		while (fgets(buf, MAXLINE, stdin) != NULL) {
				if(buf[0]=='\n'){
						printf("@ ");
						continue;
				}
				i=0;
				buf[strlen(buf)-1]=0;
				ptr=strtok(buf," ");
				arg[i] = (char*)malloc(strlen(ptr)+10);
				arg[i][strlen(ptr)] = '\0';
				strcpy(arg[i],ptr);
				i++;
				while(ptr!=NULL){
						ptr=strtok(NULL," ");
						if(ptr == NULL)
								break;
						arg[i] = (char*)malloc(strlen(ptr)+1);
						arg[i][strlen(ptr)] = '\0';
						strcpy(arg[i],ptr);
						i++;
				}

				if ( (pid = fork()) < 0)
				{
						printf("fork error");
						exit(127);
				}
				else
				{
						if (pid == 0) {
								if(strcmp(arg[0],"find")==0){
										strcpy(arg[0],"./find\0");
								}
								if(strcmp(arg[0],"rename")==0){
										strcpy(arg[0],"./rename\0");
								}

				//				if(execlp(arg[0], arg[0],arg[1],arg[2],arg[3],arg[4], (char *) 0) < 0)
				                if(execvp(arg[0], arg));
								{
										printf("couldn't execute: %s\n",arg[0]);
										exit(127);
								}

						}
				}
				if(waitpid(pid, &status, 0) < 0)
						printf("Wait Pid Error\n");

				printf("@ ");
				for(j=0;j<=i;j++){
						free(arg[j]);
						arg[j]=NULL;}

		}
		exit(0);
}


