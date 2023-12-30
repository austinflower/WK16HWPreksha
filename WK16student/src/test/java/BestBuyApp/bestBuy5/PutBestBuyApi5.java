package BestBuyApp.bestBuy5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutBestBuyApi5 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void putproduct(){
        String jsonData = "{\n" +
                "  \"name\": \"New tips for use a Phone\"\n" +
                "}";
        given()
                .baseUri("http://localhost:3030")
                .contentType(ContentType.JSON)
                .body(jsonData)
                .put("/services/23")
                .then().statusCode(200).body("name", equalTo("New tips for use a Phone"));
        System.out.println();


    }


}
