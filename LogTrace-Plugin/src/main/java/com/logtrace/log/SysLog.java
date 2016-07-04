package com.logtrace.log;

/**
 * Created by tandewei on 2016/7/4.
 */
public class SysLog implements ILogTraceLog {
    @Override
    public void t(Class clazz, String message) {
        log("TRACE: " + clazz.getSimpleName() + ": " + message);
    }

    @Override
    public void t(String tag, String message) {
        log("TRACE: " + tag + ": " + message);
    }

    @Override
    public void t(String message) {
        log("TRACE: "  + message);
    }

    @Override
    public void d(Class clazz, String message) {
        log("DEBUG: " + clazz.getSimpleName() + ": " + message);
    }

    @Override
    public void d(String tag, String message) {
        log("DEBUG: " + tag + ": " + message);
    }

    @Override
    public void d(String message) {
        log("DEBUG: " + message);
    }

    @Override
    public void i(Class clazz, String message) {
        log("INFO: " + clazz.getSimpleName() + ": " + message);
    }

    @Override
    public void i(String tag, String message) {
        log("INFO: " + tag + ": " + message);
    }

    @Override
    public void i(String message) {
        log("INFO: " + message);
    }

    @Override
    public void w(Class clazz, String message) {
        log("WARN: " + clazz.getSimpleName() + ": " + message);
    }

    @Override
    public void w(String tag, String message) {
        log("WARN: " + tag + ": " + message);
    }

    @Override
    public void w(String message) {
        log("WARN: " + ": " + message);
    }

    @Override
    public void e(Class clazz, String message) {
        log("ERROR: " + clazz.getSimpleName() + ": " + message);
    }

    @Override
    public void e(String tag, String message) {
        log("ERROR: " + tag + ": " + message);
    }

    @Override
    public void e(String message) {
        log("ERROR: "  + message);
    }

    @Override
    public void f(Class clazz, String message) {
        log("FATAL: " + clazz.getSimpleName() + ": " + message);
    }

    @Override
    public void f(String tag, String message) {
        log("FATAL: " + tag + ": " + message);
    }

    @Override
    public void f(String message) {
        log("FATAL: "  + message);
    }

    private void log(String message) {
        System.out.println(message);
    }
}
