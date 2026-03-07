package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AccountPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By depositTab = By.xpath("//button[@ng-click='deposit()']");
    By withdrawTab = By.xpath("//button[@ng-click='withdrawl()']");
    By amountInput = By.xpath("//input[@ng-model='amount']");
    By depositSubmitButton = By.xpath("//button[@type='submit' and text()='Deposit']");
    By withdrawButton = By.xpath("//button[@type='submit' and text()='Withdraw']");
    By depositSuccessMessage = By.xpath("//span[contains(text(),'Deposit Successful')]");
    By withdrawSuccessMsg = By.xpath("//span[contains(text(),'Transaction successful')]");
    By transactionTab = By.xpath("//button[@ng-click='transactions()']");
    By transactionTable = By.cssSelector("table.table");

    // =========================
    // LOGIN VERIFICATION
    // =========================
    public boolean isDepositTabVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(depositTab)).isDisplayed();
    }

    public boolean isWithdrawTabVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(withdrawTab)).isDisplayed();
    }

    // =========================
    // DEPOSIT FLOW
    // =========================
    public void clickDepositTab() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(depositTab));
        scrollIntoView(tab);
        tab.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
        System.out.println("✅ Clicked Deposit tab and input is ready");
    }

    public void enterAmount(String amount) {
        WebElement amountField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//form[not(contains(@class,'ng-hide'))]//input[@ng-model='amount']")
                )
        );
        scrollIntoView(amountField);
        amountField.click();
        amountField.clear();
        amountField.sendKeys(amount);

        System.out.println("Entered Amount in Field: " + amountField.getAttribute("value"));
    }

    public void clickDepositButton() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(depositSubmitButton));
        scrollIntoView(btn);
        btn.click();
        System.out.println("✅ Clicked Deposit button to submit");
    }

    public boolean isDepositSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(depositSuccessMessage)).isDisplayed();
    }

    // =========================
    // WITHDRAW FLOW
    // =========================
    public void clickWithdrawTab() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(withdrawTab));
        scrollIntoView(tab);
        tab.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//form[@ng-submit='withdrawl()']//input")
        ));
        System.out.println("✅ Clicked Withdraw tab");
    }

    public void clickWithdrawButton() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(withdrawButton));
        scrollIntoView(btn);
        btn.click();
        System.out.println("✅ Clicked Withdraw button to submit");
    }

    public boolean isWithdrawSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(withdrawSuccessMsg)).isDisplayed();
    }

    // =========================
    // TRANSACTIONS FLOW
    // =========================
    public void clickTransactionsAndWaitForTable() {
        WebElement transactionsBtn = wait.until(ExpectedConditions.elementToBeClickable(transactionTab));
        scrollIntoView(transactionsBtn);
        transactionsBtn.click();
        System.out.println("✅ Clicked Transactions tab");

        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionTable));
        System.out.println("✅ Transaction table visible");
    }

  
    // =========================
    // HELPER METHODS
    // =========================
    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}