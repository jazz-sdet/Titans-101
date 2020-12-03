public class Contact {


    /*
    1-  Create the Private instance variables
    firstName, lastName, Company, phoneNumber, emails, city
    2- Create getters and setter for this variables
    3- Create the constructor to initialize your instance variables and constructor must be private
    4- Create one method to instantiate object of contact,
    otherwise since constructor is private you can not instantiate
     */
    private String firstname;
    private String lastName;
    private String Company;
    private String phoneNumber;
    private String emails;
    private String city;

   // public Contact getContact(){
       // return new Contact(firstname, lastName, Company, phoneNumber, emails,city);

   // }

    //getter
    public String getFirstname() {

        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {

        return Company;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }
//    public void setPhoneNumber(String phoneNumber){
//        this.phoneNumber=phoneNumber;


    public String getEmails() {

        return emails;
    }

    public String getCity() {
        return city;
    }
    //setter

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public void setEmails(String emails) {

        this.emails = emails;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public Contact(String firstname, String lastName, String Company, String phoneNumber, String emails, String city) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.Company = Company;
        this.phoneNumber = phoneNumber;
        this.emails = emails;
        this.city = city;
    }
    }

