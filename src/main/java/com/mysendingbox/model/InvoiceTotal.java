package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceTotal {

    @JsonProperty protected final Integer totalServicesHT;
    @JsonProperty protected final Integer totalPostagesHT;
    @JsonProperty protected final Integer totalHT;
    @JsonProperty protected final Integer totalTva;
    @JsonProperty protected final Integer totalTTC;

    @JsonCreator
    public InvoiceTotal(
            @JsonProperty("total_services_ht") final Integer totalServicesHT,
            @JsonProperty("total_postages_ht") final Integer totalPostagesHT,
            @JsonProperty("total_ht") final Integer totalHT,
            @JsonProperty("total_tva") final Integer totalTva,
            @JsonProperty("total_ttc") final Integer totalTTC) {
        this.totalServicesHT = totalServicesHT;
        this.totalPostagesHT = totalPostagesHT;
        this.totalHT = totalHT;
        this.totalTva = totalTva;
        this.totalTTC = totalTTC;
    }

    public Integer getTotalServicesHT() {
        return totalServicesHT;
    }

    public Integer getTotalPostagesHT() {
        return totalPostagesHT;
    }

    public Integer getTotalHT() {
        return totalHT;
    }

    public Integer getTotalTva() {
        return totalTva;
    }

    public Integer getTotalTTC() {
        return totalTTC;
    }

    @Override
    public String toString() {
        return "InvoiceTotal{" +
                ", totalServicesHT=" + totalServicesHT +
                ", totalPostagesHT=" + totalPostagesHT +
                ", totalHT=" + totalHT +
                ", totalTva=" + totalTva +
                ", totalTTC=" + totalTTC +
                '}';
    }
}
