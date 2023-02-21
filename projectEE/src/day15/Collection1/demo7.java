package day15.Collection1;

import java.util.ArrayList;
public class demo7 {
    public static void main(String[] args) {
        /*
        如果想要操作普通索引就使用普通For
        如果想要删除元素，使用迭代器Iterator
        如果想要遍历，使用增强For
         */
        ArrayList<String> list =  new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

//
//        for(String str : list){
//            str = "q";
//            System.out.println(str);
//        }
        for (String s : list) {
            System.out.println(s);
        }

        //System.out.println(list);
    }
}
