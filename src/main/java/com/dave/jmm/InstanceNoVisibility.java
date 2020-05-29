package com.dave.jmm;

/**
 * @author dave
 * @date 2020年5月29日21:15:17
 * @description 引用类型的线程不可见性
 * 引用类型所指向
 */
public class InstanceNoVisibility {

    public static void main(String[] args) {
        final Peson peson = new Peson("dave");

        // 第一个线程
        new Thread(() -> {
            try {
                // 睡眠1秒钟，保证主线程得到执行
                Thread.sleep(1000L);
                peson.setName("jack");
                System.out.println(Thread.currentThread().getName() + "\t 执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread1").start();

        while (peson.getName().equals("dave")) {
            //如果myData的num一直为零，main线程一直在这里循环
        }
        System.out.println(Thread.currentThread().getName() + "\t 主线程执行完毕, name 值是 " + peson.getName());
    }
}

class Peson{
    private String name;
    public Peson(String name){
        this.name = name;
    }
    public void setName(String name){this.name = name;}
    public String getName(){return name;}
}
