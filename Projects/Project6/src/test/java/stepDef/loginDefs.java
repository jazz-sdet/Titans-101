package stepDef;

import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class loginDefs {
    WebDriver driver = Driver.getDriver("chrome");

    @AfterMethod
    public void after(){
        driver.quit();
    }


    @When("user navigates to opensource-demo.orangehrmlive.com")
    public void user_navigates_to_opensource_demo_orangehrmlive_com() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("user uses {string} and {string} to log in")
    public void user_uses_and_to_log_in(String userN, String passw) {
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys(userN);
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys(passw);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

    }

    @Then("user logs in")
    public void user_logs_in() {
        String actual = driver.getCurrentUrl();
        String expected = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals(actual, expected);
    }

    @Given("user is logged in to opensource-demo.orangehrmlive.com")
    public void user_is_logged_in_to_opensource_demo_orangehrmlive_com() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();


    }

    @When("user clicks Admin function")
    public void user_clicks_admin_function() {
        WebElement adminFunc = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
        adminFunc.click();
    }

    @When("user click first checkbox next to username")
    public void user_click_first_checkbox_next_to_username() {
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectAll']"));
        checkBox.click();
    }

    @Then("all checkboxes are selected")
    public void all_checkboxes_are_selected() {
        List<WebElement> selectedCheckBoxes = driver.findElements(By.xpath("//table//tbody//tr//input"));

        for (WebElement selected : selectedCheckBoxes) {
            Assert.assertTrue(selected.isSelected());
        }

    }

    @Given("user is logged in as admin")
    public void user_is_logged_in_as_admin() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

        WebElement adminFunc = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
        adminFunc.click();

    }

    @When("user clicks username twice")
    public void user_clicks_username_twice() throws InterruptedException {
        WebElement usernameFunc=driver.findElement(By.xpath("//a[text()='Username']"));
        usernameFunc.click();

        usernameFunc=driver.findElement(By.xpath("//a[text()='Username']"));
        usernameFunc.click();

    }

    @Then("usernames are in descending order")
    public void usernames_are_in_descending_order() throws InterruptedException {

        Thread.sleep(1000);
        List <WebElement> allName=driver.findElements(By.xpath("//table//tbody//tr//a"));

        List <String> allActNames=new ArrayList<>();

        for(WebElement names: allName){
            allActNames.add(names.getText().trim());

        }

        List <String> expectedNa=new ArrayList<>(allActNames);

        Collections.sort(expectedNa, Collections.reverseOrder());

        Assert.assertEquals(allActNames, expectedNa);
    }
}



