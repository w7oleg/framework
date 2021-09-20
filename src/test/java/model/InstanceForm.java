package model;

public class InstanceForm {
    private String numberOfInstances;
    private String operationSystem;
    private String machineClass;
    private String seriesID;
    private String machineType;
    private String numberGPUs;
    private String typeGPU;
    private String localSSD;
    private String dataCenterLocation;
    private String committedUsage;


    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(String seriesID) {
        this.seriesID = seriesID;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberGPUs() {
        return numberGPUs;
    }

    public void setNumberGPUs(String numberGPUs) {
        this.numberGPUs = numberGPUs;
    }

    public String getTypeGPU() {
        return typeGPU;
    }

    public void setTypeGPU(String typeGPU) {
        this.typeGPU = typeGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }
}
