package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskDrag_Drop {
    @Test
    public void taskA() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueCircle=driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(3000);
       // WebElement target = driver.findElement(By.xpath("//*[@id=\"droptarget\"]/div[2]"));
        WebElement orangeSq=driver.findElement(By.xpath("//div[@class='test2']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(blueCircle,orangeSq).perform();

        orangeSq=driver.findElement(By.xpath("//div[@class='test2']"));
        String actuualText=orangeSq.getText();
        String expText="You did great!";
        Assert.assertEquals(actuualText,expText);


    }
}
