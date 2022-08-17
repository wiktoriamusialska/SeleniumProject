package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cssSelectorsTest {
    @Test
    public void findElements(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssID = By.cssSelector("#clickOnMe"); // # id
        driver.findElement(cssID);

        By cssClass = By.cssSelector(".topSecret"); //. to klasa
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input"); //nazwa po tagach
        driver.findElement(cssTag).sendKeys("Pierwszy");

        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        By cssClass2= By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);

        By all =By.cssSelector("*"); //wszystkie znaczniki
        driver.findElement(all);

        By ulInDiv = By.cssSelector("div ul");
        By trInTable = By.cssSelector("table tr"); //nie tylko dziecko, tylko cała struktura
        By trInBody=By.cssSelector("tbody tr");

        driver.findElement(ulInDiv);
        driver.findElement(trInTable);
        driver.findElement(trInBody);

        //bezposrednie dziecko
        By firstChildUlinDiv = By.cssSelector("div > ul");
        By firstChildTrinTbody = By.cssSelector("tbody > tr");
        driver.findElement(firstChildTrinTbody);
        driver.findElement(firstChildUlinDiv);

        //pierwszy form po label - ten sam poziom - nie rodzic, dziecko
        //wszystkie formy po label
        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(firstFormAfterLabel);
        driver.findElement(allFormAfterLabel);

        //szukanie po nazwie
        //zawiera slowa
        By attrTag = By.cssSelector("input[name='fname']");
        By attrContains = By.cssSelector("[name*='name']");

        //zaczyna sie od slowa
        By attrStarts = By.cssSelector("[name^='f']");

        //konczy sie na slowo
        By attrEnds = By.cssSelector("[name$='name']");

        driver.findElement(attrTag);
        driver.findElement(attrContains);
        driver.findElement(attrStarts);
        driver.findElement(attrEnds);

        //okreslanie dziecka w drzewku -- pierwsze, ostatnie dziecko oraz wybrane w kolejnosci dzieci

        By firstChild = By.cssSelector("li:first-child");

        By lastChild = By.cssSelector("li:last-child");

        By thirdChild = By.cssSelector("li:nth-child(3)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(thirdChild);




    }
}
