package com.dave.jmm;

/**
 * @author dave
 * @date 2020/5/24 22:41
 * @description 模拟成员变量的不可见性
 */
public class NoVisibility {

    private static int NUM = 0;

    public void numEqTen(){
        NUM = 10;
    }

    public static void main(String[] args) {
        final NoVisibility noVisibility = new NoVisibility();

        // 第一个线程
        new Thread(() -> {
            try {
                // 睡眠1秒钟，保证主线程得到执行
                Thread.sleep(1000L);
                noVisibility.numEqTen();
                System.out.println(Thread.currentThread().getName() + "\t 执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread1").start();

        while (noVisibility.NUM == 0) {
            //如果myData的num一直为零，main线程一直在这里循环
        }
        System.out.println(Thread.currentThread().getName() + "\t 主线程执行完毕, num 值是 " + noVisibility.NUM);
    }
}
