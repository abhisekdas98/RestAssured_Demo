package files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethod {

    public static JsonPath rawToJson(String str)
    {
        JsonPath js=new JsonPath(str);

        return js;
    }
}
