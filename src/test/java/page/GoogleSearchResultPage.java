package page;

import model.ProcessData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.time.Duration;

public class GoogleSearchResultPage extends AbstractPage{
    private String partOfSearchQuery = "//a[@class='gs-title']/b[text()='%s']";

    protected GoogleSearchResultPage(WebDriver driver, ProcessData data) {
        super(driver, data);
    }


    @Override
    public GoogleSearchResultPage openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        logger.info("Opened page CloudGooglePageWithSearchingResultFrame");

        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage choiceSearchingQuery() {
        String locator = String.format(partOfSearchQuery, data.getCurrentSearchQuery());

        WebElement googleCalculatorLink = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

        googleCalculatorLink.click();

        logger.info("Chose link depending searching query");

        return new GoogleCloudPlatformPricingCalculatorPage(driver, data);
    }
}
