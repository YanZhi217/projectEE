package day11.Dao;

import day11.domain.Teacher;

import java.util.ArrayList;

public class OtherTeacherDao extends BaseTeacherDao{
    private final static ArrayList<Teacher> teas = new ArrayList<>();

    static {
        Teacher tea1 = new Teacher("YanZhi001","张三","18","20020422");
        Teacher tea2 = new Teacher("YanZhi002","李四","21","20020421");
        teas.add(tea1);
        teas.add(tea2);
    }

    //返回所有老师对象
    public Teacher[] findAllTeacher() {
        Teacher[] teachers = new Teacher[teas.size()];
        for (int i = 0; i < teachers.length; i++) {
            teachers[i] = teas.get(i);
        }
        return teachers;
    }

    //添加老师
    public boolean addTeacher(Teacher tea) {
        teas.add(tea);
        return true;
    }

    //删除老师
    public void deleteTeacherById(String id) {
        int index = getIndex(id);
        teas.remove(index);
    }

    //查找编号所在索引
    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < teas.size(); i++) {
            Teacher tea = teas.get(i);
            if(tea != null && tea.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    //修改老师
    public void updateTeacher(String id,Teacher newTea) {
        int index = getIndex(id);
        teas.set(index,newTea);
    }
}
