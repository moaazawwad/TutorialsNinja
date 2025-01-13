package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_ProdcutDetails {
    WebDriver driver;
   public P05_ProdcutDetails(
    WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "button-cart")
    WebElement addToCartButton;

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

    public void clickOnCheckoutButton() {

        checkoutButton.click();
    }

    public void clickOnContinueButtonStepTwo() {
        continueButtonStepTwo.click();
    }

    public void clickOnContinueButtonStepThree() {
        continueButtonStepThree.click();
    }

    public void clickOnContinueButtonStepFour() {
        continueButtonStepFour.click();
    }

    public void clickOnAgreeSearchTerms() {
        agreeSearchTerms.click();
    }

    public void clickOnContinueButtonStepFive() {
        continueButtonStepFive.click();
    }

    public void clickOnConfirmOrderButton() {
        confirmOrderButton.click();
    }

    public String getSuccessOrderMessage() {
        return successOrderMessage.getText();
    }
}
