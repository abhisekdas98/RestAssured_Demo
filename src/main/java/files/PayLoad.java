package files;

public class PayLoad {

    public static String AddPayLoad()
    {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383495,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Abhisek house\",\n" +
                "  \"phone_number\": \"(+91) 883 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String UpdatePayLoad()
    {
        return "{\n" +
                "\"place_id\":\"bb4f4ef789d9e7117ffa651a056bc347\",\n" +
                "\"address\":\"70 winter1 walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }
}
