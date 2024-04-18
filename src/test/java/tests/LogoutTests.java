package tests;

import config.BaseTest;
import dto.UserDTO;
import helpers.LeftMenuItems;
import helpers.PropertiesReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.FeedPage;
import pages.LoginPage;

public class LogoutTests extends BaseTest {
    @BeforeMethod
    public void loginWithPropertiesGoToFoundPage(){
        UserDTO user = UserDTO.builder()
                .email(PropertiesReader.getProperty("email"))
                .password(PropertiesReader.getProperty("password"))
                .build();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickBtnLoginHeader()
                .typeLoginForm(user)
                .clickBtnSubmitPositive();

    }
    @Test
    public void logoutTest(){
        FeedPage feedPage = new FeedPage(getDriver());
        BasePage.openLeftMenuItem(LeftMenuItems.LOGOUT);
    }
}
