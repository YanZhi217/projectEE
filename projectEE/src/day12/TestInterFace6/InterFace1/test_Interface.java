package day12.TestInterFace6.InterFace1;

public class test_Interface {
    /*
       接口的定义格式:
           public interface 接口名 {}

       类实现接口的格式:
           public class 类名 implements 接口名 {}

        类可以实现多个接口，需要在中间添加","
    */
    public static void main(String[] args) {
        InterImpl a = new InterImpl();
        a.print1();
        a.print2();
        a.study();
    }
}
