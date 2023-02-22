package day17.map1.demo1;

import java.util.HashMap;
import java.util.Map;
/**
 * Map的基本使用
 * Interface Map<K,V>,k:键的类型，V:值的类型
 * 键不能重复，值可以重复
 * 键和值是一一对应的，每一个键只能找到自己对应的值
 * 键 + 值，我们称之为键值对，或者Entry对象
 * 本次使用多态方式，通过具体的实现类HashMap来实现Map
 */
public class demo1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        //map.add();.不能使用，
        map.put("itheima001","小智");
        map.put("itheima002","小美");
        map.put("itheima003","大胖");

        System.out.println(map);
    }

}
