package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FoundPage extends BasePage {
    public FoundPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text " +
            "MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-" +
            "root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-cmc5zk']")
    WebElement btnIFoundPet;

    public void clickBtnIFoundPet() {
        btnIFoundPet.click();
    }
}
