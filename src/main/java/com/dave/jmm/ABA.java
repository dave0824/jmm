package com.dave.jmm;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author dave
 * @date 2020/5/25 13:34
 * @description 该代码复现ABA问题
 */
public class ABA {

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {

        new Thread(() ->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"thread1").start();

        new Thread(() ->{
            try {
                // 睡眠1秒，保证完成ABA
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(100,2020);
            System.out.println(atomicReference.get());
        },"thread1").start();
    }
}
