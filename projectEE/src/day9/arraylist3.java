package day9;

import java.util.ArrayList;

public class arraylist3 {
    /*
        ArrayList构造方法:
                ArrayList() 构造一个初始容量为 10 的空列表。
        成员方法:
            添加:
                boolean add(E e) 将指定的元素添加到此列表的尾部。
                void add(int index, E element) 将指定的元素插入此列表中的指定位置。
        注意:
                集合容器如果没有加入<> 就可以存储任意数据类型
                <> 泛型: 对集合容器存储的数据类型进行限制
    */
    public static void main(String[] args) {
        // 1. 创建集合容器对象
        ArrayList<String> list = new ArrayList<>();
        // 2. 调用对象的add方法, 向容器中添加数据
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        list.add(1,"666");


        System.out.println(list);
    }
}
