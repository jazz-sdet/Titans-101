package Calculations;

public class Multiplication extends Question{


    @Override
    public void calc() {
        answer = operand1 * operand2;
        calculated = true;

    }
    public Multiplication(Range rangeClass){
        super("Multiplication","*");
        operand1=RandomNumber.getRandomInteger(rangeClass);
        operand2=RandomNumber.getRandomInteger(rangeClass);

    }
    public String toString(){
        if(calculated){
            return operand1+"*"+operand2+"="+answer;
        }else{
            return  operand1+"*"+operand2+"=";
        }
    }
}
