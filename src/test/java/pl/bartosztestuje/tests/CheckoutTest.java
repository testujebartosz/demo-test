package pl.bartosztestuje.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bartosztestuje.models.Customer;
import pl.bartosztestuje.pages.HomePage;
import pl.bartosztestuje.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();
        customer.setFirstName("Bartek");
        customer.setLastName("Test");
        customer.setCompanyName("XXX");
        customer.setCountry("Poland");
        customer.setStreetAddress("Testowa");
        customer.setFlatNumber("22");
        customer.setPostcode("39-300");
        customer.setCity("Mielec");
        customer.setPhone("555666777");
        customer.setEmail("testowy@random.com");

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer, "Testowy");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver × 1");
    }
}
