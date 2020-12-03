package selenium_class.Sentrifugo;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
    //Here WebDriver will be initialized & call driver from this class
    // in order to avoid creating WebDriverManager.ChromeDriver().setup() in every class

   public WebDriver driver;

        @Parameters("driverName")
        @BeforeClass(alwaysRun = true)
        public void setUp(String driverName){

            driver= Driver.getDriver(driverName);
    }
}
