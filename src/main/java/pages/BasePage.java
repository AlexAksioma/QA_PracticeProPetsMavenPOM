package pages;

import helpers.LeftMenuItems;
import lombok.extern.java.Log;
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
        try {
            WebElement elementMenuItem = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(leftMenuItems.getLocator())));
            elementMenuItem.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        switch (leftMenuItems) {
            case HOME:
                return (T) new FeedPage(driver);
            case LOST:
                return (T) new LostPage(driver);
            case FOUND:
                return (T) new FoundPage(driver);
            case SERVICES:
                return (T) new ServicesPage(driver);
            case FAVORITES:
                return (T) new FavoritesPage(driver);
            case PROFILE:
                return (T) new ProfilePage(driver);
            case LOGOUT:
                return (T) new LoginPage(driver);
            default:
                throw new IllegalArgumentException("invalid parametr leftMenuItem");
        }
    }
}
