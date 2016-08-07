#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
int order=2;

typedef struct node{
		void** pointers;
		int* keys;
		struct node* parent;
		bool is_leaf;
		int num_keys;
}node;
typedef struct node2{
		int value;
}node2;
void findprint(node* ,int);
void dtn(node* );
void* printree(node* );
node* dtree(node* );
node* insert(node* ,int);
node* newtree(int ,node2*);
node* mleaf(void);
node* mnode(void);
node * fleaf(node*,int);
node2* mnode2(int);
node2* find(node*,int);
node * ileaf(node*, int,node2*);
node * ileafsp(node*,node*,int,node2*);
node * iparent(node*, node*,int,node* );
node * inroot(node*, int, node* );
node * inode(node*, node*,int , int , node*);
node * inodesp(node*, node*, int,int ,node*);
node * delete( node * root, int  );
node * d_e( node*, node* ,int, void * );
node * remove1 (node *, int, node *);
node * adj(node * root);
node * combine(node*, node*,node*,int,int );
node * redis(node*,node*,node*,int,int,int);
int gni(node*);
int gli(node*, node*);
int cut(int);
int height(node*);
int main(){
		int input;
		node* root=NULL;
		node* test=NULL;
		char cmd;
		printf("\n");
		printf("1:CreatBPTree by insert an order and a file\n");
		printf("2:Insert a search key\n");
		printf("3:Delete a search key\n");
		printf("4:Lookup a search key\n");
		printf("5:Output all tree\n");
		printf("6:Exit the program\n");
		printf("Choose one of the above command:");
		while(scanf("%c",&cmd)!=EOF){
				switch(cmd){
					case '1':
						if(root) root=dtree(root);
						printf("Please insert an integer to be the order:");
						scanf("%d",&order);
						printf("\n");
						printf("Please insert the input file name:");
						char inputfile[20];
						scanf("%s",&inputfile);
						FILE* fp;
						fp=fopen(inputfile,"r");
						if(fp==NULL){
								perror("Wrong to open");
								exit(127);
						}
						while(!feof(fp)){
						int res=fscanf(fp,"%d",&input);
						if(res==-1)break;
						root=insert(root,input);
						}
						printf("The tree was successfully created");
						fclose(fp);
						break;
					case '2':
						printf("Please insert an integer:");
						printf("\n");
						scanf("%d",&input);
						root=insert(root,input);
						break;
					case '3':
						printf("Please insert an integer:");
						printf("\n");
						scanf("%d",&input);
						root=delete(root,input);
						break;
					case '4':
						printf("Please insert an integer:");
						printf("\n");
						scanf("%d",&input);
						findprint(root,input);
						break;
					case '5':
						printree(root);
						break;
					case '6':
						return 0;
				}
		while(getchar()!=(int)'\n');
		printf("\n");
		printf("1:CreatBPTree by insert an order and a file\n");
		printf("2:Insert a search key\n");
		printf("3:Delete a search key\n");
		printf("4:Lookup a search key\n");
		printf("5:Output all tree\n");
		printf("6:Exit the program\n");
		printf("Choose one of the above command:");

		}
}

