package api_Chaining;

import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    void get_User(ITestContext context){

        int id= (Integer) context.getAttribute("user_id");

        System.out.println(id);
      Response res= given().
                pathParam("id",id)
                        .
                when()
                .get("http://restapi.adequateshop.com/api/Tourist/{id}");
      System.out.println(res.asString());
    }
}
