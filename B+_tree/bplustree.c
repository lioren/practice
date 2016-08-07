#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
int order=1;

typedef struct node{
		void** pointers;
		int* keys;
		struct node* parent;
		bool is_leaf;
		int num_keys;
		struct node* next;
}node;
typedef struct record{
		int value;
}record;
void findprint(node* ,int);
void destroy_tree_nodes(node* );
void* printree(node* );
node* destroy_tree(node* );
node* insert(node* root,int key);
node* start_new_tree(int key,record* pointer);
node* make_leaf(void);
node* make_node(void);
node * find_leaf( node * root, int key);
record* make_record(int key);
record* find( node * root, int key);
node * insert_into_leaf( node * leaf, int key, record * pointer );
node * insert_into_leaf_after_splitting(node * root, node * leaf, int key, record * pointer);
node * insert_into_parent(node * root, node * left, int key, node * right);
node * insert_into_new_root(node * left, int key, node * right);
node * insert_into_node(node * root, node * parent, 
				int left_index, int key, node * right);
node * insert_into_node_after_splitting(node * root, node * parent, int left_index, 
				int key, node * right);
node * delete( node * root, int key );
node * delete_entry( node * root, node * n, int key, void * pointer );
node * remove_entry_from_node(node * n, int key, node * pointer);
node * adjust_root(node * root);
node * coalesce_nodes(node * root, node * n, node * neighbor, int neighbor_index, int k_prime);
node * redistribute_nodes(node * root, node * n, node * neighbor, int neighbor_index, 
				int k_prime_index, int k_prime);
int get_neighbor_index( node * n );
int get_left_index(node * parent, node * left);
int cut( int length );
int height( node * root );
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
					//	printf("123");
						if(root) root=destroy_tree(root);
						printf("Please insert an integer to be the order:");
						scanf("%d",&order);
						printf("\n");
						printf("Please insert the input file name:");
						char inputfile[20];
						scanf("%s",&inputfile);
						//printf("%d\n%s",order,inputfile);
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
					case '7':
							 test = root;
							test= root->pointers[0];
						//	test= test->pointers[1];
							if(test->is_leaf)printf("yes");
							else printf("no");
							printf("%d\n",test->keys[2]);

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

