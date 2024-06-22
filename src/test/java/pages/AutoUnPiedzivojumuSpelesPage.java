package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class AutoUnPiedzivojumuSpelesPage {


    String definedItemXPath = "//*[@id=\"products\"]/div[19]";


    public void scrollDownToDroneAndClick() {
        WebElement definedItem = getCurrentDriver().findElement(By.xpath(definedItemXPath));
        JavascriptExecutor jse = (JavascriptExecutor) getCurrentDriver();
        jse.executeScript("arguments[0].scrollIntoView(true)",definedItem);
        definedItem.click();


    }

}
