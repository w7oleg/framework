package page;


import model.ProcessData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected ProcessData data;

    protected final Logger logger = LogManager.getRootLogger();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver, ProcessData data) {
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }
}
