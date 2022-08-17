package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitTest2 {
    @Test
    public void executeJavaScript()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();


        //czekanie na element

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class); //ignoruj
        wait.withTimeout(Duration.ofSeconds(10)); //poczekaj 10 sekund
        wait.pollingEvery(Duration.ofSeconds(1)); //sprobuj znowu po sekundzie
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p"))); //sprawdzenie czy jest widoczny

        //driver.findElement(By.cssSelector("p"));
        waitForElementToExist(By.cssSelector("p"));

    }


    public void waitForElementToExist(By locator) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class); //ignoruj
        wait.withTimeout(Duration.ofSeconds(10)); //poczekaj 10 sekund
        wait.pollingEvery(Duration.ofSeconds(1)); //sprobuj znowu po sekundzie
        wait.until(new Function<WebDriver, Boolean>(){
            @Override
            public Boolean apply (WebDriver driver){
                List<WebElement> elements = driver.findElements(locator);
                if (elements.size() > 0) {
                    System.out.println("Element jest na stronie");
                    return true;
                } else {
                    System.out.println("Elementu nie ma na stronie");
                    return false;
                }
            }
        });
    }
    }

