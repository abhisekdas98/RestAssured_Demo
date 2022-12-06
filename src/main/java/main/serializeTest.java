package main;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import POJO.Location;
import POJO.Place;
import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

public class serializeTest {

    public static void main(String args[])
    {
        baseURI="https://rahulshettyacademy.com";
        Place p=new Place();
        Location location=new Location();
        List<String> ll=new LinkedList<>();
        ll.add("shoe park");
        ll.add("shop");
        location.setLat(-21.233);
        location.setLng(23.44);
        p.setAccuracy(54);
        p.setAddress("VIP prestige Appartment VIP Road puri");
        p.setLanguage("Odia");
        p.setLocation(location);
        p.setName("Abhisek Home");
        p.setPhone_number("+(91) 8328823423");
        p.setWebsite("www.abhisekdas98.com");
        p.setTypes(ll);
        Response res=given().queryParam("key","qaclick123").header("Content-Type","application/json")
            .body(p)
            .when().post("/maps/api/place/add/json")
            .then().log().all().assertThat().statusCode(200).extract().response();
        String responseString=res.asString();

        System.out.println(responseString);
    }
}

