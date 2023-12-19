package RestAssuredTest6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONObjectUsingJaksonAPI {

	@Test
	public void CreteUser() {
		
		//Create ObjectMapper class instance
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Create object node i.e json node
		ObjectNode userDetails = objectMapper.createObjectNode();
		
		userDetails.put("firstName", "Rohit");
		userDetails.put("lastName", "Sharma");
		userDetails.put("age", 28);
		userDetails.put("salary", 10000.56);
		userDetails.put("IsMarried", false);
		userDetails.set("Hobbies", objectMapper.convertValue(Arrays.asList("Cooking","Music"),JsonNode.class));
		
		ObjectNode techSkill = objectMapper.createObjectNode();
		techSkill.put("Programming language", "Java");
		techSkill.put("WebAutomation", "Selenium");
		techSkill.put("API testing", "Rest Assured");
		
		userDetails.set("TechSkill", techSkill);
		
		//print userDetails JSON Object
		try {
			String UserDetailsAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
			
			System.out.println("Created JSON Node is:" + UserDetailsAsString);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Retrive field value
		String firstName = userDetails.get("firstName").asText();
		System.out.println("Value of firstname field is :" + firstName);
		
		Boolean isMarried = userDetails.get("IsMarried").asBoolean();
		System.out.println("Value of IsMarried field is :" + isMarried);
		
		//retrive field value of webAutomation
		String webAutomation = userDetails.get("TechSkill").get("WebAutomation").asText();
		System.out.println("Value of webAutomation is :" + webAutomation);
		
		System.out.println("--------------------Print all field name---------------------\n");
		
		Iterator <String> fieldNameIterator = userDetails.fieldNames();
		
		while(fieldNameIterator.hasNext()) {
			
			System.out.println(fieldNameIterator.next());
		}
		
		System.out.println("--------------------Print all field values---------------------\n");

		Iterator <JsonNode> fieldValueIterator = userDetails.elements();

		while(fieldValueIterator.hasNext()) {

			System.out.println(fieldValueIterator.next());
		}
		 
		System.out.println("--------------------Print all field name and values---------------------\n");

		Iterator <Entry<String,JsonNode>> KeyValueEntries = userDetails.fields();

		while(KeyValueEntries.hasNext()) {

			Entry<String,JsonNode> node = KeyValueEntries.next();
			
			System.out.println("Key:" + node.getKey() + "," + "Value:" + node.getValue());
			
		}
		
		//Remove field "firstName" from json object or objectnode
		
		String removedValued = userDetails.remove("firstName").asText();
		System.out.println("Removed firstname value is:" + removedValued);
		
		//update json object or object node
		userDetails.put("lastName", "Gupta");
		
		techSkill.put("Programming language", "C#");
		userDetails.set("TechSkill", techSkill);
		
		//print userDetails JSON Object
		try {
			String UserDetailsAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);

			System.out.println("JSON Node After Remove method:" + UserDetailsAsString);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create request specification
		RequestSpecification reqSpec = RestAssured.given();

		//specify URL
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(userDetails);

		//perform post request
		Response response = reqSpec.post();
		
		System.out.println("-----------------------Print Http response body-------------------------");

		response.prettyPrint();

		//Validate the status code
		Assert.assertEquals(response.statusCode(), 201,"Check for status code");

	}
}
