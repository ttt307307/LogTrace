package com.test.log;

/**
 * Created by tandewei on 2016/7/4.
 */
public class Main {
    public static void main(String args[]) {
        System.out.println("Hello World!");
        Test01 t = new Test01();
        t.test(new Test2(10));
        System.out.println(t.add3(5));
    }
}
