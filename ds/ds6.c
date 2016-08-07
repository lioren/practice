#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define IN 1999999
typedef struct queue
{
		int r,f;
		int data[100];
}q;
typedef struct list
{
		int ver1;
		int ver2;
		int wei;
		struct list *next;
}node;
//bfs  dfs
int qempty(q*p);
void addq(q*p,int c);
int delq(q*p);
int adj(int i);
void bfs(int,int );
void dfs(int,int );
int G[100][100];
int n =0;
//bfs  dfs

// kru
int k=0;
void unionset(int a,int b,int ve);
int mstree[200];
int findset(int);
int xx=IN;
int edge1,edge2;
int tedge=0;
int edges[100][100];
int set[100];
int wt[100][100];
int edge[100][3];
void findmin(int );
void makeset(int);
node* insert(node* head ,node*new);
node* creat(node* head,int e);
void kur(node* head,int ve);
// kru

//dij
int cost[100][100];
int dij(int source,int ve,int target);
//dij
int visited[100];
main()
{             
		int a,i,j,z=0,v ;
		int ve=0,e=0,buf[500];
		char c;
		FILE *fp;
		char s[20];
		char fname[20];
		char *ptr;
		node* new;
		node* head;
		while(1){
				for(i=0;i<100;i++)
						visited[i]=0;
				scanf("%c",&c);
				if(c=='N'){
						scanf("%s",fname);
						fp=fopen(fname,"r");
						while(fgets(s,20,fp)!=NULL){
								ptr=strtok(s," ");
								while(ptr!=NULL){
										a=atoi(ptr);
										if(ve==0)
												ve=a;
										else if(e==0)
												e=a;
										buf[z]= a;
										z++;
										ptr=strtok(NULL," ");
								}


						}
						z=2;
						for(i=0;i<ve;i++)
								for(j=0;j<e;j++)
										G[i][j]=0;
						for(v=0;v<e;v++){
								G[buf[z]][buf[z+1]]=G[buf[z+1]][buf[z]]=1;
								z=z+3;
						}

						z=2;

						for(i=0;i<e;i++){
								for(j=0;j<3;j++){
										edge[i][j]=buf[z];
										z++;
								}
						}
				}
				else if(c=='B'){
						scanf("%d",&i);
						bfs(i,ve);
				}
				else if(c=='D'){
						scanf("%d",&i);
						dfs(i,ve);
						printf("\n");
				}
		/*		else if(c=='K'){
						printf("1");
						for(i=0;i<ve;i++){
								for(j=0;j<ve;j++){
								visited[i]=0;
								wt[i][j]=0;
								}
						}
						node* head2;
						head2=creat(head2,e);
//						kur(head2,ve);
								while(head!=NULL){
										wt[head2->ver1][head2->ver2]=head2->wei;
									    wt[head2->ver2][head2->ver1]=head2->wei;
										head2=head2->next;
								}
								for(i=0;i<ve;i++)
										for(j=0;j<ve;j++){
												if(wt[i][j]==0){
														edges[i][j]=0;
														edges[j][i]=0;
												}
												if(wt[i][j]!=0){
														edges[i][i]=1;
														edges[j][i]=1;
														tedge=tedge+2;
												}
										}
									printf("2");
						makeset(ve);
						            printf("3");
						for(i=0;i<=tedge;i++){
								findmin(ve);
								if(findset(edge1)!=findset(edge2)){
										mstree[k++] = edge1;
										mstree[k++] = edge2;
										edges[edge1][edge2] = 0;
										unionset(edge1,edge2,ve);
								}
						}
						k=0;
						for(i=0;i<ve;i++){
								printf("%d %d\n",mstree[k],mstree[k+1]);
 								k=k+2;
						}
				}*/
				else if(c=='S'){
						for(i=0;i<ve;i++){
								for(j=0;j<ve;j++){
								visited[i]=0;
								cost[i][j]=IN;
								}
						}
						node* head;
						int co;
						int source,x,y;
						head=creat(head,e);
						while(head!=NULL){
								cost[head->ver1][head->ver2]=head->wei;
								cost[head->ver2][head->ver1]=head->wei;
								head=head->next;
						}
						scanf("%d",&source);
						for(i=0;i<ve;i++){
						   dij(source,ve,i);
						}

				}

		}

}
void dfs(int v, int ve)
{
		int j;
		printf("%d ",v);
		visited[v]=1;
		for(j=0;j<ve;j++)
				if(!visited[j]&&G[v][j]==1)
						dfs(j,ve);
}
void bfs(int v ,int ve)
{
		int i ,j,count=1,temp=1,x,cou=1,cou2=1,max=0;
		int visited[100];
		int bus[100];
		int g[100][100];
		for(i=0;i<ve;i++){
				for(j=0;j<ve;j++){
						g[i][j]=0;
						bus[i]=0;
				}
		}
		q Q;
		Q.r=Q.f=-1;
		for(i=0;i<ve;i++)
				visited[i]=0;
		addq(&Q,v);
		visited[v]=1;
		while(!qempty(&Q))
		{
				v=delq(&Q);
				for(i=0;i<ve;i++){
						if(visited[i]==0&&G[v][i]!=0)
						{
								if(cou==1)
										g[v][i]=1;
								for(j=0;j<ve;j++){
										if(v==bus[j]){
												for(x=0;x<ve;x++){
														if(g[x][v]!=0){
																g[v][i]=g[x][v]+1;
																if(g[v][i]>max)
																		max=g[v][i];}
												}
										}
								}
								addq(&Q,i);
								visited[i]=1;
								//	printf("%d ",i);
								bus[i]=i;
						}		
				}
				cou--;

		}
		for(i=1;i<max+1;i++){
				printf("d=%d:",i);
				for(j=0;j<ve;j++){
						for(x=0;x<ve;x++){
								if(g[j][x]==i)
										printf(" %d",x);
						}
				}
				printf("\n");
		}


}
void addq(q*p,int x)
{
		if(p->r==-1){
				p->r=p->f=0;
				p->data[p->r]=x;
		}
		else{
				p->r=p->r+1;
				p->data[p->r]=x;

		}

}
int delq(q*p)
{
		int x;
		x=p->data[p->f];
		if(p->r==p->f)
		{
				p->r=-1;
				p->f=-1;
		}
		else
				p->f=p->f+1;
		return(x);
}
int qempty(q *p)
{
		if(p->r==-1)
				return 1;
		return 0;
}
void kur(node* head,int ve)
{
		node* pointer;
		int edgenum=0;
		int weight=0;
		pointer=head;

		while(edgenum!=(ve-1)){
				if(visited[pointer->ver1]==0||visited[pointer->ver2]==0){
						//printf("%d %d %d\n",pointer->ver1,pointer->ver2,pointer->wei);
						weight+=pointer->wei;
						edgenum++;
						visited[pointer->ver1]=1;
						visited[pointer->ver2]=1;
				}
				


				pointer=pointer->next;
				if(pointer==NULL){
						break;
				}
		}

			printf("%d\n",weight);
}
node* insert(node* head ,node *new)
{
		node* pointer;
		node* oldnode;
		pointer=head;
		while(1){
				if(new->wei<=head->wei){
						new->next=head;
						head=new;
						break;
				}
				while((pointer!=NULL)&&(new->wei>=pointer->wei)){
						oldnode=pointer;
						pointer=pointer->next;
				}
				if(pointer!=NULL){
						new->next=pointer;
						oldnode->next=new;
						break;
				}
				else{
						oldnode->next=new;
						break;
				}
				pointer=pointer->next;
		}
		return head;
}
node* creat(node* head,int e)
{
		node* new;
		int i ;
		head=(node*)malloc(sizeof(node));
		head->ver1=edge[0][0];
		head->ver2=edge[0][1];
		head->wei=edge[0][2];
		head->next=NULL;
		for(i=1;i<e;i++){
				new=(node*)malloc(sizeof(node));
				if(new!=NULL){
						new->ver1=edge[i][0];
						new->ver2=edge[i][1];
						new->wei=edge[i][2];
						new->next=NULL;
						head=insert(head,new);
						//printf("%d %d %d\n",edge[i][0],edge[i][1],edge[i][2]);
				}
		}
		return head;
}
int dij(int source,int ve,int target)
{
		int dist[ve],prev[ve],selected[ve],i,m,min,start,d,j;
				char path[ve];
		for(i=0;i<ve;i++)
				selected[i]=0;
		for(i=0;i< ve;i++)
		{
				dist[i] =IN ;
				prev[i] = -1;
		}
		start = source;
		selected[start]=1;
		dist[start] = 0;
		while(selected[target] ==0)
		{
				min = IN;
				m = 0;
				for(i=0;i< ve;i++)
				{
						d = dist[start] +cost[start][i];
						if(d< dist[i]&&selected[i]==0)
						{
								dist[i] = d;
								prev[i] = start;
						}
						if(min>dist[i] && selected[i]==0)
						{
								min = dist[i];
								m = i;
						}
				}
				start = m;
				selected[start] = 1;
		}
		printf("%d: %d\n",target,dist[target]);
}
void makeset(int n)
{
		int i;
		for(i=0;i<n;i++){
				set[i]=i;
		}
}
void findmin(int ve )
{
		int i,j;
		for(i=0;i<ve;i++){
				for(j=0;j<ve;j++){
						if(edges[i][j]==1){
								if(wt[i][j]<=xx)
								{
										xx=wt[i][j];
										edge1=i;
										edge2=j;
								}
						}
				}
		}
        edges[edge1][edge2]=0;
        xx=IN;
 
}
int findset(int a)
{
		return set[a];
}
void unionset(int a,int b,int ve)
{
		int z;
		int temp;
		temp = set[b];
		set[b] = set[a];
		for(z = 0;z<ve;z++)
		{
				if(set[z] == temp)
				{
						set[z] = set[a];
				}
		}
}
