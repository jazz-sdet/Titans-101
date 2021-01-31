package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HW3_4 {

    @Test
    public void lowTohigh() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

    }
}
