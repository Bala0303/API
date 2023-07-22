package studentAPIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    @Test
    void delete_User(ITestContext context){

        int id=(Integer) context.getAttribute("user_id");
        given()
                .pathParam("id",id)
                .when()
                .delete("http://localhost:3000/students/{id}");

    }}
