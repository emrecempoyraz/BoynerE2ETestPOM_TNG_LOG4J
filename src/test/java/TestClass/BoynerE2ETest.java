package TestClass;

import PageObjects.HomePage;
import PageObjects.ProductsPage;
import TestManager.BaseTest;
import TestManager.ConfigReader;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoynerE2ETest extends BaseTest {

   HomePage homePage;
   ProductsPage productsPage ;
   @Description("BOYNERE2ETEST")
   @Test (priority = 1,description = "Search Product on Searchbar")
   public void searchProductOnHomePage () throws InterruptedException {
       homePage = new HomePage(driver);
       productsPage = new ProductsPage(driver);
       driver.get(ConfigReader.getProperty("baseUrl"));
       homePage.acceptCookies();
       homePage.clickToSearchLink();
       homePage.searchProductOnSearchBar();
       Assert.assertTrue(productsPage.isOnProductsPage(),"Not on products page!");
   }

   @Description("Filter product features")
   @Test(priority = 2,dependsOnMethods = "searchProductOnHomePage",description = "Filter product for needs")
   public void filterProductDetails () {
       productsPage = new ProductsPage(driver);
       productsPage.selectGender();
       productsPage.selectBrand();
       //productsPage.selectProductType();
   }

   @Description("Pick Filtered Product")
   @Test(priority = 3,dependsOnMethods = "filterProductDetails",description = "Pick filtered product")
   public void selectFilteredProduct () throws InterruptedException {
       productsPage = new ProductsPage(driver);
       productsPage.pickFilteredProduct();
       Assert.assertTrue(productsPage.isProductSelected(),"Product is not selected");
   }

}
