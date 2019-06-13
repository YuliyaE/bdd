package by.yuliya.calculator.teststeps;

import by.yuliya.calculator.page.CalculatorPage;
import by.yuliya.calculator.page.EmailPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

public class GoogleCLoudCheckSteps {


    private AutomationApi automationApi;

    public GoogleCLoudCheckSteps(AutomationApi automationApi) {
        this.automationApi = automationApi;
    }

    @And("^I opened email page$")
    public void iOpenedEmailPage() {
        automationApi.emailPage = new EmailPage(automationApi.driver.getDriver()).openPage();
    }

    @Then("^Get random email$")
    public void getRandomEmail() {
        automationApi.email = new EmailPage(automationApi.driver.getDriver()).getRandomEmail();
    }

    @When("^I return to google cloud calculator$")
    public void iReturnToGoogleCloudCalculator() {
        new CalculatorPage(automationApi.driver.getDriver()).returnToCurrentCalculator();
    }

    @Then("^enter the email$")
    public void enterTheEmail() {
        new CalculatorPage(automationApi.driver.getDriver()).confirmRentCostEstimation(automationApi.email);
    }

    @And("^I returned to email page$")
    public void iReturnedToEmailPage() {
        new EmailPage(automationApi.driver.getDriver()).openCurrentEmail();
    }

    @Then("^Wait for email and check the ([^\"]*)$")
    public void waitForEmailAndCheckThe(String cost) {
        String estimatedCost = new EmailPage(automationApi.driver.getDriver()).getEstimatedCost();
        Assert.assertEquals(estimatedCost, cost);
    }

}
