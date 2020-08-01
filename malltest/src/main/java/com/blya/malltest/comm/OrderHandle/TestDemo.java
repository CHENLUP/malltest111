package com.blya.malltest.comm.OrderHandle;

/**
 * created by chenlup on 2020/7/31 10:36
 **/
public class TestDemo {

    public static void main(String[] args) {


        DefalutTest dt1 = new DefalutTest() {
            @Override
            public int sub(int a, int b) {
                return a-b;
            }
        };

        DefalutTest dt2 = (a, b) ->{

            return a -b;
        };
        System.out.println("dt2:" + dt2.sub(3, 1));

    }
}
