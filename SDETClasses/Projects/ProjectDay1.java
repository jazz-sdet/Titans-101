
Task1
will send you screenshot


Task2
Call Function
The function has just one argument (number). 
You can call it repeatedly, providing a different input each time. 
For the call function

Touchpad
when touch pad is pressed play click sound 
when a character is pressed display that character
when a function is selected then execute that function

Camera
Unlock the phone 
Then press the camera button
And  navigate the camera to the object
Then click the "Take a picture button"
Done


Task3
package Variable;

public class Task3 {

    public static void main(String[] args) {

        float Balance=7.88f;
        int newBalance= (int) (Balance*100);
        int dimes=10;
        int quarters=25;
        int nickles=5;
        int penny=1;
        int reminderOfQuarters= (newBalance%quarters);
        int numOfQuarters= (newBalance-reminderOfQuarters)/quarters;
        int reminderOfDimes=  (reminderOfQuarters%dimes);
        int numOfDimes= (reminderOfQuarters-reminderOfDimes)/dimes;
        int reminderOfNickles=reminderOfDimes%nickles;
        int numOfNickles= (reminderOfDimes-reminderOfNickles)/nickles;
        int numOfPenny= (reminderOfNickles/penny);

        System.out.println("Total quarter is "+ numOfQuarters + " Total dimes is "+numOfNickles + " Total nickles is "+numOfNickles +" Total penny is "+numOfPenny);
        //System.out.println("Total Dimes is "+ numOfDimes);
        //System.out.println("Total Nickles is "+ numOfNickles);
        //System.out.println("Total Penny is "+ numOfPenny);








    }







}
 








