package com.xfeng.example.test.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuefeng.wang
 * @date 2020-07-13
 */
public class ReentrantLockTest {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(ReentrantLockTest::test, "线程A").start();
        new Thread(ReentrantLockTest::test, "线程B").start();
    }

    public static void test() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
