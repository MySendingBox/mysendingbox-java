package com.mysendingbox.model;

import com.mysendingbox.BaseTest;
import com.mysendingbox.model.LetterCollection;
import com.mysendingbox.model.LetterElectronic;
import com.mysendingbox.net.MysendingboxResponse;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class LetterElectronicTest extends BaseTest {

    @Test
    public void testListLetterElectronicWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("channel", "electronic");

        MysendingboxResponse<LetterCollection> response = LetterElectronic.list(params);
        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(LetterElectronic.class));
    }
}
