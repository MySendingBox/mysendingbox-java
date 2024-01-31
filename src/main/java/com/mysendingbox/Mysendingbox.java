package com.mysendingbox;

public class Mysendingbox {

    public static String apiKey;
    public static String apiVersion;

    public static void init(final String apiKey) {
        Mysendingbox.apiKey = apiKey;
        Mysendingbox.apiVersion = null;
    }

    public static void init(final String apiKey, final String apiVersion) {
        Mysendingbox.apiKey = apiKey;
        Mysendingbox.apiVersion = apiVersion;
    }

}
