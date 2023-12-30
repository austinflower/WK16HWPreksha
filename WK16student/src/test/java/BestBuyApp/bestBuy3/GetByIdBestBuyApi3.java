package BestBuyApp.bestBuy3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetByIdBestBuyApi3 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void getbyid() {
        RestAssured.baseURI = "http://localhost:3030/stores/4";

        //create a request specification
        requestSpecification = RestAssured.given();

        //calling method
        response = requestSpecification.get();

        //print response
        System.out.println(response.prettyPrint());

        // Get status line
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        // Get status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }


}
