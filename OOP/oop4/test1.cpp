#include<vector>
#include<iostream>
using namespace std;
class Point{
		public:
		Point(){
				x=1;
				y=2;
		}
		Point(double ix,double iy){
			    x=ix;
			    y=iy;
		}
		double getx(){
		       return x;
		}
		double gety(){
				return y;
		}
		private:
		double x;
		double y;
};
int main()
{	    
	    int i,x,y;
		vector<Point> point;
        for(i=0;i<5;i++){
        cin >> x >> y;
		Point dm(x,y);
		point.push_back(dm);
		}
        cout << point[3].getx() << endl;
		return 0;
}
