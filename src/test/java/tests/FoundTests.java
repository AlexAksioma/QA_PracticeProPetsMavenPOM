package tests;

import config.BaseTest;
import dto.UserDTO;
import helpers.LeftMenuItems;
import helpers.PropertiesReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.FoundPage;
import pages.HomePage;

public class FoundTests extends BaseTest {

    @BeforeMethod
    public void loginWithPropertiesGoToFoundPage(){
        UserDTO user = UserDTO.builder()
                .email(PropertiesReader.getProperty("email"))
                .password(PropertiesReader.getProperty("password"))
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader()
                .typeLoginForm(user)
                .clickBtnSubmitPositive();
        //BasePage.openLeftMenuItem(LeftMenuItems.Found);
    }

    @Test
    public void foundTest(){
        FoundPage foundPage = BasePage.openLeftMenuItem(LeftMenuItems.Found);
        foundPage.clickBtnIFoundPet();
    }
}
