package com.crowdar.practica.pages;

import com.crowdar.core.pageObjects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.util.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateToCompleteURL;

public class SwagLabsLoginPage extends PageBaseSwagLabs {

    private final String LOGO_CLASSNAME = "login_logo";
    private final String USERNAME_LABEL_CSS = "#user-name";
    private final String PASSWORD_LABEL_CSS = "#password";
    private final String BTN_LOGIN_ID  = "login-button";
    private final String ERROR_MSG_XPATH = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";

    public SwagLabsLoginPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void validateLogo() {
        Assert.isTrue(isElementPresent(new By.ByClassName(LOGO_CLASSNAME)), "Logo is not present.");
    }

    public void labelsAreDisplayed(){
        Assert.isTrue(getWebElement(new By.ByCssSelector(USERNAME_LABEL_CSS)).isDisplayed(), "Username label is not displayed.");
        Assert.isTrue(getWebElement(new By.ByCssSelector(PASSWORD_LABEL_CSS)).isDisplayed(), "Password label is not displayed.");
    }

    public void labelsAreWritable() {
        WebElement username = getWebElement(new By.ByCssSelector(PASSWORD_LABEL_CSS));
        WebElement password = getWebElement(new By.ByCssSelector(PASSWORD_LABEL_CSS));

        Assert.isTrue(username.isEnabled(), "Username is not enabled.");
        Assert.isTrue(password.isEnabled(), "Password is not enabled.");
    }

    public void enterPassword(String password) {
        WebElement passwordLabel = getWebElement(new By.ByCssSelector(PASSWORD_LABEL_CSS));
        passwordLabel.sendKeys(password);
    }

    public void passwordIsHidden() {
        WebElement passwordLabel = getWebElement(new By.ByCssSelector(PASSWORD_LABEL_CSS));
        Integer passwordLength = passwordLabel.getText().length();
        for (int i = 0; i < passwordLength; i++) {
            Assert.isTrue(passwordLabel.getText().charAt(i) == '*', "Password is not hidden");
        }
    }

    public void enterUsername(String username) {
        WebElement usernameLabel = getWebElement(new By.ByCssSelector(USERNAME_LABEL_CSS));
        usernameLabel.sendKeys(username);
    }

    public void clickOnLoginBtn() {
        click(getWebElement(new By.ById(BTN_LOGIN_ID)));
    }

    public void validateErrorMessage(String message) {
        WebElement msg = getWebElement(new By.ByXPath(ERROR_MSG_XPATH));
        Assert.isTrue(msg.getText().equals(message), "Message is not as expected.");
    }
}
