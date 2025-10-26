package AllSession;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Cookies {
	
	@Test
	void test1() {
		
		Response res =given()
		
		.when()
		.get("https://www.google.com/");
		
		//String cookie_value =res.cookie("AEC");
		//System.out.println(cookie_value);
		
		
		Map<String, String> cookies = res.cookies();
		
		for(String allCookies:cookies.keySet()) {
			String value=res.getCookie(allCookies);
			System.out.println(allCookies +"   :  "  + value);
		}
		
	}

}
