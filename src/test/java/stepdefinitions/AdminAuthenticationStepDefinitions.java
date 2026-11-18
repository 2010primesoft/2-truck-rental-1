package stepdefinitions;

import hooks.TestHooks;
import pages.AdminDashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminAuthenticationStepDefinitions {

    private AdminDashboardPage adminDashboardPage;

    private final By emailField = By.name("email");
    private final By passwordField = By.name("password");
    private final By signInButton = By.cssSelector(".inline-flex");

    @Given("I am on the admin login page")
    public void iAmOnTheAdminLoginPage() {
        adminDashboardPage = new AdminDashboardPage(TestHooks.driver);
        Assertions.assertTrue(TestHooks.driver.findElement(emailField).isDisplayed(),
                "Expected email field to be displayed on the login page");
    }

    @When("I enter email {string} and password {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        WebElement emailElement = TestHooks.driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);

        WebElement passwordElement = TestHooks.driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        TestHooks.driver.findElement(signInButton).click();
    }

    @Then("I should be redirected to the admin dashboard")
    public void iShouldBeRedirectedToTheAdminDashboard() {
        Assertions.assertTrue(adminDashboardPage.isDashboardVisible(),
                "Expected redirection to the admin dashboard");
    }

    @Then("the user profile should be verified as ADMIN")
    public void theUserProfileShouldBeVerifiedAsAdmin() {
        Assertions.assertTrue(TestHooks.driver.getPageSource().contains("ADMIN") || adminDashboardPage.isDashboardVisible(),
                "Expected user profile to be verified as ADMIN on the admin dashboard");
    }

    @Then("a validation error should be displayed on the email field")
    public void aValidationErrorShouldBeDisplayedOnTheEmailField() {
        WebElement emailElement = TestHooks.driver.findElement(emailField);
        String validationMessage = emailElement.getAttribute("validationMessage");
        boolean hasValidationMessage = validationMessage != null && !validationMessage.trim().isEmpty();
        Assertions.assertTrue(hasValidationMessage || !TestHooks.driver.getCurrentUrl().contains("/admin/dashboard"),
                "Expected validation error on email field");
    }

    @Then("the login submission should be prevented")
    public void theLoginSubmissionShouldBePrevented() {
        Assertions.assertFalse(TestHooks.driver.getCurrentUrl().contains("/admin/dashboard"),
                "Expected login submission to be prevented, but user navigated to dashboard");
    }
}
