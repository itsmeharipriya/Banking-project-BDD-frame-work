Feature: Bank Manager operations

Scenario Outline: Manager adds multiple customers
Given Manager is on Banking Home Page
When Manager clicks on "Bank Manager Login"
And Manager clicks on "Add Customer"
And Manager enters "<FirstName>" in First Name
And Manager enters "<LastName>" in Last Name
And Manager enters "<PostCode>" in Post Code
And Manager clicks "Add Customer" button
Then Manager should see confirmation alert

Examples:
| FirstName | LastName | PostCode |
| Harry     | Potter   | 22222    |
| Ron       | Weasley  | 33333    |
| Hermione  | Granger  | 44444    |

Scenario Outline: Manager opens account
Given Manager is on Banking Home Page
When Manager clicks on "Bank Manager Login"
And Manager clicks on "Open Account"
And Manager selects "<Customer>"
And Manager selects currency "<Currency>"
And Manager clicks Process button
Then Manager should see account created alert

Examples:
| Customer       | Currency |
| Harry Potter   | Pound    |
| Neville Longbottom | Dollar |

Scenario: Manager searches a customer
Given Manager is on Banking Home Page
When Manager clicks on "Bank Manager Login"
And Manager clicks Customers tab
And Manager searches customer "John"