package com.blya.malltest.comm.OrderHandle;

/**
 * created by chenlup on 2020/7/31 10:35
 **/
public interface DefalutTest {

    static int a =5;

    default void defaultMethod(){
        System.out.println("DefalutTest defalut 方法");
    }

    int sub(int a,int b);

    static void staticMethod() {
        System.out.println("DefalutTest static 方法");
    }
}
