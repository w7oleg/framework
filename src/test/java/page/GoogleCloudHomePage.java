package page;

import model.ProcessData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.time.Duration;

public class GoogleCloudHomePage extends AbstractPage{
    private static final String HOME_PAGE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@class='devsite-searchbox']/input")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver, ProcessData data){
        super(driver, data);
    }

    @Override
    public GoogleCloudHomePage openPage() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).
                until(CustomConditions.jsLoadCompleted());

        logger.info("Open page"+ HOME_PAGE_URL);
        return this;
    }


    public GoogleSearchResultPage fillSearchInput(String searchQuery) {
        data.setCurrentSearchQuery(searchQuery);

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(searchInput));

        searchInput.click();
        searchInput.sendKeys(searchQuery);
        searchInput.sendKeys(Keys.ENTER);

        logger.info("searching"+ searchQuery);

        return new GoogleSearchResultPage(driver, data);
    }
}
