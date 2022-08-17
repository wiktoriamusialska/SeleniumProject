package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class SelectorTest {
    public void findElements() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

    //clickOnMe
    By buttonId = By.id("clickOnMe");
    WebElement clickOnMeButton = driver.findElement(buttonId);

    //fname
   By firstName = By.name("fname");
   WebElement firstNameInput = driver.findElement(firstName);
   driver.findElement(By.name("fname"));

   //class
    By paraHidden = By.className("topSecret");
    driver.findElement(paraHidden);

    //input
    By inputLocator = By.tagName("input");
    WebElement input = driver.findElement(inputLocator);
    input.sendKeys("Pierwszy");
    List<WebElement> inputs = driver.findElements(inputLocator);
    System.out.println(inputs.size());

    //linki
    By linkText = By.linkText("Visit W3Schools.com!");
    WebElement schoolLink = driver.findElement(linkText);

    By partialLink = By.partialLinkText("Visit");
    WebElement schoolElement = driver.findElement(partialLink);

    }
}
