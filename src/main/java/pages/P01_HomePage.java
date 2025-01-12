package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class P01_HomePage {
    WebDriver driver;
    public P01_HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy( xpath = "(//li/a/span)[1]")
    WebElement myAccount;

    @FindBy( xpath = "(//ul/li/a)[4]")
    WebElement login;

    @FindBy( xpath = "(//ul/li/a)[3]")
    WebElement register;

    @FindBy(xpath ="//a[text()='Forgotten Password'][1]" )
    WebElement forgetPassword;

    @FindBy(xpath = "(//ul/li/a)[7]")
    WebElement logout;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a")
    List<WebElement> topCategories;

    @FindBy(css = "div.alert.alert-success")
    WebElement addToCartSuccessMessage;

    @FindBy(xpath = "(//button[@data-original-title='Add to Wish List'])[1]")
    WebElement addToWishlistButton;

    @FindBy(xpath = "(//button[@data-original-title='Compare this Product'])[1]")
    WebElement addToCompareButton;

    @FindBy(xpath = "//input[@name=\"search\"]")
    WebElement searchInput;

    @FindBy(xpath = "//button[contains(@onclick, 'cart.add')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='caption']//h4/a")
    WebElement productTitle;
    @FindBy(xpath = "//button[.//span[text()='Currency']]")
    WebElement currencyDropdownButton;

    @FindBy(xpath = "//*[@id=\"cart\"]/button")
    WebElement itemsButton;

    @FindBy(xpath = "//button[@title=\"Remove\"]")
    WebElement removeButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//button[@class='currency-select btn btn-link btn-block']")
    List<WebElement> currencyOptions;

    @FindBy(xpath = "//p[@class='price']")
    List<WebElement> productPrices;
    public void openLoginPage() {
        myAccount.click();
        login.click();
    }

    public void openRegisterPage() {
        myAccount.click();
        register.click();
    }

    public void openForgetPasswordPage() {
        this.openLoginPage();
        forgetPassword.click();
    }

    public void logout() {
            myAccount.click();
            this.logout.click();
    }

    public void searchForIMac(String keyWords) {
        WebElement search = this.searchInput;
        search.sendKeys(keyWords);
        search.sendKeys(Keys.ENTER);
    }

    // Method to check if the Add to Cart button is displayed
    public boolean isAddToCartButtonDisplayed() {
        return addToCartButton.isDisplayed();
    }

    public boolean isTitleContainsSearchKeyword(String searchKeyword) {
        String titleText = productTitle.getText();
        return titleText.toLowerCase().contains(searchKeyword.toLowerCase());
    }
    public String hoverAndOpenRandomSubcategory() throws InterruptedException {
        Actions actions = new Actions(driver);
        Random random = new Random();

        // Select a random top-level category
        int randomIndex = random.nextInt(topCategories.size());
        WebElement randomCategory = topCategories.get(randomIndex);

        // Hover over the selected category
        actions.moveToElement(randomCategory).perform();
        Thread.sleep(1000); // Allow dropdown rendering

        try {
            // Locate the specific dropdown menu for the hovered category
            List<WebElement> dropdownMenus = randomCategory.findElements(By.xpath(".//following-sibling::div[contains(@class, 'dropdown-menu')]"));

            if (!dropdownMenus.isEmpty()) {
                WebElement dropdownMenu = dropdownMenus.get(0); // Get the first dropdown menu
                System.out.println("Dropdown Menu HTML: " + dropdownMenu.getAttribute("innerHTML"));

                // Check if subcategories are present
                List<WebElement> subcategories = dropdownMenu.findElements(By.xpath(".//a"));
                System.out.println("Found subcategories: " + subcategories.size());

                if (!subcategories.isEmpty()) {
                    // Select and click a random subcategory
                    int randomSubIndex = random.nextInt(subcategories.size());
                    WebElement randomSubcategory = subcategories.get(randomSubIndex);
                    String subcategoryName = randomSubcategory.getText().trim();
                    System.out.println("Selected Subcategory: " + subcategoryName);
                    actions.moveToElement(randomSubcategory).perform();

                    // Uncomment if you want to click the subcategory
                    // randomSubcategory.click();
                    System.out.println("Opened Subcategory: " + subcategoryName);
                    return "Subcategory opened: " + subcategoryName;
                } else {
                    // Log and return if no subcategories are found
                    return "No subcategories";
                }
            } else {
                // Log and return if no dropdown menu is found
                return "No dropdown menu";
            }
        } catch (NoSuchElementException e) {
            // Handle the exception gracefully
            return "No dropdown menu";
        }
    }

    // Method to click Add to Cart
    public void clickOnAddToCart() {
        addToCartButton.click();
        System.out.println("Clicked on Add to Cart");
    }
    public void clickOnItems() {
        itemsButton.click();
        System.out.println("Clicked on Add to Cart");
    }
    public void clickOnRemove() {
        removeButton.click();
        System.out.println("Clicked on Add to Cart");
    }
    public String getSuccessMessage() {
        return addToCartSuccessMessage.getText().trim();
    }

    // Method to click Add to Wishlist
    public void clickAddToWishlist() {
        addToWishlistButton.click();
        System.out.println("Clicked on Add to Wishlist");
    }

    // Method to click Add to Compare
    public void clickAddToCompare() {
        addToCompareButton.click();
        System.out.println("Clicked on Add to Compare");
    }

    public void openCurrencyDropdown() {
        currencyDropdownButton.click();
    }

    // Method to randomly change the currency, ensuring it's not USD
    public String changeCurrencyRandomly() {
        String selectedCurrency = "USD"; // Default currency
        Random random = new Random();

        // Loop until a different currency is selected
        while (selectedCurrency.equals("USD")) {
            openCurrencyDropdown(); // Ensure dropdown is open
            int randomIndex = random.nextInt(currencyOptions.size()); // Random index
            WebElement randomCurrency = currencyOptions.get(randomIndex);

            // Get the currency name
            selectedCurrency = randomCurrency.getAttribute("name");

            // Click to select if it's not USD
            if (!selectedCurrency.equals("USD")) {
                randomCurrency.click();
            }
        }
        return selectedCurrency; // Return the selected currency for verification
    }

    // Method to get the currency symbol from the first product price
    public String getCurrencySymbol() {
        if (productPrices.size() > 0) {
            String priceText = productPrices.get(0).getText().trim(); // Get the first price text
            System.out.println("Retrieved Price Text: " + priceText); // Debugging

            // Check which symbol the text contains
            if (priceText.contains("$")) {
                return "$"; // Dollar
            } else if (priceText.contains("€")) {
                return "€"; // Euro
            } else if (priceText.contains("£")) {
                return "£"; // Pound Sterling
            } else {
                return "Unknown"; // No recognized currency symbol
            }
        }
        return ""; // Return empty string if no prices are found
    }
}
