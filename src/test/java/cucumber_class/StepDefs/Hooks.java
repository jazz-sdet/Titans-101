package cucumber_class.StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){

        System.out.println("Before hook has been executed");
    }
    @After
    public void cleanup(){

        System.out.println("After hook has been executed");
    }
}
