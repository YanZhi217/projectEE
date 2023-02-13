package day11.Dao;

import day11.doamin.Student;

public class StudentDao {
    public boolean addStudent(Student stu) {
        //创建学生对象数组
        Student[] stus = new Student[5];
        //添加学生到数组
        //定义变量index=-1,假设数组已经存满,没有null元素
        int index = -1;
        //遍历数组，判断null
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student == null){
                index = i;
                break;
            }
        }

        //返回是否添加成功的boolean状态
        if(index == -1){
            return false;
        }else{
            stus[index] = stu;
            return true;
        }

    }
}
