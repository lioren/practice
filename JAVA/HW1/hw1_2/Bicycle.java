public class Bicycle implements CarbonFootprint{
	private static double FOOT_VALUE = 0.275 ;
		private String name;
		private double MIN;
		private double LONG_MIN;
		public 	Bicycle(String name , double MIN , double  LONG_MIN){
				setname(name);
				setMIN(MIN);
				setLONG_MIN(LONG_MIN);
		}
		public void setname(String name){
				this.name=name;
		}
		public void setMIN(double MIN){
				this.MIN=MIN;
		}
		public void setLONG_MIN(double LONG_MIN){
				this.LONG_MIN=LONG_MIN;
		}
		public String getname(){
				return name;
		}
		public double getMIN(){
				return MIN;
		}
		public double getLONG_MIN(){
				return LONG_MIN;
		}
		public double getCarbonFootprint(){
				return (FOOT_VALUE * getMIN() * getLONG_MIN());
		}
		public String toString(){
				StringBuilder string = new StringBuilder();
				string.append(getname());
				string.append("\nPerMinCost: " + getMIN() + " and TotalMin: " + getLONG_MIN()); 
				return string.toString();
		}
}
