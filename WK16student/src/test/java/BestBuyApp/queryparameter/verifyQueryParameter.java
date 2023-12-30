package BestBuyApp.queryparameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class verifyQueryParameter {
    @Test
    public void verifyUser(){
        String baseUrl = "http://localhost:8080/student";
        String endPoint = "/users";

        //given
        given().log().all()
                .baseUri(baseUrl)
                .queryParam("page", "2")

                //Then
                .when()
                .get(endPoint)
                .then().log().all()

                //To verify the response body
                .statusCode(200)
                .body("page", equalTo(2))
                .body("per_page", equalTo(6))
                .body("total_pages", equalTo(2))
                .body("data[1].first_name", equalTo("Lindsay"));


    }




}
