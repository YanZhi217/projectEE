package day19.demo1;

public class demo {

    //用过继承Thread类实现多线程
    public static void main(String[] args) {
        //创建一个线程对象
        MyThread t1 = new MyThread();
        //创建一个线程对象
        MyThread t2 = new MyThread();


        //Run()方法和Start方法的区别
        //run():封装线程被执行的代码,直接调用，相当于普通方法的调用，并没有开启线程
        //Start()方法:启动方法。然后由JVM调用此线程的Run()方法
        //t1.run();//表示的仅仅是创建对象,用对象去调用方法,并没有开启线程.
        //t2.run();
        //开启一条线程
        t1.start();
        //开启第二条线程
        t2.start();
    }
}
