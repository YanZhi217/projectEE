package day20.Map5;

import java.util.concurrent.ConcurrentHashMap;
public class MyConcurrentHashMapDemo3 {
    //ConcurrentHashmap是数据安全的，效率较高，在JDK7以前和8之后底层原理是不同的

    /*
        Map体系结构：
            HashMap -- Hashtable -- TreeMap -- ConcurrentHashMap

        ConcurrentHashmap在JDK1.7之前底层原理
            创建
            默认创建一个长度16，加载因子为0.75的大数组，这个大数组一旦创建无法扩容，
            还会创建一个长度为2的小数组，把地址值赋值给0索引处，其他索引位置的元素都是null

            添加
            第一次会根据键的哈希值，来计算出在大数组中应存入的位置
                如果为null，则按照模板创建小数组，创建完毕后，会二次哈希，计算出小数组中应存入的位置，直接存入
                如果不为null，就会根据记录的地址值，找到小数组，二次哈希，计算出在小数组中应该存入的位置
                    如果需要扩容，则将小数组扩容为以前的两倍
                    如果不需要扩容，则检查小数组中的这个位置是否有元素
                        如果没有元素，则直接存
                        如果有元素则调用equals()方法，比较属性值
                            如果equals()方法为true，则不存
                            如果为false,则形成哈希桶结构，挂在元素下

        ConCurrentHashmap在JDK1.8之后的底层原理
            如果使用空参构造创建ConcurrentHashmap对象，则什么事情都不做
            在第一次添加元素的时候创建哈希表
            计算当前元素应存入的索引
                如果该索引位置为null，则利用CAS算法，将本节点添加到数组中
                如果该索引位置下不为null，则利用volatile关键字获得当前位置最新节点地址，挂在他下面，形成链表
                    当链表长度大于等于8时，自动转换成红黑树
                    以链表或者红黑树节点为锁对象，配合悲观锁保证多线程操作集合时数据的安全性
    */
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> hm = new ConcurrentHashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                hm.put(i + "", i + "");
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 51; i++) {
                hm.put(i + "", i + "");
            }
        });

        t1.start();
        t2.start();

        System.out.println("----------------------------");
        //为了t1和t2能把数据全部添加完毕
        Thread.sleep(1000);

        //0-0 1-1 ..... 50- 50

        for (int i = 0; i < 51; i++) {
            System.out.println(hm.get(i + ""));
        }//0 1 2 3 .... 50


    }
}
