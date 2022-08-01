package com.cydeo.step_definitions;

import com.cydeo.pages.CreateFuelLog;
import com.cydeo.pages.Entry;
import com.cydeo.pages.FuelLogs;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Vytrack;
import com.google.common.collect.Maps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class US10_FuelLogs {

    FuelLogs fuelLogs = new FuelLogs();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    CreateFuelLog createFuelLog=new CreateFuelLog();


    Entry entry = new Entry();

    List<Boolean> checklist = new ArrayList<>();
    List<Boolean> checklist2 = new ArrayList<>();

    int gridsizebefore;
    int gridsizelater;
    @Given("I am on home page  as a truck driver user")
    public void i_am_on_home_page_as_a_truck_driver_user() throws InterruptedException {
       // Vytrack.loginfunction(ConfigurationReader.getProperty("truckusername1"),ConfigurationReader.getProperty("password"));
    }
    @When("I click the vehicle fuel logs under the Fleet button")
    public void i_click_the_vehicle_fuel_logs_under_the_fleet_button() throws InterruptedException {
        //Vytrack.navigateToVehicleFuelLogs();
    }
    @Then("I should be able to on vehicle fuel logs page")
    public void i_should_be_able_to_on_vehicle_fuel_logs_page() {
        //wait.until(ExpectedConditions.visibilityOf(fuelLogs.grid));
    }
    @When("I am on vehicle fuel logs as a truck driver")
    public void i_am_on_vehicle_fuel_logs_as_a_truck_driver() {

    }
    @Then("I should be able to  access to vehicle fuel logs page")
    public void i_should_be_able_to_access_to_vehicle_fuel_logs_page() {
       Assert.assertTrue(fuelLogs.grid.isDisplayed());
    }


   ///


    @When("I click create a vehicle fuel logs button on the top right")
    public void i_click_create_a_vehicle_fuel_logs_button_on_the_top_right() {
        WebElement loadermask = Driver.getDriver().findElement(By.xpath("//div[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(loadermask));


        gridsizebefore=fuelLogs.gridentries.size();
        fuelLogs.createbtn.click();
    }
    @When("Create Vehicle Fuel Logs page opens")
    public void create_vehicle_fuel_logs_page_opens() {
        wait.until(ExpectedConditions.visibilityOf(createFuelLog.odometerInput));
    }


    @When("I enter valid informations for new vehicle")
    public void i_enter_valid_informations_for_new_vehicle(Map<String,String> inputMap) {

            createFuelLog.createEntry(inputMap);

    }

    @When("click save and close button")
    public void click_save_and_close_button() throws InterruptedException {
        WebElement mask= Driver.getDriver().findElement(By.xpath("//div[@id=\"oro-dropdown-mask\"]"));

        wait.until(ExpectedConditions.invisibilityOf(mask));
        createFuelLog.savebutton.click();

        Vytrack.navigateToVehicleFuelLogs();
    }
    @Then("I should be able to creat vehicle fuel logs")
    public void i_should_be_able_to_creat_vehicle_fuel_logs() {
        List<WebElement> newgrid=fuelLogs.gridentries;

        String actualResult= newgrid.get((newgrid.size()-1)).getText();
        String expectedResult= "Holden";

        Assert.assertEquals(expectedResult,actualResult);

    }


    @When("I click cancel button")
    public void i_click_cancel_button() {
        wait.until(ExpectedConditions.elementToBeClickable(createFuelLog.cancelButton));

        createFuelLog.cancelButton.click();

        

    }
    @Then("I should be able cancel")
    public void i_should_be_able_cancel() {
    gridsizelater=fuelLogs.gridentries.size();

    Assert.assertEquals(gridsizebefore,gridsizelater);
    }


    @When("I click any vehicle on the fuel logs")
    public void i_click_any_vehicle_on_the_fuel_logs() {
        Vytrack.waitForgrid();
        wait.until(ExpectedConditions.visibilityOf(fuelLogs.gridentries.get(0)));
        fuelLogs.gridentries.get(0).click();

    }
    @When("information page about that vehicle should open")
    public void information_page_about_that_vehicle_should_open() {
      //  wait.until(ExpectedConditions.visibilityOf(createFuelLog.odometerInput));

    }
    @When("I click edit button")
    public void i_click_edit_button() {

        wait.until(ExpectedConditions.elementToBeClickable(entry.editButton));

        entry.editButton.click();


    }
    @Then("I should be able to edit\\/change any information on the page")
    public void iShouldBeAbleToEditChangeAnyInformationOnThePage() {
        wait.until(ExpectedConditions.visibilityOf(entry.purchaserInput));
        entry.purchaserInput.clear();
        entry.purchaserInput.sendKeys("Holden CF");
        wait.until(ExpectedConditions.elementToBeClickable(createFuelLog.savebutton));
        createFuelLog.savebutton.click();
        Boolean msg=Driver.getDriver().findElement(By.xpath("//div[.='Entity saved']")).isDisplayed();
        Assert.assertTrue(msg);
    }

    @When("I click delete button")
    public void i_click_delete_button() {
        wait.until(ExpectedConditions.elementToBeClickable(entry.deleteButton));
        entry.deleteButton.click();
        WebElement deleteSubmit= Driver.getDriver().findElement(By.xpath("//a[contains(.,\"Yes, Delete\")]"));
        wait.until(ExpectedConditions.visibilityOf(deleteSubmit));
        deleteSubmit.click();

            }
    @Then("I should be able to delete")
    public void i_should_be_able_to_delete() {
        WebElement deletedMsg=Driver.getDriver().findElement(By.xpath("//div[contains(.,\"deleted\")]"));
        Assert.assertTrue(deletedMsg.isDisplayed());
    }

    @When("I click add attachment button")
    public void i_click_add_attachment_button() {
        wait.until(ExpectedConditions.elementToBeClickable(entry.addAttachBttn));
        entry.addAttachBttn.click();
    }
    @When("I click the choose file button and choose file")
    public void i_click_the_choose_file_button_and_choose_file() {
        WebElement uploadFile= Driver.getDriver().findElement(By.xpath("//input[@type=\"file\"]"));
        uploadFile.sendKeys("C:\\Users\\cfhol\\OneDrive\\Desktop\\SDLC.png");
    }
    @When("I click save")
    public void i_click_save() {
        Driver.getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }
    @Then("I should be able to attach file")
    public void i_should_be_able_to_attach_file() {
        Boolean attachemntMsg=Driver.getDriver().findElement(By.xpath("//div[@class=\"message\"]")).isDisplayed();

        Assert.assertTrue(attachemntMsg);
    }

    @When("I click add event button")
    public void i_click_add_event_button() {
      //  wait.until(ExpectedConditions.invisibilityOf(entry.loaderMask));
        wait.until(ExpectedConditions.visibilityOf(entry.addEventBttn));
       entry.addEventBttn.click();
    }
    @When("I enter valid informations into text areas")
    public void i_enter_valid_informations_into_text_areas() {
        WebElement title = Driver.getDriver().findElement(By.xpath("//input[@data-name=\"field__title\"]"));
    wait.until(ExpectedConditions.visibilityOf(title));
     title.sendKeys("Important event");
     Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.tagName("iframe")));

     Driver.getDriver().findElement(By.xpath("//body[@id=\"tinymce\"]")).sendKeys("Details about it");

     Driver.getDriver().switchTo().parentFrame();




    }
    @When("I click save button")
    public void i_click_save_button() {
        WebElement savebtn=Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        wait.until(ExpectedConditions.visibilityOf(savebtn));
        savebtn.click();

    }
    @Then("I should be able to see add an event.")
    public void i_should_be_able_to_see_add_an_event() {
        WebElement message=Driver.getDriver().findElement(By.xpath("//div[contains(.,'Calendar event saved')]"));

        Assert.assertTrue(message.isDisplayed());

    }

    @When("I click grid settings button")
    public void i_click_grid_settings_button() {
       fuelLogs.gridSettingBtn.click();
    }
    @When("I unselect all checkboxes on the settings")
    public void i_unselect_all_checkboxes_on_the_settings() {
        wait.until(ExpectedConditions.visibilityOf(fuelLogs.gridSettingsTable));
        for (WebElement checkbox:fuelLogs.listOfCheckbox
             ) {
            checklist.add(checkbox.findElement(By.xpath(".//following-sibling::td[2]//input")).isSelected());
            checkbox.click();
        }


        fuelLogs.closeGridSt.click();
    }
    @When("when I click reset button")
    public void when_i_click_reset_button() {
        fuelLogs.resetBtn.click();
    }
    @Then("all changes I made before should be resetted")
    public void all_changes_i_made_before_should_be_resetted() {
        boolean isSame=true;
        fuelLogs.gridSettingBtn.click();
        wait.until(ExpectedConditions.visibilityOf(fuelLogs.gridSettingsTable));
        for (WebElement checkbox:fuelLogs.listOfCheckbox
        ) {
          checklist2.add(checkbox.findElement(By.xpath(".//following-sibling::td[2]//input")).isSelected());


        }
        Assert.assertEquals(checklist,checklist2);
    }
    }
