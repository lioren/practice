#include<iostream>
#include<string>
#include<vector>
#include<typeinfo>
#define pi 3.14159
using namespace std;

class Shape{
		private:
			string color;
		public:
			Shape(const string &a ){ 
					color=a;
			}
			virtual void print(){
					cout << color;
			}
		    virtual double get_area()=0;
};
class Circle : public Shape{
		private:
			int radius;
		public:
			Circle(string a,int b):Shape(a),radius(b){ 
			}
			void print(){
					 Shape::print(); 
					 cout << " " << "circle" << "," << "radius" << ": " << radius << "," << "area" << ": " << (*this).get_area() << endl;
			}
			double get_area(){
					return (radius*radius*pi);
			}
};
class Rectangle : public Shape{
		private:
			int height;
			int width;
		public:
			Rectangle(string a,int b,int c):Shape(a),height(b),width(c){ 
			}
			void print(){
					Shape::print(); 
					cout << " " << "rectangle" << "," << "height" << ": " << height << ", " << "width" << ": " << width << ", " << "area" << ": " << (*this).get_area() << endl;
			}
			double get_area(){
					return (height*width);
			}

};
class Triangle : public Shape{
		private:
			int height;
			int base;
		public:
			Triangle(string a,int b,int c):Shape(a),height(b),base(c){
			}
			void print(){
					Shape::print(); 
					cout << " " << "triangle" << "," << "height" << ": " << height << ", " << "base" << ": " << base << ", " << "area" << ": " << (*this).get_area() << endl;
			}
			double get_area(){
					return ((height*base)/2);
			}
};
int main(){
		vector<Shape*> list;
	    Circle* p1=new Circle("blue",3);
		list.push_back(p1);
        Rectangle* p2=new Rectangle("red",3,4);
        list.push_back(p2);
        Triangle* p3=new Triangle("yellow",4,5);
        list.push_back(p3);
        Circle* p4=new Circle("black",5);
        list.push_back(p4);
        Rectangle* p5=new Rectangle("white",12,15);
        list.push_back(p5);
        Triangle* p6=new Triangle("purple",12,15);
        list.push_back(p6);
        vector<Shape*>::iterator iter;
        for(iter=list.begin();iter!=list.end();++iter)
        		(**iter).print();
        cout << "---------------------" << endl;
        for(iter=list.begin();iter!=list.end();++iter){
        		string a=typeid(**iter).name();
        		a=a.assign(a,1,a.size());
        		if(a=="Circle"){
        				(**iter).print();
				}
		}
        for(iter=list.begin();iter!=list.end();++iter){
        		delete(*iter);
		}
		list.clear();
		cout << "---------------------" << endl;

		return 0;
}
