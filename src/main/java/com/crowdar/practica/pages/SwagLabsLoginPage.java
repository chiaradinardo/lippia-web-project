package com.crowdar.practica.pages;

import com.crowdar.practica.constants.LoginConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.util.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateToCompleteURL;

public class SwagLabsLoginPage extends PageBaseSwagLabs {
    public SwagLabsLoginPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void validateLogo() {
        Assert.isTrue(isElementPresent(new By.ByClassName(LoginConstants.LOGO_CLASSNAME)), "Logo is not present.");
    }

    public void labelsAreDisplayed(){
        Assert.isTrue(getWebElement(new By.ByCssSelector(LoginConstants.USERNAME_LABEL_CSS)).isDisplayed(), "Username label is not displayed.");
        Assert.isTrue(getWebElement(new By.ByCssSelector(LoginConstants.PASSWORD_LABEL_CSS)).isDisplayed(), "Password label is not displayed.");
    }

    public void labelsAreWritable() {
        WebElement username = getWebElement(new By.ByCssSelector(LoginConstants.PASSWORD_LABEL_CSS));
        WebElement password = getWebElement(new By.ByCssSelector(LoginConstants.PASSWORD_LABEL_CSS));

        Assert.isTrue(username.isEnabled(), "Username is not enabled.");
        Assert.isTrue(password.isEnabled(), "Password is not enabled.");
    }

    public void enterPassword(String password) {
        WebElement passwordLabel = getWebElement(new By.ByCssSelector(LoginConstants.PASSWORD_LABEL_CSS));
        passwordLabel.sendKeys(password);
    }

    public void passwordIsHidden() {
        WebElement passwordLabel = getWebElement(new By.ByCssSelector(LoginConstants.PASSWORD_LABEL_CSS));
        Integer passwordLength = passwordLabel.getText().length();
        for (int i = 0; i < passwordLength; i++) {
            Assert.isTrue(passwordLabel.getText().charAt(i) == '*', "Password is not hidden");
        }
    }

    public void enterUsername(String username) {
        WebElement usernameLabel = getWebElement(new By.ByCssSelector(LoginConstants.USERNAME_LABEL_CSS));
        usernameLabel.sendKeys(username);
    }

    public void clickOnLoginBtn() {
        click(getWebElement(new By.ById(LoginConstants.BTN_LOGIN_ID)));
    }

    public void validateErrorMessage(String message) {
        WebElement msg = getWebElement(new By.ByXPath(LoginConstants.ERROR_MSG_XPATH));
        Assert.isTrue(msg.getText().equals(message), "Message is not as expected.");
    }
}
