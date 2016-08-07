#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<fcntl.h>
#define MAXLINE 1024
void creat_proc(char **argv,int fd_in, int fd_out,int pipes_count, int pipes_fd[][2]);
int main(void)
{
		char	buf[MAXLINE];
		char *arg[10][20] = {};
		char *ptr;
		pid_t	pid;
		int	status,i=0,j=0;
		fflush(stdin);
		printf("My shell > ");	
		while (fgets(buf, MAXLINE, stdin) != NULL) {
				if(buf[0]=='\n'){
						printf("My shell > ");
						continue;
				}
				int m=0,n=0;
				i=0;
				buf[strlen(buf)-1]=0;
				ptr=strtok(buf," ");
				arg[m][i]=(char*)malloc(strlen(ptr)+2);
				arg[m][i][strlen(ptr)] = '\0';
				strcpy(arg[m][i],ptr);
				i++;
				while(ptr!=NULL){
						ptr=strtok(NULL," ");
						if(ptr == NULL)
								break;
						arg[m][i] = (char*)malloc(strlen(ptr)+1);
						arg[m][i][strlen(ptr)] = '\0';
						strcpy(arg[m][i],ptr);
						i++;
				}
				int zzz=i;
				int x1=0;
				while(strcmp(arg[0][x1],">")!=0&&strcmp(arg[0][x1],"<")!=0&&arg[0][x1+1]!=NULL){
						x1++;
				}
				 if((strcmp(arg[0][i-1],";")!=0)&&(strcmp(arg[0][i-1],"&")!=0)){
						arg[0][i] = (char*)malloc(sizeof(char)*1);
						strcpy(arg[0][i],";");
						i++;
				}
				int count1 = 0;
				int tmp;
				for(tmp=0;tmp<i;tmp++){
						if((strcmp(arg[0][tmp],";")==0)||(strcmp(arg[0][tmp],"&")==0)||strcmp(arg[0][tmp],"|")==0||strcmp(arg[0][tmp],"<")==0||strcmp(arg[0][tmp],">")==0||arg[0][tmp+1]==NULL){
								if(arg[0][tmp+1]==NULL)
										tmp++;
								++m;
								for(count1;count1<tmp;count1++){
										arg[m][n]=(char*)malloc(sizeof(char)*20);
										strcpy(arg[m][n],arg[0][count1]);
										n++;
								}
								if(strcmp(arg[m][n-1],";")==0||strcmp(arg[m][n-1],"&")==0||strcmp(arg[m][n-1],"|")==0||strcmp(arg[m][n-1],"<")==0||strcmp(arg[m][n-1],">")==0){
										++m;
										arg[m][0]=(char*)malloc(sizeof(char)*2);
										strcpy(arg[m][0],arg[m-1][n-1]);
										arg[m-1][n-1]=NULL;
								}
								n=0;
						}
				}
				int pipeline_count=0;
				i=0;
				while(i<m){
						if(strcmp(arg[i][0],"|")==0){
								pipeline_count++;
						}
						i++;
				}
				if(pipeline_count!=0){
						int C, P;
						int cmd_count=pipeline_count + 1;
						int pipes_fd[7][2];
						for (P=0;P<pipeline_count;++P)
						{
								if (pipe(pipes_fd[P])==-1)
								{
										fprintf(stderr, "Error: Unable to create pipe.(%d)\n",P);
										exit(EXIT_FAILURE);
								}
						}
						for (C=0;C<cmd_count;++C)
						{
								int fd_in=(C==0)?(STDIN_FILENO):(pipes_fd[C - 1][0]);
								int fd_out=(C==cmd_count - 1)?(STDOUT_FILENO):(pipes_fd[C][1]);
								creat_proc(arg[C+1],fd_in,fd_out,pipeline_count,pipes_fd);
						}

						for (P =0;P<pipeline_count;++P)
						{
								close(pipes_fd[P][0]);
								close(pipes_fd[P][1]);
						}

						for (C=0;C<cmd_count;++C)
						{
								int status;
								waitpid(pid,&status,2);
						}
				}
				else if(x1<zzz-1){
						int pipes_fd[7][2];
						while(zzz<m){
								if(strcmp(arg[zzz][0],"|")==0){
										pipeline_count++;
								}
								zzz++;
						}
						for(zzz=0;zzz<pipeline_count;zzz++){
								if(pipe(pipes_fd[zzz])==-1)
								{
										exit(EXIT_FAILURE);
								}
						}
						int x1=0,y1=0;
						int cmd_count=pipeline_count++;
						int in=STDIN_FILENO ,out=STDOUT_FILENO;
						pid=fork();
						while(strcmp(arg[0][x1],"<")!=0&&arg[0][x1+1]!=NULL){
								x1++;
						}
						if(arg[0][x1+1]!=NULL){
							    in=open(arg[0][x1+1],O_RDONLY);
						}
						while(strcmp(arg[0][y1],">")!=0&&arg[0][y1+1]!=NULL){
								y1++;
						}
						if(arg[0][y1+1]!=NULL){
							    out=open(arg[0][y1+1],O_WRONLY|O_CREAT,0644);
						}
						if(pid<0){
						}
						else if(pid==0){
								dup2(in,STDIN_FILENO);
								dup2(out,STDOUT_FILENO);
								if(execvp(arg[1][0],&arg[1][0]));
								{
										exit(127);
								}
						}					
				}
				else {
						i=0;
						int k=1;
						while(i<m){
								i++;
								if(strcmp(arg[i][0],"exit")==0){
										exit(0);
								}
								if(strcmp(arg[i][0],"cd")==0){
										chdir(arg[i][1]);
								}
								else {

										if ( (pid = fork()) < 0)
										{
												printf("fork error");
												exit(127);
										}
										else
										{
												if (pid == 0) {
														if (strcmp(arg[i][0],"&")==0|| strcmp(arg[i][0],";")==0){
																if(strcmp(arg[i][1],"exit")==0)
																		exit(0);
																if(strcmp(arg[i][1],"cd")==0)
																		chdir(arg[i][2]);		
																else{
																		if(execvp(arg[i][1], &arg[i][1]));
																		{
																				printf("couldn't execute: %s\n",arg[i][1]);
																				exit(127);
																		}
																}
														}
														else{
																if(execvp(arg[i][0], arg[i]));
																{
																		printf("couldn't execute: %s\n",arg[i][0]);
																		exit(127);
																}
														}
												}
										}
										if(arg[i+1][0]!=NULL){
												if(strcmp(arg[i+1][0],"&")!=0){
														if(waitpid(pid, &status, 0) < 0)
														{
																//	printf("Wait Pid Error\n");
														}
												}
										}
								}
						}
				}
				printf("My shell > ");
				for(i=0;i<=9;i++){
						for(j=0;j<=19;j++){
								free(arg[i][j]);
								arg[i][j]=NULL;
						}						
				}
		}
		exit(0);
}
void creat_proc(char **argv,int fd_in, int fd_out,int pipes_count, int pipes_fd[][2])
{
		pid_t proc = fork();
		if (proc < 0)
		{
				fprintf(stderr, "Error: Unable to fork.\n");
				exit(EXIT_FAILURE);
		}
		else if (proc == 0)
		{
				if (fd_in != STDIN_FILENO) { dup2(fd_in, STDIN_FILENO); }
				if (fd_out != STDOUT_FILENO) { dup2(fd_out, STDOUT_FILENO); }
				int x;
				for (x=0;x<pipes_count;++x)
				{
						close(pipes_fd[x][0]);
						close(pipes_fd[x][1]);
				}
				if(strcmp(argv[0],"|")==0){
						if(execvp(argv[1],&argv[1])==-1){
								fprintf(stderr,"Error");
								exit(EXIT_FAILURE);
						}
				}
				else{
						if (execvp(argv[0],argv) == -1)
						{
								fprintf(stderr,"Error: Unable to load the executable %s.\n",argv[0]);
								exit(EXIT_FAILURE);
						}
				}
				exit(EXIT_FAILURE);
		}
}

