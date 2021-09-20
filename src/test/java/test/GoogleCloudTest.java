package test;

import model.InstanceForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.PricingCalculatorPage;
import service.InstanceCreator;
import utils.JavascriptUtils;

public class GoogleCloudTest extends CommonConditions{

    @Test(description = "get a letter with the results of processing the request")

    public void checkEmailEstimate(){
        String SEARCHING_QUERY = "Google Cloud Platform Pricing Calculator";
        InstanceForm instanceForm = new InstanceCreator().getDataEstimateForm();


        PricingCalculatorPage verificationCalculationResultsReceivedEmail = new GoogleCloudHomePage(driver, data)
                .openPage()
                .fillSearchInput(SEARCHING_QUERY)
                .openPage()
                .choiceSearchingQuery()
                .openCalculator()
                .activationComputeEngine()
                .choiceNumberOfInstances(instanceForm.getNumberOfInstances())
                .choiceOperationSystem(instanceForm.getOperationSystem())
                .choiceMachineClass(instanceForm.getMachineClass())
                .choiceSeries(instanceForm.getSeriesID())
                .choiceMachineType(instanceForm.getMachineType())
                .addGPUs()
                .choiceNumberGPUs(instanceForm.getNumberGPUs())
                .choiceTypeGPU(instanceForm.getTypeGPU())
                .choiceLocalSSD(instanceForm.getLocalSSD())
                .choiceDatacenterLocation(instanceForm.getDataCenterLocation())
                .choiceCommittedUsage(instanceForm.getCommittedUsage())
                .pressAddToEstimate()
                .saveResultEstimate()
                .pressButtonEmailEstimate();

        int indexTabPricingCalculator = 0;
        int indexTabTemporaryEmail = JavascriptUtils.createTab(driver);

        String totalPriceEmail = verificationCalculationResultsReceivedEmail
                .openEmailTab(indexTabTemporaryEmail)
                .openPage()
                .copyEmailAddress()
                .comeBackToCalculator(indexTabPricingCalculator)
                .enterEmail()
                .pressButtonSendEmail()
                .openEmailTab(indexTabTemporaryEmail)
                .pressCheckMailButton()
                .totalPriceEmail();
        Assert.assertTrue(data.getCurrentPriceInCalculator().contains(totalPriceEmail),
                "the data received by mail does not" +
                " coincide with the data received in the calculator");
    }

  }
