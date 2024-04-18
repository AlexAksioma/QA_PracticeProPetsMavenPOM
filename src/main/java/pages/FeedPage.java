package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FeedPage extends BasePage{
    public FeedPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    @FindBy(xpath = "//button[text()='Add new']")
    WebElement btnAddNewOnHeader;

    public CreatorPage clickBtnAddNewOnHeader(){
        btnAddNewOnHeader.click();
        return new CreatorPage(driver);
    }

}
