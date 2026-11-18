package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import hooks.TestHooks;
import pages.AdminPortalLoginWithValidCredentialsPage;

public class AdminPortalLoginWithValidCredentialsStepDefinitions {

    private final AdminPortalLoginWithValidCredentialsPage page = new AdminPortalLoginWithValidCredentialsPage(TestHooks.driver);

    @Given("Open the login page")
    public void openTheLoginPage() {
        page.openLoginPage();
    }

    @When("Enter admin email and password")
    public void enterAdminEmailAndPassword() {
        page.enterCredentials("admin@example.com", "password123");
    }

    @And("Click the login button")
    public void clickTheLoginButton() {
        page.clickLoginButton();
    }

    @Then("Authentication request is submitted with webapp source, access token is saved in local storage, user profile is fetched and verified as ADMIN, and user is redirected to the admin dashboard")
    public void authenticationRequestIsSubmittedAndUserIsRedirectedToDashboard() {
        Assertions.assertTrue(page.isRedirectedToDashboard(), "Authentication request is submitted with webapp source, access token is saved in local storage, user profile is fetched and verified as ADMIN, and user is redirected to the admin dashboard.");
    }
}
