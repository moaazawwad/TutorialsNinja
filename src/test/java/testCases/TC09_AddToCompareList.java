package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_LoginPage;

import static drivers.DriverHolder.getDriver;

public class TC09_AddToCompareList extends testBase {
    P01_HomePage homePage;
     P02_LoginPage loginPage;

    @Test(priority = 1, description = "Test adding a product to the compare list and validating the success message")
    public void testAddToCompareList() {
        SoftAssert softAssert = new SoftAssert();

        homePage = new P01_HomePage(getDriver());
        homePage.openLoginPage();

        loginPage = new P02_LoginPage(getDriver());
        loginPage.login("asdasdasd@mailinator.com", "asdasdasd");
        loginPage.backToHomePage();

        homePage.clickAddToCompare();

        String expectedMessage = "Success: You have added MacBook to your product comparison!";
        String actualMessage = homePage.getSuccessMessage();

        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Product Comparison success message validation failed!");
        softAssert.assertAll();
    }
}
