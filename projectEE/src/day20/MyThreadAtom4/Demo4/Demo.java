package day20.MyThreadAtom4.Demo4;

public class Demo {
    /*
        synchronized和CAS的区别：
            相同点：在多线程的情况下，都可以保证共享数据的安全性
            不同点：
            synchronized():总是从最坏的角度出发，认为每次获得数据的时候，别人都有可能修改，所以在每次操作共享数据的时候，都会上锁(悲观锁)
            CAS:从乐观的角度出发，假设每次获取数据别人都不会修改，所以不会上锁，只不过在修改共享数据的时候检查一下别人有没有修改过数据，如果修改过，就重新获取最新值
            没有修改过就直接修改共享数据的值
    */
    public static void main(String[] args) {
        AtomicIntegerDemo atom = new AtomicIntegerDemo();

        for (int i = 0; i < 100; i++) {
            new Thread(atom).start();
        }
    }
}