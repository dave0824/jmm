package com.dave.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dave
 * @date 2020/5/29 19:34
 * @description 使用ReentrantLock演示可重入锁
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone2 phone = new Phone2();

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

class Phone2{
    Lock lock = new ReentrantLock();
    public void call(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t 拨打电话");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendSMS();
        }finally {
            lock.unlock();
        }

    }
    public void sendSMS(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t 发短信");
        }finally {
            lock.unlock();
        }
    }
}
