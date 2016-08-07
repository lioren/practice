#include<iostream>
#include"hw3.h"
using namespace std;
void getline(double,double,double,double);
int main()
{
		int comd1,comd2;
		double slope,inter,move;
		while(1){
		cout << "1. Line    2. Line2    3. Circle    4. Circle2    5. Exit , Please choose commend :";
		cin >> comd1;
		if(comd1==1){
		cout << "Enter two points (4 doubles): ";
		Line x;
		cin >> x;
		cout << "input line is" << x <<endl;
	    getline(x.get_x0(),x.get_x1(),x.get_y0(),x.get_y1());
			while(1){
        		cout << "1. slope    2. y_intercept    3. vshift   4. back to main menu , Please choose commend :"; 
        		cin >> comd2;
        		if(comd2==1){
        				slope=x.slope();
        			if(slope==(-1))
        					cout << "slope doesn't exist!" << endl ;
					else 
							cout << "The slope is : " << slope << endl ;

				}
				else if(comd2==2){
						inter=x.y_intercept();
						cout << "The y_intercept is : " << inter << endl;
				}
				else if(comd2==3){
						cout << "How much amount do you want to shift : " ;
						cin >> move ;
						x.vshift(move);
						cout << "After shift =>>  ";
						getline(x.get_x0(),x.get_x1(),x.get_y0(),x.get_y1());
				}
				else if(comd2==4){
						break;
				}
			}
		}
		else if(comd1==2){
				cout << "Enter one point and one vector (4 doubles): ";
				Line2 x2;
				cin >> x2;
				x2.printf();
				while(1){
						cout << "1. normal    2. back to main menu , Please choose commend :";
						cin >> comd2;
						if(comd2==1){
								x2.normal();
						}
						else if(comd2==2){
								break;
						}
				}
		}
		else if(comd1==3){
				cout << "Enter one point as the center of the circle and a radius (3 doubles): ";
				Circle c;
				cin >> c;
				if(c.get_radius()<=0){
						cout << "It's not a circle ,back to main menu" << endl;
						continue;
				}
				c.printfc();
				while(1){
						cout << "1. radius    2.set_center    3.is_inside   4.back to main menu  , Please choose commend :";
						cin >> comd2;
						if(comd2==1){
								c.radius();
						}
						else if(comd2==2){
								cout << "Enter one point (2 doubles): " ;
								double buf1,buf2;
								cin >> buf1 >> buf2;
								c.set_center(buf1,buf2);
								c.printfc();
						}
						else if(comd2==3){
								cout << "Enter one point (2 doubles): " ;
								double buf1,buf2;
								cin >> buf1 >> buf2;
								c.is_inside(buf1,buf2);
						}
						else if(comd2==4){
								break;
						}

				}
		}
		else if(comd1==4){
				cout << "Enter two points as the diameter of the circle (4 doubles) : ";
				Circle2 c2;
				cin >> c2;
				c2.printfc2();
				while(1){
						cout << "1. is_inside    2. back to main menu  , Please choose commend :";
						cin >> comd2;
						if(comd2==1){
								cout << "Enter one point (2 doubles): ";
								double buf3,buf4;
								cin >> buf3 >> buf4;
								c2.is_inside2(buf3,buf4);
						}
						else if(comd2==2){
								break;
						}
				}
		}
		else if(comd1==5){
				return -1;
		}
		}

}
void getline(double x0,double x1,double y0,double y1)
{
		double m,b;
		if((x1-x0)==0){
				cout << "x=" << x0 << endl;
				return ;
		}
		if((y1-y0)==0){
				cout << "y=" << y0 << endl;
				return ;
		}
		m=(y1-y0)/(x1-x0);
		b=y0-m*x0;
		if(m==1&&b>0)
				cout << "y=x+" << b << endl;
		else if(m==1&&b==0)
				cout << "y=x" << endl;
		else if(m==1&&b<0)
				cout << "y=x" << b << endl;
		else if(b>0)
				cout << "y="<< m << "x+" << b << endl;
		else if(b==0)
				cout << "y="<< m << "x" << endl;
		else 
				cout << "y="<< m << "x" << b << endl;
}
