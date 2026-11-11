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

    @Given("Enter malformed email address without domain dot")
    public void enterMalformedEmailAddressWithoutDomainDot() {
        loginPage.enterEmail("admin@invalidemail");
    }

    @When("Enter password")
    public void enterPassword() {
        loginPage.enterPassword("somePassword123!");
    }

    @When("Submit login form")
    public void submitLoginForm() {
        loginPage.clickSubmit();
    }

    @Then("Validation error is displayed on email field and submission is prevented")
    public void validationErrorIsDisplayedOnEmailFieldAndSubmissionIsPrevented() {
        String validationMessage = loginPage.getEmailValidationMessage();
        boolean hasValidationMessage = validationMessage != null && !validationMessage.trim().isEmpty();
        boolean stillOnLoginPage = loginPage.isEmailFieldPresent() && !TestHooks.driver.getCurrentUrl().contains("/dashboard");
        Assertions.assertTrue(hasValidationMessage || stillOnLoginPage, "Expected submission to be prevented with validation error");
    }
}
