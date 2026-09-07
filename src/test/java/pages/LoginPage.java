package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private static final String URL = "https://the-internet.herokuapp.com/login";

    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator flashMessage;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("#username");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("button[type='submit']");
        this.flashMessage = page.locator("#flash");
    }

    public LoginPage navigate() {
        page.navigate(URL);
        return this;
    }

    public DashboardPage login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
        return new DashboardPage(page);
    }

    public String getFlashMessage() {
        return flashMessage.innerText().trim();
    }

    public boolean isDisplayed() {
        return usernameInput.isVisible() && passwordInput.isVisible();
    }
}
