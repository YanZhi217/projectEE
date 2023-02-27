package day19.demo13;

public class demo {
    public static void main(String[] args) {
        Object objA = new Object();
        Object objB = new Object();

        //将会导致死锁
        new Thread(()->{
            while(true){
                synchronized (objA){
                    //线程一
                    synchronized (objB){
                        System.out.println("小康同学正在走路");
                    }
                }
            }
        }).start();

        new Thread(()->{
            while(true){
                synchronized (objB){
                    //线程二
                    synchronized (objA){
                        System.out.println("小薇同学正在走路");
                    }
                }
            }
        }).start();
    }
}
