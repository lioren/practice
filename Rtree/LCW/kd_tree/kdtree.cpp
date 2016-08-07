#include <stdio.h>
#include <string.h>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
struct Node {
		Node *l, *r;
		int idx;
};
int pt[100005][5];
int L[5];
int N, K;
int A[100005];
Node buf[100005];
int bufsize;
int sortIdx;
int dis;
bool cmp(int a, int b) {
		return pt[a][sortIdx] < pt[b][sortIdx];
}
Node* kdTreebuild(int k, int l, int r) {
		if(l > r)
				return NULL;
		sortIdx = k;
		sort(A+l, A+r+1, cmp);
		int m = (l + r)/2;
		Node *ret = &buf[bufsize++];
		ret->idx = A[m]; 
		if(l != r) {
				ret->l = kdTreebuild((k+1)%K, l, m-1);
				ret->r = kdTreebuild((k+1)%K, m+1, r);
		} else {
				ret->l = ret->r = NULL;
		}
		return ret;
}
int max_dist = 0x3f3f3f3f;
int dist(int idx) {
		if((pt[idx][0]==L[0])&&(pt[idx][1]==L[1]))
				return 0x3f3f3f3f;
		int ret = 0;
		for(int i = 0; i < K; i++)
				ret += (pt[idx][i] - L[i]) * (pt[idx][i] - L[i]);
		return ret;
}
int h_function(int h[]) {
		int ret = 0;
		for(int i = 0; i < K; i++)
				ret += h[i];
		return ret;
}
void Find(Node *nd, int k, int h[]) {
		if(nd == NULL || h_function(h) >= dis*dis)
				return;
		int d = dist(nd->idx);

		if(d<=(dis*dis)){
				printf("%d  %d\n",pt[nd->idx][0],pt[nd->idx][1]);
		}
		int hk = h[k];
		if(L[k] < pt[nd->idx][k]) {
				if(nd->l != NULL)
						Find(nd->l, (k+1)%K, h);    
				if(nd->r != NULL) {
						h[k] = (pt[nd->idx][k] - L[k])*(pt[nd->idx][k] - L[k]);
						Find(nd->r, (k+1)%K, h);
						h[k] = hk;
				}
		} else {
				if(nd->l != NULL) {
						h[k] = (pt[nd->idx][k] - L[k])*(pt[nd->idx][k] - L[k]);
						Find(nd->l, (k+1)%K, h);
						h[k] = hk;
				}
				if(nd->r != NULL)
						Find(nd->r, (k+1)%K, h);
		}
}
int main(int argc, char* argv[]) {
		K = 2;
		FILE* fptr;
		fptr=fopen(argv[1],"r");
		int i=0, j, k;

		while(EOF!=(fscanf(fptr,"%d%d", &pt[i][0],&pt[i][1]))){
				A[i] = i;
				i++;}


		N=i;
		Node *root = kdTreebuild(0, 0, N-1);
		int sx,sy;
		printf("Insert point\n");
		scanf("%d%d",&sx,&sy);
		printf("Insert distance\n");
		scanf("%d",&dis);
		L[0]=sx;
		L[1]=sy;
		int h[5] = {};
		printf("Hit point:\n");
		Find(root, 0, h);

		return 0;
}

