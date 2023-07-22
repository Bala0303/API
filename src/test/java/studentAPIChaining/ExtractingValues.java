package studentAPIChaining;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ExtractingValues {
    @Test
    void extractName(){

        RestAssured.baseURI="http://localhost:3000/";

       Response res= given()
                .when()
                .get("students");

        try{

            JSONArray arr=new JSONArray(res.asString());
            for (int i=0;i<arr.length();i++){

                String name=(String) arr.getJSONObject(i).get("name");
                System.out.println(name);

            }

        }catch (JSONException j){
            System.out.println("not found");

        }


        /*String data1= arr.getJSONObject(1).toString();
        System.out.println(res.asString());
        System.out.println(data1);


        List data=res.jsonPath().getList("$");

        for(Object obj:data){
            obj.

        }
*/
    }
}
