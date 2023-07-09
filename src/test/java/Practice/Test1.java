package Practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test1 {
    public static void main(String[] args) {
        Test1 t=new Test1();
        //t.test();
        t.test3();
    }
  //  @Test
    public void test(){
        Response response= get("http://localhost:3000/students/1");
        System.out.println(  response.getStatusCode());
        System.out.println(  response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

      int statusCode=  response.getStatusCode();
      Assert.assertEquals(statusCode,200);

    }

  //  @Test(enabled = false)
    public void test2(){
        baseURI="https://reqres.in/api";
        given().get("/users?page=2")
                .then()
                .statusCode(200);
    }

    public void test3(){

        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().queryParam("key","qaclick123")
                .header("Content-Type","application/json;charset=UTF-8")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Bala\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"Tamil-IN\"\n" +
                        "}\n" +
                        " \n").when().post("maps/api/place/add/json").then().assertThat().statusCode(200);


    }
}
