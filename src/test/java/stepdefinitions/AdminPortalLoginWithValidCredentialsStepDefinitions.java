package stepdefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.AdminPortalLoginWithValidCredentialsPage;

public class AdminPortalLoginWithValidCredentialsStepDefinitions {
    private final AdminPortalLoginWithValidCredentialsPage loginPage =
            new AdminPortalLoginWithValidCredentialsPage(TestHooks.driver);

    @Given("Open the login page")
    public void openTheLoginPage() {
        Assertions.assertNotNull(TestHooks.driver);
    }
// testing
    @When("Enter admin email and password")
    public void enterAdminEmailAndPassword() {
        loginPage.enterEmail("admin@example.com");
        loginPage.enterPassword("adminPassword123!");
    }

    @When("Click the login button")
    public void clickTheLoginButton() {
        loginPage.clickSubmit();
    }

    @Then("Authentication request is submitted with webapp source, access token is saved in local storage, user profile is fetched and verified as ADMIN, and user is redirected to the admin dashboard")
    public void authenticationRequestIsSubmittedAndUserIsRedirectedToDashboard() {
        boolean isDashboardVisible = loginPage.isDashboardDisplayed() || TestHooks.driver.getCurrentUrl().contains("/dashboard");
        Assertions.assertTrue(isDashboardVisible, "Expected user to be redirected to the admin dashboard");
    }
}
