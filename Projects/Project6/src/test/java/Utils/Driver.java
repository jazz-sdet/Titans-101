package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {

    private static WebDriver driver; //instance variable

    private Driver() {
    } //constructor

    public static WebDriver getDriver(String driverName) {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId()==null) { //if there is no driver
            switch (driverName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

            }
        }

        driver.manage().window().maximize();

        return driver;
    }

}
