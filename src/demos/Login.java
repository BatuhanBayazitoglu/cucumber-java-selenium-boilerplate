package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Login {

    public static void main(String[] args) {
        //parameters
        String url = "https://www.hepsiburada.com/uyelik/giris";
        String userEmail = "bernagokce@gmail.com";
        String userPass = "password";
        String expected_data = "Hesabım";
        String browserType = "safari";

        //1.WithDriverFactory
        WebDriver driver;
        driver = utilities.DriverFactory.open(browserType);

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
        WebElement loginButtonElement = driver.findElement(loginButtonSelector);

        //3.Enter email address
        emailElement.sendKeys(userEmail);

        //4.Enter password
        passElement.sendKeys(userPass);

        //5.Click Login
        loginButtonElement.click();

        //6.Get confirmation

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(account_selector));
        List<WebElement> myElements = driver.findElements(account_selector);

        String myAccount = myElements.get(0).getText();

        //with Junit check (one way)
        assertTrue(myAccount.contains(expected_data));

        //with hardcoded check (another way)
        if (myAccount.contains(expected_data)) {
            System.out.println("Successfully Login!");
        }
        else {
            System.out.println("TEST FAILED!");
        }

        //7.Close the browser
        driver.close();
        //driver.quit();
    }
}
