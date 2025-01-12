package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P04_ResetPassword;

import static testCases.TC01_Register.email;
import static drivers.DriverHolder.getDriver;

public class TC03_ResetPassword extends testBase {
    private P01_HomePage homePage;
    private P04_ResetPassword resetPassPage;

    @Test(priority = 1, description = "Test reset password functionality with a valid email")
    public void verifyForgetPasswordWithValidEmail_P() throws InterruptedException {
        // Initialize pages
        homePage = new P01_HomePage(getDriver());
        resetPassPage = new P04_ResetPassword(getDriver());

        // Navigate to Forgot Password Page
        homePage.openForgetPasswordPage();

        // Perform password reset
        resetPassPage.forgetPassword(email);
        Thread.sleep(2000); // Consider replacing with WebDriverWait for better handling

        // Validate success message
        String actualMessage = resetPassPage.getSuccessMessageText();
        String expectedMessage = "An email with a confirmation link has been sent your email address.";
        Assert.assertEquals(actualMessage, expectedMessage, "The success message text does not match!");
    }
}