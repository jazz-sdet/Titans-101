package api_class.restassured;
import Utils.PayloadUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_class.PageFact;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class APIassertSeleinumPost {
    WebDriver driver;
    PageFact pageFact;
    String slackMessage;

    @BeforeClass
    public void initialize() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pageFact = new PageFact(driver);
    }

    @Test
    public void apiPost() throws InterruptedException {

        RestAssured.baseURI = "https://slack.com/api/chat.postMessage";
        slackMessage = PayloadUtils.getSlackMessagePayload("some message 2");
        given().accept(ContentType.JSON).contentType(ContentType.JSON).auth().oauth2("xoxb-1265938717187-1552841584019-5RRWy3TMd86ukXjHRpMpKM6Q")
                .body(slackMessage)
                .when().post()
                .then().statusCode(200);

        seleniumValidation();

    }


    public void seleniumValidation() throws InterruptedException {

        driver.get("https://techtorialbatch6.slack.com/?redir=%2Fgantry%2Fclient");
        pageFact.email.sendKeys("kalimalieva@gmail.com");
        pageFact.password.sendKeys("928786Kg?");
        pageFact.loginButton.click();
        //a[text()='use Slack in your browser']
        Thread.sleep(7000);


        pageFact.browserContinue.click();

        pageFact = new PageFact(driver);
        pageFact.browserContinue.click();

        String windowHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
            if (!h.equals(windowHandle)) {
                driver.switchTo().window(h);
            }
        }

        pageFact = new PageFact(driver);
        Thread.sleep(1000);
        pageFact.apiChannel.click();
        Thread.sleep(3000);

        List<WebElement> messages = pageFact.allMessages;
        System.out.println(messages.size());

        System.out.println("my message"+slackMessage);

        List<String>ms=new ArrayList<>();

        Thread.sleep(3000);
        boolean isPosted = false;
        for (WebElement message : messages) {
            System.out.println(message.getText());
            ms.add(message.getText());
            if (ms.equals(slackMessage)) {
//            if (message.getText().equals(slackMessage)) {
                isPosted = true;
            }
        }

        Assert.assertTrue(ms.contains(slackMessage));

//            Assert.assertTrue(isPosted);


    }
}




