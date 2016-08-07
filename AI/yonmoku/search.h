#ifndef SEARCH_H
#define SEARCH_H

struct Cell
{
    int x;
    int y;
		char mark;				//mark of moves ('o' or 'x')
};

const int  SIZE = 6;  //size of board

void search(const char b[][SIZE], const Cell& others, Cell& yours);
void search2(const char b[][SIZE], const Cell& others, Cell& yours);
void search3(const char b[][SIZE], const Cell& others, Cell& yours);
#endif // SEARCH_H
