package selenium_class.Frames;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task1 {
    WebDriver driver;
    // @BeforeClass annotation will run before Test and BeforeMethod annotation inside the class

    @BeforeClass
    public void initializeDriver() {
        //System.setProperty("webdriver.chrome.driver", "locationOfDriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize(); //there is also full i gotta look at
    }
    @Test
    public void test1(){
        driver.get("https://skpatro.github.io/demo/iframes/");
        String idOfParentPage= driver.getWindowHandle();// to get main/parent page window id

        driver.switchTo().frame("Frame1");
        WebElement category1=driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();

        String newUrl="http://qavalidation.com/category/seleniumtesting/";
        BrowserUtils.switchByURL(driver, newUrl);
        System.out.println(driver.getTitle());


        //we r inside the main page
        BrowserUtils.switchByID(driver,idOfParentPage);//to be able to click another tag from main page
        driver.switchTo().defaultContent();
        //we need to switch to second frame
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click(); //it will open new window & we need to switch to new window after clicking category3 button

        BrowserUtils.switchByURL(driver,"http://qavalidation.com/category/softwaretesting/");
        System.out.println(driver.getCurrentUrl());




    }

}
