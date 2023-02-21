package day15.List2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");


        //迭代器遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }

        //增强For遍历
        System.out.println("---------------------");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
