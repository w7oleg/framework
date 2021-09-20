package test;

import driver.DriverSingleton;
import model.ProcessData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;


@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    ProcessData data;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
        data = new ProcessData();

       data.setCurrentBrowser(((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase());
    }



    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
