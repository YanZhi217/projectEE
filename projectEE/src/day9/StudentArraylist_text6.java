package day9;
//此类调用array_domain1类创建对象
import java.util.ArrayList;
public class StudentArraylist_text6 {
    /*
        需求：创建一个存储学生对象的集合，存储3个学生对象，使用程序实现在控制台遍历该集合

        思路：
            1. 定义学生类
            2. 创建集合对象
            3. 创建学生对象
            4. 添加学生对象到集合中
            5. 遍历集合，采用通用遍历格式实现
    */
    public static void main(String[] args) {
        // 2. 创建集合对象
        ArrayList<array_domain1> list = new ArrayList<>();
        // 3. 创建学生对象
        array_domain1 stu1 = new array_domain1("张三1",23);
        array_domain1 stu2 = new array_domain1("张三2",23);
        array_domain1 stu3 = new array_domain1("张三3",23);
        // 4. 添加学生对象到集合中
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        // 5. 遍历集合，采用通用遍历格式实现
        for (int i = 0; i < list.size(); i++) {
            array_domain1 stu = list.get(i);
            System.out.println(stu);
            System.out.println(stu.getName() + "..." + stu.getAge());
        }
    }
}
