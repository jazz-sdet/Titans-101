package selenium_class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class JiraPage {
    public JiraPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='login-form-username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='login-form-password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='login']")
    public WebElement login;

    @FindBy(xpath = "//a[@id='greenhopper_menu']")
    public WebElement dashboard;

    @FindBy(id = "rapidb_lnk_1_lnk")
    public WebElement myBoard;

    @FindBy(id="ghx-board-name")
    public WebElement title;

    @FindBy(xpath = "//span[@class='aui-icon aui-icon-large agile-icon-plan aui-iconfont-backlog']")
    public WebElement backlogBTN;
}
