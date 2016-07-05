package com.example.logtracedemo_and;

import org.junit.Test;

/**
 * Created by tandewei on 2016/7/5.
 */
public class TestLogTraceTest {
    @Test
    public void add5a() throws Exception {
        TestLogTrace target = new TestLogTrace();
        target.add5a("123");
    }

}