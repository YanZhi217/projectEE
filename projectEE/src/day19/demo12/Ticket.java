package day19.demo12;

import java.util.concurrent.locks.ReentrantLock;
public class Ticket implements Runnable{
    //票的数量
    private int ticket = 100;
    private final Object obj = new Object();
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                /*
                    JDK5以后的Lock提供了比使用synchronized()方法和语句更广泛的锁定操作
                    Lock提供了获得锁和释放锁的方法
                    void lock();//获得锁
                    void unlock();//释放锁
                */
                lock.lock();
                if (ticket <= 0) {
                    //卖完了
                    break;
                } else {
                    Thread.sleep(100);
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //我们将释放锁放在finally中确保在出现异常时锁也能够被释放
                lock.unlock();
            }
        }
    }

}
