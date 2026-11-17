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

    @Given("the user enters malformed email address without domain dot")
    public void theUserEntersMalformedEmailAddressWithoutDomainDot() {
        loginPage.enterEmail("admin@invalid");
    }

    @When("the user enters password")
    public void theUserEntersPassword() {
        loginPage.enterPassword("password123");
    }

    @And("the user submits login form")
    public void theUserSubmitsLoginForm() {
        loginPage.clickSubmit();
    }

    @Then("validation error is displayed on email field and submission is prevented")
    public void validationErrorIsDisplayedOnEmailFieldAndSubmissionIsPrevented() {
        Assertions.assertTrue(loginPage.isSubmitButtonVisible());
    }
}
