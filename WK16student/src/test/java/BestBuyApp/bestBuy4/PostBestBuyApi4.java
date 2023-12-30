package BestBuyApp.bestBuy4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostBestBuyApi4 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void creatproduct(){
        String jsonData ="{\n" +
                "  \"name\": \"New Housewares\",\n" +
                "  \"type\": \"Microwave\",\n" +
                "  \"price\": 199.00,\n" +
                "  \"shipping\": 0,\n" +
                "  \"upc\": \"34343434\",\n" +
                "  \"description\": \"string\",\n" +
                "  \"manufacturer\": \"string\",\n" +
                "  \"model\": \"string\",\n" +
                "  \"url\": \"string\",\n" +
                "  \"image\": \"string\"\n" +
                "}";
        validatableResponse =given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .post("http://localhost:3030/products")
                .then()
                .statusCode(201)
                .body("name", equalTo("New Housewares"));
        System.out.println(validatableResponse.extract().asPrettyString());


    }



}
