package sampleapp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;


public class HelloWord {

    @Test
/*    public void openGooglePage() {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }*/
 /*   public void openGooglePage() {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\victoria\\Downloads\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
    }*/

//internet explorer niekoniecznie dziala
/*    public void openGooglePage() {
        System.setProperty("webdriver.ie.driver","C:\\Users\\victoria\\Downloads\\IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.com/");
        WebDriver driver = new InternetExplorerDriver(options);
    }*/
    public void openGooglePage() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize(); //maksymalizacja okna przegladarki
        Dimension windowSize = new Dimension(200, 200);
        driver.manage().window().setSize(windowSize);
        driver.get("https://www.google.com");
        //driver.quit(); //zamykanie przegladarki
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.google.com','blank','height=200','width=200')");
        //driver.close();  //zamyka tylko wcześniejsze okno
        driver.quit(); //zamyka każde okno

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