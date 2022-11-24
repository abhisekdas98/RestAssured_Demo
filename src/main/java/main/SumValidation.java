package main;

import files.PayLoad;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {

    @Test
    public void sumOfCourses()
    {
        int sum=0;
        JsonPath js=new JsonPath(PayLoad.CoursePrices());
        int purchaseamount=Integer.parseInt(js.getString("dashboard.purchaseAmount"));
        int count=Integer.parseInt(js.getString("courses.size()"));
        for(int i=0;i<3;i++) {
            int price = Integer.parseInt(js.getString("courses[" + i + "].price"));
            int copies = Integer.parseInt(js.getString("courses[" + i + "].copies"));

            sum += (price * copies);
        }

        Assert.assertEquals(sum,purchaseamount);


    }
}