void destroy_tree_nodes(node * root) {
		int i;
		if (root->is_leaf)
				for (i = 0; i < root->num_keys; i++)
						free(root->pointers[i]);
		else
				for (i = 0; i < root->num_keys + 1; i++)
						destroy_tree_nodes(root->pointers[i]);
		free(root->pointers);
		free(root->keys);
		free(root);
}
node* destroy_tree(node * root) {
		destroy_tree_nodes(root);
		return NULL;
}
node* insert(node* root,int key){
			record* pointer;
			node* leaf;
			if(find(root,key)!=NULL){
					printf("\n%d has already existed\n",key); 
					return root;
			}
			pointer=make_record(key);
			if(root==NULL){
					printf("\n%d Successed insert to tree\n",key);
					return  start_new_tree(key,pointer);
			}
			leaf=find_leaf(root,key);
			if(leaf->num_keys<order*2){
					leaf=insert_into_leaf(leaf,key,pointer);
					printf("\n%d Successed insert to tree\n",key);
					return root;
			}
			printf("\n%d Successed insert to tree\n",key);
			return insert_into_leaf_after_splitting(root,leaf,key,pointer);

}
node* start_new_tree(int key,record* pointer){
		node* root=make_leaf();
		root->keys[0]=key;
		root->pointers[0]=pointer;
		root->pointers[order*2] = NULL;
		root->parent = NULL;
		root->num_keys++;
		return root;
}
node * make_leaf( void ) {
		node * leaf = make_node();
		leaf->is_leaf = true;
		return leaf;
}
node * make_node( void ) {
		node * new_node;
		new_node = malloc(sizeof(node));
		new_node->keys = malloc( (order*2) * sizeof(int) );
		new_node->pointers = malloc( (order*2+1) * sizeof(void *) );
		new_node->is_leaf = false;
		new_node->num_keys = 0;
		new_node->parent = NULL;
		new_node->next = NULL;
		return new_node;
}
record * find( node * root, int key) {
		int i = 0;
		node * c = find_leaf( root, key);
		if (c == NULL) return NULL;
		for (i = 0; i < c->num_keys; i++)
				if (c->keys[i] == key) break;
		if (i == c->num_keys) 
				return NULL;
		else
				return (record *)c->pointers[i];
}
node* find_leaf( node * root, int key) {
		int i = 0;
		node * c = root;
		if (c == NULL) {
				return c;
		}
		while (!c->is_leaf) {
				i = 0;
				while (i < c->num_keys) {
						if (key >= c->keys[i]) i++;
						else break;
				}
				c = (node *)c->pointers[i];
		}
		return c;
}
node* insert_into_leaf( node * leaf, int key, record * pointer ) {

		int i, insertion_point;

		insertion_point = 0;
		while (insertion_point<leaf->num_keys && leaf->keys[insertion_point] < key)
				insertion_point++;

		for (i = leaf->num_keys; i > insertion_point; i--) {
				leaf->keys[i] = leaf->keys[i - 1];
				leaf->pointers[i] = leaf->pointers[i - 1];
		}
		leaf->keys[insertion_point] = key;
		leaf->pointers[insertion_point] = pointer;
		leaf->num_keys++;
		return leaf;
}
node * insert_into_leaf_after_splitting(node * root, node * leaf, int key, record * pointer) {

		node * new_leaf;
		int * temp_keys;
		void ** temp_pointers;
		int insertion_index, split, new_key, i, j;
		new_leaf = make_leaf();
		temp_keys = malloc( (order*2+1) * sizeof(int) );
		temp_pointers = malloc( (order*2+1) * sizeof(void *) );

		insertion_index = 0;
		while (insertion_index < order*2 && leaf->keys[insertion_index] < key)
				insertion_index++;
		for (i = 0, j = 0; i < leaf->num_keys; i++, j++) {
				if (j == insertion_index) j++;
				temp_keys[j] = leaf->keys[i];
				temp_pointers[j] = leaf->pointers[i];
		}
		temp_keys[insertion_index] = key;
		temp_pointers[insertion_index] = pointer;
		leaf->num_keys = 0;
		split = cut(order*2);
		for (i = 0; i < split; i++) {
				leaf->pointers[i] = temp_pointers[i];
				leaf->keys[i] = temp_keys[i];
				leaf->num_keys++;
		}
		for (i = split, j = 0; i < order*2+1; i++, j++) {
				new_leaf->pointers[j] = temp_pointers[i];
				new_leaf->keys[j] = temp_keys[i];
				new_leaf->num_keys++;
		}
		free(temp_pointers);
		free(temp_keys);
		new_leaf->pointers[order*2] = leaf->pointers[order*2];
		leaf->pointers[order*2] = new_leaf;
		new_leaf->parent = leaf->parent;
		new_key = new_leaf->keys[0];
		 
		for (i = leaf->num_keys; i < order*2; i++){
				leaf->pointers[i+1] = NULL;
				leaf->keys[i] = 0;
		}
		for (i = new_leaf->num_keys; i < order*2; i++){
				new_leaf->pointers[i+1] = NULL;
				new_leaf->pointers[i] = 0;
		}
//		for (i=0;i<order*2+1;i++){
//				leaf->pointers[i]=NULL;
//				new_leaf->pointers[i]=NULL;
//		}
		return insert_into_parent(root, leaf, new_key, new_leaf);
}
node * insert_into_parent(node * root, node * left, int key, node * right) {
		int left_index;
		node * parent;
		parent = left->parent;
		if (parent == NULL){
				return insert_into_new_root(left, key, right);}
		left_index = get_left_index(parent, left);
		if (parent->num_keys < order*2)
				return insert_into_node(root, parent, left_index, key, right);
		return insert_into_node_after_splitting(root, parent, left_index, key, right);
}
node * insert_into_new_root(node * left, int key, node * right) {

		node * root = make_node();
		root->keys[0] = key;
		root->pointers[0] = left;
		root->pointers[1] = right;
		root->num_keys++;
		root->parent = NULL;
		left->parent = root;
		right->parent = root;
		return root;
}
int get_left_index(node * parent, node * left) {

		int left_index = 0;
		while (left_index <= parent->num_keys && 
						parent->pointers[left_index] != left)
				left_index++;
		return left_index;
}
node * insert_into_node(node * root, node * n, 
				int left_index, int key, node * right) {
		int i;

		for (i = n->num_keys; i > left_index; i--) {
				n->pointers[i + 1] = n->pointers[i];
				n->keys[i] = n->keys[i - 1];
		}
		n->pointers[left_index + 1] = right;
		n->keys[left_index] = key;
		n->num_keys++;
		return root;
}
node * insert_into_node_after_splitting(node * root, node * old_node, int left_index, 
				int key, node * right) {

		int i, j, split, k_prime;
		node * new_node, * child;
		int * temp_keys;
		node ** temp_pointers;
		temp_pointers = malloc( (order*2+1 ) * sizeof(node *) );
		temp_keys = malloc( (order*2+1) * sizeof(int) );
		for (i = 0, j = 0; i < old_node->num_keys + 1; i++, j++) {
				if (j == left_index + 1) j++;
				temp_pointers[j] = old_node->pointers[i];
		}
		for (i = 0, j = 0; i < old_node->num_keys; i++, j++) {
				if (j == left_index) j++;
				temp_keys[j] = old_node->keys[i];
		}
		temp_pointers[left_index + 1] = right;
		temp_keys[left_index] = key; 
		split = cut(order*2);
		new_node = make_node();
		old_node->num_keys = 0;
		for (i = 0; i < split ; i++) {
				old_node->pointers[i] = temp_pointers[i];
				old_node->keys[i] = temp_keys[i];
				old_node->num_keys++;
		}
		printf("\n");
		old_node->pointers[i] = temp_pointers[i];
		k_prime = temp_keys[split ];
		for (++i, j = 0; i < order*2+1; i++, j++) {
				new_node->pointers[j] = temp_pointers[i];
				new_node->keys[j] = temp_keys[i];
				new_node->num_keys++;
		}
		new_node->pointers[j] = temp_pointers[i];
		free(temp_pointers);
		free(temp_keys);
		new_node->parent = old_node->parent;
		for (i = 0; i <= new_node->num_keys; i++) {
				child = new_node->pointers[i];
				child->parent = new_node;
		}
		for (i = old_node->num_keys; i < order*2; i++){
				old_node->pointers[i+1] = NULL;
				old_node->keys[i] = 0;
		}
		for (i = new_node->num_keys; i < order*2; i++){
				new_node->pointers[i+1] = NULL;
				new_node->keys[i] = 0;
		}


		return insert_into_parent(root, old_node, k_prime, new_node);
}
int cut( int length ) {
		if (length % 2 == 0)
				return length/2;
		else
				return length/2 + 1;
}
record * make_record(int value) {
		record * new_record = (record *)malloc(sizeof(record));
		if (new_record == NULL) {
				perror("Record creation.");
				exit(EXIT_FAILURE);
		}
		else {
				new_record->value = value;
		}
		return new_record;
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
						//printf("%d\n",height(n));
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
					//		if(n->pointers[i]!=NULL){
									printf("\n");
									printree(n->pointers[i]);
					//		}
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
node * delete(node * root, int key) {

		node * key_leaf;
		record * key_record;

		key_record = find(root, key);
		key_leaf = find_leaf(root, key);
		if (key_record != NULL && key_leaf != NULL) {
				root = delete_entry(root, key_leaf, key, key_record);
				free(key_record);
				printf("\nSuccess delete the integer\n");
		}
		else printf("\nThis integer is not in the tree\n");
		return root;
}
node * delete_entry( node * root, node * n, int key, void * pointer ) {

		int min_keys;
		node * neighbor;
		int neighbor_index;
		int k_prime_index, k_prime;
		int capacity;
		n = remove_entry_from_node(n, key, pointer);
		if (n == root) 
				return adjust_root(root);
		min_keys = n->is_leaf ? cut(order*2) : cut(order*2+1) - 1;
		if (n->num_keys >= min_keys)
				return root;
		neighbor_index = get_neighbor_index( n );
		k_prime_index = neighbor_index == -1 ? 0 : neighbor_index;
		k_prime = n->parent->keys[k_prime_index];
		neighbor = neighbor_index == -1 ? n->parent->pointers[1] : 
				n->parent->pointers[neighbor_index];
		capacity = n->is_leaf ? order*2+1 : order*2;
		if (neighbor->num_keys + n->num_keys < capacity)
				return coalesce_nodes(root, n, neighbor, neighbor_index, k_prime);
		else
				return redistribute_nodes(root, n, neighbor, neighbor_index, k_prime_index, k_prime);
}
node * remove_entry_from_node(node * n, int key, node * pointer) {

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
node * adjust_root(node * root) {

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
int get_neighbor_index( node * n ) {

		int i;

		for (i = 0; i <= n->parent->num_keys; i++)
				if (n->parent->pointers[i] == n)
						return i - 1;
}
node * coalesce_nodes(node * root, node * n, node * neighbor, int neighbor_index, int k_prime) {

		int i, j, neighbor_insertion_index, n_end;
		node * tmp;
		if (neighbor_index == -1) {
				tmp = n;
				n = neighbor;
				neighbor = tmp;
		}

		neighbor_insertion_index = neighbor->num_keys;
		if (!n->is_leaf) {
				neighbor->keys[neighbor_insertion_index] = k_prime;
				neighbor->num_keys++;


				n_end = n->num_keys;

				for (i = neighbor_insertion_index + 1, j = 0; j < n_end; i++, j++) {
						neighbor->keys[i] = n->keys[j];
						neighbor->pointers[i] = n->pointers[j];
						neighbor->num_keys++;
						n->num_keys--;
				}
				neighbor->pointers[i] = n->pointers[j];
				for (i = 0; i < neighbor->num_keys + 1; i++) {
						tmp = (node *)neighbor->pointers[i];
						tmp->parent = neighbor;
				}
		}
		else {
				for (i = neighbor_insertion_index, j = 0; j < n->num_keys; i++, j++) {
						neighbor->keys[i] = n->keys[j];
						neighbor->pointers[i] = n->pointers[j];
						neighbor->num_keys++;
				}
				neighbor->pointers[order*2] = n->pointers[order*2];
		}

		root = delete_entry(root, n->parent, k_prime, n);
		free(n->keys);
		free(n->pointers);
		free(n); 
		return root;
}
node * redistribute_nodes(node * root, node * n, node * neighbor, int neighbor_index, 
				int k_prime_index, int k_prime) {  

		int i;
		node * tmp;
		if (neighbor_index != -1) {
				if (!n->is_leaf)
						n->pointers[n->num_keys + 1] = n->pointers[n->num_keys];
				for (i = n->num_keys; i > 0; i--) {
						n->keys[i] = n->keys[i - 1];
						n->pointers[i] = n->pointers[i - 1];
				}
				if (!n->is_leaf) {
						n->pointers[0] = neighbor->pointers[neighbor->num_keys];
						tmp = (node *)n->pointers[0];
						tmp->parent = n;
						neighbor->pointers[neighbor->num_keys] = NULL;
						n->keys[0] = k_prime;
						n->parent->keys[k_prime_index] = neighbor->keys[neighbor->num_keys - 1];
				}
				else {
						n->pointers[0] = neighbor->pointers[neighbor->num_keys - 1];
						neighbor->pointers[neighbor->num_keys - 1] = NULL;
						n->keys[0] = neighbor->keys[neighbor->num_keys - 1];
						n->parent->keys[k_prime_index] = n->keys[0];
				}
		}

			else {  
				if (n->is_leaf) {
						n->keys[n->num_keys] = neighbor->keys[0];
						n->pointers[n->num_keys] = neighbor->pointers[0];
						n->parent->keys[k_prime_index] = neighbor->keys[1];
				}
				else {
						n->keys[n->num_keys] = k_prime;
						n->pointers[n->num_keys + 1] = neighbor->pointers[0];
						tmp = (node *)n->pointers[n->num_keys + 1];
						tmp->parent = n;
						n->parent->keys[k_prime_index] = neighbor->keys[0];
				}
				for (i = 0; i < neighbor->num_keys - 1; i++) {
						neighbor->keys[i] = neighbor->keys[i + 1];
						neighbor->pointers[i] = neighbor->pointers[i + 1];
				}
				if (!n->is_leaf)
						neighbor->pointers[i] = neighbor->pointers[i + 1];
		}

			n->num_keys++;
		neighbor->num_keys--;

		return root;
}
