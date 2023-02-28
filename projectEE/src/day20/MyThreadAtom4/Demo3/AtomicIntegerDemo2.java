package day20.MyThreadAtom4.Demo3;

import java.util.concurrent.atomic.AtomicInteger;

/*
    AtomicInteger() 原理
        自旋锁加CAS算法
            CAS算法：
                有三个操作数(内存值V,旧的预期值A,要修改的值B)
                当旧的预期值A == 内存值, 此时修改成功, 将V改成B
                当旧的预期值A ！= 内存值, 此时修改失败，不做任何操作
                并重新获取现在的最新值(这个重新获取的动作就是自旋)

        在修改共享数据的时候，把原来的旧值记录下来，然后进行CAS算法
*/
public class AtomicIntegerDemo2 {
    //    int get():   		         获取值
    //    int getAndIncrement():     以原子方式将当前值加1，注意，这里返回的是自增前的值。
    //    int incrementAndGet():     以原子方式将当前值加1，注意，这里返回的是自增后的值。
    //    int addAndGet(int data):	 以原子方式将参数与对象中的值相加，并返回结果。
    //    int getAndSet(int value):  以原子方式设置为newValue的值，并返回旧值。
    public static void main(String[] args) {
//        AtomicInteger ac1 = new AtomicInteger(10);
//        System.out.println(ac1.get());

//        AtomicInteger ac2 = new AtomicInteger(10);
//        int andIncrement = ac2.getAndIncrement();
//        System.out.println(andIncrement);
//        System.out.println(ac2.get());

//        AtomicInteger ac3 = new AtomicInteger(10);
//        int i = ac3.incrementAndGet();
//        System.out.println(i);//自增后的值
//        System.out.println(ac3.get());

//        AtomicInteger ac4 = new AtomicInteger(10);
//        int i = ac4.addAndGet(20);
//        System.out.println(i);
//        System.out.println(ac4.get());

        AtomicInteger ac5 = new AtomicInteger(100);
        int andSet = ac5.getAndSet(20);
        System.out.println(andSet);
        System.out.println(ac5.get());


    }
}
