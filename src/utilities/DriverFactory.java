package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

public class DriverFactory {

    // This returns a WebDriver object
    public static WebDriver open(String browserType){
        String basePath = new File("").getAbsolutePath();

        if (browserType.equalsIgnoreCase("firefox")) {
            //code for Firefox
            System.setProperty("webdriver.gecko.driver", basePath + "/geckodriver");
            return new FirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        }
        else {
            //code for Chrome
            System.setProperty("webdriver.chrome.driver", basePath + "/chromedriver");
            return new ChromeDriver();
        }
    }
}
