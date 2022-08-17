package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistTest {



    @Test
    public void elementExistTest(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //czy element istnieje na stronie sposob1
        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        //czy element istnieje na stronie sposob2
        System.out.println(elementSecond(By.tagName("p")));
        System.out.println(elementSecond(By.id("topSecret")));


        //czy jest widoczny
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        //czy jest klikalny / dostępny do edycji
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());



        //czy checkbox jest zaznaczony
        System.out.println("==================================");
        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
        //driver.quit();
        driver.close(); //zamyka jedno okno


    }

    public boolean elementExist(By locator) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }
    public boolean elementSecond(By locator) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        return driver.findElements(locator).size() >0 ;


    }


}
