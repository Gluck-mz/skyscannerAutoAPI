package getFlightResults;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createSessionId {
	
	public String sessionId = "";
		
	public String returnSessionId()
	{
		/*RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8");*/
				
		RequestSpecification request = RestAssured.given();
		
		request
		.header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
		.header("x-rapidapi-key", "204b58b3d4msh2aacc77507c4458p1fb109jsn08b5fa93531a")
		.header("Content-Type", "application/x-www-form-urlencoded");
		
		request
		.formParam("inboundDate", "2020-07-20")
		.formParam("cabinClass", "business")
		.formParam("children", "0")
		.formParam("infants", "0")
		.formParam("country", "AU")
		.formParam("currency", "AUD")
		.formParam("locale", "en-AU")
		.formParam("originPlace", "MEL-sky")
		.formParam("destinationPlace", "SYD-sky")
		.formParam("outboundDate", "2020-06-20")
		.formParam("adults", "1");	
		
		Response response = request.request().post("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0");
		
		int code = response.getStatusCode();
		System.out.println("Status code is "+code);
		Assert.assertEquals(code, 201);
		String locationHeader = response.getHeader("Location");
		sessionId = locationHeader.substring(locationHeader.lastIndexOf('/') + 1);
		System.out.println("Session:" +sessionId);
		return sessionId;
	}
	
}
