package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ManagerPage {

    WebDriver driver;
    WebDriverWait wait;

    By addCustomerBtn = By.xpath("//button[contains(text(),'Add Customer')]");
    By firstNameField = By.xpath("//input[@placeholder='First Name']");
    By lastNameField  = By.xpath("//input[@placeholder='Last Name']");
    By postCodeField  = By.xpath("//input[@placeholder='Post Code']");
    By submitBtn      = By.xpath("//button[@type='submit']");
    By openAccountTab = By.xpath("//button[@ng-click='openAccount()']");
    By customerDropdown = By.id("userSelect");
    By currencyDropdown = By.id("currency");
    By processBtn = By.xpath("//button[contains(text(),'Process')]");


By customersTab = By.xpath("//button[@ng-click='showCust()']");

By Searchbtn = By.xpath("//input[@ng-model='searchCustomer']");
    
    public ManagerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickAddCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerBtn)).click();
    }

    public void enterFirstName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(name);
    }

    public void enterLastName(String name) {
        driver.findElement(lastNameField).sendKeys(name);
    }

    public void enterPostCode(String code) {
        driver.findElement(postCodeField).sendKeys(code);
    }

    public void clickAddCustomerSubmit() {
        WebElement submitBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))
        );
        submitBtn.click();
    }

    public boolean isAlertDisplayed() {

        wait.until(ExpectedConditions.alertIsPresent());

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert message: " + alertText);

        driver.switchTo().alert().accept();

        return alertText.contains("Customer added successfully");
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    public void clickOpenAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openAccountTab)).click();
    }
   
    public void selectCustomer(String name) {

        WebElement customer = wait.until(
                ExpectedConditions.visibilityOfElementLocated(customerDropdown)
        );

        Select select = new Select(customer);
        select.selectByVisibleText(name);
    }

    public void selectCurrency(String currency) {

        WebElement curr = wait.until(
                ExpectedConditions.visibilityOfElementLocated(currencyDropdown)
        );

        Select select = new Select(curr);
        select.selectByVisibleText(currency);
    }

    public void clickProcessButton() {
        driver.findElement(processBtn).click();
    }

    public void handleAlert() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    public void clickCustomersTab() {
        wait.until(ExpectedConditions.elementToBeClickable(customersTab)).click();
    }

    public void searchCustomer(String name) {

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Searchbtn)
                       
   );

        searchBox.clear();
        searchBox.sendKeys(name);

        System.out.println("Customer searched: " + name);
    }
}