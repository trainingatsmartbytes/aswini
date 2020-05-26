package smartbytes.aswini.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;

import static io.restassured.path.json.JsonPath.*;

public class ReadCountryJSON {

	public static void main(String[] args) {
		
		File productFile = new File("./resources/countries.json");
		
		List< Map<String,String> > countryList= from(productFile).get("RestResponse.result");
		
		int totalCountries = countryList.size();
		System.out.println("Total Countries : " + totalCountries);
		for(Map<String,String> country :countryList) {
			System.out.println(country.get("name"));
		}
		
	}
}
