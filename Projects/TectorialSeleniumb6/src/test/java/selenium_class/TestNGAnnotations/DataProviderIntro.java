package selenium_class.TestNGAnnotations;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
public class DataProviderIntro {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= Driver.getDriver("chrome");

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

    }
    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

    @Test(dataProvider = "testData")
    public void test1(String firstName, String lastName) {
        System.out.println("First name: " + firstName + ", last name: " + lastName);


    }

    @DataProvider(name = "testData")
    public Object[][] getTestData() {

        return new Object[][]{
                {"John", "Smith"},
                {"Mike", "Grin"},
                {"Priyanka", "Khan"},
                {"admin", "Admin123"},
                {" ", "Admin123"},
                {" ", " "},
                {"admin1", "adminadmin"}
        };
    }


    @Test(dataProvider = "testData")
    public void testLogin(String username, String password) {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        WebElement usernameField=driver.findElement(By.cssSelector("#username"));

        usernameField.sendKeys(username);
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        WebElement loginButtonErrorMess=driver.findElement(By.cssSelector("#sessionLocationError"));
        Assert.assertEquals(loginButtonErrorMess.getText(), "You must choose a location!");
        System.out.println(loginButtonErrorMess.getText());

    }
    }

