package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


   @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement submit;

}
