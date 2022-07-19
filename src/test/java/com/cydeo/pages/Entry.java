package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Entry {

    @FindBy(xpath = "//a[@title='Edit Vehicle Fuel Logs']")
    public WebElement editButton;
    @FindBy(xpath = "//a[contains(@title,\"Delete\")]")
    public WebElement deleteButton;
    @FindBy(xpath = "//a[contains(@title,\"attachment\")]")
    public WebElement addAttachBttn;
    @FindBy(xpath = "//a[contains(@title,'event')]")
    public WebElement addEventBttn;
    @FindBy(xpath = "//input[contains(@name,\"Purchaser\")]")
    public WebElement purchaserInput;

    @FindBy(xpath = "//div[@class='loader-mask shown']")
    public WebElement loaderMask;





    public Entry(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
