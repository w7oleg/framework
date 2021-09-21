package page;

import model.ProcessData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JavascriptUtils;
import utils.TabsUtils;
import waits.CustomConditions;
import waits.CustomWebElementWaits;

import java.time.Duration;

public class PricingCalculatorPage extends AbstractPage{
    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement tabComputerEngine;


    @FindBy(id = "input_71")//68
    private WebElement inputNumberInstances;

    @FindBy(id = "select_value_label_64")//61
    private WebElement locatorOperatingSystem;

    @FindBy(id = "select_value_label_65")
    private WebElement locatorMachineClass;

    @FindBy(id = "select_value_label_67")
    private WebElement locatorSeries;

    @FindBy(id = "select_value_label_68")
    private WebElement locatorMachineType;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-checkbox[@aria-label='Add GPUs']")
    private WebElement locatorAddGPUs;

    private static final String locatorDefineInstanceForm = "//h2[contains(text(),'Instances')]/..";

    @FindBy(xpath = locatorDefineInstanceForm + "//md-select[@placeholder='Number of GPUs']")
    private WebElement inputContainerGPUNumber;

    @FindBy(xpath = locatorDefineInstanceForm + "//md-select[@placeholder='GPU type']")
    private WebElement inputContainerGPUType;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement locatorLocalSSD;

    @FindBy(id = "select_value_label_69")
    private WebElement locatorDatacenter;


    @FindBy(id = "select_value_label_70")
    private WebElement locatorCommittedUsage;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//button[@aria-label='Add to Estimate']")
    private WebElement locatorAddEstimate;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//h2[@class='md-title']/b")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;


    String locatorPositionDownList = "//div[contains(@class,'md-active md-clickable')]//md-option[@value='%s']";


    public PricingCalculatorPage(WebDriver driver, ProcessData data){
        super(driver, data);
    }

    @Override
    protected PricingCalculatorPage openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(CustomConditions.jsLoadCompleted());

        logger.info("filling in calculator fields");

