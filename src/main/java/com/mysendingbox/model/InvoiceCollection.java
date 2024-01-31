package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InvoiceCollection extends MysendingboxCollection<Invoice> {

    @JsonCreator
    public InvoiceCollection(
            @JsonProperty("invoices") final List<Invoice> invoices) {
        super(invoices);
    }

}
