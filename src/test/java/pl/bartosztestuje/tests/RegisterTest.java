package pl.bartosztestuje.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bartosztestuje.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        int random = (int) (Math.random() * 1000);

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData("test5" + random + "@raz12l.pl", "abc123abc@@@l1")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithSameEmailTest() {

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test5@raz12l.pl", "abc123abc@@@l1")
                .getError();

        Assert.assertTrue(error.getText().contains(" An account is already registered with your email address."));
    }
}
