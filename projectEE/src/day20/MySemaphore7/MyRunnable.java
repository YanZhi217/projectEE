package day20.MySemaphore7;

import java.util.concurrent.Semaphore;

public class MyRunnable implements Runnable {
    //1.获得管理员对象，
    //参数时最多有几个线程
    //Semaphore.acquire()发放许可证
    //Semaphore.release()收回许可证
    private final Semaphore semaphore = new Semaphore(2);

    @Override
    public void run() {
        //2.获得通行证
        try {
            //发放通行证
            semaphore.acquire();
            //3.开始行驶
            System.out.println("获得了通行证开始行驶");
            Thread.sleep(100);
            System.out.println("归还通行证");
            //4.归还通行证
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
