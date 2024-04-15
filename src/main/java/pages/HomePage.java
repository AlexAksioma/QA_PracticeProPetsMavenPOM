package pages;

import helpers.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage{
    @FindBy(xpath = "//div[@data-test-id='header-container']/button")
    WebElement btnLoginHeader;
    String url = PropertiesReader.getProperty("baseurl");
    public HomePage(WebDriver driver) {
        setDriver(driver);
        driver.get(url);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    public LoginPage clickBtnLoginHeader() {
        btnLoginHeader.click();
        return new LoginPage(driver);
    }
}
