package pl.bartosztestuje.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bartosztestuje.utils.SeleniumHelper;

public class CartPage {

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement proccedToCheckoutButton;

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AddressDetailsPage openAddressDetails() {
        SeleniumHelper.waitForClickable(proccedToCheckoutButton, driver);
        proccedToCheckoutButton.click();
        return new AddressDetailsPage(driver);
    }

}
