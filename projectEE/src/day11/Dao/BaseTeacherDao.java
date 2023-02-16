package day11.Dao;

import day11.domain.Teacher;

public abstract class BaseTeacherDao {
    //返回所有老师对象
    public abstract Teacher[] findAllTeacher();

    //添加老师
    public abstract boolean addTeacher(Teacher tea);

    //删除老师
    public abstract void deleteTeacherById(String id);

    //查找编号所在索引
    public abstract int getIndex(String id);

    //修改老师
    public abstract void updateTeacher(String id,Teacher newTea);
}
