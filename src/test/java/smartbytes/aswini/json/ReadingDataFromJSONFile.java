package smartbytes.aswini.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;

import static io.restassured.path.json.JsonPath.*;

public class ReadingDataFromJSONFile {

	public static void main(String[] args) {
		
		File productFile = new File("./resources/products.json");
		
		List< Map<String,String> > productList= from(productFile).get("products");
		
		int totalProducts = productList.size();
		System.out.println("Total Products : " + totalProducts);
		for(Map<String,String> product :productList) {
			System.out.println(product.get("ProductId"));
		}
		
	}
}
