package day20.Volatile3.Demo2;

public class Money {
    //锁对象
    public final static Object lock = new Object();
    //共享数据
    public static volatile int money = 100000;
}
