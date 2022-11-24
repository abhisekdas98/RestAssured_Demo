package main;

import files.PayLoad;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String args[])
    {
        JsonPath js=new JsonPath(PayLoad.CoursePrices());

        //print the number of courses returned by API
        //.size() is used against array in json path to retrieve the size of array
        System.out.println(js.getInt("courses.size()"));

        //get the purchase amount
        int purchaseamount=js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseamount);

        //get the courses titles

        for(int i=0;i<3;i++)
        {
            System.out.print(js.getString("courses["+i+"].title")+" ");

            System.out.print(js.getString("courses["+i+"].price")+" ");
            System.out.println();
        }

        System.out.println("Find the copies of RPA title");

        for(int i=0;i<3;i++)
        {
            String str=js.getString("courses["+i+"].title");

            if(str.equalsIgnoreCase("RPA"))
            {
                System.out.println(js.getString("courses["+i+"].copies"));
            }


        }

        int sum=0;
        for(int i=0;i<3;i++) {
            int price = Integer.parseInt(js.getString("courses[" + i + "].price"));
            int copies = Integer.parseInt(js.getString("courses[" + i + "].copies"));

            sum += (price * copies);
        }

        if(sum==purchaseamount)
            System.out.println("SUm is equals to purchase amount");



    }
}
