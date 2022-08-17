package sampleapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetPageInfoTest {
    @Test
    public void getInfo(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());




    }
}
