package cucumber_class.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class etsyHomePage {

    public etsyHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchField;

   public static etsyHomePage getEtsyHomePage(WebDriver driver){
       return new etsyHomePage(driver);
   }

}
