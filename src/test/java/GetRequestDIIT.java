import API.POSTRequest;
import APIHelper.GenerateToken;
import APIHelper.Resources;
import APIHelper.RestValidation;
import BasePage.TestBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetRequestDIIT extends TestBase {

    PostRequestDIIT postRequestDIIT;
    POSTRequest postReq=new POSTRequest();
    String extendedURL;
    GenerateToken generateToken=new GenerateToken();
    @Test
    public void getRequest() throws JsonProcessingException {
        postRequestDIIT= new PostRequestDIIT();
        postRequestDIIT.Post();
        //data.token=generateToken.accessToken();
        System.out.println(data.incidentId);
        extendedURL= Resources.getRequest(data.incidentId);
        System.out.println(extendedURL);
        Response response = postReq.getRequest(extendedURL,data.token);
        //System.out.println(res.prettyPrint());
        RestValidation.validateStatusCode(response, 200);
        RestValidation.validateFields(response,"result.domain","diit");
    }
}
