package stepDef;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Case3StepsDef {

    WebDriver driver= Driver.getDriver("chrome");
    SoftAssert softAssert=new SoftAssert();

    @Given("user is logged in admin page")
    public void user_is_logged_in_admin_page() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();
        Thread.sleep(1000);
        WebElement adminFunc = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
        adminFunc.click();
    }

    @When("user searches for an existing user")
    public void user_searches_for_an_existing_user() throws InterruptedException {
      WebElement userSearch=driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']"));
      userSearch.sendKeys("dominic12");
      Thread.sleep(1000);
      driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
    }

    @Then("user validates the username, user role, name and status")
    public void user_validates_the_username_user_role_name_and_status() {

        WebElement userName=driver.findElement(By.xpath("//a[text()='dominic12']"));
        softAssert.assertEquals(userName.getText(), "dominic12");

        WebElement userrole=driver.findElement(By.xpath("//td[text()='Admin']"));
        softAssert.assertEquals(userrole.getText(), "Admin");

        WebElement employeeNAme=driver.findElement(By.xpath("//td[text()='Dominic Chase']"));
        softAssert.assertEquals(employeeNAme.getText(),"Dominic Chase" );

        WebElement status=driver.findElement(By.xpath("//td[text()='Disabled']"));
        softAssert.assertEquals(status.getText(), "Disabled");

    }


    @Given("user is on result page")
    public void user_is_on_result_page() throws InterruptedException {


        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

        WebElement adminFunc = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
        adminFunc.click();

        WebElement userSearch=driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']"));
        userSearch.sendKeys("dominic14");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
//        Thread.sleep(1000);

    }

    @When("user clicks on username")
    public void user_clicks_on_username() {
        WebElement userName=driver.findElement(By.xpath("//a[text()='dominic14']"));
        userName.click();



    }

    @When("user clicks on edit button")
    public void user_clicks_on_edit_button() {
        driver.findElement(By.xpath("//input[@value='Edit']")).click();
        WebElement selectStatus=driver.findElement(By.xpath("//select[@id='systemUser_status']"));

        Select select=new Select(selectStatus);
        select.selectByVisibleText("Enabled");

    }

    @Then("user validates {string} message")
    public void user_validates_message(String displays) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(1000);
        WebElement display=driver.findElement(By.xpath("//div[@class='message success fadable']"));
        System.out.println(display.getText());
        //String expectedOutput="Successfully Saved";
        Assert.assertEquals(display.getText(), displays);


    }

    @Given("user on successfully updated message page")
    public void user_on_successfully_updated_message_page() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();
        Thread.sleep(1000);
        WebElement adminFunc = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
        adminFunc.click();
    }

    @When("user searches with username")
    public void user_searches_with_username() throws InterruptedException {
        WebElement userSearch=driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']"));
        userSearch.sendKeys("dominic14");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
    }

    @Then("user validates if the status is updated")
    public void user_validates_if_the_status_is_updated() {
       WebElement statusUpdate=driver.findElement(By.xpath("//td[text()='Enabled']"));
       Assert.assertTrue(statusUpdate.getText().equals("Enabled"));
    }



}
