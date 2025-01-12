package testCases;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_RegisterPage;
import Utils.DataGenerator;

import static drivers.DriverHolder.getDriver;

public class TC01_Register extends testBase {

     P01_HomePage homePage;
     P03_RegisterPage registerPage;
     static String email;
     static String password;

    @Test(priority = 1, description = "Test register with dynamic data")
    public void registerWithDynamicData_P() {
        // Initialize the HomePage and navigate to the Register Page
        homePage = new P01_HomePage(getDriver());
        homePage.openRegisterPage();

        // Generate dynamic data for registration
        String firstName = DataGenerator.generateFirstName();
        String lastName = DataGenerator.generateLastName();
        email = DataGenerator.generateEmail();
        String telephone = DataGenerator.generateTelephone();
        password = DataGenerator.generatePassword();

        // Initialize the RegisterPage and complete the registration process
        registerPage = new P03_RegisterPage(getDriver());
        registerPage.register(firstName, lastName, email, telephone, password, password);

        // Logout after registration
        homePage.logout();
    }
}
