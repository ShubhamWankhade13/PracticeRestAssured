package AllSession;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class PathAndQueryParameters {

	// https://reqres.in/api     /users               ?page=2
	// -------url-----------      Path param           Query Param
	@Test
	void test1() {
		
		given()
		.pathParam("mypath", "users")
		.queryParam("page", 2)
		.queryParam("id", 11)
		.header("x-api-key", "reqres-free-v1")
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
		.log().body();
	}
	
	@Test
	void test2() {
		
		//https://automationexercise.com/api/productsList
		//https://gorest.co.in/public/v2/users?page=1&per_page=20 
		
		given()
		.pathParams("mypath2", "users")
		.queryParam("page", 1)
		.queryParam("per_page", 20)
		
		.when()
		.get("https://gorest.co.in/public/v2/{mypath2}")
		
		.then()
		.log().body();
	}
	
}
