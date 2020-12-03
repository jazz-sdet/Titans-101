package selenium_class.Sentrifugo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){ //constructor
        //'initElements' method will initialize the webelements
        // 'this' keyword refers to class itself
        PageFactory.initElements(driver, this);
    }
    //FindBy annotation is used to store the WebElement inside this class & it finds the xml element.
//    @FindBy(id="username") works the same way as below
    @FindBy(how=How.ID, using = "username")
    public WebElement userName; //variable

    @FindBy(id="password")
    public WebElement passWord;

    @FindBy(id="loginsubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@id='password']/following-sibling::div")
    public WebElement errorMessage;

    public  void login(String username, String password){
        userName.sendKeys(username);
        passWord.sendKeys(password);

        loginButton.click();
    }



}
