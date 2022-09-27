package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class LoginWithoutCrossBrowser {
    public static void main(String[] args) {
        //parameters
        String basePath = new File("").getAbsolutePath();
        String url = "https://www.hepsiburada.com/uyelik/giris";
        String userEmail = "bernagokce@gmail.com";
        String userPass = "password";
        String expected_data = "Hesabım";
        String browserType = "chrome";
        WebDriver driver;

        //1. We should open web browser
        //Without cross browser
        System.setProperty("webdriver.chrome.driver", basePath+"/chromedriver");
        driver = new ChromeDriver();

        //With cross browser
//        if (browserType.equals("firefox")) {
//            //code for Firefox
//            System.setProperty("webdriver.gecko.driver", basePath + "/geckodriver");
//            driver = new FirefoxDriver();
//        }
//        else {
//            //code for Chrome
//            System.setProperty("webdriver.chrome.driver", basePath + "/chromedriver");
//            driver = new ChromeDriver();
//        }

        //2.Navigate to the web application
        driver.get(url);

        //selectors
        By userEmailSelector = By.id("email");
        By userPassSelector = By.id("password");
        By loginButtonSelector = By.className("btn-login-submit");
        By account_selector = By.className("cart-copy");


        //define web elements
        WebElement emailElement = driver.findElement(userEmailSelector);
        WebElement passElement = driver.findElement(userPassSelector);




        //3.Enter email address
        emailElement.sendKeys(userEmail);

        //4.Enter password
        passElement.sendKeys(userPass);

        //5.Click Login
        driver.findElement(loginButtonSelector).click();

        //6.Get confirmation

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(account_selector));

        List<WebElement> myElements = driver.findElements(account_selector);

        String myAccount = myElements.get(0).getText();

        //with Junit check (one way)
        assertTrue(myAccount.contains(expected_data));

        //with hardcoded check (another way)
        if (myAccount.equals(expected_data)) {
            System.out.println("Successfully Login!");
        }

        //7.Close the browser
        driver.close();
        //driver.quit();
    }
}
