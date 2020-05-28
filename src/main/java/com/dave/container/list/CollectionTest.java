package com.dave.container.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author dave
 * @date 2020/5/27 19:18
 * @description 通过使用Iterator访问集合中的所有元素
 */
public class CollectionTest {

    public static void main(String[] args) {
        Collection<String> s = new ArrayList<String>();
        s.add("xiaohong");
        s.add("xionming");
        s.add("wanger");

        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()) {

            String element = iterator.next();
            System.out.println(element);
        }

        for (String string : s)
        {
            System.out.println(string);

        }
    }
}
