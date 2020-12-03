import java.util.ArrayList;
import java.util.Scanner;

public class Phone {

    /*
       1- Create instance variables
       phoneBrand, phoneModel, SerialNumber, passCode and ArrayList<Contact> allContact
       2- Create constructor to initialize this variables
       3- Create the method to add new contact this method take one parameter as Contact
       4- Create the method to print all Contacts' first and last name with phone number
       5- Create the method to update person's phone number. This method takes two parameter old phone number and new phone number
       6- Create the method to search with phone number and print all other information for person
       7- create the method to search with name of person and print phone number of person
       8- Create the method to update city of person with new city, you need two parameter one is phone number of person another is new email address.
       9- Create the method to update email address for person with new email address, you need two parameter oldEmail and newEmail

       In this contact list only two things are unique Phone number and email address. You can not store same phone number and email address two times
       because of that before adding the new contact you need to make sure this phone number is not exist in your Contact arraylist.
     */

    String phoneBrand;
    String phoneModel;
    String serialNumber;
    String passCode;
    ArrayList<Contact> allContacts = new ArrayList<>();




    public Phone(String phoneBrand, String phoneModel, String serialNumber, String passCode) {
        this.phoneBrand = phoneBrand;
        this.phoneModel = phoneModel;
        this.serialNumber = serialNumber;
        this.passCode = passCode;
        //this.allContacts = allContacts;
    }

    public String getPassCode(){
        return this.passCode;
    }
    public boolean addNewContact(Contact newContact) {
        if (!allContacts.contains(newContact)) {
            return allContacts.add(newContact);
        }
        return false;
    }

    //- Create the method to print all Contacts' first and last name with phone number
    public void allInfo() {
        for(int i=0; i<allContacts.size(); i++) {

            System.out.println("First name: " + allContacts.get(i).getFirstname() + "\nLast name: " + allContacts.get(i).getLastName() + "\nPhone number: " + allContacts.get(i).getPhoneNumber());
        }
    }


    // Create the method to update person's phone number. This method takes two parameter old phone number and new phone number

    public boolean changePhoneNum(String oldNum, String newNum) {
        for (int i = 0; i < allContacts.size(); i++) {
            if (allContacts.get(i).getPhoneNumber().equals(oldNum)) {
               allContacts.get(i).setPhoneNumber(newNum);
            }
        }
        return false;
    }

    //6- Create the method to search with phone number and print all other information for person
    public void searchByPhoneNum(String phoneN) {
        for (int i = 0; i < allContacts.size(); i++) {
            if (phoneN.equals(allContacts.get(i).getPhoneNumber())) {
                System.out.println(allContacts.get(i).getFirstname());

            }
        }
    }

    public void searchByName(String nameSearch) {
        for (int i = 0; i < allContacts.size(); i++) {
            if (nameSearch.equals(allContacts.get(i).getFirstname()) || nameSearch.equals(allContacts.get(i).getLastName())) {
                System.out.println(allContacts.get(i).getPhoneNumber());
            }
        }
    }

    //8- Create the method to update city of person with new city, you need two parameter one is phone number of person another is new email address.
    public boolean updateCity(String phoneNumber, String email) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < allContacts.size(); i++) {
            if (phoneNumber.equals(allContacts.get(i).getPhoneNumber()) && email.equals(allContacts.get(i).getEmails())) {
                System.out.println("Enter your new city");
                String newCity = scanner.next();
                this.allContacts.get(i).setCity(newCity);
                return true;

            }
        }
        return false;
    }

    //9- Create the method to update email address for person with new email address, you need two parameter oldEmail and newEmail

    public boolean updateEmail(String oldEmail, String newEmail) {
        for (int i = 0; i < allContacts.size(); i++) {
            if (allContacts.get(i).getEmails().equals(oldEmail)) {
               allContacts.get(i).setEmails(newEmail);
            }
        }
            return false;
        }
    }



