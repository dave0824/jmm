package com.dave.container;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author dave
 * @date 2020/5/27 16:58
 * @description 演示ArrayList线程不安全，并用Collections.synchronizedList()解决
 */
public class ArrayListTest {
    public static void main(String[] args) {
        // List<String> list = new ArrayList<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(1,8));
                System.out.println(list);
            },Integer.toString(i)).start();
        }
    }
}
