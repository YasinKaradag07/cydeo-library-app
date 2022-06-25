
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with
  correct
  credentials to different accounts

  Background: Assuming user is on the login page
    Given user is on the login page

  @librarian @employee
  Scenario: Login as librarian
    When user enters librarian username "librarian10@library"
    And user enters librarian password "ZIkOcbCa"
    Then user should see the dashboard

  @student
  Scenario: Login as student
    When user enters student username "student10@library"
    And user enters student password "F8u6OrI2"
    Then user should see the dashboard

  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian1@library" and "qU9mrvur"
    Then dashboard should be displayed
    And there should be 144 'users'
#number can be whatever you have there