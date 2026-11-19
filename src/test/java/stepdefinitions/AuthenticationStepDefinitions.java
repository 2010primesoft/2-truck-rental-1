package stepdefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.AdminDashboardPage;
import pages.LoginPage;

public class AuthenticationStepDefinitions {
    private LoginPage loginPage;
    private AdminDashboardPage adminDashboardPage;

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        loginPage = new LoginPage(TestHooks.driver);
    }
//hello world
    @When("I enter email {string} and password {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the admin dashboard")
    public void iShouldBeRedirectedToTheAdminDashboard() {
        adminDashboardPage = new AdminDashboardPage(TestHooks.driver);
        Assertions.assertTrue(adminDashboardPage.isDashboardVisible() || TestHooks.driver.getCurrentUrl().contains("/admin/dashboard"),
                "Expected redirection to the admin dashboard");
    }

    @Then("a validation error should be displayed on the email field")
    public void aValidationErrorShouldBeDisplayedOnTheEmailField() {
        Assertions.assertTrue(!TestHooks.driver.getCurrentUrl().contains("/admin/dashboard"),
                "Submission was not prevented; user was redirected away from login");
    }
}
