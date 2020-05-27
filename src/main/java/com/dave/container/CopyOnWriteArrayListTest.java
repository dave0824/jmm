package com.dave.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author dave
 * @date 2020/5/27 22:40
 * @description 演示CopyOnWriteArrayList类
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(1,8));
                System.out.println(list);
            },Integer.toString(i)).start();
        }
    }
}
