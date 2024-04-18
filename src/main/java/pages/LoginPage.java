package pages;

import dto.UserDTO;
import helpers.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@placeholder='peter@gmail.com']")
    WebElement fieldEmail;
    @FindBy(xpath = "//input[@placeholder='******']")
    WebElement fieldPassword;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "//div[@data-test-id='header-container']/button")
    WebElement btnLoginHeader;

    String url = PropertiesReader.getProperty("baseurl");
    public LoginPage(WebDriver driver){
        setDriver(driver);
        driver.get(url);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    public LoginPage clickBtnLoginHeader() {
        btnLoginHeader.click();
        return this;
    }

    /**
     *
     * @param user userdto.class string email, password
     * @return loginpage
     */
    public LoginPage typeLoginForm(UserDTO user) {
        fieldEmail.sendKeys(user.getEmail());
        fieldPassword.sendKeys(user.getPassword());
        return this;
    }

    /**
     *
     * @return feedPage
     */
    public FeedPage clickBtnSubmitPositive(){
        btnSubmit.click();
        return new FeedPage(driver);
    }








}
