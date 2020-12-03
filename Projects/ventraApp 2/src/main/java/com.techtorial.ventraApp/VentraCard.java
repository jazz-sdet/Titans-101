package com.techtorial.ventraApp;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class VentraCard {

    /*
    1- Create instance variables for passenger fullName, phoneNumber, email, cardNumber
    2- Create getter and setter for instance variables
     Getter Example:
     public String getFullName(){
     return fullName;}

     Setter Example:
     public void setFullName(String fullName){
     this.fullName=fullName;
     }

    3- Create the constructor to set the value to the instance variables
    4- Create one method to create the 16 digit cardNumber. Return type must be long and it will return 16 digit unique number
     */

    public String fullName;
    public String phoneNumber;
    public String email;
    public long cardNumber;

    public String getFullName(){

        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public String getEmail(){

        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public long getCardNumber(){

        return cardNumber;
    }
    public void setCardNumber(long cardNumber){

        this.cardNumber=cardNumber;
    }

    public VentraCard(String fullName, String phoneNumber, String email){
        this.fullName=fullName;
        this.phoneNumber=phoneNumber;
        this.email=email;
        cardNumber=createCardNumber();
    }

    public static VentraCard createCard(String fullName, String phoneNumber, String email){

    /*
    this method needs to return VentraCard according to the parameter
     */
        return new VentraCard( fullName, phoneNumber, email);
    }

    public long createCardNumber(){
        /*
        this method needs to return the 16 digit card number
         */


        long smallest = 1000_0000_0000_0000L;
        long biggest = 9999_9999_9999_9999L;
        // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
        long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);


        return random;
    }
}
