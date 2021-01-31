package selenium_class.Syncronization;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitIntro {
    WebDriver driver;
    @BeforeMethod
    public void setup1(){
        driver= Driver.getDriver("chrome");
    }

    @Test
    public void test1(){

        WebDriverWait wait=new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));

    }
}
