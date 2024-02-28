package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoicePaymentInformationsCharge {

    @JsonProperty protected final Integer created;
    @JsonProperty protected final String receiptURL;
    @JsonProperty protected final String type;

    @JsonCreator
    public InvoicePaymentInformationsCharge(
            @JsonProperty("created") final Integer created,
            @JsonProperty("receipt_url") final String receiptURL,
            @JsonProperty("type") final String type) {
        this.created = created;
        this.receiptURL = receiptURL;
        this.type = type;
    }

    public Integer getCreated() {
        return created;
    }

    public String getReceiptURL() {
        return receiptURL;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "InvoicePaymentInformationsCharge{" +
                " created='" + created + '\'' +
                ", receiptURL='" + receiptURL + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
