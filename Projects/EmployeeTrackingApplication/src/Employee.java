import java.util.UUID;
public class Employee {
   private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String employeeId;
    private String startDate;
    private String title;
    private String department;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title=title;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(){
        this.department=department;
    }
    public Employee(String firstName, String lastName, String phoneNumber,
                    String email,String department, String startDate, String title){
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.department=department;
        this.startDate=startDate;
        this.title=title;
        employeeId=generateEmployeeId();
    }
    /*
    1- Create private instance variables for employee firstName, lastName, phoneNumber, email, employeeId, startDate,
    title, department)
    2- Create getter and setter for instance variables
    3- Create the constructor to set the value to the instance variables
    4- Create one method to create the employeeId length of 20. This employee id must have letters as well.
       */
    public static Employee createEmployee(String firstName, String lastName, String phoneNumber, String email,  String startDate, String title, String department){
    /*
    this method need to return Employee according to the parameter
    call the constructor inside this method.
     */
        return new Employee(firstName, lastName, phoneNumber,  email, department,  startDate, title);
    }
    public String generateEmployeeId(){
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        String ourID="";
        //String ourID=randomUUIDString.substring(0,23);
        /*
        this method needs to return the employeeId Length of 20 which includes numbers as well.
        EmployeeId structure must be length of 20 UUID
        Example: 61c49c2e-7dcd-11ea-bc55
         */
        return ourID=randomUUIDString.substring(0,23);
    }
}