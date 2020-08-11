package com.xfeng.example.order;

/**
 * @author xuefeng.wang
 * @date 2020-08-11
 */
public class Child extends Parent {
    public Child() {
        System.out.println("子类构造方法");
    }

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }
}
