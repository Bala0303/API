package restAussured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.*;

public class Program1 {
    public static void main(String[] args) {
      //  https://reqres.in/api/users

     //   RequestSpecification reqSpec;
     //   Response res;
     RestAssured.baseURI="https://reqres.in/";
        RestAssured.useRelaxedHTTPSValidation();
 /*   given().header("Content-Type","application/json")
                .when()
                .get("api/users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().header("Content-Type","application/json; charset=utf-8");
*/

        Response response=given().log().all()
                .header("Content-Type","application/json")
                .param("page",2)
                .param("per_page",4)
                .when()
                .get("/api/users")
                .then()
                .extract().response();

        System.out.println("Response Value: "+response.asString());

        JsonPath path=new JsonPath(response.asString());

     int total_pages=path.get("total_pages");
       System.out.println("total_pages : "+total_pages);

      List list= path.get("data");

      System.out.println(list);

    }
}
