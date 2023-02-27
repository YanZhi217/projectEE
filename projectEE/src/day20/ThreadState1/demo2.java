package day20.ThreadState1;

/*
需求 ：编写一段代码，依次显示一个线程的这些状态：NEW -> RUNNABLE -> WAITING -> RUNNABLE -> TERMINATED
*/

public class demo2 {
    public static void main(String[] args) throws InterruptedException {
        //定义一个对象，用来加锁和解锁
        Object obj = new Object();

        //定义一个内部线程
        Thread thread1 = new Thread(() -> {
            System.out.println("2.执行thread.start()之后，线程的状态：" + Thread.currentThread().getState());
            synchronized (obj) {
                try {
                    //thread1需要休眠100毫秒
                    Thread.sleep(100);
                    //thread1 100毫秒之后，通过wait()方法释放obj对象锁
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("4.被object.notify()方法唤醒之后，线程的状态：" + Thread.currentThread().getState());
        });

        //获取start()之前的状态
        System.out.println("1.通过new初始化一个线程，但是还没有start()之前，线程的状态：" + thread1.getState());
        //启动线程
        thread1.start();
        //main线程休眠150毫秒
        Thread.sleep(150);
        //因为thread1在第100毫秒进入wait等待状态，所以第150秒肯定可以获取其状态
        System.out.println("3.执行object.wait()时，线程的状态：" + thread1.getState());

        //声明另一个线程进行解锁
        new Thread(() -> {
            synchronized (obj) {
                //唤醒等待的线程
                obj.notify();
            }
        }).start();
        //main线程休眠10毫秒等待thread1线程能够苏醒
        Thread.sleep(10);
        //获取thread1运行结束之后的状态
        System.out.println("5.线程执行完毕之后，线程的状态：" + thread1.getState() + "\n");
    }
}