package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_LoginPage {
    WebDriver driver;
    public P02_LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy( id = "input-email")
    WebElement email;

    @FindBy( id = "input-password")
    WebElement password;

    @FindBy( xpath = "//input[@value=\"Login\"]")
    WebElement loginBTN;

    @FindBy( linkText = "Qafox.com")
    WebElement homePageButtom;

    public void login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginBTN.click();
    }

    public void backToHomePage() {
        homePageButtom.click();
    }

    public String loginSuccessMassege() {
        return driver.findElement(By.xpath("(//h2)[1]")).getText();
    }
}