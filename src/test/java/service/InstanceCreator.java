package service;

import model.InstanceForm;

public class InstanceCreator {
    private static final String SEARCH_QUERY = "testdata.instanceForm.search-query";
    private static final String NUMBER_OF_INSTANCES = "testdata.instanceForm.number";
    private static final String OPERATION_SYSTEM = "testdata.instanceForm.os";
    private static final String MACHINE_CLASS = "testdata.instanceForm.machine-class";
    private static final String SERIES_ID = "testdata.instanceForm.series-id";
    private static final String MACHINE_TYPE = "testdata.instanceForm.machine-type";
    private static final String NUMBER_OF_GPUS = "testdata.instanceForm.number-of-gpus";
    private static final String TYPE_GPU = "testdata.instanceForm.type-gpu";
    private static final String LOCAL_SSD = "testdata.instanceForm.local-ssd";
    private static final String DATA_CENTER_LOCATION = "testdata.instanceForm.datacenter";
    private static final String COMMITTED_USAGE = "testdata.instanceForm.committed-sage";

    private static final String resultPriceManualTest = "testdata.instanceForm.result-price-manual";



    public static InstanceForm getDataEstimateForm(){
        InstanceForm meaningEstimateForm = new InstanceForm();

        meaningEstimateForm.setNumberOfInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES));
        meaningEstimateForm.setOperationSystem(TestDataReader.getTestData(OPERATION_SYSTEM));
        meaningEstimateForm.setMachineClass(TestDataReader.getTestData(MACHINE_CLASS));
        meaningEstimateForm.setSeriesID(TestDataReader.getTestData(SERIES_ID));
        meaningEstimateForm.setMachineType(TestDataReader.getTestData(MACHINE_TYPE));
        meaningEstimateForm.setNumberGPUs(TestDataReader.getTestData(NUMBER_OF_GPUS));
        meaningEstimateForm.setTypeGPU(TestDataReader.getTestData(TYPE_GPU));
        meaningEstimateForm.setLocalSSD(TestDataReader.getTestData(LOCAL_SSD));
        meaningEstimateForm.setDataCenterLocation(TestDataReader.getTestData(DATA_CENTER_LOCATION));
        meaningEstimateForm.setCommittedUsage(TestDataReader.getTestData(COMMITTED_USAGE));

        return meaningEstimateForm;
    }



}
