package SeleniumProject2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case2 {
    public static void main(String[] args) {

        System.setProperty("webdriver chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        WebElement a=driver.findElement(By.id("sum1"));
        a.sendKeys("12");
        WebElement b=driver.findElement(By.id("sum2"));
        b.sendKeys("17");
        WebElement totalButton=driver.findElement(By.xpath("//button[contains(@onclick,'return')]"));
        totalButton.click();

        WebElement displayValue = driver.findElement(By.id("displayvalue"));
        System.out.println(displayValue.getText().equals("29"));




    }
}
