package day20.MyThreadAtom4.Demo2;

public class MyAtomThread implements Runnable{
    //volatile只能保证线程每次读取共享区域最新的值，并不能保证原子性
    private volatile int count = 0; //送冰淇淋的数量

    private final Object lock = new Object();

    @Override
    public void run() {
            for (int i = 0; i < 100; i++) {
                //1,从共享数据中读取数据到本线程栈中.
                //2,修改本线程栈中变量副本的值
                //3,会把本线程栈中变量副本的值赋值给共享数据.
                //count非原子操作
                //原子性是指一次或多次操作要么全部执行，要么全都不执行

                //加锁会使速度变慢
                synchronized(lock){
                    count++;
                    System.out.println("已经送了" + count + "个冰淇淋");
                }
            }
        }

}
