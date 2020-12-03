package Project5Nov9.Page;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver=Driver.getDriver("chrome");
    }
}
