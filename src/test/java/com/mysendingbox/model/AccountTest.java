package com.mysendingbox.model;

import com.mysendingbox.BaseTest;
import com.mysendingbox.model.Account;
import com.mysendingbox.net.MysendingboxResponse;
import org.junit.Test;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class AccountTest extends BaseTest {

    @Test
    public void testCreateAccount() throws Exception {
        MysendingboxResponse<Account> response = new Account.RequestBuilder()
              .setEmail("msb.partner@example.com")
              .setName("Erlich Bachman")
              .setPhone("+33104050607")
              .setCompanyName("MSB Partner from Java Wrapper")
              .setAddressLine1("30 rue de rivoli")
              .setAddressLine2("")
              .setAddressCity("Paris")
              .setAddressCountry("France")
              .setAddressPostalCode("75004")
              .create();

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody(), instanceOf(Account.class));

        System.out.println(response);
    }

    @Test
    public void testUpdateAccount() throws Exception {
        MysendingboxResponse<Account> response = new Account.RequestBuilder()
              .setEmail("msb.partner2@example.com")
              .setName("Erlich Bachman 2")
              .setPhone("+33104050607")
              .setCompanyName("MSB Partner from Java Wrapper")
              .setAddressLine1("30 rue de rivoli")
              .setAddressLine2("")
              .setAddressCity("Paris")
              .setAddressCountry("France")
              .setAddressPostalCode("75004")
              .create();

        Account account = response.getResponseBody();

        MysendingboxResponse<Account> responseUpdate = new Account.RequestBuilder()
              .setEmail("msb.partner3@example.com")
              .update(account.getCompany().getId());

        assertEquals(200, responseUpdate.getResponseCode());
    }
}
