package steps.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void before(){
        System.out.println("Hooks - before annotation");
    }
    @After
    public void after(){
        System.out.println("Hook - after annotation");
    }
}
