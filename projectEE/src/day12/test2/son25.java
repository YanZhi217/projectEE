package day12.test2;

import day12.test1.Fu22;

public class son25 extends Fu22 {
    // 不同包下, 被子类访问
    public void method(){
        // super.show(); 不可以
        super.print();
    }
}
