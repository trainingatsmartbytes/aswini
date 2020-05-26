package smartbytes.aswini.auth;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TestEmployeeAPIWithAuth {

	public static void main(String[] args) {
		given().auth().preemptive().basic("admin","admin").
		log().
		all().
		get("http://localhost:9090/api/employee/list").body().prettyPrint();
	}
}
