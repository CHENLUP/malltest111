package com.blya.malltest.comm.OrderHandle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * created by chenlup on 2020/7/31 10:53
 **/
public class MainTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(50);
        list.add(18);
        list.add(6);
        list.add(99);
        list.add(32);

        System.out.println("排序之前:"+list.toString());

        LambdaTest3 test3 = Collections::sort;

        test3.sort(list,(a,b) ->{
            return a - b;
        });

        System.out.println("排序之后:"+list.toString());

    }
}
