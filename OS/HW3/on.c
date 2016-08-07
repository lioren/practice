#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>

int main(){
		const int LISTNUM=10;
		int list[LISTNUM+1];
		int i,j;
		int tmp;
		int one,two;
		int tube1[LISTNUM-2][2];
		int tube2[LISTNUM-2][2];
		int tube[LISTNUM][2];
		pid_t pid[LISTNUM-1];
		fprintf(stdout,"please input 10 number: ");
		for(i=0;i<LISTNUM;i++){
				fscanf(stdin,"%d",&list[i]);
		}
		fprintf(stdout,"your input is: ");
		for(i=0;i<LISTNUM;i++){
				fprintf(stdout,"%d ",list[i]);
		}
		fprintf(stdout,"\n");

		for(i=0;i<LISTNUM-2;i++){
				pipe(tube1[i]);
				pipe(tube2[i]);
		}
		for(i=0;i<LISTNUM;i++) pipe(tube[i]);
		for(i=0;i<LISTNUM-1;i++){
				if((pid[i]=fork())==0){
						if(i%2==0){
								one=list[i];
								two=list[i+1];
								for(j=0;j<LISTNUM/2;j++){
										if(one>two){
												tmp=one;
												one=two;
												two=tmp;
										}
										if(i!=0) write(tube1[i-1][1],&one,sizeof(int));
										if(i!=LISTNUM-2) write(tube1[i][1],&two,sizeof(int));
										if(i!=0) read(tube2[i-1][0],&one,sizeof(int));
										if(i!=LISTNUM-2) read(tube2[i][0],&two,sizeof(int));
								}
								write(tube[i][1],&one,sizeof(int));
								write(tube[i+1][1],&two,sizeof(int));
						}else{
								for(j=0;j<LISTNUM/2;j++){
										read(tube1[i-1][0],&one,sizeof(int));
										read(tube1[i][0],&two,sizeof(int));
										if(one>two){
												tmp=one;
												one=two;
												two=tmp;
										}
										write(tube2[i-1][1],&one,sizeof(int));
										write(tube2[i][1],&two,sizeof(int));
								}
						}
						exit(0);
				}else if(pid[i]<0){
						fprintf(stderr,"fork failed\n");
						exit(127);
				}else{		
				}

		}
		for(i=0;i<LISTNUM;i++)
				read(tube[i][0],&list[i],sizeof(int));
		fprintf(stdout,"the result is: ");
		for(i=0;i<LISTNUM;i++){
				fprintf(stdout,"%d ",list[i]);
		}
		fprintf(stdout,"\n");
		return 0;
}
