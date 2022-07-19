package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FuelLogs {
    @FindBy(xpath = "//tbody[@class='grid-body']")
    public WebElement grid;

    @FindBy(xpath = "//a[@title='Create Vehicle Fuel Logs']")
    public WebElement createbtn;

    @FindBy(xpath = "//td[@data-column-label=\"Purchaser\"]")
    public List<WebElement> gridentries;

    @FindBy(xpath = "//div[@class=\"loader-mask shown\"]")
    public WebElement loadingmask;


    @FindBy(xpath = "//td[@class=\"title-cell\"]")
    public List<WebElement> listOfCheckbox;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement gridSettingBtn;

    @FindBy(xpath = "//div[@class=\"dropdown-menu\"]")
    public WebElement gridSettingsTable;

    @FindBy(xpath = "//span[@class=\"close\"]")
    public  WebElement closeGridSt;

    @FindBy(xpath = "//a[@title=\"Reset\"]")
    public WebElement resetBtn;



    public FuelLogs(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
