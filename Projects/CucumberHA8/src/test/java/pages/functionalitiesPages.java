package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class functionalitiesPages {

    public functionalitiesPages (WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "")
    public WebElement homeBtn;

    @FindBy(xpath = "")
    public WebElement accountsBtn;

    @FindBy(xpath = "")
    public WebElement contactsBtn;

    @FindBy(xpath = "")
    public WebElement leadsBtn;

    @FindBy(xpath = "")
    public WebElement opportunitiesBtn;

    @FindBy(xpath = "")
    public WebElement reportsBtn;

    @FindBy(xpath = "")
    public WebElement quotesBtn;


}
