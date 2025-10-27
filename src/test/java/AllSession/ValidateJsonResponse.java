package AllSession;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ValidateJsonResponse {

	@Test
	void testJsonResponse() {
		
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("data[4].last_name", equalTo("Edwards"));
	}
	
	@Test
	void testJsonResponse2() {
		
		Response res=
		
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("https://reqres.in/api/users?page=2");
		
		Assert.assertEquals(res.getStatusCode(), 200);;
		
		JSONObject jo = new JSONObject(res.asString());
		//System.out.println(jo);
		
		for(int i=0; i<jo.getJSONArray("data").length();i++) {
			String emails=jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(emails);
		}
		
	}
}
