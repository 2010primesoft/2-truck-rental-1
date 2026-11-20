package stepdefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.AdminDashboardPage;
import pages.LoginPage;

public class AuthenticationStepDefinitions {

    private final LoginPage loginPage = new LoginPage(TestHooks.driver);
    private final AdminDashboardPage adminDashboardPage = new AdminDashboardPage(TestHooks.driver);

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        Assertions.assertTrue(loginPage.isEmailFieldVisible(), "Login page email field should be visible");
    }

    @When("I enter email {string} and password {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the admin dashboard")
    public void iShouldBeRedirectedToTheAdminDashboard() {
        Assertions.assertTrue(adminDashboardPage.isDashboardVisible(), "User should be redirected to the admin dashboard");
    }

    @Then("a validation error should be displayed on the email field")
    public void aValidationErrorShouldBeDisplayedOnTheEmailField() {
        String validationMessage = loginPage.getEmailValidationMessage();
        Assertions.assertTrue(validationMessage != null && !validationMessage.isEmpty(), "Validation error should be displayed on the email field");
    }

    @And("the form submission should be prevented")
    public void theFormSubmissionShouldBePrevented() {
        Assertions.assertTrue(loginPage.isEmailFieldVisible(), "Form submission should be prevented and user should remain on login page");
    }
}
