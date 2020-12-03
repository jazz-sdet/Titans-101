package cucumber_class.StepDefs;

import Utils.Driver;
import Utils.PropertyReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class RegistrationDeskLogin{


    WebDriver driver = Driver.getDriver(PropertyReader.readPropertyByKey("browser"));

    @When("user navigates to Registration Desk")
    public void user_navigates_to_registration_desk() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

    }

    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String userN, String passW) {
        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));

        username.sendKeys(PropertyReader.readPropertyByKey("username"));

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        //password.sendKeys(passW);
        password.sendKeys(PropertyReader.readPropertyByKey("password"));

        WebElement regDesk=driver.findElement(By.xpath("//li[@id='Registration Desk']"));
        regDesk.click();

        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='loginButton']"));
        loginBtn.click();


    }


    @Then("verify if user is {string}")
    public void verify_if_user_is_super_admin(String superAdmin){
        System.out.println("User logs in as admin successfully");

        WebElement displaySuperUser= driver.findElement(By.xpath("//h4['Logged in as Super User (admin) at Registration Desk.']     "));
        Assert.assertTrue(displaySuperUser.isDisplayed());

        Assert.assertTrue(displaySuperUser.getText().contains(superAdmin));

    }

    @Given("user is logged in to demo.openmrs.org")
    public void user_is_logged_in_to_demo_openmrs_org() {

        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("admin");

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Admin123");

        WebElement regDesk=driver.findElement(By.xpath("//li[@id='Registration Desk']"));
        regDesk.click();

        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='loginButton']"));
        loginBtn.click();


    }

    @When("user searches for {int} patient on Find Patient Record page")
    public void user_searches_for_patient_on_find_patient_record_page(Integer int1) {

        WebElement findPatient= driver.findElement(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        findPatient.click();

        WebElement search=driver.findElement(By.xpath("//input[@id='patient-search']"));
        search.sendKeys("123");

    }

    @Then("no records found")
    public void no_records_found() throws InterruptedException {
        Thread.sleep(1000);

//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .pollingEvery(Duration.ofSeconds(2))//frequency of attempts
//                .withTimeout(Duration.ofSeconds(10))// max 10 seconds
//                .ignoring(NoSuchElementException.class);
//
//        WebElement foo = wait.until(new Function<WebDriver, WebElement>()
//        {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
//            }
//        });



        WebElement display=driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
        Assert.assertEquals(display.getText(), "No matching records found");

    }


    @When("user navigates to open MRS home page")
    public void user_navigates_to_open_mrs_home_page() {
        driver.get("https://demo.openmrs.org");
        System.out.println("Navigate to openmrs home page");
    }




    @When("user logs in using following data:")
    public void user_logs_in_using_following_data(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        //we store multiple maps in one list: list of maps
        List<Map<String, String>> dataTableList=dataTable.asMaps();
        System.out.println("Size of list of maps is: "+dataTableList.size());

        //getting first element from list element
        Map<String, String> datamap=dataTableList.get(0);
        //getting username from map
       String usernameValue= datamap.get("username");
       //getting password from map
       String passwordValue=datamap.get("password");

       //getting department name from map
        String deptName=datamap.get("departmentName");

        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys(usernameValue);

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(passwordValue);

        WebElement regDesk=driver.findElement(By.id(deptName));
        regDesk.click();

        Thread.sleep(1000);
        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='loginButton']"));
        loginBtn.click();




        System.out.println("getting values from datatable");
        System.out.println("Username "+usernameValue);
        System.out.println("Password "+passwordValue);



    }
    @Then("user is logged in as {string}")
    public void user_is_logged_in_as(String userInfo) {

        WebElement title=driver.findElement(By.tagName("h4"));
        Assert.assertTrue(title.getText().contains(userInfo));

    }


    @Given("user is logged in to demo.openmrs.org as admin")
    public void user_is_logged_in_to_demo_openmrs_org_as_admin() {


        driver.get("https://demo.openmrs.org");

        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("admin");

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Admin123");

        WebElement regDesk=driver.findElement(By.xpath("//li[@id='Registration Desk']"));
        regDesk.click();

        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='loginButton']"));
        loginBtn.click();


    }




    @When("user registers a new patient with following info:")
    public void user_registers_a_new_patient_with_following_info(io.cucumber.datatable.DataTable patientInfo) throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")).click();


        WebElement usernameField=driver.findElement(By.name("givenName"));

        List<Map<String, String>> dataTableList=patientInfo.asMaps();
        Map<String, String> dataMap=dataTableList.get(0);

        String userName=dataMap.get("GivenName");
        usernameField.sendKeys(userName);
        String familyName=dataMap.get("FamilyName");
        driver.findElement(By.name("familyName")).sendKeys(familyName);

        driver.findElement(By.xpath("//span[@id='genderLabel']")).click();

        Select select=new Select(driver.findElement(By.xpath("//select[@id='gender-field']")));
        String gender=dataMap.get("Gender");
        select.selectByVisibleText(gender);

       driver.findElement(By.xpath("//span[@id='birthdateLabel']")).click();

        String birthDayValue = dataMap.get("BirthDay");
        String birthMonthValue = dataMap.get("BirthMonth");
        String birthYearValue = dataMap.get("BirthYear");
        String addressValue = dataMap.get("Address");
        String cityValue = dataMap.get("City");
        String stateValue = dataMap.get("State");
        String countryValue = dataMap.get("Country");
        String postalCodeValue = dataMap.get("PostalCode");
        String phoneNumberValue = dataMap.get("Phone Number");
        String relativeNameValue = dataMap.get("RelativesName");

        driver.findElement(By.name("birthdateDay")).sendKeys(birthDayValue);

        Select select1=new Select(driver.findElement(By.xpath("//select[@name='birthdateMonth']")));
        select1.selectByVisibleText(birthMonthValue);

        driver.findElement(By.xpath("//input[@name='birthdateYear']")).sendKeys(birthYearValue);

        driver.findElement(By.xpath("//span[text()='Address']")).click();

        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(addressValue);

        driver.findElement(By.xpath("//input[@name='cityVillage']")).sendKeys(cityValue);

        driver.findElement(By.xpath("//input[@name='stateProvince']")).sendKeys(stateValue);

        driver.findElement(By.xpath("//input[@name='country']")).sendKeys(countryValue);

        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(postalCodeValue);

        driver.findElement(By.xpath("//span[text()='Phone Number']")).click();

        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumberValue);

        driver.findElement(By.xpath("//span[text()='Relatives']")).click();

        Select select2=new Select(driver.findElement(By.xpath("//select[@name='relationship_type']")));
        select2.selectByIndex(1);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys(relativeNameValue);

        driver.findElement(By.xpath("//span[text()='Confirm']")).click();

        driver.findElement(By.xpath("//input[@class='submitButton confirm right focused']")).click();






    }
    @Then("new patient is registered")
    public void new_patient_is_registered() {


    }

    @When("user registers a new patient with info below:")
    public void user_registers_a_new_patient_with_info_below( DataTable dataTable) {
        Map<String, String> dataMap=dataTable.asMap(String.class, String.class);

        String nameValue = dataMap.get("GivenName");
        String familyNameValue = dataMap.get("FamilyName");
        String genderValue = dataMap.get("Gender");
        String birthDayValue = dataMap.get("BirthDay");
        String birthMonthValue = dataMap.get("BirthMonth");
        String birthYearValue = dataMap.get("BirthYear");
        String addressValue = dataMap.get("Address");
        String cityValue = dataMap.get("City");
        String stateValue = dataMap.get("State");
        String countryValue = dataMap.get("Country");
        String postalCodeValue = dataMap.get("PostalCode");
        String phoneNumberValue = dataMap.get("PhoneNumber");
        String relativeNameValue = dataMap.get("RelativeName");


    }




    @Then("verify a new patient is registered")
    public void verify_a_new_patient_is_registered() {

    }


    @Given("user is logged in to demo.openmrs as admin")
    public void user_is_logged_in_to_demo_openmrs_as_admin() {
        System.out.println("Navigate to open MRS and login as admin");
    }




    @When("user creates a new patient with following data: {string}, {string}, {string}")
    public void user_creates_a_new_patient_with_following_data(String givenName, String FamilyNAme, String gender) {
        System.out.println("Given name of new patient: "+givenName);
        System.out.println("Family name: "+ FamilyNAme);
        System.out.println("Gender: "+ gender);

    }
    @When("with extra information: {int} , {string}, {int}")
    public void with_extra_information(Integer bday, String bMonth, Integer bYear) {
        System.out.println("Birthday: "+bday+" "+bMonth+" "+bYear);

    }
    @When("with address: {string}, {string}, {string}, {string}, and {string}")
    public void with_address_and(String address, String city, String state, String country, String zipCode) {
        System.out.println("Patient address is: "+address);
        System.out.println("Patient city is: "+ city);
        System.out.println("Patient state is: "+state);
        System.out.println("Patient country is: "+country);
        System.out.println("Patient postalcode is: "+zipCode);


    }
    @Then("new patient has been registered with: {string}, {string}")
    public void new_patient_has_been_registered_with(String givenName, String familyName) {
        System.out.println("Patient name: "+ givenName);
        System.out.println("Patient family name: "+ familyName);


    }
    @Then("address of new patient is {string}, {string}, {string}")
    public void address_of_new_patient_is(String address, String city, String state) {
        System.out.println("Patient address is: "+address);
        System.out.println("Patient city is: "+ city);
        System.out.println("Patient state is: "+state);

    }

    @Given("user is on openmrs page")
    public void user_is_on_openmrs_page() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

    }


    @When("user logs in using: {string}, {string} at {string}")
    public void user_logs_in_using(String usernameValue, String passwordValue, String location) {


        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys(usernameValue);

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(passwordValue);

        WebElement pharmacy = driver.findElement(By.xpath("//li[@id='Pharmacy']"));
        pharmacy.click();

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='loginButton']"));
        loginBtn.click();
    }
        @Then("{string} is shown")
        public void is_shown(String errorMessage) {

        WebElement errMess=driver.findElement(By.xpath("//div[@id='error-message']"));
        Assert.assertEquals(errMess.getText(), errorMessage);

        }




        @Then("user is still on login page")
        public void user_is_still_on_login_page() {

        }

    }








