package day20.MyThreadPool2;

//static ExecutorService newFixedThreadPool(int nThreads)
//创建一个指定最多线程数量的线程池

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
public class demo2 {
    public static void main(String[] args) throws InterruptedException {
        //参数不是初始值而是最大值
        //创建出来的池子是空的,线程最大值为10
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //ThreadPoolExecutor接下来会学
        //getPoolSize()得到线程池里线程的数量
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
        System.out.println(pool.getPoolSize());//0

        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName() + "在执行了");
        });

        Thread.sleep(1000);

        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName() + "在执行了");
        });

        System.out.println(pool.getPoolSize());//2
        executorService.shutdown();
    }
}
