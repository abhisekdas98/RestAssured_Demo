package main;

import files.PayLoad;
import files.ReUsableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Basics {
    public static void main(String args[])
    {
        RestAssured.baseURI="https://rahulshettyacademy.com";

        //If you encounter noClassDefFound error then some jar is missing

        // ADD Place
        String response=given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(PayLoad.AddPayLoad())
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println(response);
      //  JsonPath js=new JsonPath(response);
         JsonPath js=ReUsableMethod.rawToJson(response);
       String placeid= js.getString("place_id");
       System.out.println(placeid);

       //Update Place
        String newaddress="Summer walk , Africa";

     String updateresponse= given().log().all().queryParam("place_id",placeid).
             queryParam("key","qaclick123").
                header("Content-Type","application/json").
                body("{\n" +
                        "\"place_id\":\""+placeid+"\",\n" +
                        "\"address\":\""+newaddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("/maps/api/place/update/json").
                then().log().all().assertThat().statusCode(200)
             .body("msg",equalTo("Address successfully updated")).extract().response().asString();

        System.out.println(updateresponse);

        //Get Place API

        String getresponse = given().log().all().queryParam("key","qaclick123")
                .queryParam("place_id",placeid).header("Content-Type","application/json")
                .when().get("/maps/api/place/get/json").
                then().log().all().assertThat().statusCode(200)
                .body("location.latitude",equalTo("-38.383495")).extract().response().asString();
        
        System.out.println(getresponse);

      //  JsonPath js1=new JsonPath(getresponse);
        JsonPath js1= ReUsableMethod.rawToJson(getresponse);
        String actualaddress=js1.getString("address");

        //cucumber junit testNG
        Assert.assertEquals(actualaddress,newaddress);








    }
}
