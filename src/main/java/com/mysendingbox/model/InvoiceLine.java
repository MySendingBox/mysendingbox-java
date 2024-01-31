package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceLine {

    @JsonProperty protected final String text;
    @JsonProperty protected final Integer tva;
    @JsonProperty protected final Integer price;
    @JsonProperty protected final Integer totalHT;
    @JsonProperty protected final Integer totalTva;
    @JsonProperty protected final Integer totalTTC;

    @JsonCreator
    public InvoiceLine(
            @JsonProperty("text") final String text,
            @JsonProperty("tva") final Integer tva,
            @JsonProperty("price") final Integer price,
            @JsonProperty("total_ht") final Integer totalHT,
            @JsonProperty("total_tva") final Integer totalTva,
            @JsonProperty("total_ttc") final Integer totalTTC) {
        this.text = text;
        this.tva = tva;
        this.price = price;
        this.totalHT = totalHT;
        this.totalTva = totalTva;
        this.totalTTC = totalTTC;
    }

    public String getText() {
        return text;
    }

    public Integer getTva() {
        return tva;
    }

    public Integer getPrice() {
        return price;
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
        return "InvoiceLine{" +
                " text='" + text + '\'' +
                ", tva=" + tva +
                ", price=" + price +
                ", totalHT=" + totalHT +
                ", totalTva=" + totalTva +
                ", totalTTC=" + totalTTC +
                '}';
    }
}
