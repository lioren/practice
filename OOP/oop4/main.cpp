#include<iostream>
#include<vector>
#include<fstream>
#include<algorithm>
#include"hw4.h"
using namespace std;
int main()
{
		vector<Point> point;
		Point circle[200000];
		Point temp;
		Line  s;
		ifstream fin("Input.txt");
		ofstream  fout("Output.txt");
	    int num,i;
	    double a;
	    fin >> num;
	    for(i=0;i<num;i++){
	        	fin >> a; temp.setx(a);
	        	fin >> a; temp.sety(a); 
	    		point.push_back(temp);
		}
		
				int com;
				cout << "1.BF  2.Javis's march   3.Exit:" ;
				cin >> com;
				if(com==1){
                s.findhull(point,num);	
				}
                else if(com==2){
		        temp.findhull(point,num);
				}
				else if(com==3)
						return 0;
		
}
