package day19.demo3;

import java.util.concurrent.Callable;

//泛型中的String就是线程执行完毕后返回的结果类型
public class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("跟女孩表白" + i);
        }
        //返回值就表示线程运行完毕之后的结果
        return "答应";
    }
}
