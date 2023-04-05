package pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage {
    WebDriver driver;
    Dotenv dotenv = Dotenv.configure().load();
    public SoftAssert sa;

    By alertBoxPageTitle = By.xpath("//h1[contains(text(),'Alert Box Examples')]");
    By showAlertBox = By.id("alertexamples");
    By showConfirmBox = By.id("confirmexample");
    By showConfirmBoxMessage = By.id("confirmreturn");
    By showPromptBox = By.id("promptexample");
    By showPromptBoxMessage = By.id("promptreturn");
    By showPromptBoxCancelMessage = By.id("promptexplanation");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }
    public void verifyAlertBoxPageTitle(){
        String actualTitle = driver.findElement(alertBoxPageTitle).getText();
        String expectTitle = "Alert Box Examples";
        Assert.assertEquals(actualTitle,expectTitle,"Expected title is 'Alert Box Examples' ");
        //sa.assertEquals(actualTitle,expectTitle);
        //sa.assertAll();
    }
    public void clickShowAlertBox(){
        driver.findElement(showAlertBox).click();
    }
    public void getAlertBoxText(){
        driver.switchTo().alert();
        String actualTile = driver.switchTo().alert().getText();
        String expectedTitle = "I am an alert box!";
        Assert.assertEquals(actualTile,expectedTitle,"Expected title is 'I am an alert box!' ");
        //sa.assertEquals(actualTile,expectedTitle,"Expected title is 'I am an alert box!' ");
        //sa.assertAll();
    }
    public void acceptAlertBox(){
        driver.switchTo().alert().accept();
    }
    public void clickShowConfirmBox(){
        driver.findElement(showConfirmBox).click();
    }
    public void getShowConfirmBoxText(){
        String actualTitle = driver.switchTo().alert().getText();
        String expectedTitle = "I am a confirm alert";
        Assert.assertEquals(actualTitle,expectedTitle, "Expected title is 'I am a confirm alert' ");
    }
    public void clickOKShowConfirmBox(){
        driver.switchTo().alert();
        driver.switchTo().alert().accept();
    }
    public void verifyShowConfirmBoxOkMessage(){
        String actualTitle = driver.findElement(showConfirmBoxMessage).getText();
        String expectedTitle = "true";
        Assert.assertEquals(actualTitle,expectedTitle,"Expected title is 'true' ");
    }
    public void clickCancelShowConfirmBox(){
        driver.switchTo().alert().dismiss();
    }
    public void verifyShowConfirmBoxCancelMessage(){
        String actualTitle = driver.findElement(showConfirmBoxMessage).getText();
        String expectedTitle = "false";
        Assert.assertEquals(actualTitle,expectedTitle,"Expected title is 'false' ");
    }
    public void clickShowPromptBox(){
        driver.findElement(showPromptBox).click();
    }
    public void verifyShowPromptBox(){
        String actualTitle = driver.switchTo().alert().getText();
        String expectedTitle = "I prompt you";
        Assert.assertEquals(actualTitle,expectedTitle,"Expected title is 'I prompt you' ");
    }
    public void clickOKShowPromptBox(){
        driver.switchTo().alert().accept();
    }
    public void enterTextShowPromptBox(String msg){
        driver.switchTo().alert().sendKeys(msg);
    }
    public void verifyShowPromptBoxMessage(){
        String actualTitle = driver.findElement(showPromptBoxMessage).getText();
        String expectedTitle = this.dotenv.get("POPUPMESSAGE");
        Assert.assertEquals(actualTitle,expectedTitle,"Expected title is " + this.dotenv.get("POPUPMESSAGE"));
    }
    public void clickCancelShowPromptBox(){
        driver.switchTo().alert().dismiss();
    }
    public void verifyClickCancelShowPromptBoxMessage(){
        String actualTitle = driver.findElement(showPromptBoxCancelMessage).getText();
        String expectedTitle = "You clicked Cancel. 'prompt' returned null";
        Assert.assertEquals(actualTitle,expectedTitle);
    }







}
