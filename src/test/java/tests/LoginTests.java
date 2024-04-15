package tests;

import config.BaseTest;
import dto.UserDTO;
import helpers.PropertiesReader;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTest {
    @Test
    public void startTest(){
        UserDTO user = UserDTO.builder()
                .email(PropertiesReader.getProperty("email"))
                .password(PropertiesReader.getProperty("password"))
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader()
                .typeLoginForm(user)
                .clickBtnSubmitPositive();
    }
}
