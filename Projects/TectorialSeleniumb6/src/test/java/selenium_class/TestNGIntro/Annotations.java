package selenium_class.TestNGIntro;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Annotations {

    @Test
    public void testA(){
        System.out.println("Test annotation 1");
        String expectedTitle="Techtorial";

        Assert.assertEquals("Tech", expectedTitle);
        //Hard Assertion - if assert fails,the code will stop running & next line will not get executed
        System.out.println("some text");//wont be executed since upper line failed
    }

    @Test
    public void testB(){
        System.out.println("Test annotation 2");
        String expectedURL="www.google.com";
        String actualUrl="www.google.com";

        Assert.assertTrue(expectedURL.equals(actualUrl));

    }


}
