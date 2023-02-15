package day11.Entry;

import java.util.Scanner;
import day11.Controller.StudentController;
import day11.Controller.TeacherController;
    /*
       需求说明:
            添加学生: 键盘录入学生信息(id，name，age，birthday),使用数组存储学生信息,要求学生的id不能重复
            删除学生: 键盘录入要删除学生的id值,将该学生从数组中移除,如果录入的id在数组中不存在,需要重新录入
            修改学生: 键盘录入要修改学生的id值和修改后的学生信息,将数组中该学生的信息修改,如果录入的id在数组中不存在,需要重新录入
            查询学生: 将数组中存储的所有学生的信息输出到控制台

        Student类 标准学生类,封装键盘录入的学生信息(id , name , age , birthday)
        StudentDao类 Dao : (Data Access Object 缩写) 用于访问存储数据的数组或集合
        StudentService类 用来进行业务逻辑的处理(例如: 判断录入的id是否存在)
        StudentController类 和用户打交道(接收用户需求,采集用户信息,打印数据到控制台)

        day11.domain.Student.java      封装学生信息
        day11.Dao.StudentDao.java      访问存储数据的数组，进行赠删改查（库管）
        day11.Service.StudentService.java      业务的逻辑处理（业务员）
        day11.Controller.StudentController.java      和用户打交道（客服接待）
        day11.Entry.Entry.java         程序的入口类，提供一个main方法
    */

//主菜单入口

public class Entry {
    public static void main(String[] args) {
        //主菜单搭建
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("---------------欢迎来到学校信息管理系统,请选择您要进行的操作---------------");
            System.out.println("\t\t\t\t1:学生管理\t2:老师管理\t3:退出");
            String i = sc.next();
            switch(i){
                case "1" :
                    //开启学生管理系统
                    StudentController studentcontroller = new StudentController();
                    studentcontroller.start();
                    break;
                case "2" :
                    //开启老师管理系统
                    //System.out.println("欢迎来到老师管理");
                    TeacherController teachercontroller = new TeacherController();
                    teachercontroller.start();
                    break;
                case "3" :
                    System.out.println("感谢您的使用");
                    //退出当前正在运行的JVM虚拟机
                    System.exit(0);
                    break;
                default :
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }

    }
}
