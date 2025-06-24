
Feature: Web Details Scenarios
  Testcases below:
  Validate that you are on the User List Table page.

  Background:
    Given User is currently on webtables site

  @webdetail @Parallel
  Scenario Outline: Adding <role> user to the webtables
    When User clicks on the Add User link
    Then Add User screen pop up
    When User enter FirstName, LastName, UserName, Password "<Fname>","Lname","User","Pass"
    And User check Customer "<custype>"
    And User select Role "<role>"
    When User provide email "<Email>"
    And User provide Cell phone number "<cellphone>"
    Then All details captured
    When User click save to add the record to the table
    Then User validate if the record was added "<Fname>"

    Examples:
      | Fname  | Lname  | User  | Pass  | custype     | role     | Email             | cellphone |
      | FName1 | LName1 | User1 | Pass1 | Company AAA | Admin    | admin@mail.com    | 082555    |
      | FName2 | LName2 | User2 | Pass2 | Company BBB | Customer | customer@mail.com | 083444    |

  @Parallel
  Scenario Outline: Adding <role> user to the webtables
    When User clicks on the Add User link
    Then Add User screen pop up
    When User enter FirstName, LastName, UserName, Password "<Fname>","Lname","User","Pass"
    And User check Customer "<custype>"
    And User select Role "<role>"
    When User provide email "<Email>"
    And User provide Cell phone number "<cellphone>"
    Then All details captured
    When User click save to add the record to the table
    Then User validate if the record was added "<Fname>"

    Examples:
      | Fname  | Lname  | User  | Pass  | custype     | role     | Email             | cellphone |
      | FName1 | LName1 | User1 | Pass1 | Company AAA | Admin    | admin@mail.com    | 082555    |
      | FName2 | LName2 | User2 | Pass2 | Company BBB | Customer | customer@mail.com | 083444    |



