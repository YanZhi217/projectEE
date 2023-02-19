package day13.Object3.demo1;

public class student extends Object{
    /*
    Object类概述
    Object 是类层次结构的根，每个类都可以将 Object 作为超类。所有类都直接或者间接的继承自该类，
    换句话说，该类所具备的方法，所有类都会有一份
            查看方法源码的方式
    选中方法，按下Ctrl + B
            重写toString方法的方式
    Alt + Insert 选择toString
    在类的空白区域，右键 -> Generate -> 选择toString
    toString方法的作用：
    以良好的格式，更方便的展示对象中的属性值

    Object是所有类直接或者间接的父类，直接打印一个对象就是打印这个对象的toString()方法的返回值
    返回值是地址，我们一般会对toString方法进行重写
    D:\作业\课件\课件\阶段一 Java基础\07.常用API&异常\07.常用API&异常\day05-APIday01\资料
    */
    private String name;
    private int age;

    public student() {
    }

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}