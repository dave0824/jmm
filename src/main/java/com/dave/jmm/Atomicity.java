package com.dave.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dave
 * @date 2020/5/25 12:10
 * @description 使用AtomicInteger + volatile实现volatile不能解决的原子性
 */
public class Atomicity {
    private volatile AtomicInteger num = new AtomicInteger(0);

    public void numIncrement(){

        num.getAndIncrement();
    }
    public int getNum(){
        return num.get();
    }

    public static void main(String[] args) {
        Atomicity atomicity = new Atomicity();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j <200 ; j++) {
                        atomicity.numIncrement();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"thread" + String.valueOf(i)).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t num的最终值是：" + atomicity.getNum());
    }
}
