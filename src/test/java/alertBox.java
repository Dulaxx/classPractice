import base.BaseClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class alertBox extends BaseClass {

    @Test(priority = 1, description = "Validate whether an alert box displayed when user click on show alert box button")
    public void testCase1(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyAlertBoxPageTitle();
        homePage.clickShowAlertBox();
        homePage.getAlertBoxText();
        homePage.acceptAlertBox();
        System.out.println("Test Case ID1 - Pass");
    }
    @Test(priority = 2, description = "Validate whether alert message is displayed when user click on show confirm box " +
            "and when user click OK verify whether the webpage displays confirmation message ")
    public void testCase2(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyAlertBoxPageTitle();
        homePage.clickShowConfirmBox();
        homePage.getShowConfirmBoxText();
        homePage.clickOKShowConfirmBox();
        homePage.verifyShowConfirmBoxOkMessage();
        System.out.println("Test Case ID2 - Pass");
    }
    @Test(priority = 3, description = "Validate whether alert message is displayed when user click on show confirm box " +
            "and when user click cancel verify whether the webpage displays confirmation message ")
    public void testCase3(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyAlertBoxPageTitle();
        homePage.clickShowConfirmBox();
        homePage.getShowConfirmBoxText();
        homePage.clickCancelShowConfirmBox();
        homePage.verifyShowConfirmBoxCancelMessage();
        System.out.println("Test Case ID3 - Pass");
    }
    @Test(priority = 4, description = "Validate whether user entered message in the popup window is getting displayed")
    public void testCase4(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyAlertBoxPageTitle();
        homePage.clickShowPromptBox();
        homePage.verifyShowPromptBox();
        homePage.enterTextShowPromptBox(this.dotenv.get("POPUPMESSAGE"));
        homePage.clickOKShowPromptBox();
        homePage.verifyShowPromptBoxMessage();
        System.out.println("Test Case ID4 - Pass");
        //System.out.println(this.dotenv.get("POPUPMESSAGE"));
    }
    @Test(priority = 5, description = "Validate whether user entered message in the popup window is getting displayed")
    public void testCase5(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyAlertBoxPageTitle();
        homePage.clickShowPromptBox();
        homePage.verifyShowPromptBox();
        homePage.clickCancelShowPromptBox();
        homePage.verifyClickCancelShowPromptBoxMessage();
        System.out.println("Test Case ID5 - Pass");
    }



}
