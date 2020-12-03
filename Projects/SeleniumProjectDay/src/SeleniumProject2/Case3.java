package SeleniumProject2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case3 {
    public static void main(String[] args) {
        System.setProperty("webdriver chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        WebElement chicago=driver.findElement(By.id("sum1"));
        chicago.sendKeys("Chicago");
        WebElement illinois=driver.findElement(By.id("sum2"));
        illinois.sendKeys("Illinois");

        WebElement value=driver.findElement(By.xpath("//button[contains(@onclick, 'return')]"));
        value.click();

        WebElement total=driver.findElement(By.id("displayvalue"));
        System.out.println(total.getText().equals("NaN"));
    }
}
