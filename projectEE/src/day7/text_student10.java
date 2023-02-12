package day7;

public class text_student10 {
    public static void main(String[] args) {
        student9 s1 = new student9();
        System.out.println("[打印对象名]-->  s1");
        System.out.println(s1);
        s1.setName("张三");
        System.out.println(s1.getName());

        System.out.println("----------------------");

        student9 s2 = new student9();
        System.out.println("[打印对象名]-->  s2");
        System.out.println(s2);
        s2.setName("李四");
        System.out.println(s2.getName());
    }
}
