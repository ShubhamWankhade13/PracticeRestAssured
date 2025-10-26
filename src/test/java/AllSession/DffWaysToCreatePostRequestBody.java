package AllSession;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;


public class DffWaysToCreatePostRequestBody {
	
	
	//Post request using HashMap
	//@Test(priority=1)
	void testPostUsingHashMap() {
		
		HashMap data = new HashMap();
		data.put("name", "shubham");
		data.put("job", "Engineer");
		data.put("phone", "12345");
		
		String coursesArr[] = {"c","c++"};
		data.put("courses", coursesArr);
		
		
		given()
		.contentType("application/json")
		.body(data)
		.header("x-api-key", "reqres-free-v1")
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("shubham"))
		.body("job", equalTo("Engineer"))
		.body("phone", equalTo("12345"))
		.body("courses[0]", equalTo("c"))
		.body("courses[1]", equalTo("c++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	//@Test
	void testPostUsingJsonLibrary() {
		
		JSONObject data = new JSONObject();
		
		data.put("name", "shubham");
		data.put("job", "Engineer");
		data.put("phone", "12345");
		
		String coursesArr[] = {"c","c++"};
		data.put("courses", coursesArr);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.header("x-api-key", "reqres-free-v1")
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("shubham"))
		.body("job", equalTo("Engineer"))
		.body("phone", equalTo("12345"))
		.body("courses[0]", equalTo("c"))
		.body("courses[1]", equalTo("c++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	
	@Test
	void testPostUsingPojoClass() {
		
		PojoClass data = new PojoClass();
		data.setName("shubham");
		data.setJob("Engineer");
		data.setPhone("12345");
		
		String courseArr[]= {"c", "c++"};
		data.setCourses(courseArr);
		
		
		given()
		.contentType("application/json")
		.body(data)
		.header("x-api-key", "reqres-free-v1")
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("shubham"))
		.body("job", equalTo("Engineer"))
		.body("phone", equalTo("12345"))
		.body("courses[0]", equalTo("c"))
		.body("courses[1]", equalTo("c++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	
		
	}
	

}