        return this;
    }

    public PricingCalculatorPage activationComputeEngine(){
        tabComputerEngine.click();

        return this;
    }

    public PricingCalculatorPage choiceNumberOfInstances(String number){
        inputNumberInstances.click();
        inputNumberInstances.sendKeys(number);

        logger.info("Entered instances"+ number);

        return this;
    }

    public WebElement positionMenu( String variable){
        String locator = String.format(locatorPositionDownList, variable);

        return CustomWebElementWaits.waitBeforeChoosingMenuOption(locator, driver, WAIT_TIMEOUT_SECONDS);
    }

    public PricingCalculatorPage choiceOperationSystem(String system){
        JavascriptUtils.clickDependingBrowser(driver, locatorOperatingSystem, data.getCurrentBrowser());

        WebElement locator = positionMenu(system);

        WebElement position = CustomWebElementWaits.waitBeforeChoosingMenuOption(locator, driver, WAIT_TIMEOUT_SECONDS);
        JavascriptUtils.clickDependingBrowser(driver, position, data.getCurrentBrowser());
        //position.click();

        logger.info("Chose operation system " + system);

        return this;
    }

    public PricingCalculatorPage choiceMachineClass(String machineClass){
        JavascriptUtils.clickDependingBrowser(driver, locatorMachineClass, data.getCurrentBrowser());

        WebElement locator = positionMenu(machineClass);
        JavascriptUtils.clickDependingBrowser(driver, locator, data.getCurrentBrowser());

        logger.info("Chose machine class " + machineClass);

        return this;
    }

    public PricingCalculatorPage choiceSeries(String series){
        JavascriptUtils.clickDependingBrowser(driver, locatorSeries, data.getCurrentBrowser());

        WebElement locator = positionMenu(series);
        JavascriptUtils.clickDependingBrowser(driver, locator, data.getCurrentBrowser());

        logger.info("Chose machine class " +series);

        return this;
    }

    public PricingCalculatorPage choiceMachineType(String type){
        JavascriptUtils.clickDependingBrowser(driver, locatorMachineType, data.getCurrentBrowser());

        WebElement locator = positionMenu(type);
        JavascriptUtils.clickDependingBrowser(driver, locator, data.getCurrentBrowser());

        logger.info("Chose machine type"+type);

        return this;
    }

    public PricingCalculatorPage addGPUs(){

        JavascriptUtils.clickDependingBrowser(driver, locatorAddGPUs, data.getCurrentBrowser());

        return this;
    }

    public PricingCalculatorPage choiceNumberGPUs(String number){

        CustomWebElementWaits.waitBeforeChoosingMenuOption(inputContainerGPUNumber, driver, WAIT_TIMEOUT_SECONDS);
        JavascriptUtils.clickDependingBrowser(driver, inputContainerGPUNumber, data.getCurrentBrowser());


        WebElement positionNumber = positionMenu(number);
        JavascriptUtils.clickDependingBrowser(driver, positionNumber, data.getCurrentBrowser());

        logger.info("number GPU"+number);

        return this;
    }

    public PricingCalculatorPage choiceTypeGPU(String type){
        CustomWebElementWaits.waitBeforeChoosingMenuOption(inputContainerGPUType, driver, WAIT_TIMEOUT_SECONDS);
        JavascriptUtils.clickDependingBrowser(driver, inputContainerGPUType, data.getCurrentBrowser());

        WebElement positionType = positionMenu(type);
        JavascriptUtils.clickDependingBrowser(driver, positionType, data.getCurrentBrowser());

        logger.info("type GPU"+type);

        return this;
    }

    public PricingCalculatorPage choiceLocalSSD(String lssd){

        CustomWebElementWaits.waitBeforeChoosingMenuOption(locatorLocalSSD, driver, WAIT_TIMEOUT_SECONDS);
        JavascriptUtils.clickDependingBrowser(driver, locatorLocalSSD, data.getCurrentBrowser());

        WebElement position = positionMenu(lssd);
        JavascriptUtils.clickDependingBrowser(driver, position, data.getCurrentBrowser());

        logger.info("Chose local SSD count " + lssd);

        return this;
    }

    public PricingCalculatorPage choiceDatacenterLocation(String location){
        JavascriptUtils.clickDependingBrowser(driver, locatorDatacenter, data.getCurrentBrowser());

        WebElement position = positionMenu(location);
        JavascriptUtils.clickDependingBrowser(driver, position, data.getCurrentBrowser());

        logger.info("Chose datacenter location " + location);

        return this;
    }

    public PricingCalculatorPage choiceCommittedUsage(String usage){
        JavascriptUtils.clickDependingBrowser(driver, locatorCommittedUsage, data.getCurrentBrowser());

        WebElement position = positionMenu(usage);
        JavascriptUtils.clickDependingBrowser(driver, position, data.getCurrentBrowser());

        logger.info("Chose committed usage " + usage);

        return this;
    }

    public PricingCalculatorPage pressAddToEstimate(){
        locatorAddEstimate.click();

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).
                until(ExpectedConditions.visibilityOf(locatorAddEstimate));

        logger.info("ComputerEngine form filled");

        return this;
    }

    public PricingCalculatorPage saveResultEstimate(){
        data.setCurrentPriceInCalculator(totalEstimatedCost.getText());

        return this;
    }

    public PricingCalculatorPage pressButtonEmailEstimate(){
        buttonEmailEstimate.click();

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(inputEmail));

        logger.info("ComputerEngine form filled");

        return this;
    }

    public EmailHomePage openEmailTab(int tabIndex) {
        driver.switchTo().window(TabsUtils.getCurrentTabs(driver).get(tabIndex));

        return new EmailHomePage(driver, data);
    }

    public PricingCalculatorPage enterEmail(){
        inputEmail.sendKeys(data.getCurrentEmail());

        logger.info("Email wrote down");

        return this;
    }

    public PricingCalculatorPage pressButtonSendEmail(){
        JavascriptUtils.clickDependingBrowser(driver, buttonSendEmail, data.getCurrentBrowser());

        logger.info("Email sent");

        return this;
    }







}
