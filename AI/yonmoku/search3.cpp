#include "search.h"
#include <iostream>
#include <cstdlib>
#include <ctime>
#define INFINITE 9999999

using namespace std;
int alpha_beta(Cell point ,int depth,int alpha,int beta,const char s[][SIZE] ,bool max_min);
int evaluate(Cell point, const char board[][SIZE]);
int check_row(int x, int y, const char board[][SIZE]);
int check_col(int x, int y, const char board[][SIZE]);
int check_dia_ul(int x, int y, const char board[][SIZE]);
int check_dia_ur(int x, int y, const char board[][SIZE]);
bool isempty(const char b[][SIZE]);

/*
   functions for search
 */
void search3(const char b[][SIZE], const Cell& others, Cell& yours)
{
		//b:      board ('x': player1, 'o': player2, ' ': none)
		//others: your opponent's last move
		//yours:  your move <-- MUST determine it in this function!
		/**
		  Write your search strategy below
		 */
		int i,j,x,y,num,s,tmp1,tmp2;
		bool near;
		srand(time(NULL));
		num = -1*INFINITE;
		Cell next;
		Cell child;
		for(i=0;i<SIZE;i++){
				for(j=0;j<SIZE;j++){
						near=false;
						if(b[i][j]!=' ') continue;
						child.x = i;
						child.y = j;
						child.mark = yours.mark;
						for(tmp1=i-1; tmp1<=i+1; ++tmp1){
								for(tmp2=j-1; tmp2<=j+1; ++tmp2){
										if(tmp1<0 || tmp1>=SIZE || tmp2<0 || tmp2>=SIZE)
												continue;
										if(b[tmp1][tmp2] != ' ')
												near = true;
								}
								if(near)	break;
						}
						if(isempty(b)){
								s = INFINITE;
								i = j = SIZE;
								if(SIZE%2==0){
										next.x = (SIZE/2) - rand()%2;
										next.y = (SIZE/2) - rand()%2;
								}
								else{
										next.y = next.x =SIZE/2;
								}
						}
						if(near){
								s = alpha_beta(child,5,-1*INFINITE,INFINITE, b ,true);
								//cout << s << "\t" << i+1 << "," << j+1 << "\t" << child.x << "," << child.y <<endl;
						}
						//cout << num << endl << i << "\t" << j <<endl;
						if(num < s && near){
								num = s;
								next.x = i;
								next.y = j;
								//cout << num << " ~~ " << i+1 << "," << j+1<<endl;
						}
						else if(num == s && near){
								if(rand()%2==0){
										num = s;
										next.x = i;
										next.y = j;
										//cout << num << " !! " << i+1 << "," << j+1<<endl;
								}
						}
				}
		}
		//cout << num <<endl;
		/*
		   cout << " ( " << next.x << " , " << next.y << " ) " << endl;
		   if(b[SIZE/2][SIZE/2]==' ') next.x = next.y = SIZE/2;
		 */
		yours.x = next.x;
		yours.y = next.y;
}

/*
   functions for alpha-beta algorithm for search function.
 */
int alpha_beta(Cell point ,int depth,int alpha,int beta,const char s[][SIZE] ,bool max_min)
{
		char g[SIZE][SIZE];
		int i,j;
		for( i =0 ; i< SIZE ;i++)
				for( j=0; j<SIZE ;j++)
						g[i][j] = s[i][j];
		g[point.x][point.y] = point.mark;
		/*
		   需要判斷下子後的盤面情形 
		 */

		if(depth ==0 ){
				if(!max_min)
						point.mark = (point.mark == 'x')? 'o':'x';
				g[point.x][point.y] = point.mark;
				return evaluate(point,g);
		}


		int x,y;
		Cell child;
		if (max_min){
				for(x = 0;x < SIZE ;x++)
						for(y = 0 ; y < SIZE ; y++){
								if(g[x][y] != ' ') continue;
								if(depth == 1){
										child.x = point.x;
										child.y = point.y;
										x = y = SIZE;
								}
								else{
										child.x = x;
										child.y = y;
								}
								child.mark = (point.mark == 'x')? 'o':'x';
								alpha = max(alpha,alpha_beta(child,depth-1,alpha,beta,g,!max_min));
								if(beta <= alpha) return beta;
						}
				return alpha;
		}
		else{
				for(x = 0;x < SIZE ;x++)
						for(y = 0 ; y < SIZE ; y++){
								if(g[x][y] != ' ') continue;
								if(depth == 1){
										child.x = point.x;
										child.y = point.y;
										x = y = SIZE;
								}
								else{
										child.x = x;
										child.y = y;
								}
								child.mark = (point.mark == 'x')? 'o':'x';
								beta = min(beta,alpha_beta(child,depth-1,alpha,beta,g,!max_min));
								if(beta <= alpha) return alpha;
						}
				return beta;
		}
}


