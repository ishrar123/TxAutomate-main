package pageFactory.LolRMIPages;

import org.openqa.selenium.By;

public class LolRMILoginPage {

        public static By openLoginPageBtn = By.className("login_orangebtn__-TDQ0");
        public static By loginPage_SubmitBtn = By.xpath("//button[@type='submit']");
        public static By loginPage_UsernameBox = By.id("username");
        public static By loginPage_PasswordBox = By.id("password");
        public static By loginPage_InvalidLogin_Msg = By.xpath("//div[@class='ping-messages']/div[@class='ping-error']");


}
