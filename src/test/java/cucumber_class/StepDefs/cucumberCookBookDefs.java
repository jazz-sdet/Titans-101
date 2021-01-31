package cucumber_class.StepDefs;

import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class cucumberCookBookDefs {
    WebDriver driver= Driver.getDriver("chrome");
    @When("user looks for cucumber cook book")
    public void user_looks_for_cucumber_cook_book() {
        WebElement searchField=driver.findElement(By.name("q"));
        searchField.sendKeys("cucumber cookbook"+ Keys.ENTER);
    }

    @Then("user validates for two result pages")
    public void user_validates_for_two_result_pages() {
       List<WebElement> actualLinkOfListPage1=driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
       Integer expectedLinkOfList=20;

        WebElement page2 = driver.findElement(By.xpath("//span[text()='Next']"));
        page2.click();
        List<WebElement> actualLinkOfListPage2=driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
        int totalNumberOfLinksOf2Pages=actualLinkOfListPage1.size()+actualLinkOfListPage2.size();
        Assert.assertTrue(totalNumberOfLinksOf2Pages>expectedLinkOfList, "Failed to verify total number of links from 2 pages");


    }

}
