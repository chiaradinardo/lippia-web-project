package com.crowdar.practica.pages;

import com.crowdar.core.pageObjects.PageBaseWeb;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageBaseSwagLabs extends PageBaseWeb {
    public PageBaseSwagLabs(RemoteWebDriver driver) {
        super(driver);
        BASE_URL = "https://www.saucedemo.com/";
    }
}
