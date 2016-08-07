#include<iostream>
#include<math.h>
#include"hw3.h"
using namespace std;
///////////               Line             //////////////
Line::Line(){
		x0=0.0,x1=1.0,y0=0.0,y1=1.0;
}
Line::Line(double a,double b,double c,double d){
		x0=a,y0=b,x1=c,y1=d;
}
const double Line :: get_x0(void) const{
		return x0;
}
const double Line :: get_x1(void) const{
		return x1;
}
const double Line :: get_y0(void) const{
		return y0;
}
const double Line :: get_y1(void) const{
		return y1;
}
double Line::slope(){
		if((x1-x0)==0){
				cout << "x=" << x0 << endl;
				return -1 ;
		}
		return (y1-y0)/(x1-x0);
}
double Line::y_intercept(){
		return y0-(((y1-y0)/(x1-x0))*x0); 
}
void Line::vshift(double move){
		y0=y0+move;
		y1=y1+move;
}
std::istream&operator>>(std::istream&is,Line&l){
		double a,b,c,d;
		is>>a>>b>>c>>d;
		l=Line(a,b,c,d);
		return is;
}
std::ostream&operator<<(std::ostream&os,const Line&l){
		os<<"("<<l.get_x0()<<","<<l.get_y0()<<")";
		os<<"("<<l.get_x1()<<","<<l.get_y1()<<")";
		return os;
}
//////////               Line2             ////////////////
Line2::Line2(){
		x0=0.0,y0=1.0,dx=0.0,dy=1.0;
}
Line2::Line2(double a,double b,double c,double d){
		x0=a,y0=b,dx=c,dy=d;
}
void Line2::normal(){
		double c,m;
		if(dy==0){
				cout << "x=" << x0 << endl;
				return;
		}
		m=(-1)*(dx/dy);
		c=y0-m*x0;
		if(m==0)
				cout << "y=" << c <<endl;
		else if(m==1&&c==0)
				cout << "y=x" <<endl;
		else if(m==1&&c>0)
				cout << "y=x+" << c <<endl;
		else if(m==1&&c<0)
				cout << "y=x" << c <<endl;
		else if(m!=0&&c==0)
				cout << "y=" << m << "x" <<endl;
		else if(m!=0&&c>0)
				cout << "y=" << m << "x+" << c <<endl;
		else if(m!=0&&c<0)
				cout << "y=" << m << "x" << c <<endl;
}
void Line2::printf(){
		double c,m;
		if(dx==0){
				cout << "x=" << x0 << endl;
				return;
		}
		m=(dy/dx);
		c=y0-m*x0;
		if(m==0)
				cout << "y=" << c << endl;
		else if(m==1&&c==0)
				cout << "y=x" <<endl;
		else if(m==1&&c>0)
				cout << "y=x+" << c <<endl;
		else if(m==1&&c<0)
				cout << "y=x" << c <<endl;
		else if(m!=0&&c==0)
				cout << "y=" << m << "x" <<endl;
		else if(m!=0&&c>0)
				cout << "y=" << m << "x+" << c <<endl;
		else if(m!=0&&c<0)
				cout << "y=" << m << "x" << c <<endl;
}
std::istream&operator>>(std::istream&is,Line2&l2){
		double a,b,c,d;
		is>>a>>b>>c>>d;
		l2=Line2(a,b,c,d);
		return is;
}
/////////////         Circle       /////////////
Circle::Circle(){
		cx=0.0,cy=0.0,r=1;
}
Circle::Circle(double a,double b,double c){
		cx=a;
		cy=b;
		r=c;
}
void Circle::radius(){
		cout << "The radius is : " << r << endl;
}
void Circle::set_center(double new_x ,double new_y){
		cx=new_x;
		cy=new_y;
}
void Circle::is_inside(double a ,double b){
		if((a-cx)*(a-cx)+(b-cy)*(b-cy)>r*r)
				cout << "No!" << endl;
		else 
				cout << "Yes!"<< endl;
}
void Circle::printfc(){
		if(r==0)
				cout << " It's a point(" << cx << "," << cy << "),not a circle" << endl ;
		else if(cx==0&&cy==0)
				cout << "x^2+y^2=" << r*r <<endl;
		else if(cx==0&&cy>0)
				cout << "x^2+(y-" << cy << ")^2=" << r*r <<endl;
		else if(cx==0&&cy<0)
				cout << "x^2+(y+" << (-cy) << ")^2=" << r*r <<endl;
		else if(cx>0&&cy==0)
				cout << "(x-" << cx << ")^2+y^2=" << r*r <<endl;
		else if(cx<0&&cy==0)
				cout << "(x+" << (-cx) << ")^2+y^2=" << r*r <<endl;
		else if(cx>0&&cy>0)
				cout << "(x-" << cx << ")^2+(y-" << cy << ")^2=" << r*r <<endl;
		else if(cx<0&&cy<0)
				cout << "(x+" << (-cx) << ")^2+(y+" << (-cy) << ")^2=" << r*r <<endl;
		else if(cx>0&&cy<0)
				cout << "(x-" << cx << ")^2+(y+" << (-cy) << ")^2=" << r*r <<endl;
		else if(cx<0&&cy>0)
				cout << "(x+" << (-cx) << ")^2+(y-" << cy << ")^2=" << r*r <<endl;
}
double Circle::get_radius(){
		return r;
}
std::istream&operator>>(std::istream&is,Circle&c){
		double a,b,r;
		is>>a>>b>>r;
		c=Circle(a,b,r);
		return is;
}
///////////////           Circle2       ///////////////////
Circle2::Circle2(){
		x0=0.0,y0=0.0,x1=1.0,y1=1.0;
}
Circle2::Circle2(double a,double b,double c,double d){
		x0=a;
		y0=b;
		x1=c;
		y1=d;
}
void Circle2::printfc2(){
		double cx,cy,r;
		cx=(x0+x1)/2;
		cy=(y0+y1)/2;
        r=sqrt((cx-x0)*(cx-x0)+(cy-y0)*(cy-y0));
         		if(r==0)
				cout << " It's a point(" << cx << "," << cy << "),not a circle" << endl ;
		else if(cx==0&&cy==0)
				cout << "x^2+y^2=" << r*r <<endl;
		else if(cx==0&&cy>0)
				cout << "x^2+(y-" << cy << ")^2=" << r*r <<endl;
		else if(cx==0&&cy<0)
				cout << "x^2+(y+" << (-cy) << ")^2=" << r*r <<endl;
		else if(cx>0&&cy==0)
				cout << "(x-" << cx << ")^2+y^2=" << r*r <<endl;
		else if(cx<0&&cy==0)
				cout << "(x+" << (-cx) << ")^2+y^2=" << r*r <<endl;
		else if(cx>0&&cy>0)
				cout << "(x-" << cx << ")^2+(y-" << cy << ")^2=" << r*r <<endl;
		else if(cx<0&&cy<0)
				cout << "(x+" << (-cx) << ")^2+(y+" << (-cy) << ")^2=" << r*r <<endl;
		else if(cx>0&&cy<0)
				cout << "(x-" << cx << ")^2+(y+" << (-cy) << ")^2=" << r*r <<endl;
		else if(cx<0&&cy>0)
				cout << "(x+" << (-cx) << ")^2+(y-" << cy << ")^2=" << r*r <<endl;

}
void Circle2::is_inside2(double a,double b){
		double cx,cy,r;
		cx=(x0+x1)/2;
		cy=(y0+y1)/2;
		if((a-cx)*(a-cx)+(b-cy)*(b-cy)>((cx-x0)*(cx-x0)+(cy-y0)*(cy-y0)))
				cout << "No!" << endl;
		else 
				cout << "Yes!"<< endl;

}
std::istream&operator>>(std::istream&is,Circle2&c2){
		double a,b,c,d;
		is>>a>>b>>c>>d;
		c2=Circle2(a,b,c,d);
		return is;
}
