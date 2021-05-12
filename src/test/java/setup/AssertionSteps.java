package setup;

import io.cucumber.java.en.Then;
import pages.PillowPurchasePage;

/**
 * @author jitendra.pisal
 */
public class AssertionSteps {
    public PillowPurchasePage pillowPurchasePage;

    public AssertionSteps(PillowPurchasePage pillowPurchasePage) {
        this.pillowPurchasePage = pillowPurchasePage;
    }

    @Then("I successfully ordered pillow")
    public void iSuccessfullyOrderedPillow() {
        pillowPurchasePage.assertPillowPurchaseSuccessful("Thank you for your purchase.");
    }

    @Then("I see entered card details are wrong")
    public void iSeeEnteredCardDetailsAreWrong() {
        pillowPurchasePage.assertInvalidCardError("Invalid card number");
    }
}
