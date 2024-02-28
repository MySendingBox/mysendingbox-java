package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {

    @JsonProperty
    private final double total;
    @JsonProperty
    private final double postage;
    @JsonProperty
    private final double service;

    @JsonCreator
    public Price(
            @JsonProperty("total") final double total,
            @JsonProperty("postage") final double postage,
            @JsonProperty("service") final double service) {
        this.total = total;
        this.postage = postage;
        this.service = service;
    }

    public double getTotal() {
        return total;
    }

    public double getPostage() {
        return postage;
    }

    public double getService() {
        return service;
    }

    @Override
    public String toString() {
        return "Price{" +
                "postage=" + postage + +'\'' +
                ", service=" + service + +'\'' +
                ", total=" + total + +'\'' +
                '}';
    }

}