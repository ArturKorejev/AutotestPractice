package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class MainPage {


    String transitionToLoginPageClassName = "mini-profile-section";
    String popUpMenuElementClassName = "mini-profile-wrapper";
    String transitionToAutoUnPiedzivojumuSpelesPageXpath = "//*[@id=\"mega-nav-fin-wrapper\"]/ul/li[3]/a"; // Need to improve locator!
    String searchBarClassName = "//*[@id=\"main-container\"]/header/div/div[3]/div/div[1]/input"; // Need to improve locator!
    String searchButtonClassName = "//*[@id=\"main-container\"]/header/div/div[3]/div/div[1]/div/button"; // Need to improve locator!
    String noResultTextClassName = "no-results-image__img";




    public void performTransitionToLoginPage() {
        WebElement transitionToLoginPage = getCurrentDriver().findElement(By.className(transitionToLoginPageClassName));
        transitionToLoginPage.click();
    }

    public Boolean mainPageisOpen() {
        try {
            WebElement popUpMenuElementText = getCurrentDriver().findElement(By.className(popUpMenuElementClassName));
            if (popUpMenuElementText.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean noResultAfterSearch () {
        try {
            WebElement noResultBanner = getCurrentDriver().findElement(By.className(noResultTextClassName));
            if (noResultBanner.isDisplayed()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void performTransitionToAutoUnPiedzivojumuSpelesPage() {
        WebElement transitionToAutoUnPiedzivojumuSpelesPage = getCurrentDriver().findElement(By.xpath(transitionToAutoUnPiedzivojumuSpelesPageXpath));
        transitionToAutoUnPiedzivojumuSpelesPage.click();

    }

    public void typeTheQueryAndSearch() {
        WebElement searchBar = getCurrentDriver().findElement(By.xpath(searchBarClassName));
        searchBar.sendKeys("monopoly");
        WebElement pushSearchButton = getCurrentDriver().findElement(By.xpath(searchButtonClassName));
        pushSearchButton.click();


    }


}
