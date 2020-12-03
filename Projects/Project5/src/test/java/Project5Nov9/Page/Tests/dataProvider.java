package Project5Nov9.Page.Tests;

import org.testng.annotations.DataProvider;


public class dataProvider {


    @DataProvider(name ="Data")
    public static Object[][] getData(){
        return new Object[][]{
                {"200000", "Test1"}
                ,{"1000000", "Test2"}
                ,{"100", "Test3"}
                ,{"70", "Test4"}
                ,{"80", "Test5"}

        };
    }
}
