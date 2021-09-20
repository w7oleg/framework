package page;

import model.ProcessData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JavascriptUtils;
import utils.TabsUtils;
import waits.CustomConditions;

import java.time.Duration;

public class EmailHomePage extends AbstractPage{
    private String HOME_PAGE_URL = "https://10minutemail.com";
    private final int WAIT_EMAIL_TIMEOUT_SECONDS = 30;

    @FindBy(xpath = "//*[@id='mail_messages_content']//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement containerWithLetter;

    @FindBy(xpath = "//*[@id='mobilepadding']//td[2]/h3")
    private WebElement fieldTotalPriceEstimateBill;


    protected EmailHomePage(WebDriver driver, ProcessData data) {
        super(driver, data);
    }

    private final String inputIDEmailAddress = "mail_address";

    @Override
    public EmailHomePage openPage() {
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .withMessage("javascript didn't load")
                .until(CustomConditions.jsLoadCompleted());

        return this;
    }

    public EmailHomePage copyEmailAddress(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(CustomConditions.inputEmailJQueryLoadCompleted());

        String temporaryEmail = JavascriptUtils.getValueByLocatorThroughJSExecutor(driver, inputIDEmailAddress);
        data.setCurrentEmail(temporaryEmail);

        logger.info("Email copied");

        return this;
    }

    public PricingCalculatorPage comeBackToCalculator(int index){
        driver.switchTo().window(TabsUtils.getCurrentTabs(driver).get(index));

        return new PricingCalculatorPage(driver, data);
    }

    public EmailHomePage pressCheckMailButton() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_EMAIL_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(containerWithLetter));

        containerWithLetter.click();

        return this;
    }

    public String totalPriceEmail(){
        return fieldTotalPriceEstimateBill.getText();
    }

}
