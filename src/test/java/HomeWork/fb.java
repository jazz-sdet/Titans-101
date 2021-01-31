package HomeWork;
import Utils.DriverHW;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class fb extends DriverHW {
    
    public fb(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailAdd;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passWord;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginBtn;

    public void login(String email, String password) throws InterruptedException {
        emailAdd.sendKeys(email);
        passWord.sendKeys(password);
        loginBtn.click();
        Thread.sleep(1000);


    }

    @FindBy(xpath = "//span[text()='Japoshka Japo']")
    public WebElement japoshkaPage;

    @FindBy(xpath = "//a[@aria-hidden='false'][3]")
    public WebElement friendsBtn;

    @FindBy(xpath = "//input[@dir='auto']")
    public WebElement searchField;



    public void searching() throws InterruptedException {
        japoshkaPage.click();
        Thread.sleep(1000);
        friendsBtn.click();
        Thread.sleep(1000);
        searchField.click();
        Thread.sleep(500);
        searchField.sendKeys("Назгуль Кебекбаева");
        searchField.sendKeys(Keys.ENTER);

    }





}
