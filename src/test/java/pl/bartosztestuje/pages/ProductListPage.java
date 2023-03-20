package pl.bartosztestuje.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pl.bartosztestuje.utils.SeleniumHelper;

public class ProductListPage{

    private WebDriver driver;
    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage openProduct(String title) {
        By xpathProduct = By.xpath("//h2[text()='"+ title +"']");
        SeleniumHelper.waitForClickable(xpathProduct,driver);
        driver.findElement(xpathProduct).click();
        return new ProductPage(driver);
    }
}
