package PageObjects;

import TestManager.ConfigReader;
import TestManager.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }



    @FindBy (className = "header-top_headerTopSearch__yHko1")
    private WebElement searchLinkLocator ;

    @FindBy(css = "button#onetrust-accept-btn-handler")
    private WebElement acceptCookiesLocator ;

    @FindBy(xpath = "//input[@placeholder='Kategori, marka veya ürün ara']")
    private WebElement productSearchBarLocator ;

    @FindBy (className = "search-suggestion_searchBtn__Oemqg")
    private WebElement searchIconLocator ;

    public void acceptCookies (){
        if (acceptCookiesLocator.isDisplayed()){
            core.clickTo(acceptCookiesLocator,10);
            Log.pass("Accepted to Cookies");
        }else Log.fail("Not Aceepted cookies");

    }

    public void clickToSearchLink () {
        if (searchLinkLocator.isDisplayed()){
            core.clickTo(searchLinkLocator, 10);
            Log.pass("Clicked the search Link");
        }else Log.fail("Not clidked search link");
    }

    public void searchProductOnSearchBar () {
        if (productSearchBarLocator.isDisplayed()) {
            core.sendKeysTo(productSearchBarLocator, ConfigReader.getProperty("product"));
            Log.pass("Searched to product");
        }else Log.fail("Not searched to product");
        if (searchIconLocator.isDisplayed()){
            core.clickTo(searchIconLocator,5);
            Log.pass("Clicked the searc icon");
        }else Log.fail("Not Clicked to search icon");

    }
}
