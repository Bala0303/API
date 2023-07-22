package studentAPIChaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

@Test
    void create_User(ITestContext context){
        Faker faker=new Faker();

        JSONObject js=new JSONObject();

        js.put("name",faker.name().fullName());
        js.put("location",faker.address().country());
        String[] coursesArr={faker.gameOfThrones().character(),faker.gameOfThrones().character()};
        js.put("courses",coursesArr);

    int id=    given().
                contentType("application/json")
                .body(js.toString())
                .when()
                .post("http://localhost:3000/students").jsonPath().getInt("id");
    System.out.println(id);

    context.setAttribute("user_id",id);
    }
}
