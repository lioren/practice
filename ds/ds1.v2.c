#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int comp(const void* , const void*);
typedef struct cor{
		int x;
		int y;
		int block;
}cornum;
void counting_sort(cornum*, cornum* ,int);
main()
{                                      
		int number=0,a,b,i ;                             
		clock_t st1,fi1,st2,fi2;
		st1=clock();
		scanf("%d",&number);
		cornum *size=(cornum*)malloc(number*sizeof(cornum));
		int  start[10000];
	//	int *block=(int*)malloc(number*sizeof(int));
		start[0]=0;
		for(i=0;i<number;i++){                             
				scanf("%d%d",&a,&b);
				size[i].x=a;
				size[i].y=b;
				size[i].block=(b/600)*100+(a/600);
		}
		fi1=clock();                                         
		st2=clock();
//		qsort(block,number,sizeof(int),comp1);             
		qsort(size,number,sizeof(cornum),comp); 
		int u=0;
		for(i=0;u<10000;){
				while(size[i].block==u)
						i++;
				start[++u]=i;
		}
		int m,d,a1,b1,s1,f1,qa,qb,xx,yy,bx,by,dlock;
		while(1){
				int count=0;
				scanf("%d%d",&m,&d);
				if(m==0&&d==0)
						break ;
				for(i=0;i<m;i++){
						scanf("%d%d",&a1,&b1);
						int j=0;
						qa=a1/600;
						qb=b1/600;
						for(xx=-1;xx<2;xx++){
								bx=qa+xx;
								if(bx<0||bx>=100)
										continue;
								for(yy=-1;yy<2;yy++){
										by=qb+yy;
										if(by<0||by>=100)
												continue;
										dlock=by*100+bx;
										for(j=start[dlock];j<start[dlock+1];j++){
												if(size[j].x-a1>d||a1-size[j].x>d||b1-size[j].y>d||size[j].y-b1>d)
														continue;
												if(((size[j].x-a1)*(size[j].x-a1)+(size[j].y-b1)*(size[j].y-b1))<=d*d)
														count++;
										}
								}
						}
				}
				/*  	    		while(j!=number-1){          // Method one start ;
									if((a1-size[j].x)>d)
									j++;
									else break;
									}
									if(j==number-1)
									continue;
									s1=j;
									while(1){
									if((a1-size[j].x)<=d)
									j++;
									else break;
									}
									f1=j;
				//				printf("%d\t%d",s1,f1);
				for(s1;s1<f1;s1++){
				if((size[s1].y-b1)>d||b1-size[s1].y>d)
				continue;
				if((long)(size[s1].x-a1)*(long)(size[s1].x-a1)+(size[s1].y-b1)*(size[s1].y-b1)<=(d*d))
				count++;
				} */                         //Method one end ;

				/* 	         	for(j=0;j<number;j++){       //Method two start;
								if((size[j].x-a1)>d||(a1-size[j].x)>d||(size[j].y-b1)>d||(b1-size[j].y>d))
								continue;
								if(((long)(size[j].x-a1)*(long)(size[j].x-a1)+(long)(size[j].y-b1)*(long)(size[j].y-b1))<=(long)d*d)
								count++;
								else continue;  
								}  */                        //Method two end ;
				printf("%d\n",count);
		}
		fi2=clock();
		printf("input time=%lf\nrunning time=%lf\ntotal time=%lf",(double)(fi1-st1)/CLOCKS_PER_SEC,(double)(fi2-st2)/CLOCKS_PER_SEC,(double)(fi1+fi2-st1-st2)/CLOCKS_PER_SEC);  
}
int comp(const void*a, const void*b)
{
		cornum*c=(cornum*)(a);
		cornum*d=(cornum*)(b);
		return (c->block)- (d->block);
}
void counting_sort (cornum* size , cornum*sorted , int number)
{
		cornum* count = (cornum*)malloc(sizeof(cornum)*number);
        int i,j,k;
        for(k=0;k<number;k++){
        		count[k].block=0;
		}
		for(i=0;i<number;i++){
				count[size[i].block].block++;
		}
		for(k=1;k<100;k++){
				count[k].block+=count[k-1].block;
		}
}
