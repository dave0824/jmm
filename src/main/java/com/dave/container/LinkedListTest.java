package com.dave.container;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author dave
 * @date 2020/5/27 21:53
 * @description 简单的创建了两个链表，将它们合并在一起，然后从第二个链表中每隔一个元素删除一个元素，最后测试removeAll()方 法
 */
public class LinkedListTest {
    public static void main(String[] args) {

        List<String> a = new LinkedList<>();
        a.add("aaa");
        a.add("bbb");
        a.add("eee");

        List<String> b = new LinkedList<>();
        b.add("AAA");
        b.add("BBB");
        b.add("EEE");

        ListIterator<String> aIter = a.listIterator();
        ListIterator<String> bIter = b.listIterator();

        //a集合合并b集合

        while(bIter.hasNext()) {

            if(aIter.hasNext())
                aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        //从b链表中每间隔一个元素删除一个元素

        while(bIter.hasNext()) {

            bIter.next();//跳过一个元素
            if(bIter.hasNext()) {

                bIter.next();
                bIter.remove();//先查后删
            }
        }

        System.out.println(b);

        //测试删除所有
        a.removeAll(a);
        System.out.println(a);

    }
}
