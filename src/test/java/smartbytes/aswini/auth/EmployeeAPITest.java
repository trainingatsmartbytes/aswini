package smartbytes.aswini.auth;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class EmployeeAPITest {
  @Test
  public void test_employee_list_with_valid_credentials() {
	  given().auth().preemptive().basic("admin","admin").
		log().
		all().
		get("http://localhost:9090/api/employee/list").
		then().
		statusCode(HttpStatus.SC_OK);
  }
  @Test
  public void test_employee_list_with_invalid_credentials() {
	  given().auth().preemptive().basic("admin","admin1").
		log().
		all().
		get("http://localhost:9090/api/employee/list").
		then().
		statusCode(HttpStatus.SC_OK);
  }
}
