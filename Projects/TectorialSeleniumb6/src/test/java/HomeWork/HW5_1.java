package HomeWork;

import selenium_class.Sentrifugo.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HW5_1 extends TestBase {


    @Test
    public void test1() throws InterruptedException {
        SoftAssert softAssertion= new SoftAssert();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        WebElement blueCircle=driver.findElement(By.id("draggable"));
        Actions actions=new Actions(driver);
        actions.moveToElement(blueCircle).clickAndHold().moveByOffset(0, -30).perform();

        WebElement blue=driver.findElement(By.xpath("//div[@class='test1']"));
        String expBlueOutput="(Drop here)";
        String actualBlueOutput=blue.getText();
        softAssertion.assertEquals( actualBlueOutput,expBlueOutput);


        WebElement orange=driver.findElement(By.xpath("//div[@class='test2']"));
        String expOrangeOutput="(Drop here)";
        String actualOrangeOutput=orange.getText();
        softAssertion.assertEquals(actualOrangeOutput, expOrangeOutput);

        softAssertion.assertAll();




    }

}
