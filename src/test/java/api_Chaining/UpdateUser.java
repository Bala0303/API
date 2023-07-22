package api_Chaining;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    @Test
    void update_User(ITestContext context)
   // void test()
     {

       int id= (Integer) context.getAttribute("user_id");

        JSONObject data=new JSONObject();

       // data.put("name","India");
        data.put("tourist_location","India");
        System.out.println(id);
                Response res= given()
               .contentType("application/json")
               // .pathParam("id",0)
               .body(data.toString())
                .when()
                .put("http://restapi.adequateshop.com/api/Tourist/"+id);
        System.out.println(res.asString());
    }

}
