package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage{
    @FindBy(xpath = "//div[@data-test-id='header-container']/button")
    WebElement btnLoginHeader;

    public HomePage(WebDriver driver) {
        setDriver(driver);
        driver.get("https://propetscom.herokuapp.com/login");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    public LoginPage clickBtnLoginHeader() {
        btnLoginHeader.click();
        return new LoginPage(driver);
    }
}
