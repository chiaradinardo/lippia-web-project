package selenium.CrowdarChallengeAutomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UserActions {
    private WebDriver driver;
    public UserActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        return driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void setText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void navigate(String url) {
        driver.navigate().to(url);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}