package day12.TestLambda9;

public class test7 {
    public static void main(String[] args) {

        // Lambda调用
        /*useInter(() ->
                System.out.println("Lambda执行了")
        );
            Lambda表达式和匿名内部类的区别

            所需类型不同
            匿名内部类：可以是接口，也可以是抽象类，还可以是具体类
            Lambda表达式：只能是接口

            使用限制不同
            如果接口中有且仅有一个抽象方法，可以使用Lambda表达式，也可以使用匿名内部类
            如果接口中多于一个抽象方法，只能使用匿名内部类，而不能使用Lambda表达式

            实现原理不同
            匿名内部类：编译之后，产生一个单独的.class字节码文件
            Lambda表达式：编译之后，没有一个单独的.class字节码文件。对应的字节码会在运行的时候动态生成
        */

        useInter(new Inter7() {
            @Override
            public void show() {
                System.out.println("匿名内部类的show方法");
            }
        });

    }

    public static void useInter(Inter7 i) {
        i.show();
    }
}

interface Inter7 {
    void show();
}