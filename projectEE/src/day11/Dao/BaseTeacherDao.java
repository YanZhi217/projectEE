package day11.Dao;

import day11.domain.Teacher;

public interface BaseTeacherDao {
    //返回所有老师对象
    Teacher[] findAllTeacher();

    //添加老师
    boolean addTeacher(Teacher tea);

    //删除老师
    void deleteTeacherById(String id);

    //查找编号所在索引
    int getIndex(String id);

    //修改老师
    void updateTeacher(String id,Teacher newTea);
}
