package JsonPathParsing;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Program1 {
  //  @Test
  void testPath() {

      given().
              contentType("ContentType.JSON")
              .when().get("http://localhost:3000/store")
              .then().log().all().assertThat().body("book[3].title", equalTo("The Lord of the Rings"));


  }

    @Test(priority = 1)
    void testResponseUsingJsonObject() {

        Response res = given().
                when().get("http://localhost:3000/store");

        // System.out.println(res.asString());
String str="   {  \n" +
        "            \"author\":\"Evelyn Waugh\",\n" +
        "            \"category\":\"fiction\",\n" +
        "            \"price\":12.99,\n" +
        "            \"title\":\"Sword of Honour\"\n" +
        "         }";
        JSONObject obj = new JSONObject(res.asString());


        boolean status = false;
        for (int i = 0; i < obj.getJSONArray("book").length(); i++) {

            String names = obj.getJSONArray("book").getJSONObject(i).get("author").toString();


            if (names.equalsIgnoreCase("Herman Melville")) {
                System.out.println(names);
                status = true;
                break;
            }


        }
        Assert.assertEquals(status, true);
    }

    @Test(priority = 2)
    void testPriceAmount() {
        Response res = given().
                when().get("http://localhost:3000/store");

        // System.out.println(res.asString());

        JSONObject obj = new JSONObject(res.asString());

        double totalPrice = 0;
        for (int j = 0; j < obj.getJSONArray("book").length(); j++) {

            String price = obj.getJSONArray("book").getJSONObject(j).get("price").toString();

            totalPrice = totalPrice + Double.parseDouble(price);


        }
        System.out.println(totalPrice);
    }

    @Test(priority = 3)
    void testNameAndPrice(){
        Response res = given().
                when().get("http://localhost:3000/store");

        // System.out.println(res.asString());

         System.out.println("Status Code is : "+res.statusCode());
         System.out.println(res.contentType());
        JSONObject obj = new JSONObject(res.asString());
        for (int j = 0; j < obj.getJSONArray("book").length(); j++) {

            String price = obj.getJSONArray("book").getJSONObject(j).get("price").toString();

            String author = obj.getJSONArray("book").getJSONObject(j).get("author").toString();

            String category = obj.getJSONArray("book").getJSONObject(j).get("category").toString();
            String title = obj.getJSONArray("book").getJSONObject(j).get("title").toString();
          System.out.println("Name of the Book is "+title+" WrittenBY "+author+" Category is "+category+ " and price of the book is "+ price);
        }
    }
}
