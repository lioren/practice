import java.util.ArrayList;
public class HW1_2test{
		public static void main(String[] args){
				HW1_2test test= new HW1_2test();
				ArrayList<CarbonFootprint> array = new ArrayList<CarbonFootprint>();
				array.add(new Building("My house",100,3));
				array.add(new Car("Marry's car",2,100));
				array.add(new Bicycle("Tom's bike",3,200));

				for(CarbonFootprint current : array){
                        System.out.println(current.toString());
						System.out.println("The Carbon Foot is " + current.getCarbonFootprint());
				}
		}
}

