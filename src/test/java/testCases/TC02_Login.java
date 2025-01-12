package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_LoginPage;

import static testCases.TC01_Register.email;
import static testCases.TC01_Register.password;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.getDriver;

public class TC02_Login extends testBase {

    private P02_LoginPage loginPage;
    private P01_HomePage homePage;

    @Test(priority = 2, description = "Test login with valid credentials using dynamic data")
    public void loginWithValidDynamicData_P() throws InterruptedException {
        // Initialize pages
        loginPage = new P02_LoginPage(getDriver());
        homePage = new P01_HomePage(getDriver());

        homePage.openLoginPage();

        // Login with dynamic credentials
        loginPage.login(email, password);

        // Hard assertions for login validation
        Assert.assertEquals(loginPage.loginSuccessMassege(), "My Account", "Login success message mismatch");
        Assert.assertTrue(getDriver().getPageSource().contains("Logout"), "Logout option not found on the page");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/account", "URL mismatch after login");

        // Soft assertions for login validation
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.loginSuccessMassege(), "My Account", "Login success message mismatch");
        softAssert.assertTrue(getDriver().getPageSource().contains("Logout"), "Logout option not found on the page");
        softAssert.assertEquals(getDriver().getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/account", "URL mismatch after login");
        softAssert.assertAll();

        // Logout after validation
        homePage.logout();
    }

    @Test(priority = 3, description = "Test login with invalid credentials")
    public void loginWithInvalidCredentials() {
        // Initialize pages
        homePage = new P01_HomePage(getDriver());
        loginPage = new P02_LoginPage(getDriver());

        // Navigate to Login Page
        homePage.openLoginPage();

        // Attempt login with invalid credentials
        loginPage.login("invalidemail@example.com", "wrongpassword");
    }
}
