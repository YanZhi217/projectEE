package day19.demo10;

public class demo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}
