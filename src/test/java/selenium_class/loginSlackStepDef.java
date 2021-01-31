package selenium_class;
import Utils.PayloadUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.awt.*;

import java.util.Set;

import static io.restassured.RestAssured.given;

public class loginSlackStepDef {

WebDriver driver;
PageFact pageFact;
    String slackMessage;

    @BeforeClass
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        pageFact=new PageFact(driver);

    }

    @Test
    public void login() throws InterruptedException, AWTException {
        driver.get("https://techtorialbatch6.slack.com/?redir=%2Fgantry%2Fclient");
       pageFact.email.sendKeys("kalimalieva@gmail.com");
        pageFact.password.sendKeys("928786Kg?");
        pageFact.loginButton.click();
        //a[text()='use Slack in your browser']
        Thread.sleep(7000);


        pageFact.browserContinue.click();

        pageFact =new PageFact(driver);
        pageFact.browserContinue.click();

        String windowHandle=driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();
        for(String h: handles){
            if(!h.equals(windowHandle)){
                driver.switchTo().window(h);
            }
        }
        slackMessage="whoop whoop";
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(pageFact.apiChannel)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pageFact.messageField)).sendKeys(slackMessage);
        pageFact.sendMessage.click();

        //verifyUIMessage();



    }

    @Test
    public void apiUItest() throws InterruptedException {
        String slackMessage="Hi from Zhaz";
        String payload= PayloadUtils.getSlackMessagePayload(slackMessage);
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)
                .auth().oauth2("xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q")
                .when().post("https://slack.com/api/chat.postMessage")
                .then().statusCode(200);

        driver.get("https://techtorialbatch6.slack.com/?redir=%2Fgantry%2Fclient");
        pageFact.email.sendKeys("kalimalieva@gmail.com");
        pageFact.password.sendKeys("928786Kg?");
        pageFact.loginButton.click();
        //a[text()='use Slack in your browser']
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until((ExpectedConditions.visibilityOf(pageFact.browserContinue))).click();
         pageFact =new PageFact(driver);
    }
    private void verifyUIMessage(){
        PageFact pageFact=new PageFact(driver);
        boolean isMessageSent=false;
        for(WebElement message: pageFact.apiChannelMessageList){
            if(message.getText().equals(slackMessage)){
                isMessageSent=true;
            }
        }
        Assert.assertTrue(isMessageSent);
    }
}
