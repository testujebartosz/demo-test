package pl.bartosztestuje.utils;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver getDriver(final String browser) {
        switch (browser) {
            case "firefox":
                FirefoxOptions options1 = new FirefoxOptions();
                return new FirefoxDriver(options1);
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);
            case "safari":
                return new SafariDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }
}
