package com.cydeo.pages;

import com.cydeo.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class CreateFuelLog {

    @FindBy(xpath = "//label[contains(.,\"Odometer\")]")
            public WebElement odometerInput;

    @FindBy(xpath = "//a[contains(.,'Cancel')]")
        public WebElement cancelButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement savebutton;


    @FindBy(xpath = "//div[@class='control-label wrap']")
    public WebElement firstLabel;

    public void createEntry(Map<String,String> inputMap)
    {
        WebElement input;
        for(String key : inputMap.keySet()){



                if (key.equals("Info"))
                {
                    input = Driver.getDriver().findElement(By.xpath("//label[text()='" + key + "']//..//following-sibling::div//"+"textarea"));
                }

                else if (key.equals("Date"))

                {
                    input=Driver.getDriver().findElement(By.xpath("(//label[text()='Date']//..//following-sibling::div//input)[2]"));
                    input.click();
                    Driver.getDriver().findElement(By.xpath("//button[@data-handler=\"today\"]")).click();
                    continue;
                }

                else
                {
                    input=Driver.getDriver().findElement(By.xpath("//label[text()='" + key + "']//..//following-sibling::div//"+"input"));
                }

                input.sendKeys(inputMap.get(key));
            }

    }

   public CreateFuelLog(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
