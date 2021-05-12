package setup;

import com.paulhammant.ngwebdriver.ByAngular;
import com.testingblaze.register.I;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import pages.PillowPurchasePage;

import java.util.List;
import java.util.Map;

/**
 * @author jitendra.pisal
 */
public class PillowPurchaseSteps {
    By buyButton = By.xpath("//*[text()='BUY NOW']");
    final Logger logger = Logger.getLogger(PillowPurchaseSteps.class);

    public PillowPurchasePage pillowPurchasePage;

    public PillowPurchaseSteps(PillowPurchasePage pillowPurchasePage) {
        this.pillowPurchasePage = pillowPurchasePage;
    }

    @Given("I have decided to buy a pillow")
    public void iHaveDecidedToBuyAPillow() {
        I.amPerforming().click().on(buyButton);
    }

    @When("I checkout for payment after entering following details :")
    public void iCheckoutForPaymentAfterEnteringFollowingDetails(List<Map<String, String>> myDetails) {
        pillowPurchasePage.enterDetailsOnCheckoutModal(myDetails);
    }

    @And("I continued to after seeing order summary")
    public void iContinuedToAfterSeeingOrderSummary() {
        pillowPurchasePage.continuedOnOrderSummary();
    }

    @And("^I select the payment option (Credit/Debit Card|ATM/Bank|GoPay|ShopeePay|KlikBCA)$")
    public void iSelectThePaymentOption(String paymentOption) {
        pillowPurchasePage.selectPaymentOption(paymentOption);
    }

    @And("I enter following payment details :")
    public void iEnterFollowingPaymentDetails(List<Map<String, String>> paymentDetails) {
        pillowPurchasePage.enterPaymentDetails(paymentDetails);
    }

    @And("I proceed to pay after entering payment details")
    public void iProceedToPayAfterEnteringPaymentDetails() {
        pillowPurchasePage.proceedToPay();
    }

    @And("I enter OTP {string}")
    public void iEnterOTP(String otp) {
        pillowPurchasePage.enterOTP(otp);
    }

    @When("I go to url")
    public void iGoToUrl() {
        System.out.println("a");
        I.amPerforming().textInput().in(ByAngular.BaseBy.xpath("jcd"),"1");
    }

    String json = "{\n" +
            "\t\"glossary\": {\n" +
            "\t\t\"title\": \"example glossary\",\n" +
            "\t\t\"GlossDiv\": {\n" +
            "\t\t\t\"title\": \"S\",\n" +
            "\t\t\t\"GlossList\": {\n" +
            "\t\t\t\t\"GlossEntry\": {\n" +
            "\t\t\t\t\t\"ID\": \"SGML\",\n" +
            "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
            "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
            "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
            "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
            "\t\t\t\t\t\"GlossDef\": {\n" +
            "\t\t\t\t\t\t\"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
            "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t}\n" +
            "}";

    String json1 = "{\n" +
            "\t\"glossary\": {\n" +
            "\t\t\"title\": \"example glossary\",\n" +
            "\t\t\"GlossDiv\": {\n" +
            "\t\t\t\"title\": \"S\",\n" +
            "\t\t\t\"GlossList\": {\n" +
            "\t\t\t\t\"GlossEntry\": {\n" +
            "\t\t\t\t\t\"ID\": \"SGML\",\n" +
            "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
            "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
            "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
            "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
            "\t\t\t\t\t\"GlossDef\": {\n" +
            "\t\t\t\t\t\t\"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
            "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t}\n" +
            "}";

    @Given("validate me")
    public void validateMe() {
        I.amPerforming().restHttp().validateJsonResponse(json, json1);
    }
}
