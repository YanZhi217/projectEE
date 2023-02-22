package day16.Set1.HashSet4;

import java.util.HashSet;
import java.util.Iterator;
/**
 * 添加字符串并进行遍历
 * HashSet底层数据结构是哈希表
 * 自动排序
 * 没有索引方法
 * 哈希值，指JDK根据对象的地址值或属性值计算出来的Int类型的整数
 * Object类中有一个可以获取对象哈希值的方法，public int hashCode():根据对象的地址值计算出来的哈希值
 */
public class demo1 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("java");
        hs.add("java");
        hs.add("java");
        hs.add("java");
        hs.add("java");

        Iterator<String> it = hs.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("=============================");

        for (String s : hs) {
            System.out.println(s);
        }
    }

}
