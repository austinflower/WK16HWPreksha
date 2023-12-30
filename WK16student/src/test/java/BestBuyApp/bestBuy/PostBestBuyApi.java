package BestBuyApp.bestBuy;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostBestBuyApi {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void createUser(){
        String jsonData = "{\n" +
                "  \"name\": \"Preksha\",\n" +
                "  \"type\": \"FreeStanding\",\n" +
                "  \"address\": \"1 Main ST\",\n" +
                "  \"address2\": \"\",\n" +
                "  \"city\": \"Dallas\",\n" +
                "  \"state\": \"TX\",\n" +
                "  \"zip\": \"75078\",\n" +
                "  \"lat\": 0,\n" +
                "  \"lng\": 0,\n" +
                "  \"hours\": \"M-S 9am - 5pm\",\n" +
                "  \"services\": {}\n" +
                "}";
        validatableResponse =given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .post("http://localhost:3030/stores")
                .then()
                .statusCode(201)
                .body("name", equalTo("Preksha"));
        System.out.println(validatableResponse.extract().asPrettyString());


    }


}
