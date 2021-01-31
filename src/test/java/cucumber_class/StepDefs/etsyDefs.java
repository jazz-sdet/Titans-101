package cucumber_class.StepDefs;
import Utils.Driver;
import cucumber_class.Pages.etsyHomePage;
import cucumber_class.Pages.etsyResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class etsyDefs {

    WebDriver driver= Driver.getDriver("chrome");

    @Given("user is on etsy home page")
    public void userIsOnEtsyHomePage() {
        driver.get("https://www.etsy.com/");

    }



    @When("user searches for {string}")
    public void userSearchesFor(String searchPhrase) {
        etsyHomePage etsyHomePage= cucumber_class.Pages.etsyHomePage.getEtsyHomePage(driver);
        etsyHomePage.searchField.sendKeys(searchPhrase+ Keys.ENTER);

    }
    @Then("the result page has total price more than {int}")
    public void theResultPageHasTotalPriceMoreThan(Integer minPrice) {
        etsyResultPage etsyResultP=etsyResultPage.getEtsyResultPage(driver);

        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(etsyResultP.allPrices));

        double totalPrice=0;
        List<WebElement> priceList=etsyResultP.allPrices;
        for(WebElement price: priceList){
            try{
                totalPrice+=Double.parseDouble(price.getText().replace(",", ""));
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        }
        Assert.assertTrue(totalPrice>minPrice);


    }

    }






