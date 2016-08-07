#include <stdio.h>
#include "RTree.h"

struct Rect
{
  Rect()  {}

  Rect(int a_minX, int a_minY, int a_maxX, int a_maxY)
  {
    min[0] = a_minX;
    min[1] = a_minY;

    max[0] = a_maxX;
    max[1] = a_maxY;
  }


  int min[2];
  int max[2];
};

int  main(int argc, char* argv[])
{
  RTree<int, int, 2, float> tree;

  int i=0;
  FILE* fptr;
  fptr=fopen(argv[1],"r");
  int x,y;		
  while(EOF!=(fscanf(fptr,"%d%d",&x,&y)))
  {
  	Rect tmp;
  	tmp.min[0]=x;
  	tmp.max[0]=x;
  	tmp.min[1]=y;
  	tmp.max[1]=y;
    tree.Insert(tmp.min, tmp.max, i); 
    i++;
  }
  RTree<int, int, 2, float>::Iterator it;
  for( tree.GetFirst(it); 
       !tree.IsNull(it);
       tree.GetNext(it) )
  {
  }
   tree.Find();


}
