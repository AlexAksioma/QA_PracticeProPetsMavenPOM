package tests;

import config.BaseTest;
import dto.AnimalDTO;
import dto.UserDTO;
import helpers.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CreatorPage;
import pages.FeedPage;
import pages.LoginPage;

public class CreatorTests extends BaseTest {
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
    public void creatorTest(){
        FeedPage feedPage = new FeedPage(getDriver());
        feedPage.clickBtnAddNewOnHeader();
    }

    @Test
    public void createNewLostAnimal(){
        AnimalDTO animal = AnimalDTO.builder()
                .type(PetType.FERRET)
                .sex(PetSex.MALE)
                .breed(RandomElements.breedOfCat())
                .color(RandomElements.color())
                .distinctive_features(RandomElements.randomString(25))
                .build();
        BasePage.openLeftMenuItem(LeftMenuItems.FOUND)
                .clickBtnILostMyPet()
                .typeLostFoundForm(animal);
    }
}
