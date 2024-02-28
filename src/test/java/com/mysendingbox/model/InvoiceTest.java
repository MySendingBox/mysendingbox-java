package com.mysendingbox.model;

import com.mysendingbox.BaseTest;
import com.mysendingbox.model.Invoice;
import com.mysendingbox.model.InvoiceCollection;
import com.mysendingbox.net.MysendingboxResponse;
import org.junit.Test;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class InvoiceTest extends BaseTest {

    @Test
    public void testListInvoices() throws Exception {
        MysendingboxResponse<InvoiceCollection> response = Invoice.list();

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Invoice.class));
    }

    @Test
    public void testListInvoiceWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "paid");
        params.put("date_start", "2020-01-01");

        MysendingboxResponse<InvoiceCollection> response = Invoice.list(params);

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Invoice.class));
    }

    @Test
    public void testRetrieveInvoice() throws Exception {
        Invoice testInvoice = Invoice.list().getResponseBody().getData().get(0);

        MysendingboxResponse<Invoice> response = Invoice.retrieve(testInvoice.getId());
        Invoice invoice = response.getResponseBody();

        assertEquals(testInvoice.getId(), invoice.getId());

        System.out.println(invoice);
    }


}
