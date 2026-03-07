Feature: Banking operations for customers

Scenario: Customer login and deposit
  Given Customer is on Banking Home Page
  When Customer clicks on "Customer Login"
  And Customer selects "Ron Weasly"
  And Customer clicks "Login"
  Then Customer should be logged in successfully

  When Customer clicks on "Deposit"
  And Customer enters "5000" in amount field
  And Customer clicks Deposit button
  Then Customer should see deposit success message

  When Customer clicks on "Withdraw"
  And Customer enters "200" in amount field
  And Customer clicks Withdraw button
  Then Customer should see withdraw success message
  Then Customer should see the transaction list
  