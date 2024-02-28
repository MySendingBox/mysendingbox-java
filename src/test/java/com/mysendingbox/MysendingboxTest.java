package com.mysendingbox;

import org.junit.Test;

import com.mysendingbox.Mysendingbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MysendingboxTest {

    @Test
    public void testMysendingboxInit() {
        final String API_KEY = "test_7a6d67a5-1922-425f-9db0-ae4e4cbbdc6d";

        Mysendingbox.init(API_KEY);
        assertEquals(API_KEY, Mysendingbox.apiKey);
        assertNull(Mysendingbox.apiVersion);
    }

}
