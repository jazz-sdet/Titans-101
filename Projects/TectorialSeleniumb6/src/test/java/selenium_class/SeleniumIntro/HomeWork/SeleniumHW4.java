package selenium_class.SeleniumIntro.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<WebElement> productName=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        String names[]={"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"};
        ArrayList<String> str=new ArrayList<String>(Arrays.asList(names));
        System.out.println(str);


        for(WebElement prodName: productName) {
            System.out.println(prodName.getText());
            for(String s: str){

            }
        }
    }
}
