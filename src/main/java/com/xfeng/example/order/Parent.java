package com.xfeng.example.order;

/**
 * @author xuefeng.wang
 * @date 2020-08-11
 */
public class Parent {
    public Parent() {
        System.out.println("父类构造方法");
    }

    static {
        System.out.println("父类静态方法");
    }

    {
        System.out.println("父类代码块");
    }
}
