package day11.Controller;

import day11.Service.StudentService;
import day11.domain.Student;
import java.util.Scanner;

public class StudentController {
    public StudentService studentservice = new StudentService();
    public Scanner sc = new Scanner(System.in);
    //开启学生系统，并展示学生管理系统菜单
    public void start() {
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
                        //System.out.println("删除");
                        deleteStudentById();
                        break;
                    case "3" :
                        //System.out.println("修改");
                        updateStudent();
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

    //修改学生
    public void updateStudent() {
        String id;
        //录入学生id
        id = inputStudentId();
        //录入学生信息
        Student newStu = inputStudentinfo(id);
        //调用studentservice中的updateStudentById(),根据id修改学生
        studentservice.updateStudentById(id,newStu);
        System.out.println("修改成功");
    }

    //删除学生
    public void deleteStudentById() {
        String delId;
        delId = inputStudentId();

        //调用StudentService中的deleteStudentById(),根据id删除学生
        studentservice.deleteStudentById(delId);
        //提示删除成功
        System.out.println("删除成功!");
    }

    //查看所有学生
    public void findAllStudent() {
        //调用Controller中的findAllStudent方法，获取对象数组
        Student[] stus = studentservice.findAllStudent();
        //判断数组内存地址是否为null
        if(stus == null){
            System.out.println("查无信息，请重试");
            return;
        }
        //遍历数组，打印学生信息
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (Student stu : stus) {
            if (stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }

    //添加学生
    public void addStudent() {
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

        //录入学生信息并封装为对象
        Student stu = inputStudentinfo(id);

        //将学生对象传递给Service的StudentService中的addStudent()
        boolean result = studentservice.addStudent(stu);

        //根据返回的boolean类型在控制台打印添加成功或者失败
        if(result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

    }

    //键盘录入学生id
    public String inputStudentId(){
        String id;
        while(true){
            //键盘录入学生id
            System.out.println("请输入学生id");
            id = sc.next();
            //判断id是否存在，不存在则一直录入
            boolean exists = studentservice.isExists(id);
            if(!exists){
                System.out.println("您输入的学生id不存在，请重新输入");
            }else{
                break;
            }
        }

        return id;
    }

    //键盘录入学生信息
    public Student inputStudentinfo(String id){
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

        return stu;
    }
}
