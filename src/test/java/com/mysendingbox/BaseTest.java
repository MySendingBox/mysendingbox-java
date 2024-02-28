package com.mysendingbox;

import com.mysendingbox.environment.TestConstants;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void beforeClass() {
        TestConstants.setup();
        Mysendingbox.init("test_7a6d67a5-1922-425f-9db0-ae4e4cbbdc6d");
    }

}
