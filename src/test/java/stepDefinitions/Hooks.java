package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        // This ensures the browser is ready before ANY step runs
        DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        // This ensures the browser closes ONLY after the WHOLE scenario is done
        DriverFactory.quitDriver();
    }

}
