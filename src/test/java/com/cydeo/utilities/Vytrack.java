package com.cydeo.utilities;

import com.cydeo.pages.Dashboard;
import com.cydeo.pages.FuelLogs;
import com.cydeo.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vytrack {

    public static Actions actions = new Actions(Driver.getDriver());
    public static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    public static FuelLogs fuelLogs=new FuelLogs();

    public static void loginfunction(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(){};

        Driver.getDriver().get("https://qa3.vytrack.com/user/login");

        loginPage.username.click();
        loginPage.password.clear();

        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();

    }

    public static void navigateToVehicleFuelLogs() throws InterruptedException {
        Dashboard dashboard=new Dashboard();

        wait.until(ExpectedConditions.visibilityOf(dashboard.module));

        actions.moveToElement(dashboard.module).perform();
        wait.until(ExpectedConditions.visibilityOf(dashboard.fuellog));


        wait.until(ExpectedConditions.elementToBeClickable(dashboard.fuellog));
        dashboard.fuellog.click();

    }

    public static void waitForgrid(){
        wait.until(ExpectedConditions.visibilityOf(fuelLogs.grid));
    }

    public static void logout(){
        Driver.getDriver().findElement(By.xpath("//li[@class=\"dropdown user-menu-dropdown\"]")).click();
        Driver.getDriver().findElement(By.xpath("//a[.=\"Logout\"]")).click();
    }
}
