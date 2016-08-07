#include "search.h"
#include <iostream>
#include <cstdlib>
#define INFINITE 1e7

using namespace std;
int tmp1[5][5] = {0,0,0,0,0,0,1,1,1,0,0,1,2,1,0,0,1,1,1,0,0,0,0,0,0};
int tmp2[6][6] = { 0,0,0,0,0,0,0,1,1,1,1,0,0,1,2,2,1,0,0,1,2,2,1,0,0,1,1,1,1,0,0,0,0,0,0,0};
bool check_4(Cell point,char b[][SIZE]);
bool live_3(Cell point,char b[][SIZE]);
bool dead_3(Cell point,char b[][SIZE]);
bool dead2_3(Cell point,char b[][SIZE]);
bool live_2(Cell point,char b[][SIZE]);
bool live2_2(Cell point,char b[][SIZE]);
bool dead_2(Cell point,char b[][SIZE]);

int alpha_beta(Cell point ,int depth,int alpha,int beta,const char s[][SIZE] ,bool max_min,char mark);
int evaluate(Cell point ,char s[][SIZE]);

void search2(const char b[][SIZE], const Cell& others, Cell& yours)
{
		//b:      board ('x': player1, 'o': player2, ' ': none)
		//others: your opponent's last move
		//yours:  your move <-- MUST determine it in this function!


		/**
		  Write your search strategy below
		 */
		if(b[SIZE/2][SIZE/2]==' ') {
				yours.x = yours.y = SIZE/2;
				return ;
		}
		Cell child,next;
		int i,j;
		int s,num;
		num = -1*INFINITE;
		child.mark = yours.mark;
		for(i=0;i<SIZE;i++){
				for(j=0;j<SIZE;j++){
						if(b[i][j]!=' ') continue;
						child.x = i;
						child.y = j;		
						s = alpha_beta(child,0,-1*INFINITE,INFINITE, b ,true,yours.mark);
						if((abs(i-others.x)+abs(j-others.y))<2) s = s -2;
						if(num < s){
								num = s;
								next.x = i;
								next.y = j;
						}
				}
		}
		yours.x = next.x;
		yours.y = next.y;
}

int alpha_beta(Cell point ,int depth,int alpha,int beta,const char s[][SIZE] ,bool max_min, char mark)
{
		char g[SIZE][SIZE];
		int i,j;
		for( i =0 ; i< SIZE ;i++) for( j=0; j<SIZE ;j++) g[i][j] = s[i][j];			
		g[point.x][point.y] = point.mark; 
		if( depth == 0 ){
				return evaluate(point,g);
		}
		Cell child;
		if(point.mark == 'x' ) child.mark = 'o';
		else child.mark = 'x';
		if (!max_min){
				for(i = 0;i < SIZE ;i++){
						for(j = 0 ; j < SIZE ; j++){
								if(g[i][j] != ' ') continue;
								child.x = i;
								child.y = j;
								alpha = max(alpha,alpha_beta(child,depth-1,alpha,beta,g,!max_min,mark));
								if(beta <= alpha) return beta;
						}
				}
				return alpha;
		}
		else{
				for(i = 0;i < SIZE ;i++){
						for(j = 0 ; j < SIZE ; j++){
								if(g[i][j] != ' ') continue;
								child.x = i;
								child.y = j;
								beta = min(beta,alpha_beta(child,depth-1,alpha,beta,g,!max_min,mark));
								if(beta <= alpha) return alpha;
						}
				}
				return beta;
		}
}

