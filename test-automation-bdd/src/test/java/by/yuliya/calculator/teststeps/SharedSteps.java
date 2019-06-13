package by.yuliya.calculator.teststeps;

import by.yuliya.calculator.model.CalculatorData;
import by.yuliya.calculator.page.CalculatorPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SharedSteps {

    private AutomationApi automationApi;

    public SharedSteps(AutomationApi automationApi) {
        this.automationApi = automationApi;
    }
    @Test
    @Given("^I opened Google cloud page$")
    public void iOpenedGoogleCloudPage() {
        automationApi.calculatorPage = new CalculatorPage(automationApi.driver.getDriver()).openPage();
    }
    @Test
    @When("^I fill the calculator form with parameters:$")
    public void iFillTheCalculatorForm(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        CalculatorData calculatorData = new CalculatorData();
        for (int i = 0; i < 1; i++) {
            calculatorData.setNumberOfInstances(Integer.valueOf(table.get(i).get("number of instances")));
            calculatorData.setOperatingSystem(table.get(i).get("operating system"));
            calculatorData.setVmClass(table.get(i).get("vm class"));
            calculatorData.setInstanceType(table.get(i).get("instance type"));
            calculatorData.setAddGPUs(Boolean.valueOf(table.get(i).get("add gpus")));
            calculatorData.setNumberOfGPUs(Integer.valueOf(table.get(i).get("number of gpus")));
            calculatorData.setGPUType(table.get(i).get("gpu type"));
            calculatorData.setLocalSSD(table.get(i).get("local SSD"));
            calculatorData.setDatacenterLocation(table.get(i).get("datacenter location"));
            calculatorData.setCommitedUsage(table.get(i).get("commited usage"));
        }
        automationApi.price = automationApi.calculatorPage.estimateRentCost(calculatorData);
    }


}
