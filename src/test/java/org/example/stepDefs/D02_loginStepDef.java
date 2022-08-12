package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.D01_registerStepDef.registeredemial;

public class D02_loginStepDef {
    P02_login login = new P02_login();
    SoftAssert softassert = new SoftAssert();

    @Given("user go to login page")
    public void openLoginPage() {
        login.loginLink().click();
    }

    @When("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void enterValidEmailAndPassword(String valid, String email, String password) {
        switch (valid) {
            case "valid":
                login.loginSteps(registeredemial + email, password);
                break;
            case "invalid":
                login.loginSteps(email, password);
                break;
        }

    }

    @And("user press on login button")
    public void pressLoginBtn() {
        login.pressLoginBtn().click();
    }

    @Then("user login to the system successfully")
    public void assertSuccessfullyLogin() {
        softassert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        softassert.assertTrue(login.assertionSuccessfullyLogin().isDisplayed());
        softassert.assertAll();
    }

    @Then("user could not login to the system")
    public void assertUnsuccessfullyLogin() {
        String unsuccessfullyMsg = login.getUnsuccessfulMsg().getText();
        System.out.println(unsuccessfullyMsg);
        softassert.assertEquals(unsuccessfullyMsg.contains("Login was unsuccessful."), true);
        String Msgcolor = login.getUnsuccessfulMsg().getCssValue("color");
        String convertedcolor = Color.fromString(Msgcolor).asHex();
        softassert.assertEquals(convertedcolor, "#e4434b");
        softassert.assertAll();
    }
}
