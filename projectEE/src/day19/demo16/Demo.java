package day19.demo16;

import java.util.concurrent.ArrayBlockingQueue;
public class Demo {
    public static void main(String[] args) {
        //阻塞队列
        //继承结构：Iterable->Collection->Queue->BlockingQueue   (都是接口)
        //BlockingQueue->ArrayBlockingQueue     (底层数组,有界)
        //BlockingQueue->LinkedBlockingQueue    (底层链表,无界，但不是真正的无界，最大为int的最大值)
        //BlockingQueue核心方法，take(),put()
        //参数为阻塞队列的容量
        ArrayBlockingQueue<String> bd = new ArrayBlockingQueue<>(1);


        Foodie f = new Foodie(bd);
        Cooker c = new Cooker(bd);


        //为什么打印结果不是一个吃一个拿,因为输出语句不在锁范围内,但并不影响线程执行,仅仅只是输出不同
        f.start();
        c.start();
    }
}
