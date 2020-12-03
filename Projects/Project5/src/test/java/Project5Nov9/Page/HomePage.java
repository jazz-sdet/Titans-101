package Project5Nov9.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement passWord;

    @FindBy(xpath = "//button[contains(text(),'L')]")
    public WebElement loginButton;

    public void loginPage(){
        userName.sendKeys("admin");
        passWord.sendKeys("admin");
        loginButton.click();
    }

    @FindBy(xpath = "//span[text()='Switch']")
    public WebElement switchBtn;

    @FindBy(xpath = "//h4[@id='myModalLabel']")
    public WebElement displayedSwitchMess;

    @FindBy(xpath = "//p[contains(text(),'Select')]")
    public WebElement selectText;

    @FindBy(css = "#select2-chosen-1")
    public WebElement selectEmplButton;

    @FindBy(css = "#select2-result-label-3")
    public WebElement lalaName;

    @FindBy(xpath = "//button[text()='Switch']")
    public WebElement lalaSwitchBtn;

    @FindBy(xpath = "//a[text()='Lala Lamees']")
    public WebElement lalaDisplay;

    @FindBy(xpath = "//a[contains(text(),' Changed')]")
    public WebElement changedTo;

    @FindBy(xpath = "//a[contains(text(),' Changed')]//i")
    public  WebElement brownCircle;

    @FindBy(xpath = "//a[contains(.,'Lala')]")
    public WebElement lalaNameUser;

    @FindBy(xpath = "//i[@class='fa fa-calculator']")
    public WebElement financeBtn;

    @FindBy(xpath = "//ul[@id='module_Finance']//li//a//i[@class='fa fa-calculator']")
    public WebElement salaryBtn;

    @FindBy(xpath = "//button[@onclick='modJs.renderForm();return false;']")
    public WebElement addNewBtn;

    @FindBy(xpath = "//select[@id='component']")
    public  WebElement salaryCompDropDown;

    @FindBy(id = "amount")
    public WebElement amount;

    @FindBy(id = "details")
    public WebElement details;

    @FindBy(xpath = "//button[@class='saveBtn btn btn-primary pull-right']")
    public WebElement saveBtn;



}
