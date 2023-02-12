package day8;

//import day8.domain13;
import java.util.Scanner;
public class domain_student14 {
    /*
         需求：以字符串的形式从键盘录入学生信息，例如：“张三 , 23”
                从该字符串中切割出有效数据,封装为Student学生对象
         思路：
            1. 编写Student类，用于封装数据
            2. 键盘录入一个字符串，用 Scanner 实现
            3. 根据逗号切割字符串，得到（张三）（23）
                    String[] split(String regex) ：根据传入的字符串作为规则进行切割
                    将切割后的内容存入字符串数组中，并将字符串数组返回
            4. 从得到的字符串数组中取出元素内容，通过Student类的有参构造方法封装为对象
            5. 调用对象getXxx方法，取出数据并打印。

    */
    public static void main(String[] args) {
        // 2. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生信息:");
        String stuInfo = sc.nextLine();
        // stuInfo = "张三,23";
        // 3. 根据逗号切割字符串，得到（张三）（23）
        String[] sArr = stuInfo.split(",");

        //System.out.println(sArr[0]);
        //System.out.println(sArr[1]);

        // 4. 从得到的字符串数组中取出元素内容，通过Student类的有参构造方法封装为对象
        domain13 stu = new domain13(sArr[0],sArr[1]);

        // 5. 调用对象getXxx方法，取出数据并打印。
        System.out.println(stu.getName() + "..." + stu.getAge());
    }
}
