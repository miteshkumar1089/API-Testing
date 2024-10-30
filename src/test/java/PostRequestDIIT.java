import API.POSTRequest;
import APIHelper.GenerateToken;
import APIHelper.Headers;
import APIHelper.Resources;
import APIHelper.RestValidation;
import BasePage.TestBase;
import Payload.payloads;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

public class PostRequestDIIT extends TestBase {
   // GenerateToken generateToken=new GenerateToken();
    payloads requestBody=new payloads();
    String extendedURL;
    String finalPayload="";

    POSTRequest postReq=new POSTRequest();
   // public List<Header> headers;
    @Test
    public void Post() throws JsonProcessingException {
        data.token=generateToken.accessToken();
        extendedURL= Resources.postRequest();
       // headers=Headers.getHeader(data.token);
        finalPayload=requestBody.createPayload();
        Response response = postReq.postCreateRequest(finalPayload,extendedURL,data.token);
        Object value = response.then().assertThat().extract().path("result.number");
        data.incidentId=value.toString();
        System.out.println(response.asString());
        RestValidation.validateStatusCode(response, 200);
        RestValidation.validateFields(response,"result.status_description","Record was created successfully");

    }
}
