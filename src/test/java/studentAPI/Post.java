package studentAPI;

import io.restassured.RestAssured;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Post {
    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:3000";
         given()
                 .queryParam("")
                 .log()
                 .all()
                 .header("content-type","application/Json")
                 .body("{\n" +
                         "\"name\": \"Yam\",\n" +
                         "\"location\": \"wal\",\n" +
                         "\"phone\": \"5547744334\",\n" +
                         "\"courses\":[\"sql\",\"pl\"]}")
                 .when()
                 .post("students")
                 .then()
                 .log()
                 .all()
                 .assertThat()
                 .body("name",equalTo("Yam"))
                 .header("content-length","117");
       Assert.assertEquals("test" ,"testt");
    }
}
