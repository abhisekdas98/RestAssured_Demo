package main;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Basics {
    public static void main(String args[])
    {
        RestAssured.baseURI="https://rahulshettyacademy.com";

        String response=given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(PayLoad.AddPayLoad())
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println(response);
        JsonPath js=new JsonPath(response);

       String placeid= js.getString("place_id");
       System.out.println(placeid);

    }
}
