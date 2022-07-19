package com.cydeo.step_definitions;

import com.cydeo.pages.FuelLogs;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Vytrack;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {
    FuelLogs fuelLogs = new FuelLogs();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Before
    public void setUpScenario() throws InterruptedException {
        Vytrack.loginfunction(ConfigurationReader.getProperty("truckusername1"),ConfigurationReader.getProperty("password"));
        Vytrack.navigateToVehicleFuelLogs();
        wait.until(ExpectedConditions.visibilityOf(fuelLogs.grid));

    }

    @After
    public void tearDown(Scenario scenario){
        Vytrack.logout();
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png",scenario.getName());
        }

      //  Driver.closeDriver();
    }
}
