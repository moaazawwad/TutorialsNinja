package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_ResetPassword  {

    public P04_ResetPassword(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="input-email")
    WebElement email;

    @FindBy(xpath = "//input[@value=\"Continue\"]")
    WebElement continureBtn;

    @FindBy(xpath = "//div[text()='An email with a confirmation link has been sent your email address.']")
    WebElement successMessage;

    public void forgetPassword(String email) {
        this.email.sendKeys(email);
        continureBtn.click();
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }
}