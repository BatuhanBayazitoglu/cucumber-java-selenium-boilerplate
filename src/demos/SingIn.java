package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SingIn {
    public static void main(String[] args) {
        //parameters
        String url = "https://www.hepsiburada.com/uyelik/yeni-uye";
        String userName = "Test";
        String userSurname = "User";
        String userEmail = "bibu@mailing.one";
        String userPass = "Pass1234";
        String browserType = "chrome";
        boolean acceptRights = true;

        //1.WithDriverFactory
        WebDriver driver;
        driver = utilities.DriverFactory.open(browserType);

        //2.Navigate to the web application
        driver.get(url);

        //selectors
        By userNameSelector = By.id("firstname");
        By userSurnameSelector = By.id("lastname");
        By userEmailSelector = By.id("email-register");
        By userPassSelector = By.id("password-register");
        By createAccountCheckBox = By.cssSelector("label[for='subscribe-email']");
        By createAccountButtonSelector = By.className("btn-save-user");
        By loginErrorMessage = By.className("response-message-content");

        //Web Elements
        WebElement userNameElement = driver.findElement(userNameSelector);
        WebElement userSurnameElement = driver.findElement(userSurnameSelector);
        WebElement userPassElement = driver.findElement(userPassSelector);
        WebElement userEmailElement = driver.findElement(userEmailSelector);
        WebElement acceptRightElement = driver.findElement(createAccountCheckBox);
        WebElement createAccountButtonElement = driver.findElement(createAccountButtonSelector);

        //3.Fill your personal information
        //name
        userNameElement.sendKeys(userName);
        //surname
        userSurnameElement.sendKeys(userSurname);
        //email
        userEmailElement.sendKeys(userEmail);
        //password
        userPassElement.sendKeys(userPass);

        //scroll to element
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "150");

        //checkbox algorithm
        if (acceptRights) {
            if(!acceptRightElement.isSelected()){
                acceptRightElement.click();
            }
        }
        else {
            if(acceptRightElement.isSelected()){
                acceptRightElement.click();
            }
        }

        //4.Click create account
        createAccountButtonElement.click();

        //6.Get confirmation
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage));
        WebElement loginErrorMessageElement = driver.findElement(loginErrorMessage);

        if (loginErrorMessageElement.isDisplayed()) {
            System.out.println("Error message is shown!");
        }
        else {
            System.out.println("TEST FAILED");
        }

        //7.Close the browser
        driver.close();
        //driver.quit();

    }
}
