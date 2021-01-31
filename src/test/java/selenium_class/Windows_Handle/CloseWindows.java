package selenium_class.Windows_Handle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseWindows {
    @Test
    public void closedWindowsValidate(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.popuptest.com/popuptest1.html");
        String parentWinId=driver.getWindowHandle();

        BrowserUtils.closeWindows(driver, parentWinId);

        System.out.println(driver.getCurrentUrl());
    }

}
