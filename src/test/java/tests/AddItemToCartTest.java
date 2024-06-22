package tests;



import dataModels.User;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;



public class AddItemToCartTest extends BaseTest {


    @Test (priority = 40)
    @Parameters({"email","password"})
    void addItemToCart(String email, String password ) {

        // Create Pages Objects

        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        AutoUnPiedzivojumuSpelesPage autoUnPiedzivojumuSpelesPage = new AutoUnPiedzivojumuSpelesPage();
        ItemPage itemPage = new ItemPage();
        MyCartPage myCartPage = new MyCartPage();

        // STEP 1: Transition to Login Page

        mainPage.performTransitionToLoginPage();

        // Step 2: Login with correct credentials

        User defaultUser = new User(email, password);
        loginPage.login(defaultUser.getEmail(), defaultUser.getPassword());

        // Step 3: Transition to Main Page and check that login has happened

        mainPage.performTransitionToLoginPage();
        Assert.assertTrue(mainPage.mainPageisOpen());
        Reporter.log("Login is succesfull");


        // Step 4: Transition to Auto un Piedzivojumu Speles

        mainPage.performTransitionToAutoUnPiedzivojumuSpelesPage();

        // Step 5: Scroll down until toy "Drone" become visible and click to it

        autoUnPiedzivojumuSpelesPage.scrollDownToDroneAndClick();
        Reporter.log("Predefined Item is finded");

        // Step 6: Add to Cart

        itemPage.clickToAddToCartButton();
        Reporter.log("Click to add to cart");



        // Step 7: Transition to My Cart Page

        itemPage.performTransitionToMyCart();
        Reporter.log("Transition to cart");

        // Step 8: Check that Item is added

        Assert.assertTrue(myCartPage.itemIsAddedToCart());
        Reporter.log("Checked that item is added to cart");

        // Step 9: Clear the cart

       myCartPage.clickToRemoveItemFromCart();
       Reporter.log("Item is removed from cart");


    }

}


