package day17.map1.demo1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * Map的第一种遍历方式
 */
public class demo3 {
    public static void main(String[] args) {
        //创建集合并添加元素
        Map<String,String> map = new HashMap<>();
        map.put("1号丈夫","1号妻子");
        map.put("2号丈夫","2号妻子");
        map.put("3号丈夫","3号妻子");
        map.put("4号丈夫","4号妻子");
        map.put("5号丈夫","5号妻子");

        //获取到所有的键并返回一个单列集合
        Set<String> keys = map.keySet();

        //不能用map的key值作为迭代器遍历
        /*Iterator<String> key = keys.iterator();
        while(key.hasNext()){
            System.out.println(key.next() + "---" + map.get(key.next()));
        }*/

        //遍历Set集合得到每一个键

        for (String key : keys) {
            //通过每一个键key，来获取到对应的值
            String value = map.get(key);
            System.out.println(key + "---" + value);
        }
    }

}
