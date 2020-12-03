package Calculations;
import java.util.Random;

public class RandomNumber {
	/**
	 * 	This class will generate random numbers
		TODO:
		1. Add a static method getRandomInteger:
		parameter: type Range
		return: random generated int value within range of min and max values of the Range object
		
		2. overload a static method getRandomInteger:
		parameter: type int
		return: random generated positive int value within range of 1 and the 
		value of parameter

	 */
	public static int getRandomInteger(Range aRange){
		Random random=new Random();
		int difference=aRange.getMax()-aRange.getMin();
		int range=random.nextInt(difference);
		return range+aRange.getMin();
	}
	public static int getRandomInteger(int bRange){
		Random random=new Random();
		int range2=random.nextInt(bRange+1);
		return range2;
	}

}
