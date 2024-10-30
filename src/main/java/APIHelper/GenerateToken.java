package APIHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
public class GenerateToken {

    public String accessToken(){

        RestAssured.baseURI= "https://nycdoedev2.service-now.com/oauth_token.do";
        RequestSpecification request = RestAssured.given();
        // Send a POST request to generate the access token
        Response response =request
                .header("Content-Type", "application/x-www-form-urlencoded") // Set the header
                .formParam("grant_type", "refresh_token") // Pass key-value pairs as form parameters
                .formParam("client_id", "4c112edaff36f050f73be45dd7e2b6fd")
                .formParam("client_secret", "}Y7CzQ#xf5") // OAuth grant type (e.g., client_credentials)
                .formParam("refresh_token", "34ZQQ_VnHrp_QB8CNoVbzGRuWQIXW88dTxfQQ8lFc2-Gz2U8Bd2_RUc8XwqYN2da9Wco9L5k_nk6o_OqeEGpdA")
                .when()
                .post() // API endpoint for generating access token
                .then()
                .extract().response();
        Object val = response.then().assertThat().extract().path("access_token");
        String token=val.toString();
//        System.out.println(val.toString());
        return token;

    }

}
