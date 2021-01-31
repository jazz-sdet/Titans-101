package selenium_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageFact {

    public PageFact(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='signin_btn']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='use Slack in your browser']")
    public WebElement browserContinue;

    @FindBy(xpath = "//span[@data-qa='channel_sidebar_name_api']")
    public WebElement apiChannel;

    @FindBy(xpath = "//div[@class='ql-placeholder']")
    public WebElement messageField;

    @FindBy(xpath = "//button[@aria-label='Send message']")
    public WebElement sendMessage;

    @FindBy(xpath = "//div[@class='c-message_kit__blocks c-message_kit__blocks--rich_text']")
    public List<WebElement> apiChannelMessageList;

    @FindBy(xpath = "//span[@class='c-message_kit__text']")
    public List<WebElement> allMessages;
}
