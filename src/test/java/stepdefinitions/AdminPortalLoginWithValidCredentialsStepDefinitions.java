package stepdefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.AdminPortalLoginWithValidCredentialsPage;

public class AdminPortalLoginWithValidCredentialsStepDefinitions {

    private final AdminPortalLoginWithValidCredentialsPage loginPage = new AdminPortalLoginWithValidCredentialsPage(TestHooks.driver);

    @Given("the user opens the login page")
    public void theUserOpensTheLoginPage() {
    }

    @When("the user enters admin email and password")
    public void theUserEntersAdminEmailAndPassword() {
        loginPage.enterEmail("admin@example.com");
        loginPage.enterPassword("password123");
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("user is redirected to the admin dashboard")
    public void userIsRedirectedToTheAdminDashboard() {
        Assertions.assertTrue(loginPage.isDashboardVisible());
    }
}
