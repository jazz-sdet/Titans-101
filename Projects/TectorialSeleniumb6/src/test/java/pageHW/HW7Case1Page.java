package pageHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HW7Case1Page {

    public HW7Case1Page(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    /*  jybemam password
    mngr294976 login
     */



    @FindBy(name = "uid")
    public WebElement userID;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "btnLogin")
    public WebElement loginButton;

    public void loginPage(String userId, String passw){
        userID.sendKeys(userId);
        password.sendKeys(passw);
        //loginButton.click();




    }



}
