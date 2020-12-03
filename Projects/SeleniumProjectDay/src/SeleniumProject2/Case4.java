package SeleniumProject2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case4 {
    public static void main(String[] args) {

        System.setProperty("webdriver chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkbox=driver.findElement(By.id("isAgeSelected"));
        checkbox.click();

        WebElement success=driver.findElement(By.id("txtAge"));
        System.out.println(success.getText().equals("Success - Check box is checked")+ " -it displays the success message");
        checkbox.click();
        System.out.println(success.isDisplayed()+ " -it DO NOT display success message");

    }
}
