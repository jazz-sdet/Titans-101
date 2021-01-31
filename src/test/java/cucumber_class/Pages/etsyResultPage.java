package cucumber_class.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class etsyResultPage {

    private etsyResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public static etsyResultPage getEtsyResultPage(WebDriver driver){

        return new etsyResultPage(driver);
    }
    @FindBy(css=".currency-value")
    public List<WebElement> allPrices;

}
