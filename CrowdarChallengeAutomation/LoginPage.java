package selenium.CrowdarChallengeAutomation;

import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPage extends UserActions {
    WebElement usernameTextBox = findElement(new By.ById("user-name"));
    WebElement passwordTextBox = findElement(new By.ById("password"));
    WebElement loginBtn = findElement(new By.ById("login-button"));
    WebElement errorMsg = findElement(new By.ByClassName("error-message-container"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // parameters: username (String), password (String).
    // Fill username text box and password text box.
    private void fillLoginForm(String username, String password) {
        setText(this.usernameTextBox, username);
        setText(this.passwordTextBox, password);
    }

    public void succesfulLoading() {
        assertEquals(this.getTitle(), "Swag Labs");
    }

    public void enabledForm() {
        assertTrue(this.passwordTextBox.isEnabled());
        assertTrue(this.passwordTextBox.isEnabled());
    }

    public void encryptedPassword() {
        this.setText(this.passwordTextBox, "1234");
        assertEquals(this.passwordTextBox.getText(), "****");
    }

    public void wrongPassword(String usernameOk, String password) {
        this.setText(this.usernameTextBox, usernameOk);
        this.setText(this.passwordTextBox, password);
        this.click(this.loginBtn);

        assertEquals(this.errorMsg.getText(), "Epic sadface: Password is required.");
    }

    public void wrongUsername(String username, String password) {
        this.setText(this.usernameTextBox, username);
        this.setText(this.passwordTextBox, password);
        this.click(this.loginBtn);

        assertEquals(this.errorMsg.getText(), "Epic sadface: Username is required.");
    }

    public void loginOk(String usernameOk, String passwordOk) {
        this.setText(this.usernameTextBox, usernameOk);
        this.setText(this.passwordTextBox, passwordOk);
        this.click(this.loginBtn);

        WebElement newTitle = this.findElement(new By.ByClassName("title"));

        assertEquals(this.getText(newTitle), "Products");
    }

}