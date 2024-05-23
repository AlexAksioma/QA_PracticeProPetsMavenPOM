package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PreviewPage extends BasePage{
    public PreviewPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }
    @FindBy(xpath = "//button[text()='Edit']")
    WebElement btnEdit;

    public boolean isElementDisplayed_btnEdit(){
        return isElementDisplayed(btnEdit);
    }
}
