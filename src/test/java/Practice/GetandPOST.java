package Practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetandPOST {

    public static void main(String[] args) {
        GetandPOST g=new GetandPOST();
        g.getTest();
    }
    public void getTest(){
        //baseURI="http://localhost:3000";

        given().get("http://localhost:3000/students").then().statusCode(200).body("students[1].name",equalTo("abd"));
    }
}
