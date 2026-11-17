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

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Assertions.assertNotNull(TestHooks.driver);
    }

    @When("the user enters the admin email and password")
    public void the_user_enters_the_admin_email_and_password() {
        loginPage.enterEmail("admin@example.com");
        loginPage.enterPassword("AdminSecretPassword!");
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickSignIn();
    }

    @Then("the user is redirected to the admin dashboard")
    public void the_user_is_redirected_to_the_admin_dashboard() {
        Assertions.assertTrue(loginPage.isDashboardVisible(), "Admin dashboard element should be visible");
    }
}
