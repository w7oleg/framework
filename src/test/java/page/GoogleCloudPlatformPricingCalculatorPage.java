package page;

import model.ProcessData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.time.Duration;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage{
    @FindBy(css = "#cloud-site > devsite-iframe > iframe")
    private WebElement iFrame;

    @FindBy(css = "#myFrame")
    private WebElement iFrameCalculator;

    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver, ProcessData data){
        super(driver, data);
    }
    @Override
    public GoogleCloudPlatformPricingCalculatorPage openPage() {
       new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(CustomConditions.jsLoadCompleted());

       logger.info("Open pricing calculator page");

       return this;
    }



    public PricingCalculatorPage openCalculator(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(CustomConditions.jsLoadCompleted());

        driver.switchTo().frame(iFrame);
        String linkPricingCalculatorPage = iFrameCalculator.getAttribute("src");

        driver.get(linkPricingCalculatorPage);

        logger.info("Moved to PricingCalculatorPageFrame");

        return new PricingCalculatorPage(driver, data);
    }





}