int evaluate(Cell point, const char board[][SIZE])
{
		int i,j,tmp;
		int row=0, col[SIZE]={0}, dia_ul[SIZE][SIZE], dia_ur[SIZE][SIZE];
		int score=0;
		int x=point.x, y=point.y;
		int triple = 0, triple_stk = 0;
		char not_chess;

		for(i=0; i<SIZE; ++i)
				for(j=0; j<SIZE; ++j){
						dia_ul[i][j] = 0;
						dia_ur[i][j] = 0;
				}
		score = min(x,SIZE-1-x) + min(y,SIZE-1-y);
		not_chess = (point.mark == 'x')? 'o':'x';
		for(j=x-1; j<=x+1; ++j)
				for(i=y-1; i<y+1; ++i){
						if(i<0 || i>=SIZE || j<0 || j>=SIZE)
								continue;
						if(board[i][j] == point.mark)
								score += 4;
						else if(board[i][j] == not_chess)
								score += 3;
				}
		//cout << "\t\t\t" << x << "," << y << endl;
		for(i=0; i<SIZE; ++i){
				for(j=0; j<SIZE; ++j){
						if(board[i][j] == ' ')
								continue;
						not_chess = (board[i][j] == 'x')? 'o':'x';
						/*
						   row operation
						 */
						if(row == 0 || row == 10){
								row = check_row(j, i, board);
								if(row == 4 && board[i][j]==point.mark)
										return INFINITE;
								if(row == 3){
										/*
										   we stuck enemy3 with 2 side
										 */
										if(((j-1>=0 && board[i][j-1]==point.mark) || j==0) && ((j+3<SIZE && board[i][j+3]==point.mark) || j+3>=SIZE))
												score += 1300;
										/*
										   we get 3 with no obstacle for each side
										 */
										else if((j-1>=0 && board[i][j-1]==' ') && (j+3<SIZE && board[i][j+3]==' ') && board[i][j]==point.mark){
												score += 700;
												++triple;
										}
										/*
										   we get 3 with obstacle on one of the two sides
										 */
										else if(((j-1>=0 && board[i][j-1]==' ') && (j+3>=SIZE || (board[i][j+3]==not_chess))) || ((j+3<SIZE && board[i][j+3]==' ') && (j==0 || (board[i][j-1]==not_chess)))){
												score += 50;
												++triple_stk;
										}
										//cout<<score<<","<<j<<","<<i<<" row3 "<<row<<endl;
								}
								else if(row == 2){
										/*
										   get 2 with no obstacle for each side
										 */
										if((j-1>=0 && board[i][j-1]==' ') && (j+2<SIZE && board[i][j+2]==' ')){
												if(board[i][j]==point.mark)
														score += 100;
												else{
														score -= 200;
														row += 10;
												}
										}
										/*
										   opponent get 2 with obstacle on one of the two sides
										 */
										else if((((j-1>=0 && board[i][j-1]==' ') && (j+2>=SIZE || (board[i][j+2]==point.mark))) || ((j+2<SIZE && board[i][j+2]==' ') && (j==0 || (board[i][j-1]==point.mark)))) && board[i][j]==not_chess)
												score += 300;
										//cout<<score<<","<<j<<","<<i<<" row2 "<<row<<endl;
								}
								//else if(row == 1){
								/*
								   get 2 chess with no obstacle and 1 blank between
								 */
								/*if((j-1>=0 && board[i][j-1]==' ') && (j+3<SIZE && board[i][j+3]==' ') && (j+2<SIZE && board[i][j+2]==board[i][j]) && (j+1<SIZE && board[i][j+1]==' '))
								  if(board[i][j]==point.mark)
								  score += 100;
								  else{
								  score -= 200;
								  row += 10;
								  }
								  }*/
						}
						/*
						   column operation
						 */
						if(col[j] == 0 || col[j] == 10){
								col[j] = check_col(j, i, board);
								if(col[j] == 4 && board[i][j]==point.mark)
										return INFINITE;
								if(col[j] == 3){
										/*
										   we stuck enemy3 with 2 side
										 */
										if(((i-1>=0 && board[i-1][j]==point.mark) || i==0) && ((i+3<SIZE && board[i+3][j]==point.mark) || i+3>=SIZE))
												score += 1000;
										/*
										   we get 3 with no obstacle for each side
										 */
										else if((i-1>=0 && board[i-1][j]==' ') && (i+3<SIZE && board[i+3][j]==' ') && board[i][j]==point.mark){
												score += 700;
												++triple;
										}
										/*
										   we get 3 with obstacle on one of the two sides
										 */
										else if(((i-1>=0 && board[i-1][j]==' ') && (i+3>=SIZE || (board[i+3][j]==not_chess))) || ((i+3<SIZE && board[i+3][j]==' ') && (i==0 || (board[i-1][j]==not_chess)))){
												score += 50;
												++triple_stk;
										}
										//cout<<score<<","<<j<<","<<i<<" col3 "<<col[j]<<endl;
								}
								else if(col[j] == 2){
										/*
										   get 2 with no obstacle for each side
										 */
										if((i-1>=0 && board[i-1][j]==' ') && (i+2<SIZE && board[i+2][j]==' ')){
												if(board[i][j]==point.mark)
														score += 100;
												else{
														score -= 200;
														col[j] += 10;
												}
										}
										/*
										   opponent get 2 with obstacle on one of the two sides
										 */
										else if((((i-1>=0 && board[i-1][j]==' ') && (i+2>=SIZE || (board[i+2][j]==point.mark))) || ((i+2<SIZE && board[i+2][j]==' ') && (i==0 || (board[i-1][j]==point.mark)))) && board[i][j]==not_chess)
												score += 300;
										//cout<<score<<","<<j<<","<<i<<" col2 "<<col[j]<<endl;
								}
								//else if(col[j] == 1){
								/*
								   get 2 chess with no obstacle and 1 blank between
								 */
								/*if((i-1>=0 && board[i-1][j]==' ') && (i+3<SIZE && board[i+3][j]==' ') && (i+2<SIZE && board[i+2][j]==board[i][j]) && (i+1<SIZE && board[i+1][j]==' '))
								  if(board[i][j]==point.mark)
								  score += 100;
								  else{
								  score -= 200;
								  row += 10;
								  }
								  }*/
						}
						/*
						   dialogue operation from upper left to lower right
						 */
						if(dia_ul[i][j]==0 || dia_ul[i][j]==10){
								dia_ul[i][j] = check_dia_ul(j,i,board);
								if(dia_ul[i][j] == 4 && board[i][j]==point.mark)
										return INFINITE;
								if(dia_ul[i][j] == 3){
										/*
										   we stuck enemy3 with 2 side
										 */
										if(((i-1>=0 && j-1>=0 && board[i-1][j-1]==point.mark) || i==0 || j==0) && ((i+3<SIZE && j+3<SIZE && board[i+3][j+3]==point.mark) || i+3>=SIZE || j+3>=SIZE))
												score += 1000;
										/*
										   we get 3 with no obstacle for each side
										 */
										else if((i-1>=0 && j-1>=0 && board[i-1][j-1]==' ') && (i+3<SIZE && j+3<SIZE && board[i+3][j+3]==' ') && board[i][j]==point.mark){
												score += 700;
												++triple;
										}
										/*
										   we get 3 with obstacle on one of the two sides
										 */
										else if(((i-1>=0 && j-1>=0 && board[i-1][j-1]==' ') && (i+3>=SIZE || j+3>=SIZE || (board[i+3][j+3]==not_chess))) || ((i+3<SIZE && j+3<SIZE && board[i+3][j+3]==' ') && (i==0 || j==0 || (board[i-1][j-1]==not_chess)))){
												score += 50;
												++triple_stk;
										}
										//cout<<score<<","<<j<<","<<i<<" col3"<<endl;
								}
								else if(dia_ul[i][j] == 2){
										/*
										   get 2 with no obstacle for each side
										 */
										if((i-1>=0 && j-1>=0 && board[i-1][j-1]==' ') && (i+2<SIZE && j+2<SIZE && board[i+2][j+2]==' ')){
												if(board[i][j]==point.mark)
														score += 100;
												else{
														score -= 200;
														dia_ul[i][j] += 10;
												}
										}
										/*
										   opponent get 2 with obstacle on one of the two sides
										 */
										else if((((i-1>=0 && j-1>=0 && board[i-1][j-1]==' ') && (i+2>=SIZE || j+2>=SIZE || (board[i+2][j+2]==point.mark))) || ((i+2<SIZE && j+2<SIZE && board[i+2][j+2]==' ') && (i==0 || j==0 || (board[i-1][j-1]==point.mark)))) && board[i][j]==not_chess)
												score += 300;
										//cout<<score<<","<<j<<","<<i<<" col2"<<endl;
								}
								//else if(dia_ul[i][j] == 1){
								/*
								   get 2 chess with no obstacle and 1 blank between
								 */
								/*if((i-1>=0 && j-1>=0 && board[i-1][j-1]==' ') && (i+3<SIZE && j+3<SIZE && board[i+3][j+3]==' ') && (i+2<SIZE && j+2<SIZE && board[i+2][j+2]==board[i][j]) && (i+1<SIZE && j+1<SIZE && board[i+1][j+1]==' '))
								  if(board[i][j]==point.mark)
								  score += 100;
								  else{
								  score -= 200;
								  row += 10;
								  }
								  }*/
						}
						/*
						   dialogue operation from upper right to lower left
						 */
						if(dia_ur[i][j]==0 || dia_ur[i][j]==10){
								dia_ur[i][j] = check_dia_ur(j,i,board);
								if(dia_ur[i][j] == 4 && board[i][j]==point.mark)
										return INFINITE;
								if(dia_ur[i][j] == 3){
										/*
										   we stuck enemy3 with 2 side
										 */
										if(((i-1>=0 && j+1<SIZE && board[i-1][j+1]==point.mark) || i==0 || j==SIZE-1) && ((i+3<SIZE && j-3>=0 && board[i+3][j-3]==point.mark) || i+3>=SIZE || j-3<0))
												score += 1000;
										/*
										   we get 3 with no obstacle for each side
										 */
										else if((i-1>=0 && j+1<SIZE && board[i-1][j+1]==' ') && (i+3<SIZE && j-3>=0 && board[i+3][j-3]==' ') && board[i][j]==point.mark){
												score += 700;
												++triple;
										}
										/*
										   we get 3 with obstacle on one of the two sides
										 */
										else if(((i-1>=0 && j+1<SIZE && board[i-1][j+1]==' ') && (i+3>=SIZE || j-3<0 || (board[i+3][j-3]==not_chess))) || ((i+3<SIZE && j-3>=0 && board[i+3][j-3]==' ') && (i==0 || j==SIZE-1 || (board[i-1][j+1]==not_chess)))){
												score += 50;
												++triple_stk;
										}
										//cout<<score<<","<<j<<","<<i<<" col3"<<endl;
								}
								else if(dia_ur[i][j] == 2){
										/*
										   get 2 with no obstacle for each side
										 */
										if((i-1>=0 && j+1<SIZE && board[i-1][j+1]==' ') && (i+2<SIZE && j-2>=0 && board[i+2][j-2]==' ')){
												if(board[i][j]==point.mark)
														score += 100;
												else{
														score -= 200;
														dia_ur[i][j] += 10;
												}
										}
										/*
										   opponent get 2 with obstacle on one of the two sides
										 */
										else if((((i-1>=0 && j+1<SIZE && board[i-1][j+1]==' ') && (i+2>=SIZE || j-2<0 || (board[i+2][j-2]==point.mark))) || ((i+2<SIZE && j-2>=0 && board[i+2][j-2]==' ') && (i==0 || j==SIZE-1 || (board[i-1][j+1]==point.mark)))) && board[i][j]==not_chess)
												score += 300;
										//cout<<score<<","<<j<<","<<i<<" col2"<<endl;
								}
								//else if(dia_ur[i][j] == 1){
								/*
								   get 2 chess with no obstacle and 1 blank between
								 */
								/*if((i-1>=0 && j+1<SIZE && board[i-1][j+1]==' ') && (i+3<SIZE && j-3>=0 && board[i+3][j-3]==' ') && (i+2<SIZE && j-2>=0 && board[i+2][j-2]==board[i][j]) && (i+1<SIZE && j-1>=0 && board[i+1][j-1]==' '))
								  if(board[i][j]==point.mark)
								  score += 100;
								  else{
								  score -= 200;
								  row += 10;
								  }
								  }*/
						}
						/*
						   priority of 3 when double alive 2 happens on opponent
						 */
						if(row>10 + col[j]>10 + dia_ul[i][j] + dia_ur[i][j] > 20){
								score += triple*100;
								score += triple_stk*750;
								triple = triple_stk = 0;
								//cout<<score<<","<<j<<","<<i<<" triple"<<endl;
						}
						--row;
						--col[j];
						if(i+1<SIZE && j+1<SIZE){
								dia_ul[i+1][j+1] = dia_ul[i][j]-1;
						}
						if(i+1<SIZE && j-1>=0){
								dia_ul[i+1][j-1] = dia_ul[i][j]-1;
						}
				}
				row = 0;
		}
		//cout<<"SCORE : "<<score<<endl;
		return score;
}

