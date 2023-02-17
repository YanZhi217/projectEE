package day11.Dao;

import day11.domain.Student;

public interface BaseStudentDao {

    //返回学生对象数组
    Student[] findAllStudent();

    //添加学生到数组
    boolean addStudent(Student stu);

    //删除学生
    void deleteStudentById(String delId);

    //查找id索引位置
    int getIndex(String id);

    //修改学生
    void updateStudentById(String updateId, Student newStu);
}
