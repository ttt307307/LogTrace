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

    @LogTrace(level = 3)
    public int test(Test2 t) {
        return t.getA();
    }


}
class Test2 {
    int a;

    public Test2(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}
