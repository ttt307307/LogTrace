package com.test.log;


import com.logtrace.annotation.LogTrace;

/**
 * Created by tandewei on 2016/7/1.
 */
public class Test01 {
    @LogTrace
    public int add3(int a) {
        return a + 3;
    }
}
