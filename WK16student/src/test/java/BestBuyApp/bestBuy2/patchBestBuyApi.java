package BestBuyApp.bestBuy2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class patchBestBuyApi {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void patchproduct(){
        String jsonData = "{\n" +
                "  \"name\": \"New Blue Pen- Updated\",\n" +
                "  \"type\": \"pen\",\n" +
                "  \"price\": 1.99,\n" +
                "  \"shipping\": 0,\n" +
                "  \"upc\": \"string\",\n" +
                "  \"description\": \"string\",\n" +
                "  \"manufacturer\": \"string\",\n" +
                "  \"model\": \"string\",\n" +
                "  \"url\": \"string\",\n" +
                "  \"image\": \"string\"\n" +
                "}";
        RestAssured.baseURI = "http://localhost:3030/products/9999679";
        requestSpecification = given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonData);
        response = requestSpecification.patch();
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("name", equalTo("New Blue Pen- Updated"));

    }





}
