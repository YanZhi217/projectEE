package day19.demo9;


public class Ticket implements Runnable{
    //票的数量
    private int ticket = 100;
    private Object obj = new Object();//创建锁对象

    @Override
    public void run() {
        while(true){
            /*
                同步代码块
                synchronized(任意对象){
                    多条语句共享操作数据的代码
                }
                默认情况是打开的，只要有一个线程进入，锁就会关闭
                当线程执行完了，锁才会打开

                好处：解决了多数据的安全问题
                弊端：浪费资源，降低效率
            */
            synchronized (obj){//多个线程必须使用同一把锁.
                if(ticket <= 0){
                    //卖完了
                    break;
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                }
            }
        }
    }
}
