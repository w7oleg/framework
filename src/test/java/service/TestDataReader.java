package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle commonResources = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key) {
        return commonResources.getString(key);
    }
}
