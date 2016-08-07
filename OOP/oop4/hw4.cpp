#include<iostream>
#include<vector>
#include<algorithm>
#include<fstream>
#include<sys/time.h>
#include"hw4.h"
using namespace std;
bool cmp(Point,Point);
double cross(Point,Point,Point);
Point::Point(){
		x=0;
		y=0;
}
Point::Point(double a,double b){
		x=a;
		y=b;
}
Point::Point(const Point &p){
		x=p.x;
		y=p.y;
}
void Point::findhull(vector<Point> point,int num){
		int i,com,buf ;
		struct timeval start;
		struct timeval end;
		unsigned long diff;
        ofstream  fout("Output.txt"); 
		Point circle[50000];
		Point inside[50000];
		gettimeofday(&start,NULL);
		sort(point.begin(),point.end(),cmp);
		int j,m=0,in=0;
		for(i=0;i<num;i++){
				while(m>=2 && cross(circle[m-2],circle[m-1],point[i])<=0){
						m--;
				}
						circle[m++]=point[i];
		}
		for(i=num-1,j=m+1;i>=0;i--){
				while(m>=j && cross(circle[m-2],circle[m-1],point[i])<=0){
						m--;
				}
						circle[m++]=point[i];
		}
		gettimeofday(&end,NULL);
		diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
		cout << "cost time is " << diff << endl;
		for(i=0;i<num;i++){
				for(j=0;j<m;j++){
						if(point[i]==circle[j]){
							 com=1;
							 break;
						}
					    else com=0;
				}
				if(com==0)
						inside[in++]=point[i];
		}
        fout << in << endl;
        vector<Point> px;
        vector<Point> one;
        vector<Point> py;
        vector<Point> two;
        vector<Point> nx;
        vector<Point> three;
        vector<Point> ny;
        vector<Point> four;
        for(i=in-1;i>=0;i--){
        		if(inside[i].getx()==0&&inside[i].gety()==0)
        				fout << inside[i].getx() << " " << inside[i].gety() << endl;
        		else if((inside[i].getx()>0)&&(inside[i].gety()==0))
        				px.push_back(inside[i]);
        		else if((inside[i].getx()>0)&&(inside[i].gety()>0))
        				one.push_back(inside[i]);
        		else if((inside[i].getx()==0)&&(inside[i].gety()>0))
        				py.push_back(inside[i]);
        		else if((inside[i].getx()<0)&&(inside[i].gety()>0))
        				two.push_back(inside[i]);
        		else if((inside[i].getx()<0)&&(inside[i].gety()==0))
        				nx.push_back(inside[i]);
        		else if((inside[i].getx()<0)&&(inside[i].gety()<0))
        			    three.push_back(inside[i]);
        		else if((inside[i].getx()==0)&&(inside[i].gety()<0))
        			    ny.push_back(inside[i]);
        		else if((inside[i].getx()>0)&&(inside[i].gety()<0))
        				four.push_back(inside[i]);
		}
		vector<Point>::iterator iter;
		for((iter=px.begin());iter!=px.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=one.begin());iter!=one.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=py.begin());iter!=py.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=two.begin());iter!=two.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=nx.begin());iter!=nx.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=three.begin());iter!=three.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=ny.begin());iter!=ny.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=four.begin());iter!=four.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
        fout << endl << endl << m-1 << endl; 
         
        if(circle[0].getx()>0 && circle[0].gety()>0){
        		com=0;
        		for(i=1;i<m;i++)
        				if(circle[i].getx()<=0 && circle[i].gety()<=0){
        						com=0;
        					  break;
						}
        				else   com=1; 
		}
	    else if(circle[0].getx()<0 && circle[0].gety()<0){
	    		com=0;
        		for(i=1;i<m;i++)
        				if(circle[i].getx()<=0 && circle[i].gety()<=0){
        						com=0;
        					  break;
						}
        				else   com=1; 
		}
	    else if(circle[0].getx()>0 && circle[0].gety()>0){
	    		com=0;
        		for(i=1;i<m;i++)
        				if(circle[i].getx()<=0 && circle[i].gety()<=0){
        						com=0;
        					  break;
						}
        				else   com=1; 
		}
	    else if(circle[0].getx()>0 && circle[0].gety()>0){
	    		com=0;
        		for(i=1;i<m;i++)
        				if(circle[i].getx()<=0 && circle[i].gety()<=0){
        						com=0;
        					  break;
						}
        				else   com=1; 
		}
		else 
				com=0;
		if(com==1){
		for(i=0;i<m-1;i++)
				fout << circle[i].getx() << " " << circle[i].gety() << endl;
		}
		else if(com==0){
		//		i =0;
		//				while(circle[i].getx()>=0&&circle[i].gety()>=0)
		//						i++;
		//				while(circle[i].getx()<=0&&circle[i].gety()>=0)
		//						i++;
		//				while(circle[i].getx()<=0&&circle[i].gety()<=0)
		//						i++;
		//				while(circle[i].getx()>=0&&circle[i].gety()<0)
		//						i++;
		//						buf=i;
		//						for(i;i<m-1;i++)
		//						fout << circle[i].getx() << " " << circle[i].gety() << endl;
		//						for(i=0;i<buf;i++)
		//						fout << circle[i].getx() << " " << circle[i].gety() << endl;
		          for(i=0;i<m-1;i++)
		          		  fout << circle[i].getx() << " " << circle[i].gety() << endl;
		}
	
}
void Point::setx(double a){
		x=a;
}
void Point::sety(double a){
		y=a;
}
double Point::getx(){
		return x;
}
double Point::gety(){
		return y;
}
Line::Line(){
		a=0;
		b=0;
		c=0;
}
Line::Line(double x,double y,double z){
		a=x;
		b=y;
		c=z;
}
Line::Line(const Line&p){
		a=p.a;
		b=p.b;
		c=p.c;
}
void Line::findhull(vector<Point> point,int num)
{
        ofstream  fout("Output.txt"); 
		sort(point.begin(),point.end(),cmp);
        Point circle[50000];
        Point inside[50000];         
		struct timeval start;
		struct timeval end;
		unsigned long diff;
        int i=0,j=0,buf,now=0,com=0,buf2;
        //circle[now++]=point[0];
        //circle[now++]=point[1];
		gettimeofday(&start,NULL);
        for(i=0;i<num;i++){
        		com=0;
        		for(j=i;j<num;j++){
        				if(com==1)
        						break;
        				for(buf=0;buf<num;buf++){
        					if(cross(point[i],point[j],point[buf])>0){
        							com=1;
        			   			for(buf2=0;buf2<num;buf2++){
        			 				if(cross(point[i],point[j],point[buf2])<0){
        			 						com=0;
        			 						break;
									}
					    		}
					        	if(com==1){
                            	circle[now++]=point[i];
                            	break;
								}
							}
							else if(cross(point[i],point[j],point[buf])<0){
									com=1;
								for(buf2=0;buf2<num;buf2++){
								 	if(cross(point[i],point[j],point[buf2])>0){
								 		 	com=0;
											break;
								 	}
								}
								if(com==1){
                            	circle[now++]=point[i];
                            	break;
								}
							}
							else 
									continue; 
						}
					
				}
		}
		circle[now++]=point[num-1];
		gettimeofday(&end,NULL);
		diff=1000000*(end.tv_sec-start.tv_sec)+end.tv_usec-start.tv_usec;
		cout << "cost time is " << diff << endl;
        int in=0;
		for(i=0;i<num;i++){
				com=0;
				for(j=0;j<now;j++){
						if(point[i]==circle[j]){
							 com=1;
							 break;
						}
				}
				if(com==0)
						inside[in++]=point[i];
		}

//	    for(i=0;i<now;i++)
//	    		cout << circle[i].getx() << " " << circle[i].gety() << endl;
	     fout << in << endl;
        vector<Point> px;
        vector<Point> one;
        vector<Point> py;
        vector<Point> two;
        vector<Point> nx;
        vector<Point> three;
        vector<Point> ny;
        vector<Point> four;
        for(i=in-1;i>=0;i--){
        		if(inside[i].getx()==0&&inside[i].gety()==0)
        				fout << inside[i].getx() << " " << inside[i].gety() << endl;
        		else if((inside[i].getx()>0)&&(inside[i].gety()==0))
        				px.push_back(inside[i]);
        		else if((inside[i].getx()>0)&&(inside[i].gety()>0))
        				one.push_back(inside[i]);
        		else if((inside[i].getx()==0)&&(inside[i].gety()>0))
        				py.push_back(inside[i]);
        		else if((inside[i].getx()<0)&&(inside[i].gety()>0))
        				two.push_back(inside[i]);
        		else if((inside[i].getx()<0)&&(inside[i].gety()==0))
        				nx.push_back(inside[i]);
        		else if((inside[i].getx()<0)&&(inside[i].gety()<0))
        			    three.push_back(inside[i]);
        		else if((inside[i].getx()==0)&&(inside[i].gety()<0))
        			    ny.push_back(inside[i]);
        		else if((inside[i].getx()>0)&&(inside[i].gety()<0))
        				four.push_back(inside[i]);
		}
		vector<Point>::iterator iter;
		for((iter=px.begin());iter!=px.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=one.begin());iter!=one.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=py.begin());iter!=py.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=two.begin());iter!=two.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=nx.begin());iter!=nx.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=three.begin());iter!=three.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=ny.begin());iter!=ny.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
		for((iter=four.begin());iter!=four.end();++iter)
				fout << (*iter).getx() << " " << (*iter).gety() << endl;
        fout << endl << endl;
                 int m=0;
                Point  circle2[50000];
        for(i=0;i<now;i++){
				while(m>=2 && cross(circle2[m-2],circle2[m-1],circle[i])<=0){
						m--;
				}
						circle2[m++]=circle[i];
		}
		for(i=now-1,j=m+1;i>=0;i--){
				while(m>=j && cross(circle2[m-2],circle2[m-1],circle[i])<=0){
						m--;
				}
						circle2[m++]=circle[i];
		}
               fout << m-1 << endl;
		for(i=0;i<m-1;i++)
				fout << circle2[i].getx() << " " << circle2[i].gety() << endl;


}
bool Line::sameside(Point x,Point y,Point z)
{

}
bool  cmp(Point a,Point b)
{
		if((a.getx())!=(b.getx()))
				return (a.getx()>b.getx()); 
        return 
                (a.gety())<(b.gety());
}
double cross(Point o,Point a,Point b)
{
		return ((a.getx()-o.getx())*(b.gety()-o.gety())-(a.gety()-o.gety())*(b.getx()-o.getx()));
}
