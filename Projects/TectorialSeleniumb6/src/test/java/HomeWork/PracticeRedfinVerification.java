package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PracticeRedfinVerification {
    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.redfin.com");
        WebElement input=driver.findElement(By.xpath("//*[@id=\"search-box-input\"]"));
        input.sendKeys("Naperville" + Keys.ENTER);

        Thread.sleep(1000);
        WebElement minDropButton=driver.findElement(By.name("quickMinPrice"));
        minDropButton.click();

        Select select=new Select(minDropButton);

        select.selectByIndex(0);

    }
}
