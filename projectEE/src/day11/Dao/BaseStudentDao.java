package day11.Dao;

import day11.domain.Student;

public abstract class BaseStudentDao {

    //返回学生对象数组
    public abstract Student[] findAllStudent();

    //添加学生到数组
    public abstract boolean addStudent(Student stu);

    //删除学生
    public abstract void deleteStudentById(String delId);

    //查找id索引位置
    public abstract int getIndex(String id);

    //修改学生
    public abstract void updateStudentById(String updateId, Student newStu);
}
