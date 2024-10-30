package APIHelper;

import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestUtils {
    public static Response postResponse(String payload, String extURL, String token){
        // Headers requestHeader =new Headers(headers);
        Response res= given().relaxedHTTPSValidation().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)// Set content type
                .body(payload) // Set request body
                .when()
                .post(extURL) // Specify the endpoint
                .then()
                .extract()
                .response();
        return res;
    }
    public static Response getResponse(String extURL, String token) {
        // Headers requestHeader =new Headers(headers);
        Response res = given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token) // Set content type
                .when()
                .get(extURL) // Specify the endpoint
                .then()
                .extract()
                .response();
        return res;
    }
}
