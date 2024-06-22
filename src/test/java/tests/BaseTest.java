package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import static utils.DriverProvider.closeDriver;
import static utils.DriverProvider.getCurrentDriver;

public class BaseTest {


    @BeforeMethod
    void setUp() {

        getCurrentDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getCurrentDriver().get("https://www.toysplanet.lv");
    }

    @AfterMethod
    void tearDown() {
        closeDriver();
    }
}
