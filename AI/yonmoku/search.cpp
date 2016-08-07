#include "search.h"
#include <iostream>
#include <cstdlib>
#define INFINITE 1e7
#define WINCON 4
using namespace std;
int alpha_beta(Cell point ,int depth,int alpha,int beta,const char s[][SIZE] ,bool max_min,bool player);
bool isempty(const char grid);
int check1(bool N ,const char b[][SIZE]);
int evaluate(bool N,char s [][SIZE]);
bool checkwin(const char b[][SIZE]);
bool rowwin(const char b[][SIZE]);
bool columnwin(const char b[][SIZE]);
bool diagonalwin(const char b[][SIZE]);
bool check2(bool N,const char b[][SIZE]);
bool row2(const char b[][SIZE]);
bool column2(const char b[][SIZE]);
bool diagonal2(const char b[][SIZE]);
bool check3(bool N,const char b[][SIZE]);
bool row3(const char b[][SIZE]);
bool column3(const char b[][SIZE]);
bool diagonal3(const char b[][SIZE]);
int cou=0;
int tmp5[5][5] = { {0,0,0,0,0},
		{0,1,1,1,0},
		{0,1,2,1,0},
		{0,1,1,1,0},
		{0,0,0,0,0} };

int tmp6[6][6] = { {0,0,0,0,0,0},
		{0,1,1,1,1,0},
		{0,1,2,2,1,0},
		{0,1,2,2,1,0},
		{0,1,1,1,1,0},
		{0,0,0,0,0,0} };
void search(const char b[][SIZE], const Cell& others, Cell& yours)
{
		//b:      board ('x': player1, 'o': player2, ' ': none)
		//others: your opponent's last move
		//yours:  your move <-- MUST determine it in this function!
		/**
		  Write your search strategy below
		 */
		if(cou==0){
				cou++;
				yours.x=SIZE/2;
				yours.y=SIZE/2;
				if(b[yours.x][yours.y]!=' '){
						yours.x=SIZE/2-1;
						yours.y=SIZE/2-1;
				}
				return;
		}

		bool player = false;
		if( others.x < SIZE && others.x >= 0 && others.y < SIZE && others.y >= 0 
						&& b[others.x][others.y] == 'x') player = true;
		int i,j,x,y,num,s,num2=-1;
		num = -1*INFINITE;
		Cell next;
		Cell child;
		for(i=0;i<SIZE;i++){
				for(j=0;j<SIZE;j++){
						if(b[i][j]!=' ') continue;
						child.x = i;
						child.y = j;
						if(player ==false)
								child.mark = 'x';
						else child.mark = 'o';
						s = alpha_beta(child,1,-1*INFINITE,INFINITE, b ,true,player);
						if (num<s){
								num=s;
								next.x=i;
								next.y=j;
						}
						else if(num == s){

								if(SIZE==6 && num2 < tmp6[i][j]){
										num2 = tmp6[i][j];
										next.x = i;
										next.y = j;
								}	
								else if(SIZE==5 && num2 < tmp5[i][j]){
										num2 = tmp5[i][j];
										next.x = i;
										next.y = j;
								}

						}
				}
		}
		cout << s << endl;
		//cout << " ( " << next.x << " , " << next.y << " ) " << endl;
		//if(b[SIZE/2][SIZE/2]==' ') next.x = next.y = SIZE/2;
		yours.x = next.x;
		yours.y = next.y;
}

int alpha_beta(Cell point ,int depth,int alpha,int beta,const char s[][SIZE] ,bool max_min,bool player){
		char g[SIZE][SIZE];
		int i,j;
		for( i =0 ; i< SIZE ;i++) for( j=0; j<SIZE ;j++) g[i][j] = s[i][j];
		if(point.mark =='x')
				g[point.x][point.y]='x';
		else if(point.mark == 'o')
				g[point.x][point.y]='o';

		if(depth ==0 ){
				return evaluate(player,g);
		}
		int x,y;
		Cell child;
		if (!player){
				for(x = 0;x < SIZE ;x++)
						for(y = 0 ; y < SIZE ; y++){
								if(g[x][y] != ' ') continue;
								child.x = x;
								child.y = y;
								if(point.mark =='o')
										child.mark = 'x';
								else child.mark = 'o';
								alpha = max(alpha,alpha_beta(child,depth-1,alpha,beta,g,!max_min,!player));
								if(beta <= alpha) return beta;
						}
				return alpha;
		}
		else{
				for(x = 0;x < SIZE ;x++)
						for(y = 0 ; y < SIZE ; y++){
								if(g[x][y] != ' ') continue;
								child.x = x;
								child.y = y;
								if(point.mark =='o')
										child.mark = 'x';
								else child.mark = 'o';
								beta = min(beta,alpha_beta(child,depth-1,alpha,beta,g,!max_min,!player));
								if(beta <= alpha) return alpha;
						}
				return beta;
		}
}
bool isempty(const char grid)
{
		if(grid == ' ')
				return true;

		return false;
}
int evaluate(bool N,char s[][SIZE]){

		//		if(N==false) cout << "xxxxxx" << endl;
		//		else cout << "ooooooo" << endl;
		if(checkwin(s))
				return 10000;
		else if(check3(N,s))
				return 5000;
		else if(check2(N,s))
				return 1000;
		else if(check1(N,s)!=0)
				return check1(N,s);
		else return 0;


}
bool checkwin(const char b[][SIZE])
{
		if(rowwin(b))
				return true;
		else if(columnwin(b))
				return true;
		else if(diagonalwin(b))
				return true;

		return false;
}

