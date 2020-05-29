package com.dave.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author dave
 * @date 2020/5/29 19:34
 * @description 使用sychronized关键字演示可重入锁
 */
public class SychronizedDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.call();
        },"thread1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phone.sendSMS();
        },"thread2").start();

    }
}

class Phone{
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName() + "\t 拨打电话");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendSMS();
    }
    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName() + "\t 发短信");
    }
}
