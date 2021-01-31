package selenium_class.SeleniumIntro;
import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
public class ScreenShot {
    WebDriver driver;

    @Test
    public void test1() throws IOException {
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.get("https://techtorialacademy.com");

      File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //FILE comes from java
        long timestamp=System.currentTimeMillis();
      File destinationFolder=new File("src/test/java/selenium_class.SeleniumIntro/firstScreenshot" + timestamp+ ".png");
        FileUtils.copyFile(screenshot, destinationFolder);
    }

    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("w"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(!result.isSuccess()){
            try{
            BrowserUtils.takeScreenShot(driver, result.getName());
                }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
