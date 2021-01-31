package selenium_class;
import Utils.BrowserUtils;
import Utils.JiraUtils;
import Utils.PayloadUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class JiraLoginFunc {
    WebDriver driver;
    JiraPage jiraPage;

    @BeforeClass
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jiraPage=new JiraPage(driver);

    }

    @Test
    public void loginToJira() throws InterruptedException {
        driver.get("http://localhost:8080");
        jiraPage.username.sendKeys("Jaz");
        jiraPage.password.sendKeys("928786Kg");
        jiraPage.login.click();

        Actions actions=new Actions(driver);

        Thread.sleep(3000);
        jiraPage.dashboard.click();
        Thread.sleep(2000);

        jiraPage.myBoard.click();

        Assert.assertTrue(jiraPage.title.getText().contains("TEC board"));
    }
    @Test
    public void APItest() throws InterruptedException {
        String summary="API: Create payment return wrong status V2";
        String description="AC: Fix status code to return 201";

        //create a new story via API
      Response response=given().accept(ContentType.JSON).contentType(ContentType.JSON).cookie("JSESSIONID", JiraUtils.getSessionId())
                .body(PayloadUtils.getJiraStoryPayload(summary,
                description, "Story"))
                .when().post("http://localhost:8080/rest/api/2/issue")
                .then().statusCode(201).log().all().extract().response();
      String storyKey=response.jsonPath().getString("key");

      //validate the story is created properly via UI
        driver.get("http://localhost:8080");
        jiraPage.username.sendKeys("Jaz");
        jiraPage.password.sendKeys("928786Kg");
        jiraPage.login.click();

        Actions actions=new Actions(driver);

        Thread.sleep(3000);
        jiraPage.dashboard.click();
        Thread.sleep(2000);

        jiraPage.myBoard.click();



        //Assert.assertTrue(jiraPage.title.getText().contains("TEC board"));
        Thread.sleep(2000);
        jiraPage.backlogBTN.click();
        Thread.sleep(2000);
        WebElement userStory=driver.findElement(By.xpath("//*[@title='"+storyKey+"']"));
                                                            ////a[@title='TEC-9']

        actions.keyDown(userStory, Keys.COMMAND).click().perform();

        BrowserUtils.switchByID(driver, driver.getWindowHandle());
        Thread.sleep(2000);
        WebElement summaryE=driver.findElement(By.id("summary-val"));
        System.out.println("Summary: "+summaryE.getText());

        WebElement descriptionE=driver.findElement(By.xpath("//div[@class='user-content-block']/p"));

        Assert.assertEquals(summary, summaryE.getText());
        Assert.assertEquals(description, descriptionE.getText());

    }

    @Test
    public void uiBugCreation() throws InterruptedException {
        driver.get("http://localhost:8080");
        jiraPage.username.sendKeys("Jaz");
        jiraPage.password.sendKeys("928786Kg");
        jiraPage.login.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(jiraPage.backlogBTN)).click();
       // jiraPage.backlogBTN.click();

//        WebElement myBoard = driver.findElement(By.id("rapidb_lnk_1_lnk"));
//        myBoard.click();
//        WebElement backlog = driver.findElement(By.xpath("//span[@class='aui-icon aui-icon-large agile-icon-plan aui-iconfont-backlog']"));
//        backlog.click();
        WebElement createButton = driver.findElement(By.id("create_link"));
        createButton.click();
        WebElement issueTypeField = driver.findElement(By.id("issuetype-field"));
        issueTypeField.click();
        issueTypeField.sendKeys("Bug", Keys.ENTER);

        WebElement summaryField = driver.findElement(By.id("summary"));
        String summary = "UI: Create a bug from UI. V3";
        String description = "AC: fix summary and description";
        wait.until(ExpectedConditions.visibilityOf(summaryField)).sendKeys(summary);
        driver.switchTo().frame("mce_7_ifr");
        WebElement descrBody = driver.findElement(By.id("tinymce"));
        descrBody.click();
        descrBody.sendKeys(description);
        driver.switchTo().defaultContent();
        WebElement createIssueButton = driver.findElement(By.id("create-issue-submit"));
        createIssueButton.click();
    }
    }

