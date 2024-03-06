import java.util.ArrayList;
import java.util.Collections;

public class ArrayToArrayList {
		
		public static void main(String[] args) {
			
			String[] bands = {"Aerosmith", "Bon Jovi", "Guns & Roses", "Fleetwood Mac"};
			
			ArrayList<String> BandList = new ArrayList<String>();
			
			Collections.addAll(BandList, bands);
			
			System.out.println(BandList);
			
		}

}
