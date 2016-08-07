#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#define MAXLINE 1024
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
	//			printf("My shell > ");
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
				if((strcmp(arg[0][i-1],";")!=0)&&(strcmp(arg[0][i-1],"&")!=0)){
						arg[0][i] = (char*)malloc(sizeof(char)*1);
						strcpy(arg[0][i],";");
						i++;
				}
						int count1 = 0;
						int tmp;
						for(tmp=0;tmp<i;tmp++){
								if((strcmp(arg[0][tmp],";")==0)||(strcmp(arg[0][tmp],"&")==0)||arg[0][tmp+1]==NULL){
										if((arg[0][tmp+1]==NULL)/*||(strcmp(arg[0][tmp],";")==0||strcmp(arg[0][tmp],"&")==0)*/)
												tmp++;
										++m;
										for(count1;count1<tmp;count1++){
										arg[m][n]=(char*)malloc(sizeof(char)*20);
										strcpy(arg[m][n],arg[0][count1]);
										n++;
										}
										if(strcmp(arg[m][n-1],";")==0||strcmp(arg[m][n-1],"&")==0){
												++m;
												arg[m][0]=(char*)malloc(sizeof(char)*2);
												strcpy(arg[m][0],arg[m-1][n-1]);
												arg[m-1][n-1]=NULL;
										}
										n=0;
								}
						}
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
					//			if(wait(&status)<0)
								{
									//	printf("Wait Pid Error\n");
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


