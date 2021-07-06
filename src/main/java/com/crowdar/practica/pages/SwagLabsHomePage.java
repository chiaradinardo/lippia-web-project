package com.crowdar.practica.pages;

import com.crowdar.core.pageObjects.PageBase;
import com.crowdar.practica.constants.HomeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.util.Assert;

public class SwagLabsHomePage extends PageBaseSwagLabs {
    public SwagLabsHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public void validateTittleIsVisible() {
        Assert.isTrue(isElementVisible(new By.ByClassName(HomeConstants.TITTLE_CLASS)));
    }

    public void addProduct() {
        click(HomeConstants.BTN_BACKPACK_ID);
    }

    public void goToCart() {
        click(HomeConstants.CART_CSS);
    }
}

