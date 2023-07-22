package api_Chaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    void create_User(ITestContext context){

        Faker faker=new Faker();

        JSONObject data=new JSONObject();
        data.put("tourist_name",faker.name().fullName());
        data.put("tourist_email",faker.internet().emailAddress());
        data.put("tourist_location",faker.address().country());


      int id=  given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://restapi.adequateshop.com/api/Tourist")
              .jsonPath()
              .getInt("id");

       context.setAttribute("user_id",id);

    }
}
