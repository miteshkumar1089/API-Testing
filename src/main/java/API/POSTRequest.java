package API;

import APIHelper.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class POSTRequest {

    public Response postCreateRequest(String payload, String extendedURL, String token){
        RestAssured.baseURI= "https://nycdoedev2.service-now.com/";
        return RestUtils.postResponse(payload, extendedURL, token);
    }
    public Response getRequest(String extendedURL, String token){
        RestAssured.baseURI= "https://nycdoedev2.service-now.com/";
        return RestUtils.getResponse(extendedURL, token);
    }
}
