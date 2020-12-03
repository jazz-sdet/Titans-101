package SeleniumIntro.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleinumHW2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkAllButton=driver.findElement(By.id("check1"));
        System.out.println(checkAllButton.isDisplayed());
        System.out.println(checkAllButton.getAttribute("value").equals("Check All"));

        boolean selectBox;
        if(selectBox=true){
            driver.findElement(By.id("check1")).click();
        }

        System.out.println(checkAllButton.getAttribute("value").equals("Uncheck All"));


    }
}
