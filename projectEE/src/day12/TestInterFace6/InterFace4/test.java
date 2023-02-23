package day12.TestInterFace6.InterFace4;

public class test {
    public static void main(String[] args) {
        InterAImpl ia = new InterAImpl();
        //JDK8版本之后的特性
        //接口中的静态方法不能被对象或实现调用
        // ia.show();
        //只能被接口本身的类名调用
        InterA.show();

        Inter.show();

        // InterAImpl.show();
    }
}

class InterAImpl implements InterA , Inter {

}

