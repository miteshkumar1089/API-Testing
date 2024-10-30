package APIHelper;

public class Resources {

    public static String postRequest(){
        return String.format("api/nycd3/data/ticket");
    }
    public static String getRequest(String incident){
        return String.format("api/nycd3/v1/data/tasks/" + incident + "?email=srishti.chandela@nagarro.com");
    }
}
