package com.example.logtracedemo_and;

import com.logtrace.annotation.LogTrace;

/**
 * Created by tandewei on 2016/7/4.
 */
public class TestLogTrace {
    @LogTrace
    public String add5a(String s) {
        return s + "aaaaa";
    }
}
