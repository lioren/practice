#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
#include<sys/types.h>
#include<sys/wait.h>
int main(int argc ,char* argv[])
{  
		//		printf("321");
		int com_d=0,com_f=0,com_o=0,com_a=0,com_t=0;
		int i ;
		int c ;
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
		float narray[100000];
		if(com_d==0)
				n=1;
		if(com_f==1)
				fp=fopen(input,"r");
		else if(com_f==0)
				fp=stdin;
		while(fgets(a,10,fp)!=NULL){
				narray[total]=atof(a);
				total++;
		}
		if(com_o==1)
				rp=fopen(output,"w");
		else if(com_o==0)
				rp=stdout;
		int n2=n;
	    gettimeofday(&start,NULL);
		for(i=0;i<n;i++){	
				pids=fork();
				if(pids<0){
							perror("Fork error");
						exit(1);
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
						int num2,begin,end;
						float sum2=0;
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
								fprintf(bp,"%f %d\n",sum2,total-i*(total/n));
						else 
								fprintf(bp,"%f %d\n",sum2,total/n); 

						exit(1);
				}

		}    		
	//			 gettimeofday(&end,NULL); 
	//			 diff=(1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec)/n2;   
		int status;
		float sum=0;
		//		int n2=n;
		while(n>0){
				n--;
				pids=waitpid(-1,&status,0);

		}
		//printf("n=:%d",n2);
		gettimeofday(&end,NULL); 
		diff=(1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec)/n2; 
		fclose(bp);
		fp=fopen("bf.txt","r");
		float value;
		int z=0;
		float nsum[100000];
		float ncount[100000];
		while(fscanf(fp,"%f",&value)!=EOF){
				nsum[z]=value;
				fscanf(fp,"%f",&value);
				ncount[z]=value;
				z++;
		}
		int nc=0;
		for(i=0;i<z;i++){
				sum=sum+nsum[i];
				nc=nc+ncount[i];
		}
		//gettimeofday(&end,NULL); 
		//diff=(1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec)/nc; 
		if(com_a==1){
				for(i=0;i<z;i++){
						fprintf(rp,"%dth cluster average is:%.2f\n",i+1,nsum[i]/ncount[i]);		

				}
				fprintf(rp,"All average is:%.2f\n",sum/nc);
		}
		if(com_t==1)
				fprintf(stderr,"cost time:%d\n",diff);
		fprintf(rp,"The sum is:%.4f\n",sum);

}

