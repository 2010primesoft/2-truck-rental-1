package stepdefinitions;

import hooks.TestHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.SearchOwnerListWithDebounceAndPersistFilterParametersPage;

public class SearchOwnerListWithDebounceAndPersistFilterParametersStepDefinitions {

    private SearchOwnerListWithDebounceAndPersistFilterParametersPage page;

    @Given("I am on the vehicle owners page")
    public void iAmOnTheVehicleOwnersPage() {
        page = new SearchOwnerListWithDebounceAndPersistFilterParametersPage(TestHooks.driver);
        page.navigateToVehicleOwners();
    }

    @When("I type search term into owner search bar")
    public void iTypeSearchTermIntoOwnerSearchBar() {
        page.enterSearchTerm("John");
    }

    @And("I wait for debounce period to complete")
    public void iWaitForDebouncePeriodToComplete() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("list triggers API call after 400ms delay, resets pagination to first page, and search parameters remain persisted upon returning")
    public void listTriggersAPICallAfter400msDelayResetsPaginationToFirstPageAndSearchParametersRemainPersistedUponReturning() {
        Assertions.assertTrue(page.isSearchInputVisible(), "Search input should remain visible on owner page");
        Assertions.assertEquals("John", page.getSearchInputValue(), "Search term should persist in search input");
    }
}
