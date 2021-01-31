package HomeWork;

import com.sun.org.apache.xerces.internal.xs.StringList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW3_2 {
    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver drive = new ChromeDriver();

        drive.get("https://www.saucedemo.com/");
        WebElement userName = drive.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement passWord = drive.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        WebElement loginBtn = drive.findElement(By.id("login-button"));
        loginBtn.click();
        WebElement lowToHigh = drive.findElement(By.xpath("//select//option[@value='lohi']"));
        lowToHigh.click();
        String expected="Price (low to high)";
        Assert.assertEquals(lowToHigh.getText(), expected);

    }
}
