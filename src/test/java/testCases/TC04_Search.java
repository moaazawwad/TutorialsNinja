package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import static drivers.DriverHolder.getDriver;

public class TC04_Search extends testBase {
    private P01_HomePage homePage;

    @Test(priority = 1, description = "Test searching for a product and verifying the search results")
    public void testSearchForProduct_P() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        homePage = new P01_HomePage(getDriver());
        homePage.searchForIMac("Mac");

        // Verify if the Add to Cart button is displayed
        boolean isAddToCartDisplayed = homePage.isAddToCartButtonDisplayed();
        softAssert.assertTrue(isAddToCartDisplayed, "The Add to Cart button is not displayed. Search may have failed.");

        // Verify if the product title contains the search keyword
        boolean isTitleContainsKeyword = homePage.isTitleContainsSearchKeyword("Mac");
        softAssert.assertTrue(isTitleContainsKeyword, "The product title does not contain the search keyword.");

        // Log all assertion results
        softAssert.assertAll();
    }
}
