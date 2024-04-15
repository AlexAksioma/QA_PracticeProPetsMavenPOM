package tests;

import config.BaseTest;
import dto.UserDTO;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTest {
    @Test
    public void startTest(){
        UserDTO user = UserDTO.builder()
                .email("alexmedqwerty1@gmail.com")
                .password("Qwerty123!")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader()
                .typeLoginForm(user)
                .clickBtnSubmitPositive();
    }
}
