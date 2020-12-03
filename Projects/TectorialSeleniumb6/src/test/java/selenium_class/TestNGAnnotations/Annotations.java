package selenium_class.TestNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.*;

public class Annotations {

    @Test(priority = 1, enabled = false)
    public void test1(){
        System.out.println("Test annotation 1");
    }
    @Test (priority = 0)
    public void test2(){
        System.out.println("Test annotation 2");
    }

    @Test (dependsOnMethods = "test4")
    public void test3(){
        System.out.println("Test annotation 3");
    }
    @Test
    public void test4(){
        System.out.println("Test annotation 4");
        Assert.assertTrue(false);
    }



    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method annotation");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method annotation");
    }

    @BeforeClass
    public void beforeClassAnnotation(){
        System.out.println("Before class annotation");
    }

    @AfterClass
    public void afterClassAnnotation(){
        System.out.println("After class annotation");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test annotation");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite annotation");
    }

    @BeforeSuite //cant use priority
    public void beforeSuite1(){
        System.out.println("Before Suite 1 annotation");
    }
}
