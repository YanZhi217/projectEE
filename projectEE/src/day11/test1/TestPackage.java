package day11.test1;

import day11.test2.Student;


/*
    不同包下的相互访问

        1. 先导包后访问 (import)
        2. 通过全类名(包名+类名)访问
                day11.test3.Student stu2 = new day11.test3.Student();
                应用场景: 多个包下,出现了相同的类名称, 就可以使用这种访问进行区分
*/

public class TestPackage {
    public static void main(String[] args) {
        System.out.println("hello world");
        Student stu = new Student();
        day11.test3.Student stu2 = new day11.test3.Student();
    }
}
