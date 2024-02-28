package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceDiscount {

    @JsonProperty protected final String type;
    @JsonProperty protected final Integer value;
    @JsonProperty protected final String text;
    @JsonProperty protected final Integer tva;
    @JsonProperty protected final Integer price;
    @JsonProperty protected final Integer totalHT;


    @JsonCreator
    public InvoiceDiscount(
            @JsonProperty("type") final String type,
            @JsonProperty("value") final Integer value,
            @JsonProperty("text") final String text,
            @JsonProperty("tva") final Integer tva,
            @JsonProperty("price") final Integer price,
            @JsonProperty("total_ht") final Integer totalHT) {
        this.type = type;
        this.value = value;
        this.text = text;
        this.tva = tva;
        this.price = price;
        this.totalHT = totalHT;
    }

    public String getType() {
        return type;
    }

    public Integer getValue() {
        return value;
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

    @Override
    public String toString() {
        return "InvoiceDiscount{" +
                " type='" + type + '\'' +
                ", value=" + value +
                ", text='" + text + '\'' +
                ", tva=" + tva +
                ", price=" + price +
                ", totalHT=" + totalHT +
                '}';
    }
}
