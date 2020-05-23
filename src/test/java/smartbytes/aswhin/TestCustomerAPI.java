package smartbytes.aswhin;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.apache.http.HttpStatus;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.TestCase;

public class TestCustomerAPI extends TestCase{

String requestBody = "{\n" + 
			"    \"firstName\": \"Smart\",\n" + 
			"    \"lastName\": \"Bytes\",\n" + 
			"    \"city\": \"New Orleans\",\n" + 
			"    \"county\": \"Orleans\",\n" + 
			"    \"state\": \"LA\",\n" + 
			"    \"zip\": \"70117\",\n" + 
			"    \"phone1\": \"222-456-789\",\n" + 
			"    \"phone2\": \"333-456-789\",\n" + 
			"    \"email\": \"JamesBond@smartbytes.com\",\n" + 
			"    \"web\": \"http://v-logics.com\"\n" + 
			"}";

String createCustomerAPI = "http://localhost:9090/api/customer/add";
String updateCustomerAPI = "http://localhost:9090/api/customer/update/{customerId}";
String deleteCustomerAPI = "http://localhost:9090/api/customer/delete/{customerId}";
String readCustomerByIdAPI = "http://localhost:9090/api/customer/show";//requires id as query param

int customerId;

//public static void main(String[] args) {
//	TestCustomerAPI customerAPI = new TestCustomerAPI();
//	
//	customerAPI.test_create_customer();
//	customerAPI.test_read_customer();
//	customerAPI.test_update_customer();
//	customerAPI.test_delete_customer();
//	
//}
@Test()
public void test_create_customer() {
System.out.println("Started creating customer...");

Response createResponse=	given()
	.contentType("application/json")
	.body(requestBody)
	.post(createCustomerAPI)
	.then()
	.statusCode(HttpStatus.SC_CREATED)
	.contentType(ContentType.JSON)
	.body("id", greaterThan(0))
	.extract()
	.response();
  customerId = createResponse.path("id");
  
  System.out.println("Customer created with id :" + customerId);
  System.out.println(createResponse.path("firstName"));
  System.out.println(createResponse.path("lastName"));
  

}
@Test
public void test_update_customer() {
	System.out.println("Started updating customer...");
	given()
	.pathParam("customerId", customerId)
	.contentType("application/json")
	.body(requestBody)
	.put(updateCustomerAPI)
	.then()
	.statusCode(HttpStatus.SC_OK)
	.contentType(ContentType.JSON)
	.body("id", equalTo(customerId));
}
@Test
public void test_delete_customer() {
	System.out.println("Started deleting customer...");
	 given()
		.pathParam("customerId", customerId)
		.contentType("application/json")
		.delete(deleteCustomerAPI)
		.then()
		.statusCode(HttpStatus.SC_OK)
		.contentType(ContentType.JSON);
		
		//execute delete again, you should get 500 error code.
		given()
		.pathParam("customerId", customerId)
		.contentType("application/json")
		.delete(deleteCustomerAPI)
		.then()
		.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
}
@Test
public void test_read_customer() {
	given().
	queryParam("id", customerId).
	get("http://localhost:9090/api/customer/show").
	then().
	statusCode(415);
	
	given().
	contentType(ContentType.JSON).
	queryParam("id", customerId).
	get("http://localhost:9090/api/customer/show").
	then().
	statusCode(200).
	contentType(ContentType.JSON).
	body("firstName",equalTo("Smart")). 
	body("lastName",equalTo("Bytes")). 
	body("state",equalTo("LA"));
}

}
