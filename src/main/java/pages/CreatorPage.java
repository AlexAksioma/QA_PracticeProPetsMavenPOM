package pages;

import dto.AnimalDTO;
import helpers.PetSex;
import helpers.PetType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CreatorPage extends BasePage{
    public CreatorPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    @FindBy(xpath = "//div[@data-test-id='info-item-0']//em")
    WebElement fieldType;
    @FindBy(xpath = "//div[@data-test-id='info-item-1']//em")
    WebElement fieldSex;
    @FindBy(xpath = "//div[@data-test-id='info-item-2']//input")
    WebElement fieldBreed;
    @FindBy(xpath = "//div[@data-test-id='info-item-3']//input")
    WebElement fieldColor;
    @FindBy(xpath = "//textarea[@placeholder='Blue collar with stars, no left ear, damaged tail.']")
    WebElement fieldDistinctiveFeatures;

    public CreatorPage typeLostFoundForm(AnimalDTO animal){
        createFieldType(animal.getType());
        createFieldSex(animal.getSex());
        fieldBreed.sendKeys(animal.getBreed());
        fieldColor.sendKeys(animal.getColor());
        fieldDistinctiveFeatures.sendKeys(animal.getDistinctive_features());
        return this;
    }

    private void createFieldType(PetType type) {  ////li[text()='Rodent']
        fieldType.click();
        WebElement elementLi = driver.findElement(
                By.xpath("//li[text()='"+type.getText()+"']"));
        elementLi.click();
    }
    private void createFieldSex(PetSex sex) {  ////li[text()='Rodent']
        fieldSex.click();
        WebElement elementLi = driver.findElement(
                By.xpath("//li[text()='"+sex.getText()+"']"));
        elementLi.click();
    }
}
