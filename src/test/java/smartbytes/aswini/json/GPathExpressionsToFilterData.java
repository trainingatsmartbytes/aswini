package smartbytes.aswini.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;

import static io.restassured.path.json.JsonPath.*;

public class GPathExpressionsToFilterData {

	public static void main(String[] args) {
		
        File productFile = new File("./resources/products.json"); // 700-750
		
	    String filter= " product-> (product.Price <700 && product.Price >750)";
		List< Map<String,String> > productList= from(productFile).
												get("products.findAll {" + filter + " }");
		
		int totalProducts = productList.size();

		System.out.println("Total Products : " + totalProducts);
//		for(Map<String,String> product :productList) {
//			System.out.println(product);
//		}
		filter =" product-> product.Description =~ /DDR3 RAM/ ";
		productList= from(productFile).
				get("products.findAll{ "+filter+" }");

totalProducts = productList.size();

System.out.println("Total Products : " + totalProducts);
		
	}
}
