package main;

import files.PayLoad;
import files.ReUsableMethod;
import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class DynamicJson {

    @Test(dataProvider="BooksData")
    public void addBook(String isbn,String aisle)
    {
        /*
        we can also add json file through location of path of the json file provided by the developer
        PayLoad.addBook(new String(Files.readAllBytes(Paths.get("provide path of json payload file"))));
        */
        RestAssured.baseURI="http://216.10.245.166/";
        String response=given().header("Content-Type","application/json").
                body(PayLoad.addBook(isbn,aisle)).log().all().
                when().post("/Library/Addbook.php").then().log().all().statusCode(200).extract()
                .response().asString();
        JsonPath js= ReUsableMethod.rawToJson(response);

        String id=js.get("ID");

        System.out.println(id);

    }

    @DataProvider(name = "BooksData")
    public Object[][] getData()
    {
        return new Object[][]{{"ahz","456"},{"asdc","123"},{"ahashj","2844"}};
    }
}

