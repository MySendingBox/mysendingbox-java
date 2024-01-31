package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiKeys {

    @JsonProperty private final ApiKey live;
    @JsonProperty private final ApiKey test;

    @JsonCreator
    public ApiKeys(
            @JsonProperty("live") final ApiKey live,
            @JsonProperty("test") final ApiKey test) {
        this.live = live;
        this.test = test;
    }

    public ApiKey getLive() {
        return live;
    }

    public ApiKey getTest() {
        return test;
    }

    @Override
    public String toString() {
        return "ApiKeys{" +
                "live='" + live + '\'' +
                "test='" + test + '\'' +
                '}';
    }

}
