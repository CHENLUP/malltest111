package com.blya.malltest.comm.OrderHandle;

/**
 * created by chenlup on 2020/7/31 10:42
 **/
public class DefaultTestImpl implements DefalutTest {
    @Override
    public int sub(int a, int b) {
        return 0;
    }


    public static void main(String[] args) {


        DefaultTestImpl dt = new DefaultTestImpl();
        dt.defaultMethod();
        DefalutTest.staticMethod();
    }
}
