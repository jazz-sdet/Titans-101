package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPages{

    public loginPages(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(css ="#btn-login")
    public WebElement loginBtn ;

    @FindBy(xpath = "//div[@class='navbar-header']")
    public WebElement burgerBt;


    }


