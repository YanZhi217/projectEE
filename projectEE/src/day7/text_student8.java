package day7;

public class text_student8 {
    public static void main(String[] args) {
        student7 stu = new student7();
        stu.setName("张三");
        stu.setAge(23);

        System.out.println(stu.getName());
        System.out.println(stu.getAge());

        int age = stu.getAge();

        for(int i = 1; i <= age; i++){
            System.out.println("生日快乐");
        }

        stu.show();  // 仅仅是对数据做展示
    }
}
