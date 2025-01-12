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
        homePage = new P01_HomePage(getDriver());
        homePage.openRegisterPage();

        email = DataGenerator.generateEmail();
        password = DataGenerator.generatePassword();
        String firstName = DataGenerator.generateFirstName();
        String lastName = DataGenerator.generateLastName();
        String telephone = DataGenerator.generateTelephone();

        registerPage = new P03_RegisterPage(getDriver());
        registerPage.register(firstName, lastName, email, telephone, password, password);

        homePage.logout();
    }
}
