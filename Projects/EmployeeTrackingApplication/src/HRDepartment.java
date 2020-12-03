

import java.util.ArrayList;
import java.util.TreeSet;

public class HRDepartment {


    private String location;
    private String companyName;
    private ArrayList<Employee> allCards;

    public ArrayList<Employee> getAllCards() {
        return allCards;
    }

    public HRDepartment(String location, String companyName) {
        this.location = location;
        this.companyName = companyName;
        this.allCards = new ArrayList<Employee>();
    }

    public boolean addEmployee(Employee card) {
        if (!allCards.contains(card) && allCards.size() < 20) {
            return allCards.add(card);
        } else {
            System.out.println("Sorry, but you are already in the system or number of employers exceeded no storage");
        }
        return false;
    }



    public void getInAscendingOrder(){
        ArrayList<Employee>allCards=getAllCards();

        TreeSet<String>ascending=new TreeSet<>();
        TreeSet<String>tiTle=new TreeSet<>();
        TreeSet<String>empID=new TreeSet<>();

        for(Employee name: allCards){
            ascending.add(name.getFirstName());
            tiTle.add(name.getTitle());
            empID.add(name.getEmployeeId());

        }
        for(String titles: tiTle){
            System.out.println(titles);
        }
        for(String namess: ascending){
            System.out.println(namess);
        }
        for(String ID: empID){
            System.out.println(ID);
        }
    }
    public void descendingOrder(){
        ArrayList<Employee> allCards=getAllCards();

        TreeSet<String>ascending=new TreeSet<>();
        TreeSet<String>tiTle=new TreeSet<>();
        TreeSet<String>empID=new TreeSet<>();

        for(Employee name: allCards){
            ascending.add(name.getFirstName());
            tiTle.add(name.getTitle());
            empID.add(name.getEmployeeId());

        }
        ascending=(TreeSet<String>) ascending.descendingSet();
        tiTle=(TreeSet<String>) tiTle.descendingSet();
        empID=(TreeSet<String>) empID.descendingSet();
        for(String titles: tiTle){
            System.out.println(titles);
        }
        for(String namess: ascending){
            System.out.println(namess);
        }
        for(String ID: empID){
            System.out.println(ID);
        }
    }
    public void getInsertionOrder(){

        for(Employee name: allCards){
            System.out.println(name.getFirstName() + name.getLastName());
            System.out.println(name.getTitle());
            System.out.println(name.getEmployeeId());
        }
    }







        /*
        This method will take the parameter as a Employee object and
        if the Employee is not added to the list before it will add to the arraylist.
        To be able to understand employee is registered or not you need to check employeeId.
        Because employee id is unique value.
        Also, This company can hold up to 20 employee.
        NOTE: The company has 6 department and in each department can have max 5 employee.

         */

    public void printEmailAddress(String departmentName){
         for(Employee emls: allCards){
             if(emls.getDepartment()==departmentName){
                 System.out.println(emls.getEmail());
             }

         }


        /*
        this method is taking one parameter department name and it will print all the email address.
         which is available in this list related with department id
         */
    }

    public boolean updateEmailAddress(String employeeId, String newEmailAddress){

        /*
        This method is taking parameter as employeeId and email address.
        According to the employeeId, you will update the old email address with new email.
        if it is updated this method will return true else return false
         */
        //ArrayList<Employee> getEmail();
        for(int i=0; i<allCards.size(); i++){
            if(employeeId.equals(allCards.get(i).getEmployeeId())){
                //allCards.set(newEmailAddress);
            }
        }
        return false;
    }



    /*
    REST OF THE METHODS
        1- Create the method will take parameter as employeeId and new phone number, it will update old phone number with new phone number.
        2- Create the method will take parameter as emailAddress and newTitle, it will update old title with new title.
        3- Create the method will take one parameter as a employeeId and it will print all other information of employee like
        name, email, phone, title, department etc.
        4- Create the method will take one parameter as a employeeId and it will remove the employee from the list.
        5- Create the method will take no parameter and it will print all the department names with employee numbers
        The Company has 6 different department Finance, Marketing, IT, HR, Purchasing and Sales department.
        For example:
        Finance department - 10 employee
        Marketing department - 10 employee
        IT department - 10 employee
        ...
        .
        */
}
