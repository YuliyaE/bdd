package by.yuliya.calculator.teststeps;

import by.yuliya.calculator.driver.DriverSingleton;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.runtime.java.picocontainer.PicoFactory;

public class ScenarioHooks extends PicoFactory {

    private AutomationApi automationApi;

    public ScenarioHooks(AutomationApi automationApi) {
        this.automationApi = automationApi;
    }


    @Before()
    public void beforeScenario() {
        System.setProperty("browser", "opera");
        automationApi.driver = new DriverSingleton();
    }

    @After()
    public void afterScenario() {
        automationApi.driver.closeDriver();
    }

}
