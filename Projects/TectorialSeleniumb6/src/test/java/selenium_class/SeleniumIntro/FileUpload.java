package selenium_class.SeleniumIntro;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload {
    @Test
    public void uploadFile(){
        WebDriver driver= Driver.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileBtn=driver.findElement(By.cssSelector("#file-upload"));
        chooseFileBtn.sendKeys("/Users/zhazgulkalimalieva/Downloads/zhazgul.txt");
        WebElement uploadBtn=driver.findElement(By.cssSelector("#file-submit"));
        uploadBtn.click();

        WebElement displayed=driver.findElement(By.xpath("//h3[text()=\"File Uploaded!\"]"));
        Assert.assertEquals(displayed.getText(), "File Uploaded!");

        WebElement uploadedFile=driver.findElement(By.xpath("//div[@id='uploaded-files']"));
        Assert.assertEquals(uploadedFile.getText(), "zhazgul.txt");

    }
}
