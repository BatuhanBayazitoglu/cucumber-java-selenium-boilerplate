package junit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageCheck {

    @Test
    public static void homePageCheck(){
        String browserType = "chrome";
        WebDriver driver = utilities.DriverFactory.open(browserType);
        driver.get("");

        By pageTitle = By.id("");

        WebElement pageTitleElement = driver.findElement(pageTitle);
         String actualTitle = pageTitleElement.getText();
         String expectedTitle = "Hepsi Burada";

    }
}
