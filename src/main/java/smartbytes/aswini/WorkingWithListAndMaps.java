package smartbytes.aswini;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithListAndMaps {

	public static void main(String[] args) {
		List<String> fruitList = new ArrayList<String>();
		//add elements to list?
		fruitList.add("Apple");
		fruitList.add("Banana");
		fruitList.add("Grapes");
		
		System.out.println(fruitList.size());
		
		for(String fruitName : fruitList) {
			System.out.println(fruitName);
		}
	}
}
