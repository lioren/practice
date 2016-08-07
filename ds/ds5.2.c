#include<stdio.h>
#include<stdlib.h>
typedef struct avl_node {
		int data;
		struct avl_node *left;
		struct avl_node *right;
}ads;
int n=1;
int find_height(ads *node);
int get_diff(ads *node);
int find(ads *root ,int key);
void inorder(ads *root);
void preorder(ads *root);
ads* mini(ads *root);
ads* insert(ads *root,int val);
ads* delete(ads *root,int val);
ads* right_right_rotation(ads *parent);
ads* right_left_rotation(ads *parent);
ads* left_left_rotation(ads *parent);
ads* left_right_rotation(ads *parent);
ads* balancing(ads *node);
main()
{
		ads* root = NULL;
		char a;
		int b;
		while(1){
		scanf("%c",&a);
		switch(a){
				case 'I':
				         scanf("%d",&b);
				         printf("insert %d\n",b);
				         root=insert(root,b);
				         break;
				case 'P':
				         printf("P-order: ");
				         preorder(root);
				         printf("\n");
				         printf("I-order: ");
				         inorder(root);
				         printf("\n");
				         break;
				case 'S':
				         n=1;
				         scanf("%d",&b);
				         printf("search %d:",b);
				         find(root,b);
                         break;		 
				case 'D':
				         scanf("%d",&b);
				         printf("delete %d",b);
				         root=delete(root,b);
				         root=balancing(root);
				         printf("\n");
				         break;
				case 'E':
				         return 0;
				         
		}
		}



}
ads* mini(ads* root )
{
	ads* curr=root;
	while(curr->left!=NULL)
			curr=curr->left;
			return curr;

}
int find(ads *root ,int key)
{       
		if(root==NULL){
				printf("Not-found\n");
				return  ;				
		}
		if(key==root->data){
		        printf("found, serach times:%d\n",n);
				return ;
		}
		else if(key < root->data){
				n++;
				find(root->left,key);}
		else if(key > root->data){
                n++;
				find(root->right,key);}

}
ads* insert(ads *root,int val)
{
		if (root==NULL) {
				root = (ads*) malloc(sizeof(ads));
				root -> data = val;
				root -> left = NULL;
				root -> right = NULL;
				return root;
		}
		else if (val < root->data) {
				root->left = insert(root->left, val);
				root=balancing(root);
		}
		else if (val > root->data) {
				root->right = insert(root->right, val);
				root=balancing(root);
		}
		return root;
}
ads* delete(ads *root,int val)
{
		if(root==NULL){
				printf(":Not-found");
				return root;
		}
		else if(val>root->data)
				root->right=delete(root->right,val);
		else if(val<root->data)
				root->left=delete(root->left,val);
		else{
				if(root->left==NULL&&root->right!=NULL){
						ads* temp = root->right;
						*root=*temp;
						free(temp);
				}
				else if(root->left!=NULL&&root->right==NULL){
						ads* temp = root->left;
						*root=*temp;
						free(temp);
				}
				else if(root->left==NULL&&root->right==NULL){
						ads* temp=root;
						root =NULL;
				}
				else if(root->left!=NULL&&root->right!=NULL){
						ads* temp = mini(root->right);
						root->data=temp->data;
						root->right=delete(root->right,temp->data);

				}
		}
		return root;
}
int get_diff(ads *node)
{
		int left_height=find_height(node -> left);
		int right_height=find_height(node -> right);
		int b_factor= left_height - right_height;
		return b_factor;
}  
ads* right_right_rotation(ads *parent)
{
		ads *node1;
		node1=parent ->right;
		parent->right = node1 -> left;
		node1 -> left= parent;
		return node1;
}
ads* right_left_rotation(ads *parent)
{
		ads *node1;
		node1=parent -> right;
		parent->right = left_left_rotation(node1);
		return right_right_rotation(parent);
}
ads* left_left_rotation(ads *parent)
{
		ads *node1;
		node1 = parent -> left;
		parent -> left = node1 -> right;
		node1 -> right = parent;
		return node1;
}
ads* left_right_rotation(ads *parent)
{
		ads *node1;
		node1= parent -> left;
		parent-> left = right_right_rotation(node1);
		return left_left_rotation(parent);
}
ads* balancing(ads *node)
{
		int b_f= get_diff(node);
		if (b_f >1) {
				if (get_diff(node->left) >0)
						node=left_left_rotation(node);
				else
						node=left_right_rotation(node);
		}
		else if(b_f < -1) {
				if(get_diff(node ->right) >0)
						node=right_left_rotation(node);
				else
						node=right_right_rotation(node);
		}
		return node;
} 
int find_height(ads *node)
{
		int height=0;
		if (node !=NULL){
				int left_height= find_height(node ->left);
				int right_height= find_height(node -> right);
				int max=(left_height > right_height) ? left_height : right_height;
				height = 1+ max;
		}
		return height;
}
void inorder(ads *root)
{
		if(root!=NULL){
				inorder(root->left);
				printf("%d ",root->data);
				inorder(root->right);
		}
}
void preorder(ads *root)
{
		if(root!=NULL){
				printf("%d ",root->data);
				preorder(root->left);
				preorder(root->right);
		}

}
