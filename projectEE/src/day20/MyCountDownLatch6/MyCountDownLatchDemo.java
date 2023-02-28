package day20.MyCountDownLatch6;

import java.util.concurrent.CountDownLatch;
public class MyCountDownLatchDemo {
    public static void main(String[] args) {
        //CountDownLatch
        //1.创建CountDownLatch的对象，需要传递给四个线程。
        //在底层就定义了一个计数器，此时计数器的值就是3,参数写等待线程的数量，并定义一个计数器
        //await()让线程等待，当计数器为0，会唤醒等待的进程
        //countDown()线程执行完毕时调用，会将计数器减1
        CountDownLatch countDownLatch = new CountDownLatch(3);
        //2.创建四个线程对象并开启他们。
        MotherThread motherThread = new MotherThread(countDownLatch);
        motherThread.start();

        ChildThread1 t1 = new ChildThread1(countDownLatch);
        t1.setName("小明");

        ChildThread2 t2 = new ChildThread2(countDownLatch);
        t2.setName("小红");

        ChildThread3 t3 = new ChildThread3(countDownLatch);
        t3.setName("小刚");

        t1.start();
        t2.start();
        t3.start();
    }
}
