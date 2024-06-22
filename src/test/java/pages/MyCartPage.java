package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class MyCartPage {

    String removeItemFromCartXpath = "//*[@id=\"cart\"]/form/div[2]/div[1]/div[2]/div/div[4]/div[2]/div/div"; // Need to improve locator!
    String itemNameClassName = "cart-item__name";


    public void clickToRemoveItemFromCart() {
        WebElement removeItemFromCart = getCurrentDriver().findElement(By.xpath(removeItemFromCartXpath));
        removeItemFromCart.click();
    }

    public Boolean itemIsAddedToCart() {
        try {
            WebElement itemNameField = getCurrentDriver().findElement(By.className(itemNameClassName));
            if (itemNameField.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }



}
