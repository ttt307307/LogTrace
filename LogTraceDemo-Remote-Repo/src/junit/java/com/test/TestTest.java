package com.test;

import org.junit.Test;

/**
 * Created by tandewei on 2016/7/4.
 */
public class TestTest {
    @Test
    public void add10() throws Exception {
        TestLogTrace t = new TestLogTrace();
        t.add10(5);
    }

    @Test
    public void add2a() throws Exception {
        Test02 t = new Test02();
        t.get2A(5);
    }
}