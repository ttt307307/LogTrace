package com.test;

import com.logtrace.annotation.LogTrace;

/**
 * Created by tandewei on 2016/7/4.
 */
public class TestLogTrace {
    @LogTrace
    public int add10(int a) {
        return a + 10;
    }
}
