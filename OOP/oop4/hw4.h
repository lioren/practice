#include<iostream>
#include<vector>
using namespace std;

class Point{
		public:
			Point();
			Point(double,double);
			Point(const Point &);
			void findhull(vector<Point>,int );
			Point FindLowestPoint(vector<Point> &input);
			void setx(double);
			void sety(double);
			double getx();
			double gety();
			bool operator==(const Point &p){
					return (x==p.x)&&(y==p.y);
			}
		private:
			double x;
			double y;
};
class Line{
		public:
			Line();
			Line(double,double,double);
			Line(const Line&p);
			bool sameside(Point ,Point ,Point);
			void findhull(vector <Point>point,int num);
			bool operator==(const Line&p){
					return(a==p.a)&&(b==p.b)&&(c==p.c);
			}
			double a;
			double b;
			double c;
};
