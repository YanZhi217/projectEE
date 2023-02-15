package day12.test2;
import day12.test1.Fu22;
public class test26 {
    public static void main(String[] args) {
        // 不同包下, 被无关类访问
        Fu22 f = new Fu22();
        //f.show(); 不可以
        //f.print();不可以
    }
}
