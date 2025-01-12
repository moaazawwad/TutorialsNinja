package testCases;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_LoginPage;

import static drivers.DriverHolder.getDriver;

public class TC06_SelectCategories extends testBase {
    P01_HomePage homePage;
    P02_LoginPage loginPage;

    @Test(priority = 1, description = "Test hovering over categories and opening a subcategory if available")
    public void testHoverAndOpenCategory_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        homePage.openLoginPage();

        loginPage = new P02_LoginPage(getDriver());
        loginPage.login("asdasdasd@mailinator.com", "asdasdasd");

        String result = homePage.hoverAndOpenRandomSubcategory();

        if (result.startsWith("Subcategory opened:")) {
            assert true : "Subcategory was opened successfully.";
        } else if (result.equals("No subcategories") || result.equals("No dropdown menu")) {
            assert true : "Category had no subcategories or dropdown menu, which is valid.";
        } else {
            assert false : "Unexpected behavior occurred.";
        }
    }
}
