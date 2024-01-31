package com.mysendingbox.environment;

public abstract class Constants {

    private static String apiBaseUrl = "https://api.mysendingbox.fr/";
    private static String version = "1.0.0";

    public static String getApiBaseUrl() {
        return apiBaseUrl;
    }

    protected static void setApiBaseUrl(String apiBaseUrl) {
        Constants.apiBaseUrl = apiBaseUrl;
    }

    public static String getVersion() {
        return version;
    }

    protected static void setVersion(String version) {
        Constants.version = version;
    }
}
