package day12.TestInterFace6.InterFace7;

/*
类和类的关系
    继承关系，只能单继承，可以多层继承
类和接口的关系
    实现关系，可以单实现，也可以多实现，还可以在继承一个类的同时实现多接口
接口和接口的关系
继承关系，可以单继承，也可以多继承
 */
public class test {
    public static void main(String[] args) {
        InterImpl ii = new InterImpl();
        ii.method();
    }
}
