package com.logtrace.log;

/**
 * Created by tandewei on 2016/7/4.
 */
public class LogManager {
    public static ILogTraceLog getLogger() {
        return getDefaultLogger();
    }

    public static ILogTraceLog getDefaultLogger() {
        return new SysLog();
    }
}
