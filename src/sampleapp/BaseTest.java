package sampleapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am running before test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am running before method");
    }
}
