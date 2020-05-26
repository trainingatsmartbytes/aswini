package smartbytes.aswini;

import org.junit.Test;
import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import junit.framework.TestCase;

public class TestProductAPI extends TestCase{

	
	@Test
	public void test_create_product() {
		
Response productResp=
    given()
		.contentType(ContentType.XML)
		.body("<Product>\n" + 
				"  <description>Mackbook Pro</description>\n" + 
				"  <price>1500</price>\n" + 
				"  <productId>MBPRO-6373</productId>\n" + 
				"</Product>")
		.post("http://localhost:9090/api/product")
		.then()
		.statusCode(HttpStatus.SC_CREATED)
		.extract()
		.response();
     int productId = productResp.path("id");

     given()
     .contentType(ContentType.JSON)
     .pathParam("id", productId)
	 .get("http://localhost:9090/api/product/{id}")
	 .then()
	 .statusCode(HttpStatus.SC_OK)
	 .extract()
	 .response()
	 .prettyPrint();
	
	}
}
