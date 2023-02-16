package day11.Controller;

import day11.domain.Teacher;

public class OtherTeacherController extends BaseTeacherController{

    @Override
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
        return new Teacher(id,name,age,birthday);
        //返回对象
    }

}
