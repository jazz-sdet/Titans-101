package HomeWork;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class now8HWnegativeTesting {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver("chrome");
    }
    @AfterMethod
    public void quitting(){
        driver.quit();
    }

    @DataProvider(name = "negativeData")
    public Object[][] data(){
        return new Object[][]{
                {"admin", "Admin124"},
                {"Aadmin", "Admin123"},
                {" ","Admin123" },
                {"admin", " "},
                {" ", " "},
                {"jhnsf", "...;0"}
        };
    }
            @Test(dataProvider = "negativeData")
            public void negativeTestin(String login, String password) throws InterruptedException {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        WebElement usernameField = driver.findElement(By.cssSelector("#username"));
        usernameField.sendKeys(login);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

                driver.findElement(By.id("loginButton")).click();
                Thread.sleep(1000);
                WebElement loginButtonErrorMess=driver.findElement(By.xpath("//span[@id='sessionLocationError']"));
              String expected="You must choose a location!";
                String actual=loginButtonErrorMess.getText();
               Assert.assertEquals(actual, expected);
    }
}
