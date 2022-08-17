package sampleapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Set;

public class HomeWork {
        @Test
        public void executeJavaScript(){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
// najechanie na element
            Actions actions = new Actions(driver);
            WebElement heading = driver.findElement(By.tagName("h1"));
            actions.moveToElement(heading).perform();

 //klikanie
            WebElement basicPageLink = driver.findElement(By.id("clickOnMe"));
            basicPageLink.click();
//obsługa okienka - alertu
            Alert firstAlert = driver.switchTo().alert();
            firstAlert.accept();
//wprowadzanie wartosci w pole tekstowe
            WebElement usernameInput = driver.findElement(By.id("fname"));
            usernameInput.clear();
            usernameInput.sendKeys("admin");
//pobieranie wartosci z tabeli
            By buttonId = By.xpath("//td[1]");
            WebElement clickOnMeButton = driver.findElement(buttonId);
            System.out.println(clickOnMeButton.getText());
//select
            WebElement selectCar=driver.findElement(By.cssSelector("select"));
            Select cars = new Select(selectCar);
            cars.selectByVisibleText("Saab");
            cars.selectByValue("volvo");
//zaznaczanie checkboxa
            driver.findElement(By.cssSelector("[type='checkbox']")).click();
//zaznaczanie ratio buttona
            driver.findElement(By.cssSelector("[value='female']")).click();
//input
            By andOp = By.xpath("//input[@type='text' and @name='username']");
            WebElement first = driver.findElement(andOp);
            first.clear();
            first.sendKeys("wiktoria");
            //
            By andOp2 = By.xpath("//input[@type='password' and @name='password']");
            WebElement second = driver.findElement(andOp2);
            second.clear();
            second.sendKeys("musialska");

//click
            WebElement selector =driver.findElement(By.cssSelector(("[type='submit']")));
            selector.click();
//obsługa okienka - alertu
            Alert secondAlert = driver.switchTo().alert();
            secondAlert.accept();
            driver.switchTo().alert().accept();
//łapanie okna
            String currentWindow = driver.getWindowHandle();

//click
            WebElement selector2 =driver.findElement(By.cssSelector("button[id='newPage']"));
            selector2.click();

//kontrola nad oknami
            Set<String> windowNames = driver.getWindowHandles();
            for(String window : windowNames) {
                if(!window.equals(currentWindow)) {
                    driver.switchTo().window(window);
                }

            }
//zarzadzenie oknami
            driver.findElement(By.xpath("//div[@role='none' and @class='QS5gu sy4vM' and contains(text(),'Zaakceptuj wszystko')]")).click();
            driver.findElement(By.name("q")).sendKeys("Selenium");
            driver.switchTo().window(currentWindow);
//szukanie bezpośednich dzieci
            By desc = By.xpath("//div/descendant::li[1]"); //dziecko 1 li zwraca
            //By desc = By.xpath("//div/descendant::li"); //cale 1 li parent and child
            WebElement elem = driver.findElement(desc);
            System.out.println(elem.getText());
//zamkniecie okna
            driver.quit();
        }}
