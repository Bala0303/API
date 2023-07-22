package studentAPIChaining;

import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    void get_User(ITestContext context){

     int id=(Integer) context.getAttribute("user_id");
      given()
                .pathParam("id",id)
                .when()
                .get("http://localhost:3000/students/{id}")
              .then().log().body();




    }
}
