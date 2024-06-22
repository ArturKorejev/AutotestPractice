package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class ItemPage {

    String addToCartButtonID = "product-add-to-cart";
    String transitionToMyCartButtonID = "mini-cart-toggler";

    public void clickToAddToCartButton() {
        WebElement addToCartButton = getCurrentDriver().findElement(By.id(addToCartButtonID));
        addToCartButton.click();
    }

    public void performTransitionToMyCart() {
        WebElement transitionToMyCart = getCurrentDriver().findElement(By.id(transitionToMyCartButtonID));
        transitionToMyCart.click();
    }


}
