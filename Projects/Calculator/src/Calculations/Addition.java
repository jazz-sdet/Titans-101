package Calculations;

public class Addition extends Question {

    @Override
    public void calc() {
        answer = operand1 + operand2;
        calculated = true;

    }

    public Addition(Range rangeClass) {//this is addition(r) from calculator test
        super("Addition", "+");
        operand1 = RandomNumber.getRandomInteger(rangeClass);
        operand2 = RandomNumber.getRandomInteger(rangeClass);
    }

    @Override
    public String toString() {
        if (calculated) {
            return operand1 + "+" + operand2 + "=" + answer;
        } else {
            return operand1 + "+" + operand2 + "=";

        }
    }
}
