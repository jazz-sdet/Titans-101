package HomeWork;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class nov8thHW {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver("chrome");
    }

    @DataProvider(name = "data")
    public Object[][]getD(){
        return new Object[][]{
                {"admin", "Admin123"}
        };
    }


        @Test(dataProvider = "data")
    public void test(String username, String password) throws InterruptedException {

        driver.get("https://demo.openmrs.org/openmrs/login.htm");
            WebElement usernameField=driver.findElement(By.cssSelector("#username"));
            usernameField.sendKeys(username);
            WebElement passwordField=driver.findElement(By.id("password"));
            passwordField.sendKeys(password);
            driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("loginButton")).click();
            WebElement messageAssertion=driver.findElement(By.xpath("//h4[contains(text(),'Logged in as Super User (admin) at Inpatient Ward.')]"));
            String actual=messageAssertion.getText();
            String expected="Logged in as Super User (admin) at Inpatient Ward.";
            Assert.assertEquals(actual, expected);


        }

}
