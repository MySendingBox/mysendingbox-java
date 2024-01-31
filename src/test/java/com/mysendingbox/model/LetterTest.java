package com.mysendingbox.model;

import com.mysendingbox.BaseTest;
import com.mysendingbox.model.Address;
import com.mysendingbox.model.Letter;
import com.mysendingbox.model.LetterCollection;
import com.mysendingbox.net.MysendingboxResponse;
import org.junit.Test;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class LetterTest extends BaseTest {

    @Test
    public void testListLetters() throws Exception {
        MysendingboxResponse<LetterCollection> response = Letter.list();

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Letter.class));
    }

    @Test
    public void testListLetterWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        MysendingboxResponse<LetterCollection> response = Letter.list(params);

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Letter.class));
    }

    @Test
    public void testRetrieveLetter() throws Exception {
        Letter testLetter = Letter.list().getResponseBody().getData().get(0);

        MysendingboxResponse<Letter> response = Letter.retrieve(testLetter.getId());
        Letter letter = response.getResponseBody();

        assertEquals(testLetter.getId(), letter.getId());
    }

    @Test
    public void testCreateFileLetter() throws Exception {
        final File file = new File(getClass().getClassLoader().getResource("PDF_Lettre_Bienvenue.pdf").getPath());

        MysendingboxResponse<Letter> response = new Letter.RequestBuilder()
                .setDescription("Test Letter")
                .setSourceFile(file, "file")
                .setTo(new Address.RequestBuilder()
                        .setName("Mysendingbox")
                        .setLine1("25 passage dubail")
                        .setCity("Paris")
                        .setPostalCode("75010")
                        .setCountry("France"))
                .setColor("bw")
                .setPostageType("prioritaire")
                .create();

        Letter letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(letter.getId());
        assertEquals("letter", letter.getObject());
    }

    @Test
    public void testCreateCertifiedLetter() throws Exception {

        final File file = new File(getClass().getClassLoader().getResource("PDF_Lettre_Bienvenue.pdf").getPath());

        final Map<String, String> variables = new HashMap<String, String>();
        variables.put("name", "Mysendingbox.fr");

        MysendingboxResponse<Letter> response = new Letter.RequestBuilder()
                .setTo(new Address.RequestBuilder()
                        .setName("Mysendingbox")
                        .setLine1("25 passage dubail")
                        .setCity("Paris")
                        .setPostalCode("75010")
                        .setCountry("France"))
                .setSourceFile("<h1>Hello from {{name}}</h1>", "html")
                .setSourceFile(file, "file")
                .setPostageType("prioritaire")
                .setPdfMargin(20)
                .setVariables(variables)
                .setColor("bw")
                .create();

        Letter letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(letter.getId());
        assertEquals("letter", letter.getObject());
        assertEquals(Integer.valueOf(2), letter.getPageCount());
        assertEquals(Integer.valueOf(1), letter.getSheetCount());
        assertEquals("test", letter.getMode());
        assertEquals("75010", letter.getTo().getPostalCode());
    }

}
