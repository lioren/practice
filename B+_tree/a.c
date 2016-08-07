node* insert(node* root,int key){
			record* pointer;
			node* leaf;
			if(find(root,key)!=NULL){
					return root;
			}
			pointer=make_record(key);
			if(root==NULL){
					return  start_new_tree(key,pointer);
			}
			leaf=find_leaf(root,key);
			if(leaf->num_keys<order*2){
					leaf=insert_into_leaf(leaf,key,pointer);
					return root;
			}
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
			//	printf("%d ",i);
				leaf->pointers[i] = temp_pointers[i];
				leaf->keys[i] = temp_keys[i];
			//	printf("%d ",leaf->keys[i]);
				leaf->num_keys++;
		}
	//	printf("\n");
		for (i = split, j = 0; i < order*2+1; i++, j++) {
			//	printf("%d ",i);
				new_leaf->pointers[j] = temp_pointers[i];
				new_leaf->keys[j] = temp_keys[i];
			//	printf("%d ",new_leaf->keys[j]);
				new_leaf->num_keys++;
		}
		free(temp_pointers);
		free(temp_keys);
		new_leaf->pointers[order*2] = leaf->pointers[order*2];
		leaf->pointers[order*2] = new_leaf;
		//printf("\n%d",leaf->num_keys);
		for (i = leaf->num_keys; i < order*2; i++){
				leaf->pointers[i] = NULL;
				leaf->keys[i] = 0;
		}
		for (i = new_leaf->num_keys; i < order*2; i++){
				new_leaf->pointers[i] = NULL;
				new_leaf->pointers[i] = 0;
		}
		new_leaf->parent = leaf->parent;
		new_key = new_leaf->keys[0];
		return insert_into_parent(root, leaf, new_key, new_leaf);
}
node * insert_into_parent(node * root, node * left, int key, node * right) {
		int left_index;
		node * parent;
		parent = left->parent;
		if (parent == NULL){
			//	printf("fuck");
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
	//			printf("%d:",temp_keys[j]);
	//			printf("%d:",old_node->keys[i]);
		}
		//printf("%d%d  ",left_index,key);
		temp_pointers[left_index + 1] = right;
		temp_keys[left_index] = key; 
		split = cut(order*2);
		new_node = make_node();
		old_node->num_keys = 0;
		for (i = 0; i < split ; i++) {
			//	printf("%d",i);
				old_node->pointers[i] = temp_pointers[i];
				old_node->keys[i] = temp_keys[i];
				old_node->num_keys++;

		//		printf("%d ",old_node->keys[i]);
		}
		printf("\n");
		old_node->pointers[i] = temp_pointers[i];
		k_prime = temp_keys[split ];
		for (++i, j = 0; i < order*2+1; i++, j++) {
			//	printf("%d",i);
				new_node->pointers[j] = temp_pointers[i];
				new_node->keys[j] = temp_keys[i];
				new_node->num_keys++;

		//		printf("\n%d ",new_node->keys[j]);
		}
//		for (i = old_node->num_keys; i < order*2; i++){
//				old_node->pointers[i] = NULL;
//				old_node->keys[i] = 0;
//		}
//		for (i = new_node->num_keys; i < order*2; i++){
//				new_node->pointers[i] = NULL;
//				new_node->pointers[i] = 0;
//		}
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

