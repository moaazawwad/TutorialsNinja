package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_LoginPage;
import pages.P07_ProdcutDetails;

import static drivers.DriverHolder.getDriver;

public class TC10_CreateSuccessfulOrder extends testBase {

    P01_HomePage homePage;
    P02_LoginPage loginPage;
    P07_ProdcutDetails productDetails;

    @Test(priority = 1, description = "Test creating a successful order and validating the success message")
    public void testCreateSuccessfulOrder() {
        // Initialize the HomePage
        homePage = new P01_HomePage(getDriver());

        // Navigate to Login Page
        homePage.openLoginPage();
        loginPage = new P02_LoginPage(getDriver());

        // Login with valid credentials
        loginPage.login("asdasdasd@mailinator.com", "asdasdasd");
        loginPage.backToHomePage();

        // Search for a product
        homePage.searchForIMac("hp");
        homePage.clickOnAddToCart();

        productDetails = new P07_ProdcutDetails(getDriver());
        productDetails.clickOnAddToCartButton();
        productDetails.clickOnCheckoutButton();
        productDetails.clickOnContinueButtonStepTwo();
        productDetails.clickOnContinueButtonStepThree();
        productDetails.clickOnContinueButtonStepFour();
        productDetails.clickOnAgreeSearchTerms();
        productDetails.clickOnContinueButtonStepFive();
        productDetails.clickOnConfirmOrderButton();

        String expectedMessage = "Your order has been placed!";
        String actualMessage = productDetails.getSuccessOrderMessage();

        // Initialize SoftAssert for validation
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }
}
