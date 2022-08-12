package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

    public WebElement loginLink() {
        return Hooks.driver.findElement(By.className("ico-login"));
    }

    public WebElement enterEmail() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement enterPassword() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public void loginSteps(String email, String password) {
        enterEmail().sendKeys(email);
        enterPassword().sendKeys(password);
    }

    public WebElement pressLoginBtn() {
        return Hooks.driver.findElement(By.xpath("//form//div[3]//button"));
    }

    public WebElement assertionSuccessfullyLogin() {
        return Hooks.driver.findElement(By.className("ico-account"));
    }

    public WebElement getUnsuccessfulMsg() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"));
    }

}
