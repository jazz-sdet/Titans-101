package SeleniumIntro.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumHM3 {
    public static void main(String[] args) {
        System.setProperty("webdriver chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();

       driver.get("https://www.saucedemo.com/");
        WebElement enterUserN=driver.findElement(By.id("user-name"));
        enterUserN.sendKeys("Java");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Selenium");
        WebElement loginB=driver.findElement(By.id("login-button"));
        loginB.click();
        boolean epicSadFace;
        if(epicSadFace=true){
            System.out.println("Epic sadface: Username and password do not match any user in this service");
        }else{
            System.out.println("Welcome back");
        }


    }
}
