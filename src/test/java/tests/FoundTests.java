package tests;

import config.BaseTest;
import dto.UserDTO;
import helpers.LeftMenuItems;
import helpers.PropertiesReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.FoundPage;
import pages.LoginPage;

public class FoundTests extends BaseTest {

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
        //BasePage.openLeftMenuItem(LeftMenuItems.Found);
    }

    @Test
    public void foundTest(){
        FoundPage foundPage = BasePage.openLeftMenuItem(LeftMenuItems.FOUND);
        //foundPage.clickBtnIFoundPet();
    }
}
