package tests;

import config.BaseTest;
import dto.UserDTO;
import helpers.PropertiesReader;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void startTest(){
        UserDTO user = UserDTO.builder()
                .email(PropertiesReader.getProperty("email"))
                .password(PropertiesReader.getProperty("password"))
                .build();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickBtnLoginHeader()
                .typeLoginForm(user)
                .clickBtnSubmitPositive();
    }
}
