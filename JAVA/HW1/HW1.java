class Point{
		private double x;
		private double y;
		Point(double x1,double y1){
				this.x=x1;
				this.y=y1;
		}
		public double GetX(){
				return x;
		}
		public double GetY(){
				return y;
		}
}
class Quadrilateral{
		private Point p1;
		private Point p2;
		private Point p3;
		private Point p4;
		public Quadrilateral(Point P1,Point P2,Point P3,Point P4){
				p1=P1;
				p2=P2;
				p3=P3;
				p4=P4;
		}
		public double area(){
				double a1=(p1.GetY()+p2.GetY())*(p1.GetX()-p2.GetX())/2.0;
				double a2=(p2.GetY()+p3.GetY())*(p2.GetX()-p3.GetX())/2.0;
				double a3=(p3.GetY()+p4.GetY())*(p3.GetX()-p4.GetX())/2.0;
				double a4=(p4.GetY()+p1.GetY())*(p4.GetX()-p1.GetX())/2.0;
                double total = a1+a2+a3+a4;
                if(total<0)total=total*(-1);
                return total;
		}
}
class Trapezoid extends Quadrilateral{
		private Point p1;
		private Point p2;
		private Point p3;
		private Point p4;
        public Trapezoid(Point P1,Point P2,Point P3,Point P4){
        		super(P1,P2,P3,P4);
      //  		if(P1.GetX()==P2.GetX())
				double m1=((P1.GetY()-P2.GetY())/(P1.GetX()-P2.GetX()));
				double m2=((P4.GetY()-P3.GetY())/(P4.GetX()-P3.GetX()));
				double m3=((P2.GetY()-P3.GetY())/(P2.GetX()-P3.GetX()));
				double m4=((P1.GetY()-P4.GetY())/(P1.GetX()-P4.GetX()));
                if((m1==m2)||(m3==m4)){
					p1=P1;
					p2=P2;
					p3=P3;
					p4=P4;
					double ans=this.area();
					System.out.println("Yes,this is Trapezoid and the area is: "+ans);
				}
				else{
					System.out.println("No,this is not Trapezoid");
				}
		
		}
/*		public double area(){
				double a1=(p1.GetY()+p2.GetY())*(p1.GetX()-p2.GetX())/2.0;
				double a2=(p2.GetY()+p3.GetY())*(p2.GetX()-p3.GetX())/2.0;
				double a3=(p3.GetY()+p4.GetY())*(p3.GetX()-p4.GetX())/2.0;
				double a4=(p4.GetY()+p1.GetY())*(p4.GetX()-p1.GetX())/2.0;
                double total = a1+a2+a3+a4;
                if(total<0)total=total*(-1);
                return total;
		}*/
}
class Parallelogram extends Trapezoid{		
		private Point p1;
		private Point p2;
		private Point p3;
		private Point p4;
        public Parallelogram(Point P1,Point P2,Point P3,Point P4){
        		super(P1,P2,P3,P4);

				double m1=((P1.GetY()-P2.GetY())/(P1.GetX()-P2.GetX()));
				double m2=((P4.GetY()-P3.GetY())/(P4.GetX()-P3.GetX()));
				double m3=((P2.GetY()-P3.GetY())/(P2.GetX()-P3.GetX()));
				double m4=((P1.GetY()-P4.GetY())/(P1.GetX()-P4.GetX()));
                if((m1==m2)&&(m3==m4)){
					p1=P1;
					p2=P2;
					p3=P3;
					p4=P4;
					double ans=this.area();
					System.out.println("Yes,this is Parallelogram and the area is: "+ans);
				}
				else{
					System.out.println("No,this is not Parallelogram");
				}
		
		}
	/*	public double area(){
				double a1=(p1.GetY()+p2.GetY())*(p1.GetX()-p2.GetX())/2.0;
				double a2=(p2.GetY()+p3.GetY())*(p2.GetX()-p3.GetX())/2.0;
				double a3=(p3.GetY()+p4.GetY())*(p3.GetX()-p4.GetX())/2.0;
				double a4=(p4.GetY()+p1.GetY())*(p4.GetX()-p1.GetX())/2.0;
                double total = a1+a2+a3+a4;
                if(total<0)total=total*(-1);
                return total;
		}*/

}
class Rectangle extends Parallelogram{		
		private Point p1;
		private Point p2;
		private Point p3;
		private Point p4;
        public Rectangle(Point P1,Point P2,Point P3,Point P4){
        		super(P1,P2,P3,P4);

				double m1=((P1.GetY()-P2.GetY())/(P1.GetX()-P2.GetX()));
				double m2=((P4.GetY()-P3.GetY())/(P4.GetX()-P3.GetX()));
				double m3=((P2.GetY()-P3.GetY())/(P2.GetX()-P3.GetX()));
				double m4=((P1.GetY()-P4.GetY())/(P1.GetX()-P4.GetX()));
                if((m1==m2)&&(m3==m4)){
                		if(((P1.GetX()==P2.GetX())&&(P2.GetY()==P3.GetY())&&(P3.GetX()==P4.GetX())&&(P4.GetY()==P1.GetY()))
                		||((P4.GetX()==P1.GetX())&&(P1.GetY()==P2.GetY())&&(P2.GetX()==P3.GetX())&&(P3.GetY()==P4.GetY()))){
							p1=P1;
							p2=P2;
							p3=P3;
							p4=P4;
							double ans=this.area();
							System.out.println("Yes,this is Rectangle and the area is: "+ans);
						}
						else System.out.println("No,this is not Rectangle");
				}
				else{
					System.out.println("No,this is not Rectangle");
				}
		
		}
	/*	public double area(){
				double a1=(p1.GetY()+p2.GetY())*(p1.GetX()-p2.GetX())/2.0;
				double a2=(p2.GetY()+p3.GetY())*(p2.GetX()-p3.GetX())/2.0;
				double a3=(p3.GetY()+p4.GetY())*(p3.GetX()-p4.GetX())/2.0;
				double a4=(p4.GetY()+p1.GetY())*(p4.GetX()-p1.GetX())/2.0;
                double total = a1+a2+a3+a4;
                if(total<0)total=total*(-1);
                return total;
		}*/

}
class Square extends Rectangle{
		private Point p1;
		private Point p2;
		private Point p3;
		private Point p4;
        public Square(Point P1,Point P2,Point P3,Point P4){
        		super(P1,P2,P3,P4);

				double m1=((P1.GetY()-P2.GetY())/(P1.GetX()-P2.GetX()));
				double m2=((P4.GetY()-P3.GetY())/(P4.GetX()-P3.GetX()));
				double m3=((P2.GetY()-P3.GetY())/(P2.GetX()-P3.GetX()));
				double m4=((P1.GetY()-P4.GetY())/(P1.GetX()-P4.GetX()));
                if((m1==m2)&&(m3==m4)){
                		if(((P1.GetX()==P2.GetX())&&(P2.GetY()==P3.GetY())&&(P3.GetX()==P4.GetX())&&(P4.GetY()==P1.GetY()))
                		||((P4.GetX()==P1.GetX())&&(P1.GetY()==P2.GetY())&&(P2.GetX()==P3.GetX())&&(P3.GetY()==P4.GetY())))
                		{
                				double a= (P1.GetX()-P2.GetX())*(P1.GetX()-P2.GetX())+(P1.GetY()-P2.GetY())*(P1.GetY()-P2.GetY());
                				double b= (P2.GetX()-P3.GetX())*(P2.GetX()-P3.GetX())+(P2.GetY()-P3.GetY())*(P2.GetY()-P3.GetY());
                				double c= (P3.GetX()-P4.GetX())*(P3.GetX()-P4.GetX())+(P3.GetY()-P4.GetY())*(P3.GetY()-P4.GetY());
                				double d= (P1.GetX()-P4.GetX())*(P1.GetX()-P4.GetX())+(P1.GetY()-P4.GetY())*(P1.GetY()-P4.GetY());
                				if((a==b)&&(b==c)&&(c==d)&&(d==a)){
									p1=P1;
									p2=P2;
									p3=P3;
									p4=P4;
									double ans=this.area();
									System.out.println("Yes,this is Square and the area is: "+ans);
								}
								else System.out.println("No,this is not Square");
						}
						else System.out.println("No,this is not Square");
				}
				else{
					System.out.println("No,this is not Square");
				}
		
		}
		/*public double area(){
				double a1=(p1.GetY()+p2.GetY())*(p1.GetX()-p2.GetX())/2.0;
				double a2=(p2.GetY()+p3.GetY())*(p2.GetX()-p3.GetX())/2.0;
				double a3=(p3.GetY()+p4.GetY())*(p3.GetX()-p4.GetX())/2.0;
				double a4=(p4.GetY()+p1.GetY())*(p4.GetX()-p1.GetX())/2.0;
                double total = a1+a2+a3+a4;
                if(total<0)total=total*(-1);
                return total;
		}*/
}
/*public class HW1{
		public static void main(String[] args){
				Point p1=new Point(0,0);
				Point p2=new Point(3,0);
				Point p3=new Point(3,2);
				Point p4=new Point(0,2);
				//Quadrilateral test1=new Trapezoid(p1,p2,p3,p4);
				Quadrilateral test2=new Square(p1,p2,p3,p4);
				//System.out.println("Hello world");
		}
}*/
