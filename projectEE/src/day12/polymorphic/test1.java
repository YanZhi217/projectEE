package day12.polymorphic;

public class test1 {
    /*
        多态:

            1. 要有(继承 \ 实现)关系
            2. 要有方法重写
            3. 要有父类引用, 指向子类对象
            4. 多态无法调用子类中特有的方法
            5.多态可以调用父类的任意子类
            6.向上转型，向下转型
            7.当被转型的引用类型变量，其实际类型与目标类型不是同一个类型，则会出现ClassCastException错误
            8.解决方法，使用instanceof关键字判断是否为同一个类型，将会返回true或者false
     */
    public static void main(String[] args) {

        // 当前事物, 是一只动物
        Animal a = new Cat();
        // 当前事物, 是一只猫
        Cat c = new Cat();

        System.out.println(a.num);  //num == 10
        a.eat();    //猫吃鱼
        System.out.println(c.num);  //num == 20
        c.eat();    //猫吃鱼

        Animal(new Cat());  //10,猫吃鱼    Animal a = new Cat()    父类类型引用子类对象
        Animal(new Dog());  //10,狗吃肉    Animal a = new Dog()    父类类型引用子类对象

        //向上转型：父类类型指向子类对象
        Animal b = new Cat();
        System.out.println(b.num);  //num == 10
        b.eat();    //猫吃鱼

        //向下转型：父类类型转换为子类对象
        //若想要调用子类特有的方法还可以单独创建一个子类对象
        Cat d = (Cat) b;
        System.out.println(d.num);  //num == 20
        d.print();
    }

    public static void Animal(Animal a) {
        System.out.println(a.num);
        a.eat();
    }
}

abstract class Animal {
    int num = 10;
    public abstract void eat();
}

class Cat extends Animal {
    int num = 20;
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void print(){
        System.out.println("我是Cat中的特有方法");
    }
}

class Dog extends Animal {
    int num = 30;
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
}