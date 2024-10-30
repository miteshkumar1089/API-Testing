package APIHelper;

import io.restassured.http.Header;

import java.util.ArrayList;
import java.util.List;

public class Headers {
    public static List<Header> getHeader(String token){
        ArrayList<Header> headerList = new ArrayList<>();
        headerList.add(new Header("Content-Type", "application/json"));
        headerList.add(new Header("Authorization", "Bearer " + token));
        return headerList;
    }
}
