package pageHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HW7C1Validation {

    public HW7C1Validation (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Manager']")
    public WebElement managerFunc;

    @FindBy(xpath = "//a[text()='New Customer']")
    public WebElement newCustomerFunc;

    @FindBy(xpath = "//a[text()='Edit Customer']")
    public WebElement editCustomerFunc;

    @FindBy(xpath = "//a[text()='Delete Customer']")
    public WebElement delCustomerFunc;

    @FindBy(xpath = "//a[text()='New Account']")
    public WebElement newAccountFunc;

    @FindBy(xpath = "//a[text()='Edit Account']")
    public WebElement editAccountFunc;

    @FindBy(xpath = "//a[text()='Delete Account']")
    public WebElement delAccountFunc;

    @FindBy(xpath = "//a[text()='Deposit']")
    public  WebElement depositFunc;

    @FindBy(xpath = "//a[text()='Withdrawal']")
    public  WebElement withdrawalFunc;

    @FindBy(xpath = "//a[text()=Fund Transfer]")
    public WebElement fundTransferFunc;

    @FindBy(xpath = "//a[text()='Change Password']")
    public WebElement changePassFunc;

    @FindBy(xpath = "//a[text()='Balance Enquiry']")
    public WebElement balanceEnquiryFunc;

    @FindBy(xpath = "//a[text()='Mini Statement']")
    public WebElement miniStatementFunc;

    @FindBy(xpath = "//a[text()='Customised Statement']")
    public WebElement custOmizedStatFunc;

    @FindBy(xpath = "//a[text()='Log out']")
    public WebElement logOutFunc;
}
