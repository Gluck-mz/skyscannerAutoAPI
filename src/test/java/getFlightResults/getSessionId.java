package getFlightResults;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class getSessionId {

	@Test
	public void testResponsecode()
	{
		Response resp = get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/uk2/v1.0/ee9925d6-2327-4c60-ae5f-e6258f685b84");
		int code = resp.getStatusCode();
		System.out.println("Status code is "+code);
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void testBody()
	{
		Response resp = get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/uk2/v1.0/ee9925d6-2327-4c60-ae5f-e6258f685b84");
		String data = resp.asString();
		System.out.println("Data is "+data);
		System.out.println("Response time "+resp.getTime());
	}
	
}
