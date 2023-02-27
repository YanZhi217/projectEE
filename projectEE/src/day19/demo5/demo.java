package day19.demo5;

public class demo {
    public static void main(String[] args) {
        //currentThread(),返回对当前正在执行的线程对象的引用
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
