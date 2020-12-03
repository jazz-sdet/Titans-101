package stepDefs;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import utils.Driver;
public class TestBase {


        //Here WebDriver will be initialized & call driver from this class
        // in order to avoid creating WebDriverManager.ChromeDriver().setup() in every class

        public WebDriver driver;

        @BeforeClass
        public void setUp(){

            driver= Driver.getDriver("chrome");
        }
    }


