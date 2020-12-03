package com.techtorial.ventraApp;
import java.util.Scanner;
public class VentraAppRunner {

    static VentraCardMachine ventraCardMachineObject = new VentraCardMachine("Chicago");
    public static void main(String[] args){
        welcome();
        Scanner scanner = new Scanner(System.in);
        String option;
        /*
        implement the choice logic
         */
        do {printOptions();
            option=scanner.next();
            makeAChoice(option);
        }while(!option.equals("0"));
    }
    private static void makeAChoice(String choice){
        Scanner scanner = new Scanner(System.in);
        switch (choice){
            case "0":
                System.out.println("Thank you for working with us");
                System.exit(0);
                break;
            case "1":
                System.out.println("Please create your full name");
                String fName = scanner.nextLine();
                Scanner scann=new Scanner(System.in);
                System.out.println("Please enter your phone number");
                String phoneNum = scann.next();
                System.out.println("Please provide your email");
                String ema= scanner.next();
                VentraCard ventraCardObject=VentraCard.createCard(fName,phoneNum,ema);
                ventraCardMachineObject.addCard(ventraCardObject);
                break;
                /*
                1- Using scanner get the information of User (FullName, PhoneNumber, Email)
                2- Create new card According to this information(Call createCard method)
                3- Call addCard method from VentraCard Machine and add new card
                 */
            case "2":
                ventraCardMachineObject.option2();
                break;
            case "3":
                ventraCardMachineObject.option3();
                break;
            case "4":
                System.out.println("Please enter your old card number");
                long oldcard = scanner.nextLong();
                System.out.println("Please enter your new card number");
                long newCard = scanner.nextLong();
                ventraCardMachineObject.updateCardNumbers(oldcard,newCard);
                break;
            case "5":
                System.out.println("Enter your old card number");
                long oldcard2 = scanner.nextLong();
                System.out.println("Enter your new card number");
                long newCard2 = scanner.nextLong();
                ventraCardMachineObject.updateCardNumbers(oldcard2,newCard2);
                break;
            case "6":
                System.out.println("Enter your old email");
                String oldemail = scanner.next();
                System.out.println("Enter your new email");
                String newemail = scanner.next();
                ventraCardMachineObject.replaceEmail(oldemail,newemail);
                break;
            case "7":
                System.out.println("Please enter your phone number");
                String phoneNumb = scanner.nextLine();
                ventraCardMachineObject.printByPhoneNumberInfo(phoneNumb);
                break;
            case "8":
                printOptions();
                break;
        }
    }
    public static void welcome(){
        System.out.println("Welcome to the Ventra card");
    }
    public static void printOptions(){
        System.out.println("Hello. Please choose one of the following options");
        System.out.println("1 - For new card");
        System.out.println("2 - To print all card holders name and card number");
        System.out.println("3 - To print ventra card numbers");
        System.out.println("4 - To update the Ventra Card  with New Card");
        System.out.println("5 - To update the card number");
        System.out.println("6 - To update existing card email address");
        System.out.println("7 - To search the card with phone number and print all card information");
        System.out.println("8 - To print available options");
        System.out.println("0 - To exit");
    }
}