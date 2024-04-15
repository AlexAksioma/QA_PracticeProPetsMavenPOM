package pages;

import helpers.LeftMenuItems;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static <T extends BasePage> T openLeftMenuItem(LeftMenuItems leftMenuItems) {
        //div[text()='Favorites']
        String xPathMenuItem = "//div[text()='" + leftMenuItems + "']";
        By elementMenuItemBy = By.xpath(xPathMenuItem);
        try {
            WebElement elementMenuItem = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(elementMenuItemBy));
            elementMenuItem.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        switch (leftMenuItems) {
            case Home:
                return (T) new FeedPage(driver);
            case Lost:
                return (T) new LostPage(driver);
            case Found:
                return (T) new FoundPage(driver);
            case Services:
                return (T) new ServicesPage(driver);
            case Favorites:
                return (T) new FavoritesPage(driver);
            default:
                throw new IllegalArgumentException("invalid parametr leftMenuItem");
        }
    }
}
