public class Building implements CarbonFootprint{	
		private static double FOOT_VALUE = 0.785 ;
		private String name;
		private double ELEC;
		private double MON;
		public Building(String name , double ELEC ,double MON){
				setname(name);
				setELEC(ELEC);
				setMON(MON);
		}
		public void setname(String name){
				this.name=name;
		}
		public void setELEC(double ELEC){
				this.ELEC=ELEC;
		}
		public void setMON(double MON){
				this.MON=MON;
		}
		public String getname(){
				return name;
		}
		public double getELEC(){
				return ELEC;
		}
		public double getMON(){
				return MON;
		}
		public double getCarbonFootprint(){
				return (FOOT_VALUE * getELEC() * getMON());
		}
		public String toString(){
				StringBuilder string = new StringBuilder();
				string.append(getname());
				string.append("\nElecPerMon: " + getELEC() + " and TotalMon: " + getMON()); 
				return string.toString();
		}
}
