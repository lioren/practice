public class Car implements CarbonFootprint{
		private static double FOOT_VALUE = 0.785 ;
		private String name;
		private double OIL_PER_KM;
		private double TOTAL_KM;
		public Car(String name , double OIL_PER_KM , double  TOTAL_KM){
				setname(name);
				setOIL_PER_KM(OIL_PER_KM);
				setTOTAL_KM(TOTAL_KM);
		}
		public void setname(String name){
				this.name=name;
		}
		public void setOIL_PER_KM(double OIL_PER_KM){
				this.OIL_PER_KM=OIL_PER_KM;
		}
		public void setTOTAL_KM(double TOTAL_KM){
				this.TOTAL_KM=TOTAL_KM;
		}
		public String getname(){
				return name;
		}
		public double getOIL_PER_KM(){
				return OIL_PER_KM;
		}
		public double getTOTAL_KM(){
				return TOTAL_KM;
		}
		public double getCarbonFootprint(){
				return (FOOT_VALUE * getOIL_PER_KM() * getTOTAL_KM());
		}
		public String toString(){
				StringBuilder string = new StringBuilder();
				string.append(getname());
				string.append("\nOilPerKM: " + getOIL_PER_KM() + " and TotalKM: " + getTOTAL_KM()); 
				return string.toString();
		}
}
