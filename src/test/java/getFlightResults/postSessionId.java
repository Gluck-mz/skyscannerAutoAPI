package getFlightResults;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postSessionId {
	
	@Test
	public void getId()
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
		request.header("x-rapidapi-key", "a001b04941mshb79f44a42b86760p160a7ajsn7cb9f3252176");
		
		JSONObject json = new JSONObject();
		json.put("inboundDate", "2020-04-20");
		json.put("cabinClass", "business");
		json.put("children", "0");
		json.put("infants", "0");
		json.put("country", "AU");
		json.put("currency", "AUD");
		json.put("locale", "en-AU");
		json.put("originPlace", "MEL-sky");
		json.put("destinationPlace", "SYD-sky");		
		json.put("inboundDate", "2020-03-20");
		json.put("adults", "1");
		
		request.body(json.toJSONString());
		Response response = request.post("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0");
		
		int code = response.getStatusCode();
		System.out.println("Status code is "+code);
		Assert.assertEquals(code, 201);
		String header = response.getHeader("Location");
		System.out.println("Session:" +header);
	}
	
}
