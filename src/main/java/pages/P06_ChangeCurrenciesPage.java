//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import java.util.List;
//import java.util.Random;
//
//public class P06_ChangeCurrenciesPage {
//    public P06_ChangeCurrenciesPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
//
//    // Dropdown toggle button
//    @FindBy(xpath = "//button[.//span[text()='Currency']]")
//    WebElement currencyDropdownButton;
//
//    // List of currency options
//    @FindBy(xpath = "//ul[@class='dropdown-menu']//button[@class='currency-select btn btn-link btn-block']")
//    List<WebElement> currencyOptions;
//
//    // Price elements in product cards
//    @FindBy(xpath = "//p[@class='price']")
//    List<WebElement> productPrices;
//
//    // Method to open the dropdown
//    public void openCurrencyDropdown() {
//        currencyDropdownButton.click();
//    }
//
//    // Method to randomly change the currency, ensuring it's not USD
//    public String changeCurrencyRandomly() {
//        String selectedCurrency = "USD"; // Default currency
//        Random random = new Random();
//
//        // Loop until a different currency is selected
//        while (selectedCurrency.equals("USD")) {
//            openCurrencyDropdown(); // Ensure dropdown is open
//            int randomIndex = random.nextInt(currencyOptions.size()); // Random index
//            WebElement randomCurrency = currencyOptions.get(randomIndex);
//
//            // Get the currency name
//            selectedCurrency = randomCurrency.getAttribute("name");
//
//            // Click to select if it's not USD
//            if (!selectedCurrency.equals("USD")) {
//                randomCurrency.click();
//            }
//        }
//        return selectedCurrency; // Return the selected currency for verification
//    }
//
//    // Method to get the currency symbol from the first product price
//    public String getCurrencySymbol() {
//        if (productPrices.size() > 0) {
//            String priceText = productPrices.get(0).getText().trim(); // Get the first price text
//            System.out.println("Retrieved Price Text: " + priceText); // Debugging
//
//            // Check which symbol the text contains
//            if (priceText.contains("$")) {
//                return "$"; // Dollar
//            } else if (priceText.contains("€")) {
//                return "€"; // Euro
//            } else if (priceText.contains("£")) {
//                return "£"; // Pound Sterling
//            } else {
//                return "Unknown"; // No recognized currency symbol
//            }
//        }
//        return ""; // Return empty string if no prices are found
//    }
//
//
//}
