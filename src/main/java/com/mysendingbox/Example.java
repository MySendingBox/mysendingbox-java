package com.mysendingbox;

import com.mysendingbox.model.Address;
import com.mysendingbox.model.Letter;
import com.mysendingbox.model.LetterElectronic;
import com.mysendingbox.model.Account;
import com.mysendingbox.model.Invoice;
import com.mysendingbox.model.InvoiceCollection;
import com.mysendingbox.net.MysendingboxResponse;

import java.util.HashMap;
import java.util.Map;

public class Example {

    public static void main(String[] args) throws Exception {
        System.out.println("Mysendingbox Java Wrapper");

        Mysendingbox.init("test_7a6d67a5-1922-425f-9db0-ae4e4cbbdc6d");

        System.out.println("----LETTERS");
        System.out.println("----Paper");

        final Map<String, String> variables = new HashMap<String, String>();
        variables.put("website", "Mysendingbox.fr");

        MysendingboxResponse<Letter> response = new Letter.RequestBuilder()
                .setTo(
                        new Address.RequestBuilder()
                                .setName("Mysendingbox")
                                .setLine1("25 passage dubail")
                                .setCity("Paris")
                                .setPostalCode("75010")
                                .setCountry("France")
                )
                .setPostageSpeed("D1")
                .setDescription("Sent with the Java Wrapper")
                .setBothSides(false)
                .setSourceFile("<h1>Hello from {{website}}</h1>", "html")
                .setPostageType("prioritaire")
                .setColor("bw")
                .setVariables(variables)
                .setPdfMargin(20)
                .create();

        Letter letter = response.getResponseBody();

        System.out.println(letter);
        System.out.println(letter.getChannel());
        System.out.println(letter.getCreatedAt());
        System.out.println(letter.getTo().getPostalCode());
        System.out.println(letter.getFile().getUrl());
        System.out.println(letter.getPrice());
        System.out.println(letter.getVariables());
        System.out.println(letter.getEvents());
        //System.out.println(letter.getFile());


        MysendingboxResponse<Letter> response_get = Letter.retrieve(letter.getId());
        Letter letter_get = response_get.getResponseBody();

        System.out.println(letter_get);

        System.out.println("----Electronic");

        MysendingboxResponse<LetterElectronic> responseElectronic = new LetterElectronic.RequestBuilder()
                .setTo(
                    new Address.RequestBuilder()
                        .setFirstName("Erlich")
                        .setLastName("Dumas")
                        .setEmail("mysendingbox@example.com")
                        .setStatus("individual")
                )
                .setPostageType("lre")
                .setSourceFile("<h1>Hello from {{website}}</h1>", "html")
                .setDescription("Sent Electronic with the Java Wrapper")
                .setContent("Please review the attached documents:")
                .create();

        LetterElectronic letterElectronic = responseElectronic.getResponseBody();

        System.out.println(letterElectronic);
        System.out.println(letterElectronic.getChannel());
        System.out.println(letterElectronic.getCreatedAt());
        System.out.println(letterElectronic.getTo().getEmail());
        System.out.println(letterElectronic.getFile().getUrl());
        System.out.println(letterElectronic.getPrice());
        System.out.println(letterElectronic.getVariables());
        System.out.println(letterElectronic.getEvents());


        MysendingboxResponse<Letter> responseElectronic_get = Letter.retrieve(letterElectronic.getId());
        Letter letterElectronic_get = responseElectronic_get.getResponseBody();

        System.out.println(letterElectronic_get);

        System.out.println("----ACCOUNTS");

        MysendingboxResponse<Account> responseAccount = new Account.RequestBuilder()
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

        Account account = responseAccount.getResponseBody();

        System.out.println(account);
        System.out.println(account.getUser());
        System.out.println(account.getCompany());
        System.out.println(account.getCompany().getApiKeys());

        MysendingboxResponse<Account> responseAccountUpdate = new Account.RequestBuilder()
              .setEmail("msb.partner3@example.com")
              .update(account.getCompany().getId());

        System.out.println("----INVOICES");

        MysendingboxResponse<InvoiceCollection> responseInvoiceList = Invoice.list();

        MysendingboxResponse<Invoice> responseInvoiceGet = Invoice.retrieve(responseInvoiceList.getResponseBody().getData().get(0).getId());
        Invoice invoice = responseInvoiceGet.getResponseBody();

        System.out.println(invoice);
        System.out.println(invoice.getInvoiceNumber());
        System.out.println(invoice.getTotal());
        System.out.println(invoice.getInvoiceLines());

    } // end method main


}

