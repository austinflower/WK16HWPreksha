package BestBuyApp.bestBuy3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class patchBestBuyApi3 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void patchuser(){
        String jsonData = "{\n" +
                "    \"name\": \"PrekshaP89298929\",\n" +
                "    \"type\": \"FreeStanding\",\n" +
                "    \"address\": \"1 Main ST\",\n" +
                "    \"address2\": \"\",\n" +
                "    \"city\": \"Dallas\",\n" +
                "    \"state\": \"TX\",\n" +
                "    \"zip\": \"75078\",\n" +
                "    \"lat\": 0,\n" +
                "    \"lng\": 0,\n" +
                "    \"hours\": \"M-S 9am - 5pm\",\n" +
                "    \"createdAt\": \"2023-12-27T22:00:06.377Z\",\n" +
                "    \"updatedAt\": \"2023-12-27T22:00:06.377Z\",\n" +
                "    \"services\": []\n" +"}";
        RestAssured.baseURI = "http://localhost:3030/stores/8929";
        requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonData);
        response = requestSpecification.patch();
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("name", equalTo("PrekshaP89298929"));

    }





}
