package com.test.log;


import com.logtrace.annotation.LogTrace;
import org.junit.Test;

/**
 * Created by tandewei on 2016/7/4.
 */
public class Test01Test {
    @Test
    public void add3() throws Exception {
        Test01 target = new Test01();
        target.add3(7);
    }

    @Test
    public void testLogtraceJunit() throws Exception {
        LogtraceJunit target = new LogtraceJunit();
        target.doubleX(7);
    }

    class LogtraceJunit {
        @LogTrace(level = 3)
        public int doubleX(int x) {
            return x * 2;
        }
    }
}