package com.cydeo.pages;

import com.cydeo.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    @FindBy(xpath = "//span[@class='title title-level-1']")
    public WebElement module;

    @FindBy(xpath = "//span[.='Vehicles Fuel Logs']")
    public WebElement fuellog;


    public Dashboard()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
