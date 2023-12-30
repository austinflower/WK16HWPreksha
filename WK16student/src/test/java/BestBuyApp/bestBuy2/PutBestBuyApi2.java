package BestBuyApp.bestBuy2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutBestBuyApi2 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void putproduct(){
        String jsonData = "{\n" +
                "  \"name\": \"New Bluegreen Pen- Updated\",\n" +
                "  \"type\": \"marker\",\n" +
                "  \"price\": 3.99,\n" +
                "  \"shipping\": 0,\n" +
                "  \"upc\": \"string\",\n" +
                "  \"description\": \"string\",\n" +
                "  \"manufacturer\": \"string\",\n" +
                "  \"model\": \"string\",\n" +
                "  \"url\": \"string\",\n" +
                "  \"image\": \"string\"\n" +
                "}";
        given()
                .baseUri("http://localhost:3030")
                .contentType(ContentType.JSON)
                .body(jsonData)
                .put("/products/9999679")
                .then().statusCode(200).body("name", equalTo("New Bluegreen Pen- Updated"));



    }


}
