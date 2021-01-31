package selenium_class.TestNGAnnotations;

import org.testng.annotations.Test;

public class Annotations2 {

    @Test(invocationCount = 10) //10x will run
    public void test1(){
        System.out.println("Test 1 execution");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void test3(){
        System.out.println("Test 3 execution");
        throw new ArithmeticException();

    }
}
