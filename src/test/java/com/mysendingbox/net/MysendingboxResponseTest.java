package com.mysendingbox.net;

import com.mysendingbox.BaseTest;
import com.mysendingbox.net.MysendingboxResponse;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MysendingboxResponseTest extends BaseTest {

    @Test
    public void testMysendingboxResponse() {
        final MysendingboxResponse<String> response = new MysendingboxResponse<String>(200, "{}");

        assertEquals(200, response.getResponseCode());
        assertEquals("{}", response.getResponseBody());
        assertNull(response.getResponseHeaders());
    }

    @Test
    public void testMysendingboxResponseWithHeaders() {
        HashMap<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("User-Agent", Arrays.asList("MysendingboxBindingsTest"));

        final MysendingboxResponse<String> response = new MysendingboxResponse<String>(200, "{}", headers);

        assertEquals(200, response.getResponseCode());
        assertEquals("{}", response.getResponseBody());
        assertEquals(Arrays.asList("MysendingboxBindingsTest"), response.getResponseHeaders().get("User-Agent"));
    }

}
