package modules.PRAChallenge;

import pageFactory.RPAChallenge.RPAHomePage;
import utilities.KeywordUtil;

public class RPAChallengeActions extends KeywordUtil {
    public static void enterFirstNmae(String FirstName) throws InterruptedException {
        delay(5000);
        inputText(RPAHomePage.FirstName, FirstName,"Enter Username");
    }
    public static void enterLastName(String LastName) throws InterruptedException {
        delay(5000);
        inputText(RPAHomePage.LastName, LastName,"Enter Username");
    }
    public static void enterCompanyName(String CompanyName) throws InterruptedException {
        delay(5000);
        inputText(RPAHomePage.CompanyName, CompanyName,"Enter Company Name");
    }
    public static void enterRoleinCompany(String RoleinCompany) throws InterruptedException{
        delay(5000);
        inputText(RPAHomePage.RoleinCompany, RoleinCompany, "Enter Role in Company");
    }
    public static void enterEmail(String Email) throws InterruptedException {
        delay(5000);
        inputText(RPAHomePage.Email, Email,"Enter Username");
    }
    public static void enterPhoneNumber(String PboneNumber) throws InterruptedException {
        delay(5000);
        inputText(RPAHomePage.PhoneNumber, PboneNumber,"Enter Username");
    }
    public static void enterAddress(String Address) throws InterruptedException {
        delay(5000);
        inputText(RPAHomePage.Address, Address,"Enter Username");
    }
    public static void clickSubmitBtn() {
        waitForVisible(RPAHomePage.SubmitBtn);
        click(RPAHomePage.SubmitBtn, "Clicking Open Login page btn");
        waitForVisible(RPAHomePage.SubmitBtn);
    }
}
