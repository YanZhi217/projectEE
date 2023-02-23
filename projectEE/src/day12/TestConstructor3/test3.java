package day12.TestConstructor3;

public class test3 {
    public static void main(String[] args) {
        student2 stu = new student2("张三",23,100);

        System.out.println(stu.getName() + "..." + stu.getAge() + "..." + stu.getScore());

    }
}
