package sampleapp;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebDriverManagerTest {

    @Test

    public void openGooglePage() {

        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        // znalezienie przycisku
        //WebElement agreeButton = driver.findElement(By.xpath("//div[contains(text(),'Zaakceptuj wszystko')]"));
        WebElement agreeButton = driver.findElement(By.xpath("//button[@class='tHlp8d']"));
        driver.findElement(By.xpath("//div[contains(text(),'Zaakceptuj wszystko')]"));
        // klikniecie przycisku
        agreeButton.click();
        // znajdz pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        // wprowadz wartosc Selenium do pola
        searchField.sendKeys("Selenium");
        // zasymuluj nacisniecie przycisku Enter
        searchField.sendKeys(Keys.ENTER);
        // znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());

    }

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                String chromePath = "C:\\Users\\victoria\\Downloads\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromePath);
                return new ChromeDriver();
            case "firefox":
                String firefoxPath = "C:\\Users\\victoria\\Downloads\\geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", firefoxPath);
                return new FirefoxDriver();
            case "ie":
                String iePath = "C:\\Users\\victoria\\Downloads\\IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", iePath);
                return new InternetExplorerDriver();

            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }
}
