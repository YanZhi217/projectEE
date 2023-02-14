package day11.Controller;

import day11.Service.StudentService;
import day11.doamin.Student;
import java.util.Scanner;

public class StudentController {
    private StudentService studentservice = new StudentService();
    //开启学生系统，并展示学生管理系统菜单
    public void start() {
        Scanner sc = new Scanner(System.in);
        student_exit:
            while(true){
                System.out.println("---------------欢迎来到学生信息管理系统,请选择您要进行的操作---------------");
                System.out.println("\t1:增加学生\t2:删除学生\t3:修改学生\t4:查看所有学生\t5:退出");
                String i = sc.next();
                switch(i){
                    case "1" :
                        //System.out.println("增加");
                        addStudent();
                        break;
                    case "2" :
                        System.out.println("删除");
                        break;
                    case "3" :
                        System.out.println("修改");
                        break;
                    case "4" :
                        //System.out.println("查询");
                        findAllStudent();
                        break;
                    case "5" :
                        System.out.println("感谢您的使用");
                        break student_exit;
                    default :
                        System.out.println("您的输入有误，请重新输入");
                        break;
                }
            }

    }

    //查看所有学生
    private void findAllStudent() {
        //调用Controller中的findAllStudent方法，获取对象数组
        Student[] stus = studentservice.findAllStudent();
        //判断数组内存地址是否为null
        if(stus == null){
            System.out.println("查无信息，请重试");
        }
        //遍历数组，打印学生信息
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if(stu != null){
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }

    //添加学生
    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        String id;
        //键盘接受学生信息
        while(true){
            System.out.println("请输入学生id:");
            id = sc.next();
            boolean flag = studentservice.isExists(id);
            if(flag){
                System.out.println("您输入的id已经存在，请重新输入");
            }else{
                break;
            }
        }
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();

        //学生信息封装为学生对象
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);

        //将学生对象传递给Service的StudentService中的addStudent()
        boolean result = studentservice.addStudent(stu);

        //根据返回的boolean类型在控制台打印添加成功或者失败
        if(result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

    }
}
