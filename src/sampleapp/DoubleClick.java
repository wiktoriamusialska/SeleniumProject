package sampleapp;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick {
    @Test
    public void executeJavaScript(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        //klikanie prawym przyciskiem myszy
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        //actions.contextClick(driver.findElement(By.id("myFile"))).perform();

        WebElement button = driver.findElement(By.id("bottom"));
        actions.doubleClick(button).perform();



    }
}
