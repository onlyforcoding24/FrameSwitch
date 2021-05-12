package pages;

import com.testingblaze.register.I;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;

import java.util.List;
import java.util.Map;

/**
 * @author jitendra.pisal
 */
public class PillowPurchasePage {
    private final By name = By.xpath("//td[normalize-space()='Name']/..//input");
    private final By email = By.xpath("//input[@type='email']");
    private final By phoneNumber = By.xpath("//td[normalize-space()='Phone no']/..//input");
    private final By city = By.xpath("//td[normalize-space()='City']/..//input");
    private final By address = By.xpath("//td[normalize-space()='Address']/..//textarea");
    private final By postalCode = By.xpath("//td[normalize-space()='Postal Code']/..//input");
    private final By checkoutButton = By.xpath("//div[normalize-space()='CHECKOUT']");
    private final By continueButtonOnOrderSummary = By.xpath("//a[@class='button-main-content']");
    private final By cardNumberLocator = By.name("cardnumber");
    private final By expiryDateLocator = By.xpath("//label[text()='Expiry date']/preceding-sibling::input");
    private final By cvvLocator = By.xpath("//label[text()='CVV']/preceding-sibling::input");
    private final By payNowButton = By.xpath("//*[text()='Pay Now']/ancestor::a[@class='button-main-content']");
    private final By OTPIFrame = By.xpath("//iframe[not(@id)]");
    private final By OTPInput = By.xpath("//*[@id='PaRes']");
    private final By OKButton = By.xpath("//button[@type='submit' or text()='OK']");

    /************************** Utility methods ***********************************/

    public void enterDetailsOnCheckoutModal(List<Map<String, String>> myDetails) {
        for (Map<String, String> singleDetail : myDetails) {
            I.amPerforming().textInput().toClear(name);
            I.amPerforming().textInput().in(name, singleDetail.get("Name"));
            I.amPerforming().textInput().toClear(email);
            I.amPerforming().textInput().in(email, singleDetail.get("Email"));
            I.amPerforming().textInput().toClear(phoneNumber);
            I.amPerforming().textInput().in(phoneNumber, singleDetail.get("Phone no"));
            I.amPerforming().textInput().toClear(city);
            I.amPerforming().textInput().in(city, singleDetail.get("City"));
            I.amPerforming().textInput().toClear(address);
            I.amPerforming().textInput().in(address, singleDetail.get("Address"));
            I.amPerforming().textInput().toClear(postalCode);
            I.amPerforming().textInput().in(postalCode, singleDetail.get("Postal Code"));
            I.amPerforming().click().on(checkoutButton);
        }
    }

    public void continuedOnOrderSummary() {
        I.amPerforming().click().on(continueButtonOnOrderSummary);
    }

    public void selectPaymentOption(String paymentOption) {
        By paymentType = By.xpath("//div[@id='payment-list']" +
                "//div[contains(@class,'list-title') and contains(text(),'" + paymentOption + "')]");
        I.amPerforming().click().on(paymentType);
    }

    public void enterPaymentDetails(List<Map<String, String>> paymentDetails) {
        for (Map<String, String> cardDetails : paymentDetails) {
            I.amPerforming().textInput().in(this.cardNumberLocator, cardDetails.get("Card Number"));
            I.amPerforming().textInput().in(this.expiryDateLocator, cardDetails.get("Expiry Date"));
            I.amPerforming().textInput().in(this.cvvLocator, cardDetails.get("CVV Number"));
        }
    }

    public void proceedToPay() {
        I.amPerforming().click().on(payNowButton);
    }

    public void enterOTP(String otp) {
        I.amPerforming().textInput().in(OTPInput, otp);
        I.amPerforming().click().on(OKButton);
    }

    /************************** Assertion methods **********************************/

    public void assertPillowPurchaseSuccessful(String successMessage) {
        By successMessageLocator = By.xpath("//div[contains(@class,'trans-success')]//span[1]");
        Assert.assertEquals("Unable to purchase pillow", successMessage, I.amPerforming().actionToGet()
                .text(successMessageLocator).trim());
    }

    public void assertInvalidCardError(String errorMessage) {
        By invalidCardLocator = By.xpath("//div[@class='card-container']//div[contains(@class,'danger')]//span");
        Assert.assertEquals("Error is not showing for wrong card details", errorMessage
                , I.amPerforming().actionToGet()
                        .text(invalidCardLocator).trim());
    }
}
