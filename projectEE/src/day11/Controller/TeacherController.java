package day11.Controller;

import day11.Service.TeacherService;
import day11.domain.Teacher;

import java.util.Scanner;

public class TeacherController {
    public TeacherService teacherservice= new TeacherService();
    public Scanner sc = new Scanner(System.in);

    public void start() {
        teacher_exit:
            while(true){
                System.out.println("---------------欢迎来到老师管理系统,请输入您的选择---------------");
                System.out.println("\t1:增加老师\t2:删除老师\t3:修改老师\t4:查看所有老师\t5:退出");
                String choice = sc.next();
                switch(choice){
                    case "1" :
                        System.out.println("增加老师");
                        addTeacher();
                        break;
                    case "2" :
                        //System.out.println("删除老师");
                        deleteTeacherById();
                        break;
                    case "3" :
                        //System.out.println("修改老师");
                        updateTeacher();
                        break;
                    case "4" :
                        //System.out.println("查看所有老师");
                        findAllTeacher();
                        break;
                    case "5" :
                        System.out.println("感谢你的使用");
                        break teacher_exit;
                    default :
                        System.out.println("您的输入有误,请重新输入");
                        break;
                }
            }
    }

    //修改老师信息
    public void updateTeacher() {
        String id = inputTeacherId();
        Teacher newTea = inputTeacherInfo(id);
        teacherservice.updateTeacher(id,newTea);
        System.out.println("修改成功");
    }

    //删除老师
    public void deleteTeacherById() {
        String id;
        id = inputTeacherId();

        teacherservice.deleteTeacherById(id);
        System.out.println("删除成功");
    }

    //判断老师编号是否存在
    public String inputTeacherId() {
        String id;
        while(true){
            System.out.println("请输入老师的编号");
            id = sc.next();
            boolean flag = teacherservice.isExists(id);
            if(!flag){
                System.out.println("您输入的老师不存在,请重新输入");
            }else{
                break;
            }
        }

        return id;
    }

    //查询所有老师信息
    public void findAllTeacher() {
        Teacher[] teas = teacherservice.findAllTeacher();
        if(teas == null){
            System.out.println("查无信息，请重新输入");
            return;
        }
        System.out.println("编号\t\t姓名\t年龄\t生日");

        for (Teacher tea : teas) {
            if (tea != null) {
                System.out.println(tea.getId() + "\t" + tea.getName() + "\t" + tea.getAge() + "\t\t" + tea.getBirthday());
            }
        }

    }

    //添加老师
    public void addTeacher() {
        String id;
        while(true){
            System.out.println("请输入您要添加的老师编号");
            id = sc.next();
            boolean flag = teacherservice.isExists(id);
            if(flag){
                System.out.println("您的输入的编号已经存在，请重新输入");
            }else{
                break;
            }
        }

        Teacher tea = inputTeacherInfo(id);
        boolean flag = teacherservice.addTeacher(tea);
        if(flag){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    //录入老师信息
    private Teacher inputTeacherInfo(String id) {
        //录入信息
        System.out.println("请输入老师姓名");
        String name = sc.next();
        System.out.println("请输入老师年龄");
        String age = sc.next();
        System.out.println("请输入老师生日");
        String birthday = sc.next();

        //封装对象
        Teacher tea = new Teacher();
        tea.setId(id);
        tea.setName(name);
        tea.setAge(age);
        tea.setBirthday(birthday);

        //返回对象
        return tea;
    }

}
