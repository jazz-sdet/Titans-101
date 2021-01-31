package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsIntro {
        WebDriver driver;

    @BeforeClass
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }
    @Test
    public void validationOfContextClick(){

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box=driver.findElement(By.id("hot-spot"));

        Actions actions=new Actions(driver);

        actions.contextClick(box).perform();

//        Action action=actions.contextClick(box).build();
//        action.perform(); coming from cation interface, above one coming from actions class

    }
    @Test
    public void validateHoverAction() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");
        List <WebElement> headers=driver.findElements(By.xpath("//h5"));
        for (WebElement header: headers){
            System.out.println("header: "+header.getText());
        }

        List<WebElement>images=driver.findElements(By.xpath("//div[@id='content']//img"));

        Actions actions=new Actions(driver);

        for(int i=0; i<images.size(); i++){
            actions.moveToElement(images.get(i)).perform();
            System.out.println("header2: "+headers.get(i).getText());

        }
    }

}
