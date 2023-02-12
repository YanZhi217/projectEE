package day9;
//此类调用array_domain1类创建对象
import java.util.ArrayList;
import java.util.Scanner;
public class StudentArraylist_text9 {
    /*
        需求：定义一个方法，方法接收一个集合对象（泛型为Student）
            方法内部将年龄低于18的学生对象找出
            并存入新集合对象，方法返回新集合。

        思路：
            1. 定义方法，方法的形参定义为ArrayList<Student> list
            2. 方法内部定义新集合，准备存储筛选出的学生对象 ArrayList<Student> newList
            3. 遍历原集合，获取每一个学生对象
            4. 通过学生对象调用getAge方法获取年龄，并判断年龄是否低于18
            5. 将年龄低于18的学生对象存入新集合
            6. 返回新集合
            7. main方法中测试该方法
    */
    public static void main(String[] args) {
        // 7. main方法中测试该方法
        ArrayList<array_domain1> list = new ArrayList<>();
        list = getStudent();
        ArrayList<array_domain1> newList = getList(list);
        for (int i = 0; i < newList.size(); i++) {
            array_domain1 stu = newList.get(i);
            System.out.println(stu.getName() + "..." + stu.getAge());
        }

    }

    //键盘录入学生信息，并返回以array_domain1为对象元素的集合类型
    public static ArrayList<array_domain1> getStudent(){
        ArrayList<array_domain1> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for(int i =0; i < 3 ; i++) {
            System.out.println("请输入学生姓名与年龄:");
            String name = sc.next();
            int age = sc.nextInt();
            array_domain1 stu = new array_domain1(name, age);
            list.add(stu);
        }
        return list;
    }

    // 1. 定义方法，方法的形参定义为ArrayList<Student> list
    public static ArrayList<array_domain1> getList(ArrayList<array_domain1> list) {
        // 2. 方法内部定义新集合，准备存储筛选出的学生对象 ArrayList<Student> newList
        ArrayList<array_domain1> newList = new ArrayList<>();
        // 3. 遍历原集合，获取每一个学生对象
        for (int i = 0; i < list.size(); i++) {
            array_domain1 stu = list.get(i);
            // 4. 通过学生对象调用getAge方法获取年龄，并判断年龄是否低于18
            int age = stu.getAge();
            if (age < 18) {
                //  5. 将年龄低于18的学生对象存入新集合
                newList.add(stu);
            }
        }
        // 6. 返回新集合
        return newList;
    }
}
