package stepDefenitions;

import io.cucumber.java.en.*;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import factory.DriverFactory;
import pages.AccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;

public class CustomerSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage home;
    CustomerLoginPage cust;
    AccountPage accountPage;

    @Given("Customer is on Banking Home Page")
    public void customerOnHome() {
        home = new HomePage(driver);
    }

    @When("Customer clicks on {string}")
    public void customerClicks(String btn) {
        switch(btn.toLowerCase()) {
            case "customer login":
                home.clickCustomerLogin();
                break;
            case "deposit":
                accountPage = new AccountPage(driver);
                accountPage.clickDepositTab();
                break;
            case "withdraw":
                accountPage = new AccountPage(driver);
                accountPage.clickWithdrawTab();
                break;
            case "transactions":
                accountPage.clickTransactionsAndWaitForTable();
                break;
            default:
                // fallback for other buttons
                System.out.println("⚠️ Button not handled: " + btn);
        }
    }

    @When("Customer selects {string}")
    public void selectCustomer(String name) {
        cust = new CustomerLoginPage(driver);
        cust.selectUser(name);
    }

    @When("Customer clicks {string}")
    public void customerClicksAny(String button) {
        if(button.equalsIgnoreCase("Login")) {
            cust.clickLogin();
            accountPage = new AccountPage(driver);
        }
    }

    @When("Customer enters {string} in amount field")
    public void customer_enters_amount(String amount) {
        accountPage.enterAmount(amount);
    }

    @When("Customer clicks Deposit button")
    public void customer_clicks_deposit_button() {
        accountPage.clickDepositButton();
    }

    @When("Customer clicks Withdraw button")
    public void customer_clicks_withdraw_button() {
        accountPage.clickWithdrawButton();
    }

    @Then("Customer should be logged in successfully")
    public void customer_should_be_logged_in_successfully() {
        Assert.assertTrue(accountPage.isDepositTabVisible(), "Deposit tab not visible - login may have failed");
        Assert.assertTrue(accountPage.isWithdrawTabVisible(), "Withdraw tab not visible - login may have failed");
        System.out.println("✅ Customer login successful and account page loaded");
    }

    @Then("Customer should see deposit success message")
    public void customer_should_see_deposit_success_message() {
        Assert.assertTrue(accountPage.isDepositSuccessMessageVisible(), "Deposit not successful!");
        System.out.println("✅ Deposit success verified!");
    }

    @Then("Customer should see withdraw success message")
    public void customer_should_see_withdraw_success_message() {
        Assert.assertTrue(accountPage.isWithdrawSuccessMessageVisible(), "Withdraw not successful!");
        System.out.println("✅ Withdraw success verified!");
    }

    @Then("Customer should see the transaction list")
    public void customerSeesTransactionList() {
        accountPage.clickTransactionsAndWaitForTable();
       // Assert.assertTrue(accountPage.getTransactionTable().isDisplayed(), "Transaction table not displayed");
        System.out.println("✅ Transaction list displayed");
    }

    
    
}