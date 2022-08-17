package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {
    @Test
    public void testNewWindow() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        Set<String> windowNames = driver.getWindowHandles();
        for(String window : windowNames) {
            if(!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }

        }
        //driver.switchTo().window(currentWindow);
        //driver.findElement(By.xpath("//button[contains(text(),'Zaakceptuj wszystko']")).click();
        driver.findElement(By.xpath("//div[@role='none' and @class='QS5gu sy4vM' and contains(text(),'Zaakceptuj wszystko')]")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Wiktoria");
    }
}
