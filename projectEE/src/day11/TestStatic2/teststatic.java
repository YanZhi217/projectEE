package day11.TestStatic2;



public class teststatic {
    /*
        1. 被static修饰的成员, 会被该类的所有对象所[共享]
        2. 被static修饰的成员, 会随着类的加载而加载, 优先于对象存在
        3. 多了一种调用方式, 可以通过类名.进行调用
    */
    public static void main(String[] args) {
        day11.TestStatic2.Student.school = "hell world";
        day11.TestStatic2.Student stu1 = new day11.TestStatic2.Student();
        stu1.name = "张三";
        stu1.age = 23;
        //stu1.school = "hello world";
        stu1.show();

        day11.TestStatic2.Student stu2 = new Student();
        stu2.show();

        day11.TestStatic2.Student.method();
    }


}