int evaluate(Cell point ,char s[][SIZE]){
		Cell next;
		next.x = point.x;
		next.y = point.y;
		if(point.mark == 'x') next.mark = 'o';
		else next.mark = 'x';
		char G6[SIZE][SIZE];
		int i,j;
		if(SIZE == 5) for(i=0;i<SIZE;i++) for(j=0;j<SIZE;j++) G6[i][j] = tmp1[i][j];
		if(SIZE == 6) for(i=0;i<SIZE;i++)for(j=0;j<SIZE;j++) G6[i][j] = tmp2[i][j];

		if(check_4(point,s)) return 500+G6[point.x][point.y];
		if(check_4(next,s)) return 400+G6[point.x][point.y];
		if(live_3(point,s)) return 300+G6[point.x][point.y];
		if(live_3(next,s)) return 200+G6[point.x][point.y];
		if(live2_2(point,s)) return 100+G6[point.x][point.y];
		if(live2_2(next,s)) return 90+G6[point.x][point.y];
		if(live_2(point,s) && dead_2(point,s)) return 80+G6[point.x][point.y];
		if(live_2(next,s)  && dead_2(point,s)) return 70+G6[point.x][point.y];
		if(dead_3(point,s)) return 60+G6[point.x][point.y];
		if(dead_3(next,s)) return 50+G6[point.x][point.y];
		if(live_2(point,s)) return 40+G6[point.x][point.y];
		if(live_2(next,s)) return 30+G6[point.x][point.y];
		if(dead_2(point,s)) return 20+G6[point.x][point.y];
		if(dead_2(next,s)) return 10+G6[point.x][point.y];

		return G6[point.x][point.y];
}
bool check_4(Cell point,char b[][SIZE]){
		int i,j;
		for(i=-1;i<=1;i++){
				for(j=-1;j<=1;j++){
						if(point.x+i < 0 || point.x+i>SIZE) continue;
						if(point.y+j < 0 || point.y+j>SIZE) continue;
						if(i==0&&j==0) continue;
						if(b[point.x+i][point.y+j] == point.mark){
								if(b[point.x+2*i][point.y+2*j] == point.mark){
										if(b[point.x+3*i][point.y+3*j]==point.mark 
														&&!(point.x+3*i < 0 || point.x+3*i>SIZE)
														&&!(point.y+3*j < 0 || point.y+3*j>SIZE))
												return true;
										if( b[point.x-i][point.y-j]==point.mark 
														&&!(point.x-i < 0 || point.x-i>SIZE) 
														&&!(point.y-j < 0 || point.y-j>SIZE) )
												return true;
								}
								if(b[point.x-i][point.y-j] == point.mark){
										if(b[point.x+2*i][point.y+2*j]==point.mark 
														&&!(point.x+2*i < 0 || point.x+2*i>SIZE) 
														&&!(point.y+2*j < 0 || point.y+2*j>SIZE))
												return true;
										if(b[point.x-2*i][point.y-2*j]==point.mark 
														&&!(point.x-2*i < 0 || point.x-2*i>SIZE) 
														&&!(point.y-2*j < 0 || point.y-2*j>SIZE))
												return true;
								}
						}
				}
		}
		return false;
}
bool live_3(Cell point,char b[][SIZE]){
		int i,j;
		for(i=-1;i<=1;i++){
				for(j=-1;j<=1;j++){
						if(point.x+i < 0 || point.x+i>SIZE) continue;
						if(point.y+j < 0 || point.y+j>SIZE) continue;
						if(b[point.x+i][point.y+j] == point.mark){
								if(b[point.x+2*i][point.y+2*j] == point.mark)
										if(b[point.x+3*i][point.y+3*j]== ' '
														&&!(point.x+3*i < 0 || point.x+3*i>SIZE)
														&&!(point.y+3*j < 0 || point.y+3*j>SIZE)
														&& b[point.x-i][point.y-j]==' '
														&&!(point.x-i < 0 || point.x-i>SIZE) 
														&&!(point.y-j < 0 || point.y-j>SIZE) ) 
												return true;
								if(b[point.x-i][point.y-j] == point.mark)
										if(b[point.x+2*i][point.y+2*j]==' ' 
														&&!(point.x+2*i < 0 || point.x+2*i>SIZE) 
														&&!(point.y+2*j < 0 || point.y+2*j>SIZE)
														&& b[point.x-2*i][point.y-2*j]==' ' 
														&&!(point.x+2*i < 0 || point.x+2*i>SIZE) 
														&&!(point.y+2*j < 0 || point.y+2*j>SIZE))
												return true;
						}
				}
		}
		return false;
}
bool dead_3(Cell point,char b[][SIZE]){
		int i,j;
		char mark;
		if(point.mark =='x') mark = 'o';
		else mark = 'x';
		for(i=-1;i<=1;i++){
				for(j=-1;j<=1;j++){
						if(point.x+i < 0 || point.x+i>SIZE) continue;
						if(point.y+j < 0 || point.y+j>SIZE) continue;
						if(b[point.x+i][point.y+j] == point.mark){
								if(b[point.x+3*i][point.y+3*j]== mark 
												&&!(point.x+3*i < 0 || point.x+3*i>SIZE)
												&&!(point.y+3*j < 0 || point.y+3*j>SIZE))
										return true;
								if( b[point.x-i][point.y-j]==mark
												&&!(point.x-i < 0 || point.x-i>SIZE) 
												&&!(point.y-j < 0 || point.y-j>SIZE))
										return true;
								if(b[point.x-i][point.y-j] == point.mark)	
										if(b[point.x+2*i][point.y+2*j]==mark
														&&!(point.x+2*i < 0 || point.x+2*i>SIZE) 
														&&!(point.y+2*j < 0 || point.y+2*j>SIZE))
												return true; 
								if(b[point.x-2*i][point.y-2*j]==mark 
												&&!(point.x-2*i < 0 || point.x-2*i>SIZE) 
												&&!(point.y-2*j < 0 || point.y-2*j>SIZE)) 
										return true;
						}
				}
		}
		return false;
}
bool dead2_3(Cell point,char b[][SIZE]){
		int i,j;
		int x,y;
		bool con;
		con = false;
		for(i=-1;i<=1;i++){
				for(j=-1;j<=1;j++){
						if(point.x+i < 0 || point.x+i>SIZE) continue;
						if(point.y+j < 0 || point.y+j>SIZE) continue;
						if(b[point.x+i][point.y+j] == point.mark){
								if(b[point.x+2*i][point.y+2*j] == point.mark)
										if(b[point.x+3*i][point.y+3*j]=='x' || b[point.x-i][point.y-j]=='x' ) con  = true;
								if(b[point.x-i][point.y-j] == point.mark)
										if(b[point.x+2*i][point.y+2*j]=='x' || b[point.x-2*i][point.y-2*j]=='x' ) con  = true;
						}
				}
		}
		return false;
}
bool live_2(Cell point,char b[][SIZE]){
		int i,j;
		for(i=-1;i<=1;i++){
				for(j=-1;j<=1;j++){
						if(point.x+i < 0 || point.x+i>SIZE) continue;
						if(point.y+j < 0 || point.y+j>SIZE) continue;
						if(b[point.x+i][point.y+j] == point.mark){
								if(b[point.x+2*i][point.y+2*j]==' ' 
												&&!(point.x+2*i < 0 || point.x+2*i>SIZE) 
												&&!(point.y+2*j < 0 || point.y+2*j>SIZE)
												&& b[point.x-i][point.y-j]==' ' 
												&&!(point.x-i < 0 || point.x-i>SIZE) 
												&&!(point.y-j < 0 || point.y-j>SIZE)) 
										return true;
						}
				}
		}
		return false;
}
bool live2_2(Cell point,char b[][SIZE]){
		int i,j;
		char mark;
		bool con;
		con = false;
		if(point.mark =='x') mark = 'o';
		else mark = 'x';
		for(i=-1;i<=1;i++){
				for(j=-1;j<=1;j++){
						if(point.x+i < 0 || point.x+i>SIZE) continue;
						if(point.y+j < 0 || point.y+j>SIZE) continue;
						if(con){
								if(b[point.x+i][point.y+j] == point.mark){
										if(b[point.x+2*i][point.y+2*j]==' ' 
														&&!(point.x+2*i < 0 || point.x+2*i>SIZE) 
														&&!(point.y+2*j < 0 || point.y+2*j>SIZE)
														&& b[point.x-i][point.y-j]==' ' 
														&&!(point.x-i < 0 || point.x-i>SIZE) 
														&&!(point.y-j < 0 || point.y-j>SIZE)) 
												return true;
								}
						}
						else{
								if(b[point.x+i][point.y+j] == point.mark){
										if(b[point.x+2*i][point.y+2*j]==' ' 
														&&!(point.x+2*i < 0 || point.x+2*i>SIZE) 
														&&!(point.y+2*j < 0 || point.y+2*j>SIZE)
														&& b[point.x-i][point.y-j]==' ' 
														&&!(point.x-i < 0 || point.x-i>SIZE) 
														&&!(point.y-j < 0 || point.y-j>SIZE)) 
												con = true;
								}
						}
				}
		}
		return false;
}
bool dead_2(Cell point,char b[][SIZE]){
		int i,j;
		char mark;
		if(point.mark =='x') mark = 'o';
		else mark = 'x';
		for(i=-1;i<=1;i++){
				for(j=-1;j<=1;j++){
						if(point.x+i < 0 || point.x+i>SIZE) continue;
						if(point.y+j < 0 || point.y+j>SIZE) continue;
						if(b[point.x+i][point.y+j] == point.mark){
								if(b[point.x+2*i][point.y+2*j]==mark 
												&&!(point.x+2*i < 0 || point.x+2*i>SIZE) 
												&&!(point.y+2*j < 0 || point.y+2*j>SIZE))
										return true;
								if(	b[point.x-i][point.y-j]==mark 
												&&!(point.x-i < 0 || point.x-i>SIZE) 
												&&!(point.y-j < 0 || point.y-j>SIZE))
										return true;
						}
				}
		}
		return false;
}
