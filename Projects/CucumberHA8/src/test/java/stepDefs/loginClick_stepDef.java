package stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

import pages.loginPages;
import utils.Driver;




public class loginClick_stepDef {

        //loginPages loginP;

         WebDriver driver=Driver.getDriver("chrome");

//         @Before
//         public void SetUp() {

                loginPages loginP = new loginPages(driver);
                //functionalitiesPages functionalitiesPages=new functionalitiesPages(driver);

    @Given("user is on {string} web page")
    public void user_is_on_web_page(String host) {
        driver.get(host);

    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginP.loginBtn.click();

    }
    @When("user clicks on burger button")
    public void user_clicks_on_burger_button() {
        loginP.burgerBt.click();


    }
    @Then("user should see all the function names")
    public void user_should_see_all_the_function_names() {

    }




}








//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement logIn= wait.until(ExpectedConditions.elementToBeClickable(loginP.loginBtn));
//        logIn.click();
//
//        loginP.burgerBt.click();



