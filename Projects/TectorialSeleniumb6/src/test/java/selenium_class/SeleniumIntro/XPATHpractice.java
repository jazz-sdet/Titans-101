package selenium_class.SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPATHpractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/zhazgulkalimalieva/Desktop/HTML/Techtorial.html");

       // WebElement register=driver.findElement(By.xpath("//a[starts-with(@href,'mercuryr')]);

    }
}
