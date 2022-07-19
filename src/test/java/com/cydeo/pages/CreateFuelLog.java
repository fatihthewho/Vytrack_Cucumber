package com.cydeo.pages;

import com.cydeo.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateFuelLog {

    @FindBy(xpath = "//label[contains(.,\"Odometer\")]")
            public WebElement odometerInput;

    @FindBy(xpath = "//a[contains(.,'Cancel')]")
        public WebElement cancelButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement savebutton;

   public CreateFuelLog(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
