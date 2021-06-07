package selenium.CrowdarChallengeAutomation;

import org.checkerframework.checker.fenum.qual.SwingTextOrientation;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTests {
    private WebDriver driver;
    LoginPage onLogin;

    @Before
    public void setUp() {
        onLogin = new LoginPage(driver);
        driver = onLogin.chromeDriverConnection();
    }

    @Test
    public void test01() {
        onLogin.succesfulLoading();
    }

    @Test
    public void test02() {
        onLogin.enabledForm();
    }

    @Test
    public void test03() {
        onLogin.encryptedPassword();
    }

    @Test
    public void test04() {
        onLogin.wrongUsername("", "");
    }

    @Test
    public void test05() {
        onLogin.wrongUsername("", "hola");
    }

    @Test
    public void test06() {
        onLogin.wrongPassword("hola", "");
    }

    @Test
    public void test07() {
        onLogin.loginOk("standard_user", "secret_sauce");
    }



}
