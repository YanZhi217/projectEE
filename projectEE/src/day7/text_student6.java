package day7;

public class text_student6 {
        //      学生测试类
    public static void main(String[] args) {
        student5 stu = new student5();
        stu.name = "张三";
        //      stu.age = 23;
        stu.setAge(-23);
        int a = stu.getAge();
        System.out.println(a);
        stu.show();
    }
}
