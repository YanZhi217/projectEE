package day11.Controller;

import day11.domain.Student;

public class OtherStudentController extends BaseStudentController{

    @Override
    //对方法重写的注解
    //键盘录入学生信息
    public Student inputStudentinfo(String id){
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();

        //开闭原则：对扩展内容开放，对修改内容关闭，就是说想要扩展功能则允许，想要修改原有代码则拒绝
        //因此我们另外复制一份用来修改我们想要的功能
        //学生信息封装为学生对象


        return new Student(id,name,age,birthday);
    }
}
