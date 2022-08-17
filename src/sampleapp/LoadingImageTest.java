package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadingImageTest {



    @Test
    public void imageTest(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");
        WebElement image = driver.findElement(By.tagName("img"));
        String height = image.getAttribute("naturalHeight");
        System.out.println(image.getAttribute("naturalHeight"));
        Assert.assertEquals("0",height);

}}
