package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoicePaymentInformations {

    @JsonProperty protected final boolean paid;
    @JsonProperty protected final String error;
    @JsonProperty protected final String errorCode;
    @JsonProperty protected final InvoicePaymentInformationsCharge charge;

    @JsonCreator
    public InvoicePaymentInformations(
            @JsonProperty("paid") final boolean paid,
            @JsonProperty("error") final String error,
            @JsonProperty("error_code") final String errorCode,
            @JsonProperty("charge") final InvoicePaymentInformationsCharge charge) {
        this.paid = paid;
        this.error = error;
        this.errorCode = errorCode;
        this.charge = charge;
    }

    public boolean getPaid() {
        return paid;
    }

    public String getError() {
        return error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public InvoicePaymentInformationsCharge getCharge() {
        return charge;
    }

    @Override
    public String toString() {
        return "InvoicePaymentInformations{" +
                " paid='" + paid + '\'' +
                ", error='" + error + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", charge='" + charge + '\'' +
                '}';
    }
}
