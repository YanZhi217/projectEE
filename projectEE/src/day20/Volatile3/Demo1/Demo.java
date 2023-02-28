package day20.Volatile3.Demo1;

public class Demo {
    /*
        堆内存是唯一的，每个线程都会有自己的线程栈，修改共享数据时，先将共享数据在自己栈内创建一个变量副本，修改，再传给共享数据
        当线程A修改了共享数据时
        B线程没有即时获取到最新的值
        如果还在使用原先的值，就会出现问题
        因此使用volatile关键字，强制线程在每次使用的时候，都要看一下共享区域的最新值
    */
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.setName("小路同学");
        t1.start();

        MyThread2 t2 = new MyThread2();
        t2.setName("小皮同学");
        t2.start();
    }
}
