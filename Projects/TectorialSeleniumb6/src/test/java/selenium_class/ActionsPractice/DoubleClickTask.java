package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class DoubleClickTask {
    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        List<WebElement> buttons=driver.findElements(By.xpath("//table//div[@class='ui-panel-content ui-widget-content']"));

        for(WebElement button: buttons){
            switch(button.getText()){
                case "click":
                    button.click();
                    break;
                case "doubleclick":
                    Actions actions=new Actions(driver);
                    actions.doubleClick(button).perform();
                    break;
            }
        }
    }
}
