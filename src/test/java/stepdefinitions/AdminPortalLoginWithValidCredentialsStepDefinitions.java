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

    @Given("the user opens the login page")
    public void the_user_opens_the_login_page() {
        Assertions.assertTrue(loginPage.isLoginPageLoaded(), "Login page should be loaded");
    }

    @When("the user enters admin email and password")
    public void the_user_enters_admin_email_and_password() {
        loginPage.enterEmail("admin@example.com");
        loginPage.enterPassword("AdminPass123!");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user is redirected to the admin dashboard")
    public void the_user_is_redirected_to_the_admin_dashboard() {
        Assertions.assertTrue(loginPage.isDashboardDisplayed(),
                "user is redirected to the admin dashboard");
    }
}
