package BestBuyApp.homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetStudentApi {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void getAllEmployees(){
        given().log().all()
                .when()
                .get("http://localhost:8080/student/list")
                .then().log().all()
                .statusCode(200);

    }
    @Test
    public void getAllEmployeesWay2(){
        RestAssured.baseURI = "http://localhost:8080/student/list";
        requestSpecification = RestAssured.given();
        response = requestSpecification.get();
        System.out.println(response.prettyPrint());
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
