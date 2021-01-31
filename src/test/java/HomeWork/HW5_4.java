package HomeWork;
import Utils.DriverHW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class HW5_4 extends DriverHW {
    @Test
    public void test() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        //Thread.sleep(1000);
        //driver.findElement(By.xpath("//div[@id='closeBtn']")).click();

        WebElement firstFiveTh=driver.findElement(By.xpath("//a[@class='button button-orange'][contains(.,'-5000')][1]"));
        Actions actions=new Actions(driver);
        WebElement debitSide=driver.findElement(By.xpath("//table[@border='1']"));
        actions.clickAndHold(firstFiveTh).moveToElement(debitSide).perform();
        WebElement disp=driver.findElement(By.id("e1"));
        String actual=disp.getText();
        String exp="Please select another block";
        Assert.assertEquals(actual, exp);
        WebElement positiveFiveTh=driver.findElement(By.xpath("//div[@id='products']//li[2]//a"));



        actions.dragAndDrop(firstFiveTh, positiveFiveTh).release().perform();



        //WebElement display1=driver.findElement(By.xpath("//div[@class='e14']"));
//        softAssert.assertTrue(display1.getText().equals("Please select another block"));
//        softAssert.assertAll();
    }
}
