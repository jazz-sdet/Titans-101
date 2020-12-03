package selenium_class.Sentrifugo.Tests;
import Utils.Driver;
import org.openqa.selenium.WebDriver;
import selenium_class.Sentrifugo.Pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest  {
    //class    variable name
    LoginPage loginPage;
    WebDriver driver= Driver.getDriver("chrome");
    @BeforeClass (alwaysRun = true)
    public void setUpPage() {
        loginPage = new LoginPage(driver); //has to be initialized first, coming from TestBAse class
        System.out.println("pageHW");

    }


    @Parameters({"userName", "password"})
    @Test(priority = 4)
    public void loginTest1( String userName, String password) {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login(userName, password);
        Assert.assertEquals(driver.getCurrentUrl(), "http://demo.sentrifugo.com/index.php/index/welcome");
        //System.out.println(driver.getTitle());


        //while implementing the selenium code
        //1. Create page class (Do Not Forget to create constructor, PageFActory.initElement()
        //2. We use TestBAse class to initialize our webdriver
        //3. Inside Test case create an object in BeforeClass for Pages and extend the Test class with TestBase class

     // if more than one value {} has to be provided


    }
      @Test(priority = 1)
       public void negativeTest() {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("test", "Sentrifugo");
        String actualErrorMessage = loginPage.errorMessage.getText().trim();
        String expectedErrorMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }
    @Test(priority = 2)
    public void negativeTest2() {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM01", "test");
        String actualErrorMessage = loginPage.errorMessage.getText().trim();
        String expectedErrorMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


    }
    @Test(priority = 3)
    public void negativeTest3() {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("test", "test");
        String actualErrorMessage = loginPage.errorMessage.getText().trim();
        String expectedErrorMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}