/*
   check row from left to right
 */
int check_row(int x, int y, const char board[][SIZE])
{
		if(board[y][x]==' ')
				return 0;
		int i,cnt;
		for(i=x, cnt=0; i<SIZE && board[y][i] == board[y][x]; ++i, ++cnt);
		return cnt;
}

/*
   check column from up to down
 */int check_col(int x, int y, const char board[][SIZE])
{
		if(board[y][x]==' ')
				return 0;
		int i,cnt;
		for(i=y, cnt=0; i<SIZE && board[i][x] == board[y][x]; ++i, ++cnt);
		return cnt;
}

/*
   check diagonal from upper-left to lower-right
 */
int check_dia_ul(int x, int y, const char board[][SIZE])
{
		if(board[y][x]==' ')
				return 0;
		int i,j,cnt;
		for(i=x, j=y, cnt=0; i<SIZE && j<SIZE && board[j][i] == board[y][x]; ++i, ++j, ++cnt);
		return cnt;
}

/*
   check diagonal from upper-right to lower-left
 */
int check_dia_ur(int x, int y, const char board[][SIZE])
{
		if(board[y][x]==' ')
				return 0;
		int i,j,cnt;
		for(i=x, j=y, cnt=0; i>=0 && j<SIZE && board[j][i] == board[y][x]; --i, ++j, ++cnt);
		return cnt;
}

/*
   check if the board is empty
 */
bool isempty(const char b[][SIZE])
{
		int i,j;
		for(i=0; i<SIZE; ++i){
				for(j=0; j<SIZE; ++j)
						if(b[i][j]!=' ')
								return false;
		}
		return true;
}
