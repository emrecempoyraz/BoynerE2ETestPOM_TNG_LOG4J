package PageObjects;

import TestManager.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//button[@class='collapse_header__LAEcj'])[1]")
    private WebElement genderSelectionLocator ;

    @FindBy (xpath = "(//input['checkbox_input__B5l_h'])[1]")
    private WebElement selectManCheckBoxLocator ;

    @FindBy(xpath = "(//button[@class='collapse_header__LAEcj'])[2]")
    private WebElement brandSelectionLocator;

    @FindBy (xpath = "//input[@value='20546']")
    private WebElement jackJonesCheckBoxLocator;

    @FindBy(xpath = "(//div[@class='collapse_title__y_n4k'])[3]")
    private WebElement productTypeSelectionLocator;

    @FindBy(xpath = "//input[@value='20715']")
    private WebElement productTypeSelectionCheckBox ;

    @FindBy(xpath = "(//div[@class='product-item_content__9CfBp'])[2]")
    private WebElement filteredProductSelectionLocator;




    public boolean isOnProductsPage () throws InterruptedException {
        Thread.sleep(10000);
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        String expectedUrl = "https://www.boyner.com.tr/search?q=hoodie";

        return actualUrl.equals(expectedUrl);
    }

    public boolean isProductSelected () throws InterruptedException {
        Thread.sleep(10000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.boyner.com.tr/jack-jones-sweatshirt-1260142";
        return actualUrl.equals(expectedUrl);
    }

    public void selectGender () {
        core.clickTo(genderSelectionLocator,15);
        if (selectManCheckBoxLocator.isDisplayed()) {
            core.clickTo(selectManCheckBoxLocator,15);
            Log.pass("Selected Man Category");
        }else Log.fail("Not selected to Gender");
    }

    public void selectBrand () {
        core.clickTo(brandSelectionLocator,20);
        if (jackJonesCheckBoxLocator.isDisplayed()){
            core.clickTo(jackJonesCheckBoxLocator,20);
            Log.pass("Selected to Jack Jones");
        }else Log.fail("Not selected Jack Jones");

    }



    public void pickFilteredProduct () {
        if (filteredProductSelectionLocator.isDisplayed()){
            core.clickTo(filteredProductSelectionLocator,60);
            Log.pass("Picked Filtered Product");
        }else Log.fail("Not picked to filtered product");
    }


}
