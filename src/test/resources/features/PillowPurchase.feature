@buyingPillowTests
Business Need: Buying Pillow

  @buyPillowSuccessfully
  Scenario: Buy pillow with successful payment
    Given validate me
    Given I have decided to buy a pillow
    When I checkout for payment after entering following details :
      | Name     | Email          | Phone no     | City | Address       | Postal Code |
      | Jitendra | jitu@gmail.com | 081808466420 | Pune | Koregaon Park | 411001      |
    And I continued to after seeing order summary
    And I select the payment option Credit/Debit Card
    And I enter following payment details :
      | Card Number         | Expiry Date | CVV Number |
      | 4811 1111 1111 1114 | 12/24       | 123        |
    And I proceed to pay after entering payment details
    And I enter OTP "112233"
    Then I successfully ordered pillow

    Scenario: Validate Response
      Given validate me

