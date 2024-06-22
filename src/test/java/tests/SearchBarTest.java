package tests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;


public class SearchBarTest extends BaseTest {


    @Test (priority = 50)
    @Parameters({"email","password"})
    void searchBarCheck () {

        // Create Pages Objects

        MainPage mainPage = new MainPage();


        // Step 1: Send query to Search bar

        mainPage.typeTheQueryAndSearch();
        Reporter.log("Query is sent to search bar");

        // Step 2: Check that we have some result

        Assert.assertFalse(mainPage.noResultAfterSearch());
        Reporter.log("Some items finded");

    }
}


