package TestManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {

    private final WebDriver driver;

    public ReusableMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTo (WebElement element, long waitTimeInSeconds) {
        WebDriverWait wait = getWait(waitTimeInSeconds);
        WebElement elements;
        elements = wait.until(ExpectedConditions.elementToBeClickable(element));
        elements.click();
    }

    public void sendKeysTo (WebElement element , String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    // Select from Dropdown List
    public void selectVisibleText (WebElement element , String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    // Mouse hovering from one element to other element
    public void mouseHoverAndClickElement (WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    private WebDriverWait getWait(long waitTimeInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
    }
}
