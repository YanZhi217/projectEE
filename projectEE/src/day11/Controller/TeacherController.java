package day11.Controller;

import day11.domain.Teacher;

public class TeacherController extends BaseTeacherController{

    //录入老师信息
    public Teacher inputTeacherInfo(String id) {
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
