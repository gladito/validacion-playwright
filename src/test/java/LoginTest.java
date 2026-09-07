import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    private static final String VALID_USERNAME = "tomsmith";
    private static final String VALID_PASSWORD = "SuperSecretPassword!";
    private static final String INVALID_USERNAME = "usuarioInvalido";
    private static final String INVALID_PASSWORD = "claveInvalida";

    @Test
    void test_loginExitoso() {
        LoginPage loginPage = new LoginPage(page).navigate();

        DashboardPage dashboard = loginPage.login(VALID_USERNAME, VALID_PASSWORD);

        assertTrue(dashboard.isLoggedIn());
        assertTrue(dashboard.getSuccessMessage().contains("You logged into a secure area!"));
        assertTrue(dashboard.getHeaderText().contains("Secure Area"));
    }

    @Test
    void test_loginFallido() {
        LoginPage loginPage = new LoginPage(page).navigate();

        loginPage.login(INVALID_USERNAME, INVALID_PASSWORD);

        assertFalse(page.url().contains("/secure"));
        assertTrue(loginPage.getFlashMessage().contains("Your username is invalid!"));
    }
}
