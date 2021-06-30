package com.crowdar.practica.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.practica.pages.SwagLabsLoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class SwagLabsSteps extends PageSteps {

    @Given("The user is on nevegador's home.")
    public void navegadorHome() {}

    @Then("The user sees SwagLabs login page.")
    public void validateLoginPage() { Injector._page(SwagLabsLoginPage.class).validateLogo(); }

    @When("The user enters www.saucedemo.com on search bar.")
    @Given("User is on Swag Labs page.")
    public void loginPage() { Injector._page(SwagLabsLoginPage.class).go(); }

    @When("User sees labels on page.")
    public void labelsAreDisplayed() { Injector._page(SwagLabsLoginPage.class).labelsAreDisplayed(); }

    @Then("Labels are enabled to write.")
    public void labelsAreEnabledToWrite() { Injector._page(SwagLabsLoginPage.class).labelsAreWritable(); }

    @When("User enter a password (.*).")
    public void enterPassword(String password) { Injector._page(SwagLabsLoginPage.class).enterPassword(password); }

    @Then("Characters entered are hidden with *.")
    public void passwordIsHidden() { Injector._page(SwagLabsLoginPage.class).passwordIsHidden(); }

    @When("User enter an username (.*).")
    public void enterUsername(String username) { Injector._page(SwagLabsLoginPage.class).enterUsername(username); }

    @When("User click on Login button.")
    public void userClickOnLoginButton() { Injector._page(SwagLabsLoginPage.class).clickOnLoginBtn(); }

    @Then("Home page is not redirected. A message (.*) is shown.")
    public void notPossibleToLogin(String message) { Injector._page(SwagLabsLoginPage.class).validateErrorMessage(message); }
}
