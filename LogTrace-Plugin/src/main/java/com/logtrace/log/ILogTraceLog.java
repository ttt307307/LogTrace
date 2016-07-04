package com.logtrace.log;

/**
 * Created by tandewei on 2016/7/4.
 */
public interface ILogTraceLog {
    public void t(Class clazz, String message);

    public void t(String tag, String message);

    public void t(String message);

    public void d(Class clazz, String message);

    public void d(String tag, String message);

    public void d(String message);

    public void i(Class clazz, String message);

    public void i(String tag, String message);

    public void i(String message);

    public void w(Class clazz, String message);

    public void w(String tag, String message);

    public void w(String message);

    public void e(Class clazz, String message);

    public void e(String tag, String message);

    public void e(String message);

    public void f(Class clazz, String message);

    public void f(String tag, String message);

    public void f(String message);
}
