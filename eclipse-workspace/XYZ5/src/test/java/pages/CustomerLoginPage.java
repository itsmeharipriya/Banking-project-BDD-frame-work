package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CustomerLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By userDropdown = By.id("userSelect");
    By loginBtn = By.xpath("//button[text()='Login']");

    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectUser(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userDropdown));
        driver.findElement(userDropdown).sendKeys(name);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}