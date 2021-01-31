package selenium_class.SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");


    }
}
