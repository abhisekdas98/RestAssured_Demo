package main;

import files.PayLoad;
import files.ReUsableMethod;
import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DynamicJson {

    @Test
    public void addBook()
    {
        RestAssured.baseURI="http://216.10.245.166/";
        String response=given().header("Content-Type","application/json").
                body(PayLoad.addBook("adsfc","2345")).log().all().
                when().post("/Library/Addbook.php").then().log().all().statusCode(200).extract()
                .response().asString();
        JsonPath js= ReUsableMethod.rawToJson(response);

        String id=js.get("ID");

        System.out.println(id);

    }
}

