package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class APITest {

    protected RequestSpecification requestSpecification;
    protected ResponseSpecification responseSpecification;
    protected Response response;

    public Response get(String url) {
        requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON).build();
        responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
        return given().spec(requestSpecification).when().get(url).then().spec(responseSpecification).extract().response();
    }
}
