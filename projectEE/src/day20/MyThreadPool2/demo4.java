package day20.MyThreadPool2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class demo4 {
    //    参数一：核心线程数量
    //    参数二：最大线程数
    //    参数三：空闲线程最大存活时间
    //    参数四：时间单位 -- TimeUnit -- DAYS -- HOURS -- MINUTES -- SECONDS
    //    参数五：任务队列 -- 让任务在队列中等着，等有线程空闲了，在从这个队列中获取任务执行
    //    参数六：创建线程工厂 -- 按照默认的方法创建线程对象
    //    参数七：任务的拒绝策略 -- 什么时候拒绝任务 -- 当提交的任务 > 池子中最大线程数量 + 队列容量
    //                       -- 如何拒绝 -- ThreadPoolExecutor.AbortPolicy() 求其任务并抛出RejectedExecutionException异常,是默认的策略
    //                                  -- ThreadPoolExecutor.DiscardPolicy() 丢弃任务但不抛出异常
    //                                  -- ThreadPoolExecutor.DiscardOldestPolicy() 抛弃队列中等待最久的任务然后把当前任务加入队列中
    //                                  -- ThreadPoolExecutor.CallerRunsPolicy() 调用任务的run()方法绕过线程池直接执行
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(0, 5, 2, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0 ; i < 15 ; i++) {
            pool.submit(new MyRunnable());
        }


        pool.shutdown();
    }
}
