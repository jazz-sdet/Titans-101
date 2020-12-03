package SeleniumIntro.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class SeleniumHW4 {
    public static void main(String[] args) {
        System.setProperty("webdriver chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement userName=driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement clickLogin=driver.findElement(By.id("login-button"));
        clickLogin.click();
        System.out.println(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));





    }
}
