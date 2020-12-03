package SeleniumIntro.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW3_2 {
    public static void main(String[] args) {
        System.setProperty("webdriver chrome.driver", "chromedriver");
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

    }
}
