package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SecondTest extends BaseTest{
    @Test
    public void firstTest()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class); //ignoruj
        wait.withTimeout(Duration.ofSeconds(10)); //poczekaj 10 sekund
        wait.pollingEvery(Duration.ofSeconds(1)); //sprobuj znowu po sekundzie
        waitForElementToExist(By.cssSelector("p"));

        String paraText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paraText,"Dopiero się pojawiłem!");
        driver.quit();
    }
    @Test
    public void secondTest()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class); //ignoruj
        wait.withTimeout(Duration.ofSeconds(10)); //poczekaj 10 sekund
        wait.pollingEvery(Duration.ofSeconds(1)); //sprobuj znowu po sekundzie
        waitForElementToExist(By.cssSelector("p"));

        String paraText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paraText,"Dopiero się pojawiłem!");
        driver.quit();
    }


    public void waitForElementToExist(By locator) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class); //ignoruj
        wait.withTimeout(Duration.ofSeconds(10)); //poczekaj 10 sekund
        wait.pollingEvery(Duration.ofSeconds(1)); //sprobuj znowu po sekundzie

        wait.until((driver1) -> {
            List<WebElement> elements = driver1.findElements(locator);
            if(elements.size()>0) {
                System.out.println("Element jest na stronie");
                return true;
            }else {
                System.out.println("Elementu nie ma na stronie");
                return false;
            }
        });
        driver.quit();
    }
    }

