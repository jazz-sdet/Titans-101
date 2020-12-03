package Calculations;

public class Subtraction extends Question {

    @Override
    public void calc() {

            answer = operand1 - operand2;
            calculated = true;



    }
    public Subtraction(Range rangeClass){
        super("Subtraction","-");
        int num1=RandomNumber.getRandomInteger(rangeClass);
        int num2=RandomNumber.getRandomInteger(rangeClass);
        for(int i=1; i<num1;i++){
            if(num1>num2){
                operand1=num1;
                operand2=num2;
            }else if(num2>num1){
                operand1=num2;
                operand2=num1;

            }
        }

    }
    public String toString(){
        if(calculated){
            return operand1+"-"+operand2+"="+answer;
        }else{
            return  operand1+"-"+operand2+"=";
        }
    }
}


