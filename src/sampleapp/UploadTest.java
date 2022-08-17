package sampleapp;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadTest {
    @Test
    public void executeJavaScript(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\victoria\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\victoria\\Desktop\\smile.png");


        //robienie zrzutu ekranu z zapisywaiem do katalogu - nie działa
       /*
        int randomNumber = (int) (Math.random()*1000);
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "beforeUpload" + randomNumber + ".png";
        FileUtils.copyFile(before, new File("src/test/resources/" + fileName));
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\victoria\\Desktop\\smile.png");
        */


    }
}
