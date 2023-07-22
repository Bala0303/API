package Practice;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetandPOST {

    public static void main(String[] args) {
        GetandPOST g=new GetandPOST();
        g.getTest();
    }
    public void getTest(){
        //baseURI="http://localhost:3000";

        Faker f=new Faker();
        String a=f.animal().name();
        System.out.println(a);
       String name= f.name().firstName();
       System.out.println(name);

     String email=  f.internet().emailAddress();
      System.out.println(email);


  //    given().header("Authorization","Bearer 0eb9710905392519651140b645be4de41ddd8c1a267ea4c967e3f93650a7ea32").body("{\"name\":\"Chandrani Deshpande V\",\"email\":\"chandrani_v_deshpande@wehner-paucek.test\",\"gender\":\"male\",\"status\":\"inactive\"}")
  //            .when().post("https://gorest.co.in/public/v2/users").then().statusCode(200);     // given().get("http://localhost:3000/students").then().statusCode(200).body("students[1].name",equalTo("abd"));

      given().when().get("http://restapi.adequateshop.com/api/Tourist").then().log().all();

      Response res= given().when().get("http://restapi.adequateshop.com/api/Tourist");
        JSONObject js=new JSONObject(res.asString());

        System.out.println(js.getJSONArray("data").getJSONObject(0).get("tourist_name"));

        for(int i=0;i<js.getJSONArray("data").length();i++){

           String tour_name=  js.getJSONArray("data").getJSONObject(i).get("tourist_name").toString();
            String tourist_emai=  js.getJSONArray("data").getJSONObject(i).get("tourist_email").toString();
            String tourist_location=  js.getJSONArray("data").getJSONObject(i).get("tourist_location").toString();
            System.out.println(tour_name+"  "+tourist_emai+"  "+tourist_location);
        }
      // String s =res.asString();
       //System.out.println(s.contains("John1"));

      //  System.out.println();
    }
}
