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
		RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
			     .encoderConfig(EncoderConfig.encoderConfig()
			     .encodeContentTypeAs("x-www-form-urlencoded",
			     ContentType.URLENC)))
				.contentType("application/x-www-form-urlencoded; charset=UTF-8");
				
		request
		.header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
		.header("x-rapidapi-key", "cbba553789msh9398ee7c7cc7163p1cb8fajsn1d3dc0d1a3bf");
								
		request
		.formParam("inboundDate", "2020-04-20")
		.formParam("cabinClass", "business")
		.formParam("children", "0")
		.formParam("infants", "0")
		.formParam("country", "AU")
		.formParam("currency", "AUD")
		.formParam("locale", "en-AU")
		.formParam("originPlace", "MEL-sky")
		.formParam("destinationPlace", "SYD-sky")
		.formParam("outboundDate", "2020-03-20")
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
