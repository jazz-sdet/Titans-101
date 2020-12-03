package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("file:///Users/zhazgulkalimalieva/Desktop/HTML/Techtorial.html");

        WebElement submitButton=driver.findElement(By.id("submitbutton"));
        System.out.println(submitButton.getText());
        System.out.println(submitButton.getAttribute("value"));
        System.out.println(submitButton.getAttribute("type"));

        WebElement javaButton=driver.findElement(By.linkText("Java"));
        System.out.println(javaButton.getAttribute("href"));
        javaButton.click();
        WebElement nextPage=driver.findElement(By.tagName("button"));
        System.out.println(nextPage.getText());

        WebElement seleniumButton=driver.findElement(By.linkText("Selenium"));
        seleniumButton.click();

        WebElement cucumberButton=driver.findElement(By.linkText("Cucumber"));
        cucumberButton.click();

       // driver.close(); //closes tabs which the main driver is pointing
        driver.quit(); // it will close all the tabs which has opened using driver


    }
}
