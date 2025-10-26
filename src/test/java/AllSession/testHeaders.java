package AllSession;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class testHeaders {
	
	//@Test
	void test1() {
		
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1");
		
		
	}
	
	@Test
	void test2() {
		
		Response res =given()
		
		.when()
		.get("https://www.google.com/");
		
		//String value=res.header("Content-Type");
		//System.out.println(value);
		
	Headers value	= res.getHeaders();
	
	for(Header hd:value) {
		System.out.println(hd.getName()+"  "+hd.getValue());
	};
	
	}

}
