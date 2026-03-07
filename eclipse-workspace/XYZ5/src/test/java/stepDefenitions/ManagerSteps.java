package stepDefenitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import factory.DriverFactory;
import pages.*;

public class ManagerSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage home;
    ManagerPage manager;

    @Given("Manager is on Banking Home Page")
    public void managerOnHome() {
        home = new HomePage(driver);
        manager = new ManagerPage(driver);
    }

    @When("Manager clicks on {string}")
    public void managerClicks(String btn){

        if(btn.equals("Bank Manager Login")){
            home.clickManagerLogin();
        }

        else if(btn.equals("Add Customer")){
            manager.clickAddCustomer();
        }

        else if(btn.equals("Open Account")){
            manager.clickOpenAccount();
        }
    }

    @When("Manager enters {string} in First Name")
    public void firstName(String name){
        manager.enterFirstName(name);
    }

    @When("Manager enters {string} in Last Name")
    public void lastName(String name){
        manager.enterLastName(name);
    }

    @When("Manager enters {string} in Post Code")
    public void postCode(String code){
        manager.enterPostCode(code);
    }

    @When("Manager clicks {string} button")
    public void manager_clicks_button(String btn) {

        if(btn.equals("Add Customer")) {
            manager.clickAddCustomerSubmit();
        }

        else if(btn.equals("Process")) {
            manager.clickProcessButton();
        }
    }

    @When("Manager selects {string}")
    public void manager_selects_customer(String name) {
        manager.selectCustomer(name);
    }

    @When("Manager selects currency {string}")
    public void manager_selects_currency(String currency) {
        manager.selectCurrency(currency);
    }
    @When("Manager clicks Process button")
    public void manager_clicks_process_button() {
        manager.clickProcessButton();
    }

    @Then("Manager should see confirmation alert")
    public void managerAlert(){
        Assert.assertTrue(manager.isAlertDisplayed());
    }

    @Then("Manager should see account created alert")
    public void manager_account_created_alert() {
        manager.handleAlert();
    }
    @When("Manager clicks Customers tab")
    public void manager_clicks_customers_tab() {
        manager.clickCustomersTab();
    }

    @When("Manager searches customer {string}")
    public void manager_search_customer(String name) {
        manager.searchCustomer(name);
    }
}