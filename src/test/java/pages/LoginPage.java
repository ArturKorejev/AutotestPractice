package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class LoginPage {



    String emailInputXpath = "//*[@id=\"login-form\"]/div[1]/div[1]/input";
    String passwordInputClassName = "togglable-password_";
    String loginButtonId = "login-button";
    String errorMessageClassName = "login-warning";


    public void login(String email, String password) {

        WebElement emailInput = getCurrentDriver().findElement(By.xpath(emailInputXpath));
        WebElement passwordInput = getCurrentDriver().findElement(By.className(passwordInputClassName));
        WebElement loginButton = getCurrentDriver().findElement(By.id(loginButtonId));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();

    }

    public Boolean isErrorMessageDisplayed() {
        try {
            WebElement errorMessageText = getCurrentDriver().findElement(By.className(errorMessageClassName));
            if (errorMessageText.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
