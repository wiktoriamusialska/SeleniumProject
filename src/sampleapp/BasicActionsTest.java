package sampleapp;

import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethodsIf;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class BasicActionsTest {
    @Test
    public void performAction(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        //klikanie
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();


        //wprowadzanie wartosci
        driver.findElement(By.id("fname")).sendKeys("Wiktoria");
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.clear();
        usernameInput.sendKeys("admin");
        /*driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");*/

        //nacisniecie przycisku na klawiaturze
        //usernameInput.sendKeys(Keys.ENTER);
        //usernameInput.sendKeys(Keys.TAB);

        //pobieranie wartosci z pola tekstowego
        System.out.println(usernameInput.getText());
        System.out.println(usernameInput.getAttribute("value"));

        //obługa alertu
        usernameInput.sendKeys(Keys.ENTER);
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        driver.switchTo().alert().accept();

        //zaznaczanie checkboxa i radio buttona
        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        //select (dropdown)
        WebElement selectCar=driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        cars.selectByVisibleText("Saab");
        cars.selectByValue("volvo");

        //pobieranie opcji selecta
        List<WebElement> options=cars.getOptions();
        for (WebElement option: options){
            System.out.println(option.getText());
        }
        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.checkOption("Audi",selectCar));
        System.out.println(selectCheck.checkOption("Jeep",selectCar));

        //pobieranie wartosci z ukrytego elementu
        WebElement para=driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By text: " + para.getText());
        System.out.println("By attr text: " + para.getAttribute("value"));
        System.out.println("By attr text content: " + para.getAttribute("textContent"));

        //obsluga nowego okna przegladarki




    }
}
