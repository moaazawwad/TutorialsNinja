package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_LoginPage;

import static drivers.DriverHolder.getDriver;

public class TC08_AddToWishlist extends testBase {
    P01_HomePage homePage;
    P02_LoginPage loginPage;

    @Test(priority = 1, description = "Test adding a product to the wish list and validating the success message")

    public void testAddToWishlist() {
        SoftAssert softAssert = new SoftAssert();

        homePage = new P01_HomePage(getDriver());
        homePage.openLoginPage();

        loginPage = new P02_LoginPage(getDriver());
        loginPage.login("asdasdasd@mailinator.com", "asdasdasd");
        loginPage.backToHomePage();

        homePage.clickAddToWishlist();

        String expectedMessage = "Success: You have added MacBook to your wish list!";
        String actualMessage = homePage.getSuccessMessage();
        System.out.println("Actual Success Message: " + actualMessage);
        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Wish List success message validation failed!");
        softAssert.assertAll();
    }
}