bool rowwin(const char b[][SIZE])
{
		for(int i = 0; i < SIZE; i++)
		{
				for(int j = 0; j < SIZE - WINCON + 1; j++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON; k++)
								{
										char next = b[i][j + k];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}
		}

		return false;
}

bool columnwin(const char b[][SIZE])
{
		for(int j = 0; j < SIZE; j++)
				for(int i = 0; i < SIZE - WINCON + 1; i++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON; k++)
								{
										char next = b[i + k][j];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}

		return false;
}

bool diagonalwin(const char b[][SIZE])
{
		for(int i = 0; i < SIZE - WINCON + 1; i++)
		{
				for(int j = 0; j < SIZE - WINCON + 1; j++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON; k++)
								{
										char next = b[i + k][j + k];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}
		}

		for(int i = 0; i < SIZE - WINCON + 1; i++)
		{
				for(int j = WINCON - 1; j < SIZE; j++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON; k++)
								{
										char next = b[i + k][j - k];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}
		}

		return false;
}
int check1(bool N, const char b[][SIZE])
{
		for(int i =0;i<SIZE;i++){
				for(int j=0;j<SIZE;j++){
						char first = b[i][j];
						bool conn = true;
						if(!isempty(first)){
								if((i==0)||((i-1)==SIZE)){
										return 0;
								}
								else if((j==0)||((j-1)==SIZE)){
										return 0;
								}
								if(!isempty(b[i-1][j-1]) || !isempty(b[i-1][j+1]) || !isempty(b[i+1][j-1]) || !isempty(b[i-1][j-1])){
										if((abs(i-SIZE/2)+abs(j-SIZE/2))<3){
												return 20;
										}
										else if((abs(i-SIZE/2)+abs(j-SIZE/2))<6){
												return 10;
										}	
										else if((abs(i-SIZE/2)+abs(j-SIZE/2))>=6){
												return 5;
										}
								}

						}

				}
		}
		return 0;
}
bool check2(bool N,const char b[][SIZE])
{
		if(diagonal2(b))
				return true;
		if(column2(b))
				return true;
		else if(row2(b))
				return true;
		else false;
}

bool row2(const char b[][SIZE])
{
		for(int i = 0; i < SIZE; i++)
		{
				for(int j = 0; j < SIZE - WINCON + 3; j++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON-2; k++)
								{
										char next = b[i][j + k];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}
		}

		return false;
}

bool column2(const char b[][SIZE])
{
		for(int j = 0; j < SIZE; j++)
				for(int i = 0; i < SIZE - WINCON + 3; i++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON-2; k++)
								{
										char next = b[i + k][j];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}

		return false;
}

bool diagonal2(const char b[][SIZE])
{
		for(int i = 0; i < SIZE - WINCON + 3; i++)
		{
				for(int j = 0; j < SIZE - WINCON + 3; j++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON-2; k++)
								{
										char next = b[i + k][j + k];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}
		}

		for(int i = 0; i < SIZE - WINCON + 3; i++)
		{
				for(int j = WINCON - 2; j < SIZE; j++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON-2; k++)
								{
										char next = b[i + k][j - k];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}
		}

		return false;
}
bool check3(bool N,const char b[][SIZE])
{
		if(diagonal3(b))
				return true;
		else if(column3(b))
				return true;
		else if(row3(b))
				return true;

		return false;
}

bool row3(const char b[][SIZE])
{
		for(int i = 0; i < SIZE; i++)
		{
				for(int j = 0; j < SIZE - WINCON + 2; j++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON-1; k++)
								{
										char next = b[i][j + k];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}
		}

		return false;
}

bool column3(const char b[][SIZE])
{
		for(int j = 0; j < SIZE; j++)
				for(int i = 0; i < SIZE - WINCON + 2; i++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON-1; k++)
								{
										char next = b[i + k][j];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}

		return false;
}

bool diagonal3(const char b[][SIZE])
{
		for(int i = 0; i < SIZE - WINCON + 2; i++)
		{
				for(int j = 0; j < SIZE - WINCON + 2; j++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON-1; k++)
								{
										char next = b[i + k][j + k];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}
		}

		for(int i = 0; i < SIZE - WINCON + 2; i++)
		{
				for(int j = WINCON - 2; j < SIZE; j++)
				{
						char first = b[i][j];
						bool conn = true;

						if(!isempty(first))
						{
								for(int k = 1; k < WINCON-1; k++)
								{
										char next = b[i + k][j - k];
										if(!isempty(next) && first == next)
												;
										else
										{
												conn = false;
												break;
										}
								}

								if(conn)
										return true;
						}
				}
		}

		return false;
}
