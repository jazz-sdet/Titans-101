package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class HW3_3 {
    @Test
    public void functionalityAcceptance() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        WebElement openMenu = driver.findElement(By.xpath("//button[.='Open Menu']"));
        openMenu.click();
        Thread.sleep(1000);
        WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
        logOut.click();
    }

    }


