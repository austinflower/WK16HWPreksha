package RestfulBooker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class booking2 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    int mybookingid;
    String mytokenid;
    @Test
    public void agetallbooking(){
        given().log().all()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
        .then().log().all()
                .statusCode(200);
    }
    @Test
    public void bcreateBookingPost(){
        String jsonData = "{\n" +
                "    \"firstname\" : \"Preksha\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        validatableResponse = given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .body(jsonData)
                .when()
                .post()
                .then()
                .statusCode(200);
                //.body("firstname",equalTo("Preksha"));
        mybookingid = validatableResponse.extract().body().path("bookingid");
        System.out.println(validatableResponse.extract().asPrettyString());
        System.out.println(mybookingid);

    }@Test
    public void cgetBookingById(){
            given().log().all()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .pathParam("bookingid", mybookingid)
                    .when()
                    .get("/booking/{bookingid}")
                    .then();
    }
    @Test
    public void dcreatetoken() {
        String jsonData = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .statusCode(200);
        mytokenid = validatableResponse.extract().body().path("token");
        System.out.println(mytokenid);
    }

    @Test
    public void eupdatebookingPUT(){
        String jsonData ="{\n" +
                        "    \"firstname\": \"Preksha-Updated2\",\n" +
                        "    \"lastname\": \"Patel-Updated2\",\n" +
                        "    \"totalprice\": 111,\n" +
                        "    \"depositpaid\": true,\n" +
                        "    \"bookingdates\": {\n" +
                        "        \"checkin\": \"2018-01-01\",\n" +
                        "        \"checkout\": \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\": \"Breakfast\"\n" +
                        "}";
                given().log().all()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .contentType("application/json")
                        .cookie("token",mytokenid)
                        .pathParam("bookingid",mybookingid)
                        .when()
                        .body(jsonData)
                        .put("/booking/{bookingid}")
                        .then()
                        .statusCode(200)
                        .body("firstname",equalTo("Preksha-Updated2"));
    }
    @Test
    public void fpartialupdatebookingPATCH() {
        String jsonData ="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        given().log().all()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .accept("application/json")
                .cookie("token",mytokenid)
                .pathParam("bookingid", mybookingid)
                .when()
                .body(jsonData)
                .patch("/booking/{bookingid}")
                .then()
                .statusCode(200)
                .body("firstname", equalTo("James"));
    }
    @Test
    public void gdeleteBookingById() {
        given().log().all()
                .baseUri("https://restful-booker.herokuapp.com")
                .cookie("token",mytokenid)
                .pathParam("bookingid", mybookingid)
                .when()
                .delete("/booking/{bookingid}")
                .then()
                .statusCode(201);
    }
    @Test
    public void hgetBookingByIdVerifyDeleted() {
        given().log().all()
                .baseUri("https://restful-booker.herokuapp.com")
                .pathParam("bookingid", mybookingid)
                .when()
                .get("/booking/{bookingid}")
                .then()
                .statusCode(404);
    }



}




