package selenium_class.headlessBrowser;
import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;
import java.io.IOException;
public class headlessPhantomJS {

    WebDriver driver;

    @Test
    public void phantomTest() throws IOException {
        WebDriverManager.phantomjs().setup();
        driver=new PhantomJSDriver();
        driver.get("https://techtorialacademy.com");
        BrowserUtils.takeScreenShot(driver, "phantom");
    }

}
