package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import hooks.TestHooks;
import pages.LoginFormRejectsInvalidEmailFormatPage;

public class LoginFormRejectsInvalidEmailFormatStepDefinitions {

    private final LoginFormRejectsInvalidEmailFormatPage page = new LoginFormRejectsInvalidEmailFormatPage(TestHooks.driver);

    @Given("Enter malformed email address without domain dot")
    public void enterMalformedEmailAddressWithoutDomainDot() {
        page.enterEmail("admin@invalidemail");
    }

    @When("Enter password")
    public void enterPassword() {
        page.enterPassword("password123");
    }

    @And("Submit login form")
    public void submitLoginForm() {
        page.submitLogin();
    }

    @Then("Validation error is displayed on email field and submission is prevented")
    public void validationErrorIsDisplayedOnEmailFieldAndSubmissionIsPrevented() {
        Assertions.assertTrue(page.isSubmissionPrevented(), "Validation error is displayed on email field and submission is prevented.");
    }
}
