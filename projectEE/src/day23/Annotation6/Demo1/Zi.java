package day23.Annotation6.Demo1;

/*
* 注解
*   概述
*   对我们的程序进行标注和解释
* 注解和注释的区别
*    注释: 给程序员看的
*    注解: 给编译器看的
* */
@SuppressWarnings(value = "all")
//表示压制了本类中所有的警告
public class Zi extends Fu{
    @Override//告诉我们得编译器这个方法是重写了父类中的show方法
    //那么我们在进行方法定义的时候，就需要按照重写方法的要求进行方法定义。
    public void show() {
        System.out.println("子类的方法");
    }

    //表示这是一个过时的方法
    @Deprecated
    public void method(){
        System.out.println("method.......");
    }

    public void function2(){
        int a = 10;
    }

    @SuppressWarnings(value = "all")
    //表示压制本方法中所有的警告
    public void function(){
        int a = 10;
        int b = 20;
        //System.out.println(a);
        //System.out.println(b);
    }
}