#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
#include<sys/types.h>
#include<sys/wait.h>
int main(int argc ,char* argv[])
{  
		int com_d=0,com_f=0,com_o=0,com_a=0,com_t=0;
		int i,k ;
		int c ;
		int sum=0;
		struct timeval start;
		struct timeval end;
		unsigned long diff;
		int total=0;
		int n;
		pid_t pids;
		FILE* fp;
		FILE* rp;
		char a[40];
		char input[20],output[20];
		while((c=getopt(argc,argv,"dfoat"))!=-1){
				switch(c)
				{
						case'd':
								com_d=1;
								if(argv[optind]==NULL){
										n=1;
										break;
								}
								if(isdigit(argv[optind][0])){
										n=atoi(argv[optind]);
								}
								else 
										n=1;
								optind++;
								break;
						case'f':
								com_f=1;								
								strcpy(input,argv[optind]);
								optind++;
								break;
						case'o':
								com_o=1;
								strcpy(output,argv[optind]);
								optind++;
								break;
						case'a':
								com_a=1;
								break;
						case't':
								com_t=1;
								break;
						case'?':
								break;
						default:
								break;

				}
		}
		int narray[20000];
		float aarray[20000];
		if(com_d==0)
				n=1;
		if(com_f==1)
				fp=fopen(input,"r");
		else if(com_f==0)
				fp=stdin;
		while(fgets(a,10,fp)!=NULL){
				narray[total]=atoi(a);
				total++;
		}
		if(com_o==1)
				rp=fopen(output,"w");
		else if(com_o==0)
				rp=stdout;
		int total2=n;
		for(i=0;i<n;i++){	
				gettimeofday(&start,NULL);
				pids=fork();
				if(pids<0){
						perror("Fork error");
				}
				else if(pids==0){
						char s[10];
						int time=i*(total/n);
						int j=0;
						if(com_f==1){
								fp=fopen(input,"r");
								while(time>0){
										j++;
										time--;
								}
						}
						else if(com_f==0){
								while(time>0){
										j++;
										time--;
								}
						}
						int sum2=0,num2,begin,end;
						if(i==n-1){
								num2=total-i*(total/n);
						}
						else 
								num2=total/n;
						while(num2>0){
								num2--;
								sum2=sum2+narray[j];
								j++;
						}
					    
						exit(sum2);   
				} 
				else{      		
						int status;
						k=i;
						total2--;
						pids=waitpid(-1,&status,0);
						sum=sum+WEXITSTATUS(status);
						if(com_a==1){
								if(total2==0&&(total%n)!=0){
										aarray[k++]=(float)(WEXITSTATUS(status))/(float)((total-i*(total/n)));
								}
								else{
										aarray[k++]=(float)(WEXITSTATUS(status))/(float)((total/n));
								}
						}
				}
				gettimeofday(&end,NULL);
				diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec; 

		}
		for(i=0;i<k;i++){
				if(com_a==1){
				fprintf(rp,"%dth cluster average is:%.2f\n",i+1,aarray[i]);		
				}
		}
		if(com_t==1)
				fprintf(stderr,"cost time:%d\n",diff);
		fprintf(rp,"The sum is:%d\n",sum);

}

