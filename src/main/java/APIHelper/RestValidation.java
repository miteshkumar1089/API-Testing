package APIHelper;

import io.restassured.response.Response;
import org.testng.Assert;

public class RestValidation {

    public static void validateStatusCode(Response response,int statusCode){

        int statusCodeResponse= response.getStatusCode();
        Assert.assertEquals(statusCodeResponse,statusCode);
    }

    public static void validateFields(Response response,String jsonPath, Object expectedValue){

        String actualValue = getValueFromResponseBody(response, jsonPath);
        System.out.println(actualValue);

        if (expectedValue instanceof String) {
            Assert.assertEquals(actualValue, expectedValue);
            //ReportLogger.info(jsonPath + " : " + actualValue);
        } else if (expectedValue instanceof Boolean) {
            Assert.assertEquals(Boolean.parseBoolean(actualValue), expectedValue);
            //ReportLogger.info(jsonPath + " : " + actualValue);
        } else if (expectedValue instanceof Integer) {
            Assert.assertEquals(Integer.parseInt(actualValue), expectedValue);
           // ReportLogger.info(jsonPath + " : " + actualValue);
        } else if (expectedValue instanceof Object) {
            Assert.assertEquals(actualValue, expectedValue);
           // ReportLogger.info(jsonPath + " : " + actualValue);
        } else {
            String nullValue = (String) expectedValue;
            Assert.assertEquals(actualValue, expectedValue);
            // ReportLogger.info(jsonPath + " : " + actualValue);
        }
    }

    public static String getValueFromResponseBody(Response response, String jsonPath) {
        Object value = response.then().assertThat().extract().path(jsonPath);
        if (value instanceof String) {
            return value.toString();
        } else if (value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof Integer) {
            return value.toString();
        } else {
            String nullValue = (String) value;
            return nullValue;
        }
    }
}
