package com.logtrace.log;

/**
 * Created by tandewei on 2016/7/4.
 */
public class LogManager {
    static ILogTraceLog logger;
    public static void setLogger(ILogTraceLog log) {
        logger = log;
    }

    public static ILogTraceLog getLogger() {
        if (logger != null) {
            return logger;
        }
        return getDefaultLogger();
    }

    public static ILogTraceLog getDefaultLogger() {
        return new SysLog();
    }
}
