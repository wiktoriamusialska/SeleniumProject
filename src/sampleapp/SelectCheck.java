
package sampleapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectCheck {


    public boolean checkOption(String optionText, WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(optionText))
                return true;
        }
        return false;


    }

}

