#include<stdio.h>
#include<stdlib.h>
void union1(int  , int );
int find(int  );
int *parent; 
int total;
main()
{
		int a,b,i,x,y,z;
	//	int n[50000];
		char c;
		char s[10];
		while(1){
		scanf("%d%d",&a,&b);
		if(a==0&&b==0)
				break;
		parent=(int*)malloc(a*sizeof(int));
		for(i=0;i<a;i++){
				parent[i]= -1 ;
		}
		while(b>0){
				int n[30001];
				b--;
				scanf("%d",&x);
				if(x==1){
						scanf("%d",&n[0]);
				     	continue;
				}
			
				for(i=0;i<x;i++){
						scanf("%d",&n[i]);
				}
				for(i=1;i<x;i++){
						union1(n[i-1],n[i]);
				}
		}
		printf("%d\n",0-parent[find(0)]);
		free(parent);
		}

}
void union1(int i , int j )
{
		i=find(i);
		j=find(j);
		if(i==j)
				return;
		int temp = parent[i]+parent[j];
//		printf("%d %d\n" ,parent[i],parent[j]);
		if(parent[i]>parent[j]){
				parent[i]=j;
				parent[j]=temp;
			//	printf("Root:%d ,",j);
		}
		else {
				parent[j]=i;
				parent[i]=temp;
			//	printf("Root:%d ,",i);
		}
     	//temp=0-temp;
		//printf("%d members\n",temp);
}
int find(int i) 
{
	//	int root ,trail ,lead ;
	//	for(root=i;parent[root]>=0;root=parent[root]);
	//	for(trail=i;trail!=root;trail=lead){
	//			lead=parent[trail];
	//			parent[trail]=root;
	//			total++;
	//	}
	//	return root ;
	for(;parent[i]>=0;i=parent[i]);
	return i;




}
