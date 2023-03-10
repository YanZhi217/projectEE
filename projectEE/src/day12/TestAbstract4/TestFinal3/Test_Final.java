package day12.TestAbstract4.TestFinal3;

public class Test_Final {
    /*
        final修饰变量:

            基本数据类型变量: 其值不能被更改

            引用数据类型变量: 地址值不能被更改, 但是可以修改对象的属性值

        final修饰的特点
            修饰方法：表明该方法是最终方法，不能被重写
            修饰变量：表明该变量是常量，不能再次被赋值
            修饰类：表明该类是最终类，不能被继承
    */
    public static void main(String[] args) {
        // 常量的命名规范: 如果是一个单词, 所有字母大写, 如果是多个单词, 所有字母大写, 但是中间需要使用_分隔
        final int A = 10;
        // a = 10;
        final int MAX = 10;
        final int MAX_VALUE = 20;

        final Student stu = new Student();
        stu.setName("张三");
        stu.setName("李四");

        // stu = new Student();
    }
}

class Student {
    // final修饰成员变量 初始化时机
    // 1. 在创建的时候, 直接给值
    // 2. 在构造方法结束之前, 完成赋值
    final int a = 10;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
final类不能被继承
final class Fu {

}

class Zi extends Fu {

}
*/
