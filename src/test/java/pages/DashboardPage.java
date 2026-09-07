package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage {

    private final Page page;
    private final Locator flashMessage;
    private final Locator logoutButton;
    private final Locator secureAreaHeader;

    public DashboardPage(Page page) {
        this.page = page;
        this.flashMessage = page.locator("#flash");
        this.logoutButton = page.locator("a.button.secondary.radius");
        this.secureAreaHeader = page.locator("h2");
    }

    public boolean isLoggedIn() {
        return page.url().contains("/secure")
                && flashMessage.innerText().contains("You logged into a secure area!");
    }

    public String getSuccessMessage() {
        return flashMessage.innerText().trim();
    }

    public String getHeaderText() {
        return secureAreaHeader.innerText().trim();
    }

    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage(page);
    }
}
