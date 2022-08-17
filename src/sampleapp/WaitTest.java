package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    @Test
    public void executeJavaScript() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();

/*
        //czekanie na element
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("p"));
*/

        //drugi sposob na czekanie na elementy
        driver.findElement(By.cssSelector("p"));


    }}