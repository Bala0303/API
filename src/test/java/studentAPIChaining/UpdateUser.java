package studentAPIChaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    @Test
    void update_User(ITestContext context){
        Faker faker=new Faker();

        JSONObject js=new JSONObject();

        js.put("name",faker.name().fullName());
        js.put("location",faker.address().country());
        String[] coursesArr={faker.gameOfThrones().character(),faker.gameOfThrones().character()};
        js.put("courses",coursesArr);

       int id= (Integer) context.getAttribute("user_id");
        given().pathParam("id",id)
                .body(js.toString())
                .contentType("application/json")
                .when()
                .put("http://localhost:3000/students/{id}")
                .then().log().body();

    }
}
