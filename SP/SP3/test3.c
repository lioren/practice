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
		FILE* bp=fopen("bf.txt","w");
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
		int narray[100000];
		float aarray[100000];
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
						if(i==n-1)
								fprintf(bp,"%d %d\n",sum2,total-i*(total/n));
						else 
					    fprintf(bp,"%d %d\n",sum2,total/n); 
						exit(sum2);   
				} 
				gettimeofday(&end,NULL);
				diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;      		
						int status;
						k=i;
						total2--;
						pids=waitpid(-1,&status,0);

		}
		fclose(bp);
		fp=fopen("bf.txt","r");
		int value;
		int z=0;
		float nsum[100000];
		float ncount[100000];
		while(fscanf(fp,"%d",&value)!=EOF){
				nsum[z]=value;
				fscanf(fp,"%d",&value);
				ncount[z]=value;
				z++;
		}
        for(i=0;i<z;i++)
        	 sum=sum+nsum[i];
        if(com_a==1){
		for(i=0;i<z;i++){
				fprintf(rp,"%dth cluster average is:%.2f\n",i+1,nsum[i]/ncount[i]);		
				
		}
		}
		if(com_t==1)
				fprintf(stderr,"cost time:%d\n",diff);
		fprintf(rp,"The sum is:%d\n",sum);

}

