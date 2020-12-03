package SeleniumProject2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case1 {

    public static void main(String[] args) {
        System.setProperty("webdriver chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        System.out.println(driver.getTitle().equals("Selenium Easy Demo - Simple Form to Automate using Selenium"));
        WebElement message= driver.findElement(By.id("user-message"));
        message.sendKeys("First Test Case");
        WebElement showMessageBtn = driver.findElement(By.xpath("//button[@onclick='showInput();']"));
        showMessageBtn.click();
        WebElement input = driver.findElement(By.xpath("//span[@id='display']"));
        System.out.println(input.getText().equals(message));


    }

}
