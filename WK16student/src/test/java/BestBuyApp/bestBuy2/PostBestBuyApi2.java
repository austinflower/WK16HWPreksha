package BestBuyApp.bestBuy2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostBestBuyApi2 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void creatUser2(){
    String jsonData = "{\n" +
            "  \"name\": \"New REDRED Pen\",\n" +
            "  \"type\": \"pen\",\n" +
            "  \"price\": 1.99,\n" +
            "  \"shipping\": 0,\n" +
            "  \"upc\": \"34343434\",\n" +
            "  \"description\": \"string\",\n" +
            "  \"manufacturer\": \"string\",\n" +
            "  \"model\": \"string\",\n" +
            "  \"url\": \"string\",\n" +
            "  \"image\": \"string\"\n" +
            "}";
        // GIVEN
        validatableResponse = given()
                .baseUri("http://localhost:3030")
                .contentType(ContentType.JSON)
                .body(jsonData)

                // WHEN
                .when()
                .post("/products")

                // THEN
                .then()
                .statusCode(201)
                .body("name", equalTo("New REDRED Pen"));

        System.out.println(validatableResponse.extract().asPrettyString());
    }
    }


