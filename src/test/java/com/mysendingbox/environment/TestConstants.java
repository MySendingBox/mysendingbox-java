package com.mysendingbox.environment;

public abstract class TestConstants {
    public static void setup() {
        Constants.setApiBaseUrl("http://localhost:8080/");
    }
}
