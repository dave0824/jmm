package com.dave.jmm;

/**
 * @author dave
 * @date 2020/5/25 11:39
 * @description 双重判断+锁实现单例模式
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton(){ }

    public Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
