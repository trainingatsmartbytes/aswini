package smartbytes.aswini;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Test;

import io.restassured.response.Response;
import junit.framework.TestCase;
import smartbytes.aswini.util.APIUtil;

public class ComplexAssertions extends TestCase{

	@Test
	public void test_all_countries() {
		 Response  countryResponse = get("http://localhost:9090/api/country/country/get/all");
			
			given().
			get(APIUtil.ALL_COUNTRY_URI).
			then().
			statusCode(HttpStatus.SC_OK).
			body("RestResponse.result.size()", equalTo(249));

	}
	@Test
	public void test_products_list() {
		
	       File productFile = new File("./resources/products.json"); // 700-750
			
		    List< Map<String,String> > productList= from(productFile).
					get("products.findAll { product-> (product.Price >=700 && product.Price <=750) }");

		   assertEquals(1, productList.size());
	}

}
