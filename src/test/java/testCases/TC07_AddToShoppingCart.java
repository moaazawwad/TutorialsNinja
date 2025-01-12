package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_LoginPage;

import static drivers.DriverHolder.getDriver;

public class TC07_AddToShoppingCart extends testBase {
    P01_HomePage homePage;
    P02_LoginPage loginPage;

    @Test(priority = 1, description = "Test adding a product to the shopping cart and validating the success message")
    public void testAddToShoppingCart_P() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        homePage = new P01_HomePage(getDriver());
        homePage.openLoginPage();

        loginPage = new P02_LoginPage(getDriver());
        loginPage.login("asdasdasd@mailinator.com", "asdasdasd");
        loginPage.backToHomePage();

        homePage.clickOnAddToCart();
        homePage.clickOnItems();
        homePage.clickOnRemove();

        String expectedMessage = "Success: You have added MacBook to your shopping cart!";
        String actualMessage = homePage.getSuccessMessage();

        // Soft assertion to validate the success message
        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Add to cart success message validation failed!");
        softAssert.assertAll();
    }
}
