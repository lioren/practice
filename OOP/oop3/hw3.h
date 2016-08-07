#include<iostream>
using namespace std;

class Line{
		public:
			Line();
			Line(double,double,double,double);
			const double get_x0(void) const;
			const double get_x1(void) const;
			const double get_y0(void) const;
			const double get_y1(void) const;
			double slope();
		    void vshift(double);
			double y_intercept();
			friend std::istream&operator>>(std::istream&is,Line&l);
			friend std::ostream&operator<<(std::ostream&os,const Line&l);

		private:
			double x0,x1,y0,y1;
};
class Line2{
		public:
		    Line2();
		    Line2(double,double,double,double);
		    void normal();
		    void printf();
		    friend std::istream&operator>>(std::istream&is,Line2&l2);

		private:
		    double x0,y0,dx,dy;
};
class Circle{
		public:
			Circle();
			Circle(double,double,double);
			void radius();
			void set_center(double,double);
			void is_inside(double,double);
			void printfc();
			double get_radius();
			friend std::istream&operator>>(std::istream&is,Circle&c);

		private:
			double cx,cy,r;
};
class Circle2{
		public:
			Circle2();
			Circle2(double,double,double,double);
			void printfc2();
			void is_inside2(double,double);
			friend std::istream&operator>>(std::istream&is,Circle2&c2);

		private:
			double x0,x1,y0,y1;
};
