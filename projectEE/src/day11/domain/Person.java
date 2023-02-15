package day11.domain;

public class Person {
    /*
    继承的概念
    继承是面向对象三大特征之一，可以使得子类具有父类的属性和方法，还可以在子类中重新定义，以及
            追加属性和方法
    实现继承的格式
            继承通过extends实现
    格式：class 子类 extends 父类 { }
    举例：class Dog extends Animal { }
    继承带来的好处
    继承可以让类与类之间产生关系，子父类关系，产生子父类后，子类则可以使用父类中非私有的成员。

    Java中类只支持单继承，不支持多继承，支持多层继承
    */
    //封装用户数据

    private String id;
    private String name;
    private String age;
    private String birthday;

    public Person() {
    }

    public Person(String id, String name, String age, String birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
