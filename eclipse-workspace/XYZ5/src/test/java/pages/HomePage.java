package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {

    WebDriver driver;

    By customerLoginBtn = By.xpath("//button[text()='Customer Login']");
    By managerLoginBtn  = By.xpath("//button[text()='Bank Manager Login']");

    public HomePage(WebDriver driver) { this.driver = driver; }
    public void clickCustomerLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(customerLoginBtn)).click();
    }

    public void clickManagerLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(managerLoginBtn)).click();
    }
}