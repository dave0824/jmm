package com.dave.jmm;

/**
 * @author dave
 * @date 2020/5/24 23:14
 * @description 模拟非原子性
 */

public class NoAtomicity {

    private int num;

    public void numPlusPlus(){
        num++;
    }

    public static void main(String[] args) {
        NoAtomicity noAtomicity = new NoAtomicity();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j <200 ; j++) {
                        noAtomicity.numPlusPlus();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"thread" + String.valueOf(i)).start();
        }

        // 当线程数大于2时，等待其它线程执行完（两个线程：main和GC）
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t num的最终值是：" + noAtomicity.num);
    }
}



