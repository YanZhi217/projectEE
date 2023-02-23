package day11.TestPackage1.Package1;

import day11.TestPackage1.Student2.Student;


/*
    不同包下的相互访问

        1. 先导包后访问 (import)
        2. 通过全类名(包名+类名)访问
                day11.test3.Student stu2 = new day11.test3.Student();
                应用场景: 多个包下,出现了相同的类名称, 就可以使用这种访问进行区分
    package必须是程序第一条语句
    import在package下
    class在import下
*/

public class TestPackage1 {
    public static void main(String[] args) {
        System.out.println("hello world");
        Student stu = new Student();
        day11.TestPackage1.Student3.Student stu2 = new day11.TestPackage1.Student3.Student();
    }
}
