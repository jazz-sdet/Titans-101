package selenium_class.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Practice {
    @Test
    public void test1(){
        //it will only effect current test annotation
        Assert.assertEquals(3,5);
        System.out.println("Hard assert test");
    }
    @Test
    public void test2(){
        Assert.assertEquals(5,5);
        System.out.println("After assert 1");
        Assert.assertEquals(3,5);
        System.out.println("After assert 2");
        Assert.assertEquals(6,6);
        System.out.println("After assert 3");
    }

    @Test
    public void test3(){
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(5,5);
        System.out.println("After soft assert 1");
        softAssert.assertEquals(3,5);
        System.out.println("After soft assert 2");
        softAssert.assertEquals(6,6);
        System.out.println("After soft assert 3");

        //when you do more than one assertion inside one test case, it will be better to use soft assertion
      softAssert.assertAll(); //until assertAll, all assertion will be executed on this page

        System.out.println("Test Assert All");

    }

    @Test
    public void loginTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passWord=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        Assert.assertTrue(userName.isDisplayed());
        userName.sendKeys("standard_user");

        Assert.assertTrue(passWord.isDisplayed());
        passWord.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String expTitle="Swag Labs";

        Assert.assertEquals(expTitle, driver.getTitle());

    }
}


