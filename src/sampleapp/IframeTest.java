package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class IframeTest {
    @Test
    public void testNewWindow() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        WebElement iframe =driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("fname")).sendKeys("Wiktoria");
        driver.switchTo().defaultContent();  //wracamy do pierwotnego okna
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }
}
