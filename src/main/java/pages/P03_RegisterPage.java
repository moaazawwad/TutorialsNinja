package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_RegisterPage {
    public P03_RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-telephone")
    WebElement telephone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@name=\"agree\"]")
    WebElement policyAgree;

    @FindBy(xpath = "//input[@value=\"Continue\"]")
    WebElement registerButton;

    public void register(String firstName, String lastName, String email, String telephone, String password, String confirmPassword
    ) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.telephone.sendKeys(telephone);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        this.policyAgree.click();

        this.registerButton.click();
    }
}