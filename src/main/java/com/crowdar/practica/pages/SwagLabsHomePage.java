package com.crowdar.practica.pages;

import com.crowdar.core.pageObjects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.util.Assert;

public class SwagLabsHomePage extends PageBase {
    private final String TITTLE_CLASS = "title";

    public SwagLabsHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public void validateTittleIsVisible() {
        Assert.isTrue(isElementVisible(new By.ByClassName(TITTLE_CLASS)));
    }
}

