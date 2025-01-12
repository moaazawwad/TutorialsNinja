package testCases;

import org.testng.Assert; // Assertion library
import org.testng.annotations.Test; // Test annotation
import pages.P01_HomePage;

import static drivers.DriverHolder.getDriver;
//import pages.P06_ChangeCurrenciesPage; // Page object for currency changes

public class TC05_ChangeCurrencies extends testBase {
//    P06_ChangeCurrenciesPage changeCurrenciesPage;
    private P01_HomePage homePage;


    @Test(priority = 1, description = "Test changing the currency and verifying the displayed currency symbol")
    public void testCurrencyChange_P() {
        homePage = new P01_HomePage(getDriver());

        // Change currency randomly and retrieve the detected currency symbol
        String selectedCurrency = homePage.changeCurrencyRandomly();
        String detectedCurrencySymbol = homePage.getCurrencySymbol();

        // Verify the detected currency matches the selected currency
        if (selectedCurrency.equals("USD")) {
            Assert.assertEquals(detectedCurrencySymbol, "$", "Currency mismatch: Expected Dollar.");
        } else if (selectedCurrency.equals("EUR")) {
            Assert.assertEquals(detectedCurrencySymbol, "€", "Currency mismatch: Expected Euro.");
        } else if (selectedCurrency.equals("GBP")) {
            Assert.assertEquals(detectedCurrencySymbol, "£", "Currency mismatch: Expected Pound Sterling.");
        }
    }
}