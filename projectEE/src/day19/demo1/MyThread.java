package day19.demo1;

public class MyThread extends Thread{

    //为什么要重写Run()方法，因为线程执行的就是Run()方法
    @Override
    public void run() {
        //代码就是线程在开启之后执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println("线程开启了" + i);
        }
    }
}