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
public class Case2SelectUser {
    WebDriver driver = Driver.getDriver("chrome");
    @Given("user was logged in as admin")
    public void user_was_logged_in_as_admin() throws InterruptedException {
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
    @When("admin clicks on add button and selects his\\/her role")
    public void admin_clicks_on_add_button_and_selects_his_her_role() {
        WebElement addButton=driver.findElement(By.xpath("//input[@id='btnAdd']"));
        addButton.click();
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='systemUser_userType']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Admin");
        ;
    }
    @When("admin selects employee name, enters username and selects status")
    public void admin_selects_employee_name_enters_username_and_selects_status() {
        WebElement fullName=driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']"));
        fullName.sendKeys("Dominic Chase");

        WebElement userName=driver.findElement(By.xpath("//input[@id='systemUser_userName']"));
        userName.sendKeys("dominic14");

        WebElement statusDropD=driver.findElement(By.xpath("//select[@id='systemUser_status']"));
        Select select = new Select(statusDropD);
        select.selectByVisibleText("Disabled");
    }

    @When("admin enters password, confirms and saves")
    public void admin_enters_password_confirms_and_saves() {

        WebElement password=driver.findElement(By.xpath("//input[@id='systemUser_password']"));
        password.sendKeys("Dominic2020November");
        WebElement confPassw=driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']"));
        confPassw.sendKeys("Dominic2020November");

        WebElement saveBtn=driver.findElement(By.name("btnSave"));
        saveBtn.click();
        saveBtn=driver.findElement(By.name("btnSave"));
        saveBtn.click();
    }
    @Then("admin validates Successfully Saved message")
    public void admin_validates_successfully_saved_message() throws InterruptedException {
        Thread.sleep(1000);
        WebElement display=driver.findElement(By.xpath("//div[@class='message success fadable']"));
        System.out.println(display.getText());
        String expectedOutput="Successfully Saved";
        Assert.assertEquals(display.getText(), expectedOutput);
    }
}