void dtn(node * root) {
		int i;
		if (root->is_leaf)
				for (i = 0; i < root->num_keys; i++)
						free(root->pointers[i]);
		else
				for (i = 0; i < root->num_keys + 1; i++)
						dtn(root->pointers[i]);
		free(root->pointers);
		free(root->keys);
		free(root);
}
node* dtree(node * root) {
		dtn(root);
		return NULL;
}
node* insert(node* root,int key){
			node2* pointer;
			node* leaf;
			if(find(root,key)!=NULL){
					printf("\n%d has already existed\n",key); 
					return root;
			}
			pointer=mnode2(key);
			if(root==NULL){
					printf("\n%d Successed insert to tree\n",key);
					return  newtree(key,pointer);
			}
			leaf=fleaf(root,key);
			if(leaf->num_keys<order*2){
					leaf=ileaf(leaf,key,pointer);
					printf("\n%d Successed insert to tree\n",key);
					return root;
			}
			printf("\n%d Successed insert to tree\n",key);
			return ileafsp(root,leaf,key,pointer);

}
node* newtree(int key,node2* pointer){
		node* root=mleaf();
		root->keys[0]=key;
		root->pointers[0]=pointer;
		root->pointers[order*2] = NULL;
		root->parent = NULL;
		root->num_keys++;
		return root;
}
node * mleaf(void) {
		node* leaf=mnode();
		leaf->is_leaf=true;
		return leaf;
}
node * mnode(void) {
		node* a;
		a=malloc(sizeof(node));
		a->keys=malloc((order*2)*sizeof(int));
		a->pointers=malloc((order*2+1)*sizeof(void*));
		a->is_leaf=false;
		a->num_keys=0;
		a->parent=NULL;
		return a;
}
node2* find(node* root,int key) {
		int i=0;
		node* a=fleaf(root,key);
		if (a == NULL) return NULL;
		for (i = 0;i<a->num_keys; i++)
				if (a->keys[i]==key) break;
		if (i==a->num_keys) 
				return NULL;
		else
				return (node2*)a->pointers[i];
}
node* fleaf(node* root,int key) {
		int i = 0;
		node* a = root;
		if (a==NULL) {
				return a;
		}
		while (!a->is_leaf) {
				i=0;
				while (i < a->num_keys) {
						if (key >=a->keys[i]) i++;
						else break;
				}
				a=(node *)a->pointers[i];
		}
		return a;
}
node* ileaf(node* leaf,int key,node2* pointer ) {

		int i, ip;
		ip=0;
		while (ip<leaf->num_keys && leaf->keys[ip]<key)
				ip++;

		for (i=leaf->num_keys; i>ip; i--) {
				leaf->keys[i]=leaf->keys[i-1];
				leaf->pointers[i]=leaf->pointers[i-1];
		}
		leaf->keys[ip] = key;
		leaf->pointers[ip] = pointer;
		leaf->num_keys++;
		return leaf;
}
node * ileafsp(node* root,node* leaf,int key,node2* pointer) {

		node * nl;
		int * tk;
		void ** tp;
		int i,j;
		int index, split, nk;
		nl=mleaf();
		tk=malloc( (order*2+1) * sizeof(int) );
		tp=malloc( (order*2+1) * sizeof(void *) );
		index = 0;
		while (index < order*2 && leaf->keys[index] < key)
				index++;
		for (i = 0, j = 0; i < leaf->num_keys; i++, j++) {
				if (j==index) j++;
				tk[j]=leaf->keys[i];
				tp[j]=leaf->pointers[i];
		}
		tk[index] = key;
		tp[index] = pointer;
		leaf->num_keys = 0;
		split = cut(order*2);
		for (i = 0; i < split; i++) {
				leaf->pointers[i] = tp[i];
				leaf->keys[i]=tk[i];
				leaf->num_keys++;
		}
		for (i = split, j = 0; i < order*2+1; i++, j++) {
				nl->pointers[j] = tp[i];
				nl->keys[j] = tk[i];
				nl->num_keys++;
		}
		free(tp);
		free(tk);
		nl->pointers[order*2] = leaf->pointers[order*2];
		leaf->pointers[order*2] = nl;
		nl->parent = leaf->parent;
		nk=nl->keys[0];
		 
		for (i = leaf->num_keys; i < order*2; i++){
				leaf->pointers[i+1] = NULL;
				leaf->keys[i] = 0;
		}
		for (i = nl->num_keys; i < order*2; i++){
				nl->pointers[i+1] = NULL;
				nl->pointers[i] = 0;
		}
		return iparent(root, leaf, nk, nl);
}
node * iparent(node* root,node* left,int key,node* right) {
		int index;
		node * parent;
		parent = left->parent;
		if (parent == NULL){
				return inroot(left,key,right);}
		index = gli(parent,left);
		if (parent->num_keys < order*2)
				return inode(root, parent, index, key, right);
		return inodesp(root, parent, index, key, right);
}
node * inroot(node* left,int key,node* right) {

		node * root = mnode();
		root->keys[0] = key;
		root->pointers[0] = left;
		root->pointers[1] = right;
		root->num_keys++;
		root->parent = NULL;
		left->parent = root;
		right->parent = root;
		return root;
}
int gli(node * parent, node * left) {

		int index = 0;
		while (index <= parent->num_keys && 
						parent->pointers[index] != left)
				index++;
		return index;
}
node * inode(node * root, node * n,int index,int key,node * right) {
		int i;
		for (i = n->num_keys;i>index; i--) {
				n->pointers[i + 1] = n->pointers[i];
				n->keys[i] = n->keys[i - 1];
		}
		n->pointers[index + 1] = right;
		n->keys[index] = key;
		n->num_keys++;
		return root;
}
node * inodesp(node * root, node * old_node, int index,int key, node * right) {

		int i, j, split, k;
		node * new_node, * child;
		int * temp_keys;
		node ** temp_pointers;
		temp_pointers = malloc( (order*2+1 ) * sizeof(node *) );
		temp_keys = malloc( (order*2+1) * sizeof(int) );
		for (i = 0, j = 0; i < old_node->num_keys + 1; i++, j++) {
				if (j==index + 1) j++;
				temp_pointers[j] = old_node->pointers[i];
		}
		for (i = 0, j = 0; i < old_node->num_keys; i++, j++) {
				if (j==index) j++;
				temp_keys[j] = old_node->keys[i];
		}
		temp_pointers[index + 1] = right;
		temp_keys[index] = key; 
		split = cut(order*2);
		new_node = mnode();
		old_node->num_keys = 0;
		for (i = 0; i < split ; i++) {
				old_node->pointers[i] = temp_pointers[i];
				old_node->keys[i] = temp_keys[i];
				old_node->num_keys++;
		}
		printf("\n");
		old_node->pointers[i] = temp_pointers[i];
		k=temp_keys[split ];
		for (++i, j = 0; i < order*2+1; i++, j++) {
				new_node->pointers[j] = temp_pointers[i];
				new_node->keys[j] = temp_keys[i];
				new_node->num_keys++;
		}
		new_node->pointers[j] = temp_pointers[i];
		free(temp_pointers);
		free(temp_keys);
		new_node->parent = old_node->parent;
		for (i=0;i<=new_node->num_keys;i++) {
				child = new_node->pointers[i];
				child->parent = new_node;
		}
		for (i=old_node->num_keys;i<order*2;i++){
				old_node->pointers[i+1] = NULL;
				old_node->keys[i] = 0;
		}
		for (i=new_node->num_keys;i<order*2;i++){
				new_node->pointers[i+1] = NULL;
				new_node->keys[i] = 0;
		}
		return iparent(root, old_node, k, new_node);
}
int cut( int length ) {
		if ((length%2)==0)
				return length/2;
		else
				return length/2+1;
}
node2* mnode2(int value) {
		node2* new_node2 = (node2*)malloc(sizeof(node2));
		new_node2->value = value;
		return new_node2;
}
void* printree(node* root){
		node* n =root;
		int i;
		if(n==NULL){
			printf("\nEmpty tree\n");
			return n;
		}
		else{
				if(!(n->is_leaf)){
						int level=height(n);
						for(i=0;i<level;i++){
								printf("-");
						}
						printf(" (");
						for(i=0;i<order*2;i++){
							if(i!=order*2-1){
								if(n->keys[i]==0){
									printf("_:");
								}
								else 
									printf("%d:",n->keys[i]);
							}
							else{
								if(n->keys[i]==0){
									printf("_");
								}
								else 
									printf("%d",n->keys[i]);
							}
				
						}
						printf(")");
				}
				else {
						int level=height(n);
						for(i=0;i<level;i++){
								printf("-");
						}
						printf(" [");
						for(i=0;i<order*2;i++){
							if(i!=order*2-1){
								if(n->keys[i]==0){
									printf("_,");
								}
								else 
									printf("%d,",n->keys[i]);
							}
							else{
								if(n->keys[i]==0){
									printf("_");
								}
								else 
									printf("%d",n->keys[i]);
							}
				
						}
						printf("]");

				}
			if(!(n->is_leaf)){
					for(i=0;i<n->num_keys+1;i++){
									printf("\n");
									printree(n->pointers[i]);
					}
			}
			
		}
}
int height( node * root ) {
		int h = 1;
		node * c = root;
		while(c->parent!=NULL){
				c=c->parent;
				h++;
		}
		return h;
}
void findprint(node* root,int key){
		int i=0;
		node* tmp=root;
		if(!(tmp->is_leaf)){
			while(tmp->keys[i]<=key){
					i++;
					if(i>=tmp->num_keys)break;
			}
			if(i==0){
					printf("%d < %d\n",key,tmp->keys[0]);
			}
			else 
			printf("%d >= %d\n",key,tmp->keys[i-1]);
		}
		if(!(tmp->is_leaf)){
			findprint(tmp->pointers[i],key);
		}
		else if(tmp->is_leaf){
				i=0;
				while(i< tmp->num_keys){
						if((tmp->keys[i])==key){
								printf("%d found\n",key);
								return;
						}
						i++;
				}
				printf("%d not found\n",key);
				return;
		}
}
node* delete(node * root, int key) {
		node* key_leaf;
		node2* key_node2;
		key_node2=find(root, key);
		key_leaf=fleaf(root, key);
		if (key_node2 != NULL && key_leaf != NULL) {
				root = d_e(root, key_leaf, key, key_node2);
				free(key_node2);
				printf("\nSuccess delete the integer\n");
		}
		else printf("\nThis integer is not in the tree\n");
		return root;
}
node* d_e( node * root, node * n, int key, void * pointer ) {
		int min_keys;
		node * nei;
		int nei_index;
		int a, b;
		int ca;
		n = remove1(n, key, pointer);
		if (n == root) 
				return adj(root);
		min_keys = n->is_leaf ? cut(order*2) : cut(order*2+1) - 1;
		if (n->num_keys >= min_keys)
				return root;
		nei_index = gni( n );
		a= nei_index == -1 ? 0 : nei_index;
		b= n->parent->keys[a];
		nei= nei_index == -1 ? n->parent->pointers[1] : 
				n->parent->pointers[nei_index];
		ca=n->is_leaf ? order*2+1 : order*2;
		if (nei->num_keys + n->num_keys < ca)
				return combine(root,n,nei,nei_index,b);
		else
				return redis(root,n,nei,nei_index,a,b);
}
node * remove1(node * n,int key,node * pointer) {

		int i, num_pointers;

		i = 0;
		while (n->keys[i] != key)
				i++;
		for (++i; i < n->num_keys; i++){
				n->keys[i - 1] = n->keys[i];
				n->keys[i]=0;
		}
		if(i==n->num_keys){
				n->keys[i-1]=0;
		}
		num_pointers = n->is_leaf ? n->num_keys : n->num_keys + 1;
		i = 0;
		while (n->pointers[i] != pointer)
				i++;
		for (++i; i < num_pointers; i++)
				n->pointers[i - 1] = n->pointers[i];
		n->num_keys--;
		if (n->is_leaf)
				for (i = n->num_keys; i < order*2; i++)
						n->pointers[i] = NULL;
		else
				for (i = n->num_keys + 1; i < order*2+1; i++)
						n->pointers[i] = NULL;

		return n;
}
node * adj(node * root) {

		node * new_root;
		if (root->num_keys > 0)
				return root;
		if (!root->is_leaf) {
				new_root = root->pointers[0];
				new_root->parent = NULL;
		}		
		else
				new_root = NULL;
		free(root->keys);
		free(root->pointers);
		free(root);

		return new_root;
}
int gni( node * n ) {

		int i;

		for (i = 0; i <= n->parent->num_keys; i++)
				if (n->parent->pointers[i] == n)
						return i - 1;
}
node* combine(node* root,node* n,node* nei,int nei_index,int k_prime) {

		int i, j, neiin, n_end;
		node * tmp;
		if (nei_index == -1) {
				tmp = n;
				n = nei;
				nei=tmp;
		}
		neiin=nei->num_keys;
		if (!n->is_leaf) {
				nei->keys[neiin] = k_prime;
				nei->num_keys++;


				n_end = n->num_keys;

				for (i = neiin+1,j = 0; j < n_end; i++, j++) {
						nei->keys[i] = n->keys[j];
						nei->pointers[i] = n->pointers[j];
						nei->num_keys++;
						n->num_keys--;
				}
				nei->pointers[i] = n->pointers[j];
				for (i = 0; i < nei->num_keys + 1; i++) {
						tmp = (node *)nei->pointers[i];
						tmp->parent = nei;
				}
		}
		else {
				for (i = neiin,j = 0; j < n->num_keys; i++, j++) {
						nei->keys[i] = n->keys[j];
						nei->pointers[i] = n->pointers[j];
						nei->num_keys++;
				}
				nei->pointers[order*2] = n->pointers[order*2];
		}
		root = d_e(root, n->parent, k_prime, n);
		free(n->keys);
		free(n->pointers);
		free(n); 
		return root;
}
node * redis(node* root,node* n,node* nei,int nei_index, 
				int k_prime_index, int k_prime) {  

		int i;
		node * tmp;
		if (nei_index != -1) {
				if (!n->is_leaf)
						n->pointers[n->num_keys + 1] = n->pointers[n->num_keys];
				for (i = n->num_keys; i > 0; i--) {
						n->keys[i] = n->keys[i - 1];
						n->pointers[i] = n->pointers[i - 1];
				}
				if (!n->is_leaf) {
						n->pointers[0] = nei->pointers[nei->num_keys];
						tmp = (node *)n->pointers[0];
						tmp->parent = n;
						nei->pointers[nei->num_keys] = NULL;
						n->keys[0] = k_prime;
						n->parent->keys[k_prime_index] = nei->keys[nei->num_keys - 1];
				}
				else {
						n->pointers[0] = nei->pointers[nei->num_keys - 1];
						nei->pointers[nei->num_keys - 1] = NULL;
						n->keys[0] = nei->keys[nei->num_keys - 1];
						n->parent->keys[k_prime_index] = n->keys[0];
				}
		}

			else {  
				if (n->is_leaf) {
						n->keys[n->num_keys]=nei->keys[0];
						n->pointers[n->num_keys]=nei->pointers[0];
						n->parent->keys[k_prime_index]=nei->keys[1];
				}
				else {
						n->keys[n->num_keys] = k_prime;
						n->pointers[n->num_keys + 1] = nei->pointers[0];
						tmp = (node *)n->pointers[n->num_keys + 1];
						tmp->parent = n;
						n->parent->keys[k_prime_index] = nei->keys[0];
				}
				for (i = 0; i < nei->num_keys - 1; i++) {
						nei->keys[i]=nei->keys[i + 1];
						nei->pointers[i]=nei->pointers[i + 1];
				}
				if (!n->is_leaf)
						nei->pointers[i]=nei->pointers[i + 1];
		}

			n->num_keys++;
		nei->num_keys--;

		return root;
}
