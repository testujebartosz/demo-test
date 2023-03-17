package pl.bartosztestuje.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bartosztestuje.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void logInTest() {

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData("test5@raz12l.pl", "abc123abc@@@l1")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInWithInvalidPasswordTest() {

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData("test5@raz122l.pl", "abc123abc@@@l1")
                .getError();

        Assert.assertTrue(error.getText().contains(" Incorrect username or password."),
                "Expected error text doesn't match");
    }
}
