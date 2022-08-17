package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class XpathTest {
    public void findElements() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //clickOnMe
        By buttonId = By.xpath("/html/body/button[@id='clickOnMe']");
        WebElement clickOnMeButton = driver.findElement(buttonId);

        //fname
        By firstName = By.xpath("//input[@name='fname']");
        WebElement firstNameInput = driver.findElement(firstName);

        //class
        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

        //input
        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());

        //sprawdzamy czy tekst jest rowny danemu
        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);

        //znamy tylko kawałek tekstu
        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        WebElement schoolElement = driver.findElement(partialLink);

        //konkretny adres
        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        //wszystkie ul w strukturze
        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);


        //szukanie calej struktury
        By allXpath =By.xpath("//*");
        driver.findElement(allXpath);

        //selektor z indeksem

        By secondElement =By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        //element z atrybutem
        By elementWithAttribute =By.xpath("//*[@name]");
        driver.findElement(elementWithAttribute);

        //
        By attrEq=By.xpath("//button[@id='clickOnMe']");
        By attrNotEq=By.xpath("//*[@id!='clickOnMe']");
        By attrCont=By.xpath("//*[contains(@name, 'ame')]");
        By startsWith=By.xpath("//*[starts-with(@name, 'user')]");
        By endsWith = By.xpath("//*[substring(@name, string-length(@name)-string-length('name')+1)='name']");
        driver.findElement(attrEq);
        driver.findElement(attrNotEq);
        driver.findElement(startsWith);
        driver.findElement(attrCont);
        driver.findElement(endsWith);

        //dzieci znacznika
        By child = By.xpath("//div/child::ul");

        //bezpośredni rodzic
        By parent = By.xpath("//div/../..");

        // szukamy w dół dzieci
        By desc = By.xpath("//div/descendant::ul");

        //szukamy w górę rodziców
        By asc =By.xpath("//div/ancestor::*");

        //wszystkie tagi występujące po naszym tagu
        By foll =By.xpath("//img/following::*");

        //wszystkie tagi po, niezagnieżdżone, na tym samym poziomie
        By follSib =By.xpath("//img/following-sibling::*");

        //wszystkie tagi przed
        By prec=By.xpath("//img/preceding::*");

        //wszystkie tagi przed na tym samym poziomie w strukturze
        By precSib =By.xpath("//img/preceding-sibling::*");

        driver.findElement(child);
        driver.findElement(parent);
        driver.findElement(desc);
        driver.findElement(asc);
        driver.findElement(foll);
        driver.findElement(follSib);
        driver.findElement(prec);
        driver.findElement(precSib);

        //szukanie selektorów
        By divsAndLinks = By.xpath("//a | //div");

        //operator and
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");
        By orOp = By.xpath("//input[@name='fname' or @id='fname']");

        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOp);

    }
}
