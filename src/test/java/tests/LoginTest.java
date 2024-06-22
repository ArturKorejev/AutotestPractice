package tests;


import dataModels.User;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;



public class LoginTest extends BaseTest {
    @Test (priority = 10)
    @Parameters({"email","password"})
    void successfullLoginCheck( String email, String password) {

        // Create Pages Objects

        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();

        // STEP 1: Transition to Login Page

        mainPage.performTransitionToLoginPage();

        // Step 2: Login with correct credentials

        User defaultUser = new User(email, password);
        loginPage.login(defaultUser.getEmail(), defaultUser.getPassword());
        Reporter.log("Correct email and password is entered");

        // Step 3: check that login has happened

        mainPage.performTransitionToLoginPage();
        Assert.assertTrue(mainPage.mainPageisOpen());
        Reporter.log("Login succesful");

    }

    @Test (priority = 20)
    @Parameters({"email","password"})
    void wrongPasswordCheck( String email,String password ) {

        // Create Pages Objects

        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();

        // STEP 1: Transition to Login Page

        mainPage.performTransitionToLoginPage();

        // Step 2: Login with correct email and incorrect password

        User defaultUser = new User(email, password);
        loginPage.login(defaultUser.getEmail(), defaultUser.getPassword() + "1" );
        //loginPage.login(email, password + "1");
        Reporter.log("correct email is entered, password is wrong");

        // Step 3: check that login has not happened, error message must be displayed

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Reporter.log("Error message displayed");

    }

    @Test (priority = 30)
    @Parameters({"email","password"})
    void emptyEmailFieldCheck ( String email,String password ) {

        // Create Pages Objects

        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();

        // STEP 1 Transition to Login Page

        mainPage.performTransitionToLoginPage();

        // Step 2: Login with empty Email field and correct password

        User defaultUser = new User(email, password);
        loginPage.login("", defaultUser.getPassword());

        Reporter.log("email don't entered, password is correct");

        // Step 3: check that login has not happened, error message must be displayed

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Reporter.log("Error message displayed");
    }


}


