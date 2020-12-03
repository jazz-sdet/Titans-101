package com.techtorial.ventraApp;
import java.util.ArrayList;

public class VentraCardMachine {
    private String location;
    private ArrayList<VentraCard> allCards;
    public ArrayList<VentraCard> getAllCards() {
        return allCards;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setAllCards(ArrayList<VentraCard> allCards) {
        this.allCards = allCards;
    }
    public VentraCardMachine(String location){
        this.location=location;
        this.allCards=new ArrayList<VentraCard>();
    }
    public boolean addCard(VentraCard card){
        if (!allCards.contains(card)){
            return allCards.add(card);
        }
        System.out.println("Your card is already registered.");
        return false;
        /*
         This method is taking the parameter as a VentraCard.
         if this VentraCard is not registered before this method will add the VentraCard to the allCards(ArrayList).
         Using VentraCard cardNumber you can verify that the card is in allCards or not
         */
    }
    public void printCardNumbers(ArrayList <VentraCard> cards){
        for (VentraCard cardNums : cards){
            System.out.println(cardNums.getCardNumber());
        }
        /*
         This method is taking one parameter as a list of cards and it will print all the card number
         which is available in this list
         */
    }
    public boolean updateCard(VentraCard oldCardNumber, VentraCard newCard){
        for (int i =0; i<allCards.size(); i++){
            long actualCardNum=allCards.get(i).getCardNumber();
            long newCardNumber = oldCardNumber.getCardNumber();
            if (newCardNumber==actualCardNum){
                allCards.remove(oldCardNumber);
                allCards.add(i,newCard);
                return true;
            }
        }
        /*
        This method is taking two parameter oldCardNumber and it will replace this card with newCard.
        */
        return false;
    }
    public void printCardHolderName(ArrayList<VentraCard> cars){
        for (VentraCard list:cars){
            System.out.println(list.getFullName());
        }
    }
    public boolean replaceEmail( String oldEmail, String newEmail) {
        for (VentraCard list : allCards) {
            if (list.getEmail().equals(oldEmail))
                list.setEmail(newEmail);
            return true;
        }
        return false;
    }
    public boolean isMatching(long cardNum){
        for (VentraCard list : allCards) {
            if (list.getCardNumber()==cardNum){
                allCards.remove(list.getCardNumber());
                return true;
            }
        }
        return false;
    }
    public boolean printByPhoneNumberInfo(String phoneNumber){
        for (int i =0;i<allCards.size(); i++ ){
            if (phoneNumber.equals(allCards.get(i).getPhoneNumber())){
                System.out.println(allCards.get(i));
                return true;
            }
        }
        return false;
    }
    public boolean updateCardNumbers (long oldCardNum, long newCardNum){
        for (int i =0; i<allCards.size(); i++){
            if (allCards.get(i).getCardNumber()==oldCardNum){
                allCards.get(i).setCardNumber(newCardNum);
                return true;
            }
        }
        return false;
    }
    public void option2(){
        for (int i =0; i<allCards.size(); i++){
            System.out.println("Name is " + allCards.get(i).getFullName() + "Card Number is " + allCards.get(i).getCardNumber() );
        }
    }
    public void option3(){
        for (int i =0; i<allCards.size(); i++){
            System.out.println(allCards.get(i).getCardNumber());
        }
    }
    public void option6(){
    }
    /*
        1-Create the method will take parameter as a list of cards and it will print all the card holders name
        2- Create the method will take three parameter as a cardNumber, oldEmail and newEmail. This method will replace old email address with
        new email address matching with cardNumber
        3- Create the method will take one parameter as a card number and it will remove the card from the list if card number if matching.
        If the card removed it will return true else will return false.
        4- Create the method will take the parameter as a phone number and it will print all card information connected with this phone number.
        5- Create the method will take two parameter as an oldCardNumber and newCardNumber.
        This method will update the old card number with new card number
     */
}






