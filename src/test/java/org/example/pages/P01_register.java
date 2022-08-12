package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_register {

    public WebElement registerlink()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }

    public WebElement selectGender() {
        return Hooks.driver.findElement(By.id("gender-male"));
    }

    public WebElement enterFirstName() {
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement enterlastName() {
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public void login(String firsttname, String lastname) {
        enterFirstName().sendKeys(firsttname);
        enterlastName().sendKeys(lastname);
    }

    public static void selectDateOfBirth(String selection, By ElementId) {
        Select DDselection = new Select(Hooks.driver.findElement(ElementId));
        DDselection.selectByVisibleText(selection);
    }

    public WebElement enterEmail() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement enterPassword() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement enterConfirmPassword() {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement clickRegisterButton() {
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement getSuccessfullyMessagetext() {
        return Hooks.driver.findElement(By.className("result"));
    }

}
