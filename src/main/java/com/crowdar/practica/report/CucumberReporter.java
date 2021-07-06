package com.crowdar.practica.report;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberGenericAdapter;
import com.crowdar.core.PropertyManager;
import com.crowdar.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberReporter extends ExtentCucumberGenericAdapter {

    public CucumberReporter(String arg) {
        super(arg);
    }

    public String getScreenshotBase64() {
        return null;
    }

    @Override
    public Boolean isScreenshotDisable() {
        return true;
    }
}