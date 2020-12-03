Feature: Registration desk login

  @neverFails
  Scenario: user navigates to demo.openmrs.org
    When user navigates to Registration Desk
    And user logs in using "admin" and "Admin123"
    Then verify if user is Logged in as "Super User (admin)" at Registration Desk.


  Scenario: Find patient
    Given user is logged in to demo.openmrs.org
    When user searches for 123 patient on Find Patient Record page
    Then no records found

  @datatable
  Scenario: Login with cucumber datatable
    When user navigates to open MRS home page
    And user logs in using following data:
      | departmentName    | username | password |
      | Registration Desk | admin    | Admin123 |
    Then user is logged in as "Super User (admin)"


  Scenario: Register a new patient
    Given user is logged in to demo.openmrs.org as admin
    When user registers a new patient with following info:
      | GivenName | FamilyName | Gender | BirthDay | BirthMonth | BirthYear | Address        | City    | State | Country | PostalCode | Phone Number | RelativesName |
      | John      | Smith      | Male   | 10       | January    | 1990      | 1200 N Lasalle | Chicago | IL    | USA     | 60613      | 8728064747   | Jennifer      |

    Then new patient is registered


  Scenario: Login as admin with cucumber datatable (variant 2)
    When user navigates to open MRS home page
    And user logs in using following data:
      | departmentName | Registration Desk |
      | username       | admin             |
      | password       | Admin123          |
    Then user is logged in as "Super User Name"


  Scenario: Register a new patient variant 2
    Given user is logged in to demo.openmrs.org as admin
    When user registers a new patient with info below:
      | GivenName     | John           |
      | FamilyName    | Smith          |
      | Gender        | Male           |
      | BirthDay      | 11             |
      | BirthMonth    | January        |
      | BirthYear     | 1991           |
      | Address       | 2600 N Hampden |
      | City          | Chicago        |
      | State         | IL             |
      | Country       | USA            |
      | PostalCode    | 60613          |
      | PhoneNumber   | 8729997854     |
      | RelativesName | Sam            |
    Then verify a new patient is registered

  @outline
  Scenario Outline: Register a patient variant 3
    Given user is logged in to demo.openmrs as admin
    When user creates a new patient with following data: "<GivenName>", "<FamilyName>", "<Gender>"
    And with extra information: <BirthDay> , "<BirthMonth>", <BirthYear>
    And with address: "<Address>", "<City>", "<State>", "<Country>", and "<PostalCode>"
    Then new patient has been registered with: "<GivenName>", "<FamilyName>"
    And address of new patient is "<Address>", "<City>", "<State>"

    Examples:
      | GivenName | FamilyName | Gender | BirthDay | BirthMonth | BirthYear | Address        | City    | State | Country | PostalCode | Phone Number | RelativesName |
      | John      | Smith      | Male   | 10       | January    | 1990      | 1200 N Lasalle | Chicago | IL    | USA     | 60613      | 8728064747   | Jennifer      |
      | Sam       | Fellon     | Male   | 17       | April      | 1988      | 2400 N Clark   | Chicago | IL    | USA     | 60614      | 9259801000   | Ally          |
      | John      | Smith      | Male   | 10       | January    | 1990      | 1200 N Lasalle | Chicago | IL    | USA     | 60613      | 8728064747   | Jennifer      |
      | Sam       | Fellon     | Male   | 17       | April      | 1988      | 2400 N Clark   | Chicago | IL    | USA     | 60614      | 9259801000   | Ally          |


  @negative
  Scenario Outline: negative login functionality check
    Given user is on openmrs page
    When user logs in using: "<UserName>", "<Password>" at "<location>"
    Then "<error message>" is shown
    And user is still on login page

    Examples:
      | UserName | Password | location | error message |
      | Admin123 | admin    | Pharmacy | Invalid username/password. Please try again. |
      |          | 940192   | Pharmacy | Invalid username/password. Please try again. |
      |          |          | Pharmacy | Invalid username/password. Please try again. |
      | admin    |          | Pharmacy | Invalid username/password. Please try again. |
      | jdfsjk   | Admin123 | Pharmacy | Invalid username/password. Please try again. |
