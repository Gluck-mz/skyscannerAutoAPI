package getFlightResults;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getAndValidateFlightSearchResults {

	@Test
	public void testResponsecode()
	{
		createSessionId session = new createSessionId();
		String sessionId = session.returnSessionId();
		
		RequestSpecification request = RestAssured.given();
		request		
		.header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
		.header("x-rapidapi-key", "204b58b3d4msh2aacc77507c4458p1fb109jsn08b5fa93531a");
		
		Response response = request.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/uk2/v1.0/"+sessionId);
		
		int code = response.getStatusCode();
		System.out.println("Status code is "+code);
		Assert.assertEquals(code, 200);		
		System.out.println("Response time "+response.getTime());		
		
		response.prettyPrint();
		
		JsonPath extractor = response.jsonPath();		
		ArrayList<String> carriers = extractor.get("Carriers");
		
		for(String carrier : carriers) {
			System.out.println("Carriers between Sydney and Melbourne are: "+carrier);					
		}		
	}
	
	
}
