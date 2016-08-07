#include <iostream>
#include <cstdlib>
#include <ctime>
#include "search.h"

using std::cout;
using std::endl;
using std::cin;

const int       WINCON = 4;           //win condition: 4-in-a-row
const double    WAIT_COUNTS = 1e8;    //wait counts
const double		TIME_ALLOWED = 5.0;   //allowed time (seconds)

void init(char b[][SIZE]);
void wait(int count=WAIT_COUNTS);
void show(const char b[][SIZE], const Cell& player, double t);
bool isFull(const char b[][SIZE]);
bool isEmpty(const char grid);
bool isError(const char b[][SIZE], const Cell& c, double t);
bool checkWin(const char b[][SIZE]);
bool rowWin(const char b[][SIZE]);
bool columnWin(const char b[][SIZE]);
bool diagonalWin(const char b[][SIZE]);


int main(int argc, char** argv)
{
    char board[SIZE][SIZE];
    Cell player1;
    Cell player2;
		clock_t tStart, tEnd;
		double tUsed;

		player1.mark = 'x';				//player1: 'x'
		player2.mark = 'o';				//player1: 'o'
		
    init(board);
    
    while(!isFull(board))
    {
        /** Player 1 **/
				tStart = clock();
        search3(board, player2, player1);      //>>> search of player 1 <<<
				tEnd = clock();
        
				tUsed = (double)(tEnd - tStart) / CLOCKS_PER_SEC;
        if(!isError(board, player1, tUsed))
        {
            board[player1.x][player1.y] = 'x';
            show(board, player1, tUsed);
            if(checkWin(board))
            {
                cout << "Player 1(x) win the game!" << endl;
                cin.get();
                return 0;
            }
        }

        /** Player 2 **/
        tStart = clock();
        search(board, player1, player2);      //>>> search of player 2 <<<
        tEnd = clock();

        if(!isError(board, player2, tUsed))
        {
            board[player2.x][player2.y] = 'o';
            show(board, player2, tUsed);
            if(checkWin(board))
            {
                cout << "Player 2(o) win the game!" << endl;
                cin.get();
                return 0;
            }
        }
    }

    if(!checkWin(board))
        cout << "Draw.";

    return 0;
}

/**
Initialize the board of Yonmoku game
*/
void init(char b[][SIZE])
{
    for(int i = 0; i < SIZE; i++)
        for(int j = 0; j < SIZE; j++)
            b[i][j] = ' ';
}

/**
Let the programming to wait time
*/
void wait(int count)
{
    for(int i=0; i<count; i++);
}

/**
Show the board of Yonmoku game
*/
void show(const char b[][SIZE], const Cell& player, double t)
{
    system("cls");
    cout << "========== Yonmoku Game ==========" << endl;

    cout << "Player 1: x" << endl << "Player 2: o" << endl << endl;

    for(int i = 0; i < SIZE; i++)
        cout << "  " << i + 1 << " ";

    cout << endl;

    for(int i = 0; i < SIZE; i++)
        if(i < SIZE)
            cout << "+---";

    cout << "+" << endl;

    for (int i = 0; i < SIZE; i++)
    {
        for(int j = 0; j < SIZE; j++)
        {
            cout << "| " << b[i][j] << " ";
        }
        cout << "| " << i + 1 << endl;
        for(int j = 0; j < SIZE; j++)
        {
            if(j < SIZE)
                cout << "+---";
        }
        cout << "+" << endl;
    }
    cout << endl;

    cout << player.mark << " selects (" << (player.y + 1) << ", " << (player.x + 1) << ") in " << t << " secs" << endl;
    wait();
}

//
/**
Check whether the board of Yonmoku game is full or not
*/
bool isFull(const char b[][SIZE])
{
    for(int i = 0; i < SIZE; i++)
        for(int j = 0; j < SIZE; j++)
            if (b[i][j] == ' ')
                return false;

    return true;
}

//
/**
Check whether grid is empty or nor
*/
bool isEmpty(const char grid)
{
    if(grid == ' ')
        return true;

    return false;
}

/**
Check whether some errors exists or not
Example: index is out of range or the cell is occupied
*/
bool isError(const char b[][SIZE], const Cell& c, double t)
{
    if(c.x < 0 || c.x >= SIZE || c.y < 0 || c.y >= SIZE)
    {
        cout << "Error:\t(" << c.y + 1 << ", " << c.x + 1 << ") ";
        cout << "is out of range!!" << endl;
        return true;
    }
    
    if(!isEmpty(b[c.x][c.y]))
    {
        cout << "Error:\t(" << c.y + 1 << ", " << c.x + 1 << ") ";
        cout << "is occupied." << endl;
        return true;
    }
    
    if(t > TIME_ALLOWED)
    {
        cout << "Error:\t Overtime (" << t << " secs)!!\n";
        return true;
    }

    return false;
}

/**
Check whether the state of Yonmoku game is winning or not
*/
bool checkWin(const char b[][SIZE])
{
    if(rowWin(b))
        return true;
    else if(columnWin(b))
        return true;
    else if(diagonalWin(b))
        return true;

    return false;
}

/**
Check whether one row is successful or not
*/
bool rowWin(const char b[][SIZE])
{
    for(int i = 0; i < SIZE; i++)
    {
        for(int j = 0; j < SIZE - WINCON + 1; j++)
        {
            char first = b[i][j];
            bool conn = true;

            if(!isEmpty(first))
            {
                for(int k = 1; k < WINCON; k++)
                {
                    char next = b[i][j + k];
                    if(!isEmpty(next) && first == next)
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

/**
Check whether one column is successful or not
*/
bool columnWin(const char b[][SIZE])
{
    for(int j = 0; j < SIZE; j++)
        for(int i = 0; i < SIZE - WINCON + 1; i++)
        {
            char first = b[i][j];
            bool conn = true;

            if(!isEmpty(first))
            {
                for(int k = 1; k < WINCON; k++)
                {
                    char next = b[i + k][j];
                    if(!isEmpty(next) && first == next)
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

/**
Check whether one diagonal is successful or not
*/
bool diagonalWin(const char b[][SIZE])
{
    /** from lefttop to rightbottom */
    for(int i = 0; i < SIZE - WINCON + 1; i++)
    {
        for(int j = 0; j < SIZE - WINCON + 1; j++)
        {
            char first = b[i][j];
            bool conn = true;

            if(!isEmpty(first))
            {
                for(int k = 1; k < WINCON; k++)
                {
                    char next = b[i + k][j + k];
                    if(!isEmpty(next) && first == next)
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

    /** from righttop to leftbottom */
    for(int i = 0; i < SIZE - WINCON + 1; i++)
    {
        for(int j = WINCON - 1; j < SIZE; j++)
        {
            char first = b[i][j];
            bool conn = true;

            if(!isEmpty(first))
            {
                for(int k = 1; k < WINCON; k++)
                {
                    char next = b[i + k][j - k];
                    if(!isEmpty(next) && first == next)
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
