package selenium_class.SeleniumIntro.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MentoringPrac {
    public static void main(String[] args) {
        System.setProperty("webdriver chrome.drive", "chromedriver");
        WebDriver drive=new ChromeDriver();
        drive.get("http://demo.guru99.com/test/ajax.html");
        List<WebElement> list=drive.findElements(By.xpath("//input[@name='name']"));
        for (int i=0; i<list.size();i++){
            if(list.get(i).getAttribute("value").equals("Yes"));
           list.get(i).click();
        }
    }
}
