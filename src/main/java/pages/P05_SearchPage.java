//package pages;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class P05_SearchPage {
//
//    public P05_SearchPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
//    @FindBy(xpath = "//input[@name=\"search\"]")
//    WebElement searchInput;
//
//    @FindBy(xpath = "//button[contains(@onclick, 'cart.add')]")
//    WebElement addToCartButton;
//
//    @FindBy(xpath = "//div[@class='caption']//h4/a")
//    WebElement productTitle;
//
//
//    public void searchForIMac(String keyWords) {
//      WebElement search = this.searchInput;
//      search.sendKeys(keyWords);
//      search.sendKeys(Keys.ENTER);
//    }
//
//
//    // Method to check if the Add to Cart button is displayed
//    public boolean isAddToCartButtonDisplayed() {
//        return addToCartButton.isDisplayed();
//    }
//
//
//    public boolean isTitleContainsSearchKeyword(String searchKeyword) {
//        String titleText = productTitle.getText();
//        return titleText.toLowerCase().contains(searchKeyword.toLowerCase());
//    }
//
//
//}
