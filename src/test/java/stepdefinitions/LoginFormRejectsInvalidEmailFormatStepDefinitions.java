package stepdefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginFormRejectsInvalidEmailFormatPage;

public class LoginFormRejectsInvalidEmailFormatStepDefinitions {

    private final LoginFormRejectsInvalidEmailFormatPage loginPage =
            new LoginFormRejectsInvalidEmailFormatPage(TestHooks.driver);

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Assertions.assertTrue(loginPage.isLoginPageLoaded(), "Login page should be loaded");
    }

    @When("the user enters malformed email address without domain dot")
    public void the_user_enters_malformed_email_address_without_domain_dot() {
        loginPage.enterEmail("malformed_email@nodomain");
    }

    @When("the user enters password")
    public void the_user_enters_password() {
        loginPage.enterPassword("SomePassword123!");
    }

    @When("the user submits login form")
    public void the_user_submits_login_form() {
        loginPage.submitLoginForm();
    }

    @Then("validation error is displayed on email field and submission is prevented")
    public void validation_error_is_displayed_on_email_field_and_submission_is_prevented() {
        Assertions.assertTrue(loginPage.isSubmissionPrevented(),
                "Validation error is displayed on email field and submission is prevented.");
    }
}
