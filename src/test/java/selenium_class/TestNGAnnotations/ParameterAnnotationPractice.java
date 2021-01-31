package selenium_class.TestNGAnnotations;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotationPractice {
    // we need to use parameter annotation with xml file bc values will come from xml file
    @Parameters({"firstName", "lastName"}) // if more than one value {} has to be provided


    @Test
    public void printName(String name,String lastName){
        System.out.println("The name is : "+name);
        System.out.println("The last name is: "+lastName);
    }
}
