package selenium_class.AlertPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertTest {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        softAssert=new SoftAssert();
    }

    @Test
    public void validateHtmlPopup() throws InterruptedException {
        driver.get("https://sweetalert.js.org/");
        WebElement htmlPreview=driver.findElement(By.xpath("//button[contains(@onclick, 'swal')]"));
        htmlPreview.click();
        Thread.sleep(1000);
        WebElement errorSym=driver.findElement(By.xpath("//div[@role='dialog']//div[contains(@class, 'swal-icon--error')]"));

        softAssert.assertTrue(errorSym.isDisplayed());

        WebElement swalTitle=driver.findElement(By.xpath("//div[@class='swal-title']"));
        String actualTitle= swalTitle.getText();
        String expectedTitle="Oops";
        softAssert.assertEquals(actualTitle,expectedTitle);

        WebElement swalText=driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualText=swalText.getText();
        String expectedText="Something went wrong!";

        softAssert.assertEquals(actualText,expectedText);

        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();

        softAssert.assertAll("HTML Popup Validation Message");
    }

    @Test
    public void validateJSalert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();

        Alert alert=driver.switchTo().alert();
        String actualMessage= alert.getText();
        String expectedMessage="I am a JS Alert";
        softAssert.assertEquals(actualMessage, expectedMessage);
        alert.accept();

        WebElement resultMessage=driver.findElement(By.id("result"));
        String actualResult=resultMessage.getText();
        String expectedResult="You successfuly clicked an alert";

        softAssert.assertEquals(actualMessage, expectedMessage);

        softAssert.assertAll("JS Alert Validation");
    }

    @Test
    public void validateJSPromt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPromptButton=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptButton.click();

        Alert alert=driver.switchTo().alert();

        String actualAlertText=alert.getText();
        String expectedAlertText="I am a JS prompt";

        softAssert.assertEquals(actualAlertText,expectedAlertText);

        alert.sendKeys("Techtorial");

        alert.accept();

        WebElement result=driver.findElement(By.id("result"));
        String actualResult=result.getText();
        String expectedResult="You entered: Techtorial";

        softAssert.assertEquals(actualResult,expectedResult);

        softAssert.assertAll("Validate of JS Prompt");

    }
    @Test
    public void validateJSDismiss(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPromptButton=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptButton.click();

        Alert alert=driver.switchTo().alert();

        String actualAlertText=alert.getText();
        String expectedAlertText="I am a JS prompt";

        softAssert.assertEquals(actualAlertText,expectedAlertText);

        alert.sendKeys("Techtorial");

        alert.dismiss(); //it clicks cancel button on js alert

        WebElement result=driver.findElement(By.id("result"));
        String actualResult=result.getText();
        String expectedResult="You entered: null";

        softAssert.assertEquals(actualResult,expectedResult);

        softAssert.assertAll("Validation of JS Prompt dismiss");






    }
}
