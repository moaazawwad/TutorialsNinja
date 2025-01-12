package testCases;

import drivers.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static pages.Page_Base.quitBrowser;

public class testBase {

    @Parameters("browsername")
    @BeforeTest
    public void setupDriver(@Optional String browsername){

        setDriver(DriverFactory.getNewInstance(browsername));

        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        getDriver().get("https://tutorialsninja.com/demo");
    }

    @AfterTest
    public void tearDown(){
        quitBrowser(getDriver());
    }
}
