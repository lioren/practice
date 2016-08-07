#include<stdio.h>
#include<stdlib.h>
void union1(int  , int );
int find(int  );
int *parent; 
int total;
main()
{
		int a,b,i,x,y,z;
		char c;
		char s[10];
		scanf("%d%d",&a,&b);
		parent=(int*)malloc(a*sizeof(int));
		for(i=0;i<a;i++){
				parent[i]= -1 ;
		}
		while(b>0){
				scanf("%c",&c);
				if(c=='U'){
						b--;
						scanf("%d%d",&x,&y);
						union1(x,y);
				}
				else if(c=='F'){
						b--;
						scanf("%d",&z);
						printf("Representor:%d\n",find(z));
				}
				else if(c==' '||c=='\n'){
						continue;
				}
				else 
				    continue;

		}
		printf("%d\n",total);
		
}
void union1(int i , int j )
{
		i=find(i);
		j=find(j);
		if(i==j)
				return ;
		int temp = parent[i]+parent[j];
		if(parent[i]>parent[j]){
				parent[i]=j;
				parent[j]=temp;
				printf("Root:%d ,",j);
		}
		else {
				parent[j]=i;
				parent[i]=temp;
				printf("Root:%d ,",i);
		}
     	temp=0-temp;
		printf("%d members\n",temp);
}
int find(int i) 
{
		int root ,trail ,lead ;
		for(root=i;parent[root]>=0;root=parent[root]);
		for(trail=i;trail!=root;trail=lead){
				lead=parent[trail];
				parent[trail]=root;
				total++;
		}
		return root ;
}
