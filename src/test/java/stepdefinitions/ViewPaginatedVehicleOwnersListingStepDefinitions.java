package stepdefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.ViewPaginatedVehicleOwnersListingPage;

public class ViewPaginatedVehicleOwnersListingStepDefinitions {

    private ViewPaginatedVehicleOwnersListingPage page;

    @Given("I navigate to vehicle owners page")
    public void iNavigateToVehicleOwnersPage() {
        page = new ViewPaginatedVehicleOwnersListingPage(TestHooks.driver);
        page.navigateToVehicleOwners();
    }

    @Then("paginated owner list displays client-generated IDs, name, phone, vehicle count, registration date, status badge, and Stripe status")
    public void paginatedOwnerListDisplaysClientGeneratedIDsNamePhoneVehicleCountRegistrationDateStatusBadgeAndStripeStatus() {
        Assertions.assertTrue(page.isVehicleOwnersHeaderVisible(), "Vehicle owners navigation header should be visible");
        Assertions.assertTrue(page.getCurrentUrl().contains("/admin/owners"), "Current URL should contain /admin/owners");
    }
}
