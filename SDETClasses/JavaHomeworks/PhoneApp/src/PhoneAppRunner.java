


import java.util.Arrays;
import java.util.Scanner;

public class PhoneAppRunner {
    static Phone phone=new Phone("Iphone", "Iphone11", "9328491GD","3232");
    // in here instantiate the Phone object


    public static void main(String[] args) {
        welcome();
        printOptions();
        Scanner scanner = new Scanner(System.in);
        String option;
        /*1
        Implement the logic for passcode.
        You need to first ask the user passcode of the phone
        if the user input is not same with phone.passCode then the user
        should not be able to open the phone and see the below options
         */

        //Phone phone=new Phone();

        System.out.println("Enter your passcode");
        String passCode=scanner.next();
        if(phone.getPassCode().equals(passCode)){
            printOptions();
        }else {
            System.out.println("Your passcode is not correct.");
        }
//        public boolean checkPassCode(String passCodE){
//            if(this.passCode.equals(passCodE)){
//                return true;
//            }
//            return false;
//        }
//        phone.checkPassCode(passCode);





        do {
            option=scanner.next();
            makeAChoice(option);
        }while(!option.equals("0"));
        System.out.println("Thank you for working with us");
    }
    private static void makeAChoice(String choice) {
        Scanner input = new Scanner(System.in);
        switch (choice) {

            case "1":
               System.out.println("Enter your first name");
                String fName =input.next();
                System.out.println("Enter your last name");
                String lName =input.next();
                System.out.println("Enter your company name");
                String compName =input.next();
                System.out.println("Enter your phone number");
                String phoneNum=input.next();
                System.out.println("Enter your email address");
                String emailAddress=input.next();
                System.out.println("Enter your city");
                String cityName=input.next();
                Contact contact=new Contact(fName, lName,compName,phoneNum,emailAddress,cityName);
                phone.addNewContact(contact);
                System.out.println("----------------------------");
                printOptions();
                break;
            case "2":
                phone.allInfo();
                printOptions();
                break;
            case "3":
                System.out.println("Please enter your old number");
                String oldN=input.next();
                System.out.println("Please enter your new number");
                String newN=input.next();
                phone.changePhoneNum(oldN, newN);
                System.out.println("------------------------------");
                printOptions();

                break;
            case "4":
                System.out.println("Please, enter the phone number to pull the info");
                String searchByCell=input.next();
                phone.searchByPhoneNum(searchByCell);
                System.out.println("------------------------------");
                printOptions();

                break;
            case "5":
                System.out.println("Please enter the name to pull the info by name");
                String searchByN=input.next();
                phone.searchByName(searchByN);
                printOptions();

                break;
            case "6":
                System.out.println("Provide phone number and an email address to update the city");
                System.out.println("Enter your phone number");
                String cellN=input.next();
                System.out.println("Enter your email address");
                String email_address=input.next();
                phone.updateCity(cellN, email_address);
                printOptions();
                break;
            case "7":
                System.out.println("Update email address");
                System.out.println("Enter your old email address");
                String oldEm=input.next();
                System.out.println("Enter your new email address");
                String newEm=input.next();
                phone.updateEmail(oldEm, newEm);
                printOptions();
                break;
            case "9":
                printOptions();
                break;
            case "0":
                System.out.println("Press 0 to exit");
                System.exit(0);
                break;
        }


    }

    public static void welcome() {

        System.out.println("Welcome to the Phone Application");
    }

    public static void printOptions() {

        System.out.println("Hello. Please choose one of the following options");
        System.out.println("1 - For new Contact");
        System.out.println("2 - To print all Contacts' Full Name  and Phone Number");
        System.out.println("3 - Update Contact Phone number");
        System.out.println("4 - Find Person information with Phone Number");
        System.out.println("5 - Find Phone number with Contact Name");
        System.out.println("6 - Update City information for Contact");
        System.out.println("7 - Update Email address information for Contact");
        System.out.println("0 - To exit");





    }
}
