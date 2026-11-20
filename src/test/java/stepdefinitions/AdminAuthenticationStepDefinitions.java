package stepdefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.AdminDashboardPage;
import pages.LoginPage;

public class AdminAuthenticationStepDefinitions {

    private final LoginPage loginPage;
    private final AdminDashboardPage adminDashboardPage;

    public AdminAuthenticationStepDefinitions() {
        this.loginPage = new LoginPage(TestHooks.driver);
        this.adminDashboardPage = new AdminDashboardPage(TestHooks.driver);
    }

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        loginPage.open();
    }

    @When("I enter email {string} and password {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the admin dashboard")
    public void iShouldBeRedirectedToTheAdminDashboard() {
        Assertions.assertTrue(adminDashboardPage.isDashboardDisplayed(),
                "Expected admin dashboard to be displayed after login");
    }

    @Then("a validation error should be displayed on the email field")
    public void aValidationErrorShouldBeDisplayedOnTheEmailField() {
        Assertions.assertTrue(loginPage.isEmailValidationErrorDisplayed(),
                "Expected validation error on email field or submission prevented");
    }
}
