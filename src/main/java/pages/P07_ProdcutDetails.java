package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P07_ProdcutDetails {
    WebDriver driver;
   public P07_ProdcutDetails (
    WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "button-cart")
    WebElement addToCartButton;

//    @FindBy(linkText = "shopping cart")
//    WebElement shoppingCart;

    @FindBy(linkText = "Checkout")
    WebElement checkoutButton;

    @FindBy(id = "button-payment-address")
    WebElement continueButtonStepTwo;

    @FindBy(id = "button-shipping-address")
    WebElement continueButtonStepThree;

    @FindBy(id = "button-shipping-method")
    WebElement continueButtonStepFour;

    @FindBy(xpath = "//input[@name=\"agree\"]")
    WebElement agreeSearchTerms;

    @FindBy(id = "button-payment-method")
    WebElement continueButtonStepFive;

    @FindBy(id = "button-confirm")
    WebElement confirmOrderButton;

    @FindBy(xpath = "//h1[text()=\"Your order has been placed!\"]")
    WebElement successOrderMessage;



    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

//    public void openShoppingCart() {
//        shoppingCart.click();
//    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }


    public void clickOnContinueButtonStepTwo() {
        continueButtonStepTwo.click();
    }

    /**
     * Clicks on the "Continue" button on step three of the checkout process.
     */
    public void clickOnContinueButtonStepThree() {
        continueButtonStepThree.click();
    }

    /**
     * Clicks on the "Continue" button on step four of the checkout process.
     */
    public void clickOnContinueButtonStepFour() {
        continueButtonStepFour.click();
    }

    /**
     * Clicks on the agreement checkbox to agree to the terms and conditions.
     */
    public void clickOnAgreeSearchTerms() {
        agreeSearchTerms.click();
    }

    /**
     * Clicks on the "Continue" button on step five of the checkout process.
     */
    public void clickOnContinueButtonStepFive() {
        continueButtonStepFive.click();
    }

    /**
     * Clicks on the "Confirm Order" button to complete the checkout process.
     */
    public void clickOnConfirmOrderButton() {
        confirmOrderButton.click();
    }

    /**
     * Retrieves the success message text displayed after confirming the order.
     *
     * @return The success message text.
     */
    public String getSuccessOrderMessage() {
        return successOrderMessage.getText();
    }
}
