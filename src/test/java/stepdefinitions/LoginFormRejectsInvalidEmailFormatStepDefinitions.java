package stepdefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginFormRejectsInvalidEmailFormatPage;

public class LoginFormRejectsInvalidEmailFormatStepDefinitions {
    private final LoginFormRejectsInvalidEmailFormatPage loginPage = new LoginFormRejectsInvalidEmailFormatPage(TestHooks.driver);

    @Given("the user is on the login page to submit credentials")
    public void the_user_is_on_the_login_page_to_submit_credentials() {
        Assertions.assertTrue(loginPage.isSignInButtonVisible(), "Sign in button should be visible");
    }

    @When("the user enters a malformed email address without domain dot")
    public void the_user_enters_a_malformed_email_address_without_domain_dot() {
        loginPage.enterEmail("invaliduser@domain");
    }

    @And("the user enters a password in the password field")
    public void the_user_enters_a_password_in_the_password_field() {
        loginPage.enterPassword("SamplePassword123");
    }

    @And("the user submits the login form")
    public void the_user_submits_the_login_form() {
        loginPage.clickSignIn();
    }

    @Then("submission is prevented and user remains on the login page")
    public void submission_is_prevented_and_user_remains_on_the_login_page() {
        Assertions.assertTrue(loginPage.isSignInButtonVisible(), "User should still be on login page");
        Assertions.assertFalse(loginPage.getCurrentUrl().contains("/admin/dashboard"), "User should not be redirected to dashboard");
    }
}
