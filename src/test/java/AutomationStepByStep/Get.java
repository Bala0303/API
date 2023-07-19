package AutomationStepByStep;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public   class Get {

    public static void main(String[] args) {
        Get g=new Get();
     //  g.getMethod();
g.get1Method();

    }
    void getMethod(){

        baseURI="http://localhost:3000/";
   // Response response=RestAssured.get("users?page=2");
       given().get("students").then().statusCode(200);
        Response response=get("http://localhost:3000/students");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("Content-Type"));
        System.out.println(response.time());
        System.out.println(response.getBody().asString());
    }

    void get1Method(){
        baseURI="http://localhost:3000/";
        given().get("students").then().statusCode(200).body("students[0].name",equalTo("centurion"));
    }
}
