package day12.TestExtends1.test4;


public class Zi11 extends Fu10 {
    // 子父类当中, 出现了重名的成员变量,就近原则优先使用子类的
    int a = 20;

    public void method(){

        int a = 30;

        System.out.println(a);  // 30

        // 需求1: 在控制台打印本类成员变量 20
        System.out.println(this.a);

        // 需求2: 在控制台打印父类成员变量 10
        System.out.println(super.a);
    }
}
