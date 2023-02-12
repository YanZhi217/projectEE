package day7;

public class text_student14 {
    public static void main(String[] args) {
        // 1. 无参数构造方法创建对象, 通过setXxx方法给成员变量进行赋值
        student13 stu1 = new student13();
        stu1.setName("张三");
        stu1.setAge(23);
        stu1.show();
        System.out.println(stu1.getName());

        // 2. 通过带参数构造方法, 直接给属性进行赋值
        student13 stu2 = new student13("李四",24);
        stu2.show();
        System.out.println(stu2.getAge());
    }
}
