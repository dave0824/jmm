package com.dave.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author dave
 * @date 2020/5/29 22:30
 * @description 使用关门案例演示CountDownLatch的用法。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(66);
        for (int i = 1; i <= 66; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "上完自习");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            // 等待其它66个线程执行完毕
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t班长锁门离开教室");
    }
}
