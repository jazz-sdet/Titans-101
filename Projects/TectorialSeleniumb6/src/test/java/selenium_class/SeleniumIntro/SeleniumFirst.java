package selenium_class.SeleniumIntro;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFirst {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //WebDriver is an interface.We cannot instatiate te webdriver with new webdriver
        WebDriver driver=new ChromeDriver(); //object

        //GET METHOD -->NAVIGATE TO THE GIVEN URL
        //driver.get("https://www.google.com/");
        driver.navigate().to("https://www.google.com/");
        String googleTitle=driver.getTitle();
        System.out.println(googleTitle);

        driver.navigate().to("https://www.techtorialacademy.com/");
        String techtorialTitle=driver.getTitle();
        System.out.println(techtorialTitle);
        if(techtorialTitle.equals("Home Page - Techtorial")){
            System.out.println("Title is correct");
        }else{
            System.out.println("Title is wrong");
        }
        //GETTITLE METHOD-- GETS TITLE OF THE PAGE. IT RETURNS STRING VALUE

        //getcurrenturl
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);

        //System.out.println(driver.getPageSource());
        /* we have two ways of navigating to the page
        1-driver.get("url"); it waits until your page is loaded
        2-driver.navigate().to("url"); ->it will not wait whole page to load
         */

        driver.navigate().to("https://www.facebook.com/");

        driver.navigate().back();

        driver.navigate().forward();


    }
}
