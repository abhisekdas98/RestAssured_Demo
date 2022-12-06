package main;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import POJO.Location;
import POJO.Place;
import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
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

        RequestSpecification rq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON).build();

       RequestSpecification res1=given().spec(rq).body(p);

        ResponseSpecification respspec=new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();


        Response resp=res1.when().post("/maps/api/place/add/json").then().
                spec(respspec).extract().response();

        Response res=given().queryParam("key","qaclick123").header("Content-Type","application/json")
            .body(p)
            .when().post("/maps/api/place/add/json")
            .then().log().all().assertThat().statusCode(200).extract().response();
        String responseString=res.asString();

        System.out.println(responseString);

        System.out.println(resp.asString());
    }
}

