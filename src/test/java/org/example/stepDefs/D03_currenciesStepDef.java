package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {
    P03_homepage currency = new P03_homepage();

    @Given("Select Euro currency from the dropdown list on the top left of home page")
    public void selectEuroCurrency() {
        P03_homepage.selectCurrency("Euro", By.id("customerCurrency"));
    }

    @Then("Find all Elements with Euro currency")
    public void getElementEuroCurrency() {
        List<WebElement> eurovalues = currency.getEuroValues();
        for (WebElement eurovalue : eurovalues) {
            Assert.assertTrue(eurovalue.getText().contains("€"));
            System.out.println(eurovalue.getText());
        }
    }

}
