package by.yuliya.calculator.teststeps;

import cucumber.api.java.en.Then;

import org.testng.Assert;


public class EmailCostCheckSteps {

    private AutomationApi automationApi;

    public EmailCostCheckSteps(AutomationApi automationApi) {
        this.automationApi = automationApi;
    }

    @Then("^Check the ([^\"]*)$")
    public void checkTheCost(String cost) {
        Assert.assertEquals(automationApi.price, cost);
    }


}
