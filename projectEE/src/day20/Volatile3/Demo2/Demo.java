package day20.Volatile3.Demo2;

public class Demo {
    /*
        同步代码块同样可以避免共享数据没有及时被进程获取的问题
        synchronized(){}的执行步骤
        1、线程获取锁
        2、清空变量副本
        3、拷贝共享变量最新的值到变量副本中
        4、执行代码
        5、将修改后变量副本中的值赋值给共享数据
        6、释放锁
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
