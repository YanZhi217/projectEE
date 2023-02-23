package day12.TestInterFace6.InterFace3;

public class test {
    /*
        默认方法，JDK8banben之后，允许定义非抽象方法，使用default修饰
        用于解决接口升级的问题
        默认方法不强制要求重写，但是可以重写，重写的时候要去掉default关键字，如果实现的多个接口中有相同声明的方法则必须重写
     */
    public static void main(String[] args) {
        InterAImpl ia = new InterAImpl();
        ia.show();
    }
}

class InterAImpl implements InterA, InterB {

    @Override
    public void show() {

    }
}
