package day16.Set1.Set1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/*
    Set集合的基本使用
 */
public class demo1 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("ccc");
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");

//        for (int i = 0; i < set.size(); i++) {
//            //Set集合是没有索引的，所以不能使用通过索引获取元素的方法
//        }

        //所有集合都可以使用迭代器进行遍历
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("-----------------------------------");

        for (String s : set) {
            System.out.println(s);
        }
    }
}

