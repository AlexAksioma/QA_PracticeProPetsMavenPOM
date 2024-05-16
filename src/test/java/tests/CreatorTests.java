package tests;

import config.BaseTest;
import dto.AnimalDTO;
import dto.UserDTO;
import helpers.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CreatorPage;
import pages.FeedPage;
import pages.LoginPage;

public class CreatorTests extends BaseTest {
    @BeforeMethod
    public void loginWithPropertiesGoToFoundPage() {
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
    public void creatorTest() {
        FeedPage feedPage = new FeedPage(getDriver());
        feedPage.clickBtnAddNewOnHeader();
    }

    @Test
    public void createNewLostAnimal() {
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

    @Test
    public void serializable() {
        AnimalDTO animal = AnimalDTO.builder()
                .type(PetType.FERRET)
                .sex(PetSex.MALE)
                .breed("breed")
                .color("white")
                .distinctive_features("string")
                .description("New qwerty")
                .photo("c://")
                .location("Haifa")
                .contacts("054123123")
                .email("qwerty@mail.com")
                .build();
        AnimalDTO.serializableAnimalDTO(animal, "animal2.ser");
        AnimalDTO animalNew = AnimalDTO.deSerializableAnimalDTO("animal2.ser");
        System.out.println(animal.toString());
        System.out.println(animalNew.toString());
        Assert.assertTrue(animal.equals(animalNew));
    }

}